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

class PreviewResultSummarySpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Preview Result Summary  - Validations") {

    Scenario("Preview results summary information before retaining a calculation") {
      And("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      And("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      And("the profit is 70000")
        // ⚠️ No step-def match found for: the profit is 70000

      And("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option No for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option No for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the Check Marginal Relief calculation in detail link is displayed")
        // Possible match (best=1.00)
        andTheCheckMarginalReliefCalculationInDetailLinkIsDisplayed()

      When("the user clicks the Get A Copy Of Results link")
        // Possible match (best=1.00)
        thenTheUserClicksTheGetACopyOfResultsLink()

      And("the user selects option as yes on add company details page")
        // ⚠️ No step-def match found for: the user selects option as yes on add company details page

      And("the user clicks the continue button on the company details page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheCompanyDetailsPage()

      Then("Print your calculation should be displayed")
        // ⚠️ No step-def match found for: Print your calculation should be displayed

      And("Print your full calculation link is available")
        // ⚠️ No step-def match found for: Print your full calculation link is available

      And("marginal results are shown")
        // Possible match (best=1.00)
        andMarginalResultsAreShown()

    }
  }
}
