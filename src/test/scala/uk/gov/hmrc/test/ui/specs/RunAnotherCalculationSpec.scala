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

import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*

class RunAnotherCalculationSpec extends BaseSpec {

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

    And("the user can see the calculate margin relief button enabled")
    theUserCanSeeTheCalculateMarginReliefButtonEnabled()

    When("the user can click on the calculate margin relief button")
    theUserCanClickOnTheCalculateMarginReliefButton()

    And("the user can see the run another calculation button enabled")
    theUserCanSeeTheRunAnotherCalculationButtonEnabled()
  }

  Feature("Run another calculation - Validations") {

    Scenario("Click on Run Another Calculation and verify fields as NULL , ZapTests") {
      givenDefaultState()

      When("the user clicks the run another calculation button")
      theUserClicksTheRunAnotherCalculationButton()

      Then("the user lands on the before you start page")
      thenTheUserLandsOnTheBeforeYouStartPage()

      When("the user clicks the start now button")
      andTheUserClicksTheStartNowButton()

      Then("the user can see the accounting period start and end dates as null")
      thenTheUserCanSeeTheAccountingPeriodStartAndEndDatesAsNull()

      When("the accounting period start date is provided as 31/03/2023")
      theAccountingPeriodStartDateIsProvidedAs("31/03/2023")

      When("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      Then("I can see companies taxable profit as null")
      thenICanSeeCompaniesTaxableProfitAsNull()

      And("the profit is 50000")
      andTheProfitIs("50000")

      When("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      Then("the user is navigated to the exempt distributions page")
      thenTheUserIsNavigatedToTheExemptDistributionsPage()

      And("the user can see the options yes, no are not selected")
      thenTheUserCanSeeTheOptionsYesNoAreNotSelected()

      And("the user selects option Yes for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("Yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user can see the options Yes,no are not selected on the Second exempt distributions page")
      thenTheUserCanSeeTheOptionsYesnoAreNotSelectedOnTheSecondExemptDistributionsPage()

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("Yes")

      Then("the user is provided with an input field to provide distributions")
      thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £50,000 as distributions")
      andTheUserProvidesAsDistributions("£50,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user can see the options Yes and No as not selected")
      andTheUserCanSeeTheOptionsYesAndNoAsNotSelected()

      When("the user selects option Yes for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

      Then("the user is presented with an input field for associated companies")
      andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

      And("the user is presented with an input field for associated companies with the value as null")
      andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

      And("the user inputs a valid number as 2 associated companies")
      andTheUserInputsAValidNumberAsAssociatedCompanies("2")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user can see the calculate margin relief button enabled")
      theUserCanSeeTheCalculateMarginReliefButtonEnabled()

      When("the user can click on the calculate margin relief button")
      theUserCanClickOnTheCalculateMarginReliefButton()

      And("the user can see the run another calculation button enabled")
      theUserCanSeeTheRunAnotherCalculationButtonEnabled()

    }
  }
}
