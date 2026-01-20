/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*

class DistributionsSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()

    When("the accounting period start date is provided as 01/01/2023")
    theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

    Then("the user clicks the continue button on the accounting period page")
    andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

    And("the profit is 50000")
    andTheProfitIs("50000")

    Then("the user clicks continue button on taxable profit page")
    andTheUserClicksContinueButtonOnTaxableProfitPage()
  }

  Feature("Exempt Distributions - Validations") {

    Scenario("User selects No for question Did your company receive any distributions") {
      givenDefaultState()

      And("""the user selects option "No" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

    }

    Scenario("User selects Yes for question Did your company receive any distributions and No to include in profits") {
      givenDefaultState()

      And("""the user selects option "Yes" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("Yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And(
        """the user selects option "No" for the question Do any distributions need to be included with your profits?"""
      )
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

    }

    Scenario("Happy Path - Yes for question Did your company receive any distributions and Yes to include in profits") {
      givenDefaultState()

      And("""the user selects option "Yes" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("Yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And(
        """the user selects option "yes" for the question Do any distributions need to be included with your profits?"""
      )
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("yes")

      Then("the user is provided with an input field to provide distributions")
      thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("""the user provides "£50,000" as distributions""")
      andTheUserProvidesAsDistributions("£50,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

    }

    Scenario("Happy Path - Distributions amount is displayed on check your answers page") {
      givenDefaultState()

      And("""the user selects option "Yes" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("Yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And(
        """the user selects option "yes" for the question Do any distributions need to be included with your profits?"""
      )
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("yes")

      And("""the user provides "£200,500,000" as distributions""")
      andTheUserProvidesAsDistributions("£200,500,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("""the user selects option "yes" for the question Did your company have any active associated companies?""")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

      And("""the user inputs a valid number as "1" associated companies""")
      andTheUserInputsAValidNumberAsAssociatedCompanies("1")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then("the user is presented with change link next to the distribution amount")
      theUserIsPresentedWithChangeLinkNextToTheDistributionAmount()

      And("""the user can validate their distribution amount as "£200,500,000"""")
      theUserCanValidateTheirDistributionAmountAs("£200,500,000")

      When("the user clicks the change link next to the distribution amount")
      theUserClicksTheChangeLinkNextToTheDistributionAmount()

      Then("the user is navigated to the exempt distributions page")
      thenTheUserIsNavigatedToTheExemptDistributionsPage()

      And("""the user selects option "yes" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      When("""the user changes the distributions value to "£30,000"""")
      thenTheUserChangesTheDistributionsValueTo("£30,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("""the user can validate their distribution amount as "£30,000"""")
      theUserCanValidateTheirDistributionAmountAs("£30,000")
    }

    Scenario("Zero Distributions Shown as NONE on check your answers page") {
      givenDefaultState()

      And("""the user selects option "no" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("no")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("""the user selects option "no" for the question Did your company have any active associated companies?""")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("""the user can validate their distribution amount as "None"""")
      theUserCanValidateTheirDistributionAmountAs("None")
    }
  }
}
