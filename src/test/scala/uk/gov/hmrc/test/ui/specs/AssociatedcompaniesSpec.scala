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
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*

class AssociatedcompaniesSpec extends BaseSpec {

  def givenDefaultState(): Unit = {

    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()

    When(s"the accounting period start date is provided as 01/01/2023")
    theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

    Then("the user clicks the continue button on the accounting period page")
    andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

    And(s"the profit is 50000")
    andTheProfitIs("50000")

    Then("the user clicks continue button on taxable profit page")
    andTheUserClicksContinueButtonOnTaxableProfitPage()

    And(s"the user selects option no for the question Did your company receive any distributions?")
    andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("no")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()
  }

  Feature("Associated companies - Validations") {
    Scenario("Associated companies - Happy path") {
      givenDefaultState()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user can see the options yes and No as not selected")
      andTheUserCanSeeTheOptionsYesAndNoAsNotSelected()

      When("the user selects option yes for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

      Then("the user is presented with an input field for associated companies")
      andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

      And(s"the user inputs a valid number as 10 associated companies")
      andTheUserInputsAValidNumberAsAssociatedCompanies("10")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()
    }

    Scenario("No Associated companies - Happy path") {
      givenDefaultState()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user can see the options yes and No as not selected")
      andTheUserCanSeeTheOptionsYesAndNoAsNotSelected()

      When(s"the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()
    }
  }
}
