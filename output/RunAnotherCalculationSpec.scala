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

import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen

class RunAnotherCalculationSpec extends AnyFeatureSpec with GivenWhenThen with Matchers{

  Feature("Run another calculation - Validations") {

    Scenario("Click on Run Another Calculation and verify fields as NULL") {
      When("the user clicks the run another calculation button")
        // Possible match (best=1.00)
        thenTheUserClicksTheRunAnotherCalculationButton()

      Then("the user lands on the before you start page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheBeforeYouStartPage()

      When("the user clicks the start now button")
        // Possible match (best=1.00)
        andTheUserClicksTheStartNowButton()

      Then("the user can see the accounting period start and end dates as null")
        // Possible match (best=1.00)
        thenTheUserCanSeeTheAccountingPeriodStartAndEndDatesAsNull()

      When("the accounting period start date is provided as 31/03/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 31/03/2023

      When("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      Then("I can see companies taxable profit as null")
        // Possible match (best=1.00)
        thenICanSeeCompaniesTaxableProfitAsNull()

      And("the profit is 50000")
        // ⚠️ No step-def match found for: the profit is 50000

      When("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      Then("the user is navigated to the exempt distributions page")
        // Possible match (best=1.00)
        thenTheUserIsNavigatedToTheExemptDistributionsPage()
        // --- Other possible matches ---
        // thenTheUserIsNavigatedToTheSecondExemptDistributionsPage() [0.78] (ExcemptDistributionsStepDefSteps.scala) pattern: the user is navigated to the Second exempt distributions page

      And("the user can see the options yes, no are not selected")
        // ⚠️ No step-def match found for: the user can see the options yes, no are not selected

      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user can see the options yes,no are not selected on the Second exempt distributions page")
        // Possible match (best=0.85)
        thenTheUserCanSeeTheOptionsYesnoAreNotSelectedOnTheSecondExemptDistributionsPage()

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Do any distributions need to be included with your profits?

      Then("the user is provided with an input field to provide distributions")
        // Possible match (best=1.00)
        thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £50,000 as distributions")
        // ⚠️ No step-def match found for: the user provides £50,000 as distributions

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user can see the options yes and No as not selected")
        // Possible match (best=1.00)
        andTheUserCanSeeTheOptionsYesAndNoAsNotSelected()

      When("the user selects option yes for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option yes for the question Did your company have any active associated companies?

      Then("the user is presented with an input field for associated companies")
        // Possible match (best=1.00)
        andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

      And("the user is presented with an input field for associated companies with the value as null")
        // Possible match (best=1.00)
        andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()
        // --- Other possible matches ---
        // andTheUserIsPresentedWithAnInputFieldForAssociatedCompaniesWithTheValueAsNull() [1.00] (AssociatedCompaniesStepDefSteps.scala) pattern: the user is presented with an input field for associated companies with the value as null

      And("the user inputs a valid number as 2 associated companies")
        // ⚠️ No step-def match found for: the user inputs a valid number as 2 associated companies

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user can see the calculate margin relief button enabled")
        // Possible match (best=1.00)
        andTheUserCanSeeTheCalculateMarginReliefButtonEnabled()

      When("the user can click on the calculate margin relief button")
        // Possible match (best=1.00)
        whenTheUserCanClickOnTheCalculateMarginReliefButton()

      And("the user can see the run another calculation button enabled")
        // Possible match (best=1.00)
        thenTheUserCanSeeTheRunAnotherCalculationButtonEnabled()

    }
  }
}
