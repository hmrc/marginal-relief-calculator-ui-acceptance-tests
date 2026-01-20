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

import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*

class CheckYourAnswersSpec extends BaseSpec {

  def givenDefaultState(): Unit = {

    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()

    When("""the accounting period start date is provided as "01/01/2023"""")
    theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

    Then("the user clicks the continue button on the accounting period page")
    andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

    And("""the profit is "50000"""")
    andTheProfitIs("50000")

    Then("the user clicks continue button on taxable profit page")
    andTheUserClicksContinueButtonOnTaxableProfitPage()

    And("""the user selects option "Yes" for the question Did your company receive any distributions?""")
    andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("Yes")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    And(
      """the user selects option "Yes" for the question Do any distributions need to be included with your profits?"""
    )
    andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("Yes")

    Then("the user is provided with an input field to provide distributions")
    thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

    And("""the user provides "£50,000" as distributions""")
    andTheUserProvidesAsDistributions("£50,000")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    Then("the user lands on the associated companies page")
    thenTheUserLandsOnTheAssociatedCompaniesPage()

    When("""the user selects option "yes" for the question Did your company have any active associated companies?""")
    theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

    Then("the user is presented with an input field for associated companies")
    andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

    And("""the user inputs a valid number as "10" associated companies""")
    andTheUserInputsAValidNumberAsAssociatedCompanies("10")

    Then("the user clicks the continue button on the associated companies page")
    thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

    Then("the user is presented with the Check Your Answers page")
    thenTheUserIsPresentedWithTheCheckYourAnswersPage()
  }

  Feature("Check your answers - Validations") {

    val validateMessage = "1 January 2023 to 31 December 2023.\nEnd date defaulted to a full year from the start date."

    Scenario("Validate all values on check your answers page") {
      givenDefaultState()

      Then(s"the user can validate the accounting period as $validateMessage")
      theUserCanValidateTheAccountingPeriodAs(validateMessage)

      Then(s"the user can validate profit as £50,000")
      theUserCanValidateProfitAs("£50,000")

      Then(s"the user can validate distributions included as £50,000")
      theUserCanValidateDistributionsIncludedAs("£50,000")

      Then(s"the user can validate associated companies as 10")
      theUserCanValidateAssociatedCompaniesAs("10")

      And("the user can see the calculate margin relief button enabled")
      theUserCanSeeTheCalculateMarginReliefButtonEnabled()

    }

    Scenario("Clicking on back button") {
      givenDefaultState()

      When("the user clicks the back button")
      theUserClicksTheBackButton()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

    }

    Scenario("Clicking on back button after changing the distributions amount") {
      givenDefaultState()

      Then("the user is presented with change link next to the distribution amount")
      theUserIsPresentedWithChangeLinkNextToTheDistributionAmount()

      And("the user can validate their distribution amount as £50,000")
      theUserCanValidateTheirDistributionAmountAs("£50,000")

      When("the user clicks the change link next to the distribution amount")
      theUserClicksTheChangeLinkNextToTheDistributionAmount()

      Then("the user is navigated to the exempt distributions page")
      thenTheUserIsNavigatedToTheExemptDistributionsPage()

      And("the user selects option yes for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      When("the user changes the distributions value to £30,000")
      thenTheUserChangesTheDistributionsValueTo("£30,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user can validate their distribution amount as £30,000")
      theUserCanValidateTheirDistributionAmountAs("£30,000")

      When("the user clicks the back button")
      theUserClicksTheBackButton()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

    }

    Scenario("Verify message for default accounting period end date") {
      givenDefaultState()

      Then(s"the user can validate the accounting period as $validateMessage")
      theUserCanValidateTheAccountingPeriodAs(validateMessage)

      When("the user clicks the change link next to the accounting period dates")
      theUserClicksTheChangeLinkNextToTheAccountingPeriodDates()

      Then("the user is navigated to the accounting period page")
      theUserLandsOnTheAccountingPeriodPage()

      Then("the user can see the accounting end period as 31/12/2023")
      theUserCanSeeTheAccountingEnd("31/12/2023")

      When("the accounting period start date is provided as 01/04/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/04/2023")

      And("the accounting period end date is provided as 31/03/2024")
      provideAccountingPeriodEndDate("31/03/2024")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And(s"the user can validate their accounting period dates as 1 April 2023 to 31 March 2024")
      theUserCanValidateTheirAccountingPeriodDatesAs("1 April 2023 to 31 March 2024")
    }
  }
}
