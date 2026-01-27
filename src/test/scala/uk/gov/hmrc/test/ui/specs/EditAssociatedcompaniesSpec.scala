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

class EditAssociatedcompaniesSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()

    When("""the accounting period start date is provided as "01/01/2023""")
    theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

    Then("the user clicks the continue button on the accounting period page")
    andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

    And("""the profit is "70000"""")
    andTheProfitIs("70000")

    Then("the user clicks continue button on taxable profit page")
    andTheUserClicksContinueButtonOnTaxableProfitPage()

    And("""the user selects option "No" for the question Did your company receive any distributions?""")
    andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    Then("the user lands on the associated companies page")
    thenTheUserLandsOnTheAssociatedCompaniesPage()

    When("""the user selects option "yes" for the question Did your company have any active associated companies?""")
    theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

    Then("the user is presented with an input field for associated companies")
    andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

    And("""the user inputs a valid number as "25" associated companies""")
    andTheUserInputsAValidNumberAsAssociatedCompanies("25")

    Then("the user clicks the continue button on the associated companies page")
    thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

    Then("the user is presented with the Check Your Answers page")
    thenTheUserIsPresentedWithTheCheckYourAnswersPage()
  }

  Feature("Edit Associated Companies - Validations") {

    Scenario("Edit Associated Companies, ZapTests") {
      givenDefaultState()

      And("the user is presented with a change link next to the associated companies")
      theUserIsPresentedWithAChangeLinkNextToTheAssociatedCompanies()

      Then(s"the user can validate the associated companies as 25")
      theUserCanValidateTheAssociatedCompaniesAs("25")

      And("the user clicks the change link next to the associated companies")
      theUserClicksTheChangeLinkNextToTheAssociatedCompanies()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And(s"the user validates associated companies are pre-populated as 25")
      thenTheUserValidatesAssociatedCompaniesArePrepopulatedAs("25")

      And(s"the user inputs a valid number as 50 associated companies")
      andTheUserInputsAValidNumberAsAssociatedCompanies("50")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And(s"the user can validate the associated companies as 50")
      theUserCanValidateTheAssociatedCompaniesAs("50")
    }

    Scenario("Edit Associated Companies-No Associated Company") {
      givenDefaultState()

      And("the user is presented with a change link next to the associated companies")
      theUserIsPresentedWithAChangeLinkNextToTheAssociatedCompanies()

      Then(s"the user can validate the associated companies as 25")
      theUserCanValidateTheAssociatedCompaniesAs("25")

      And("the user clicks the change link next to the associated companies")
      theUserClicksTheChangeLinkNextToTheAssociatedCompanies()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And(s"the user validates associated companies are pre-populated as 25")
      thenTheUserValidatesAssociatedCompaniesArePrepopulatedAs("25")

      And(s"the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And(s"the user can validate the associated companies as 0")
      theUserCanValidateTheAssociatedCompaniesAs("0")
    }
  }
}
