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

class FutureScenariosSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("2 Associated companies - Validations on different pages") {

    Scenario("Verify 2 associated companies on check your answers page") {
      When("the user inputs 2 associated companies for the first part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 2 associated companies for the first part of accounting period

      When("the user inputs 3 associated companies for the second part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 3 associated companies for the second part of accounting period

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then("the user validates associated companies for the first part of financial year as 2")
        // ⚠️ No step-def match found for: the user validates associated companies for the first part of financial year as 2

      Then("the user validates associated companies for the second part of financial year as 3")
        // ⚠️ No step-def match found for: the user validates associated companies for the second part of financial year as 3

    }

    Scenario("Verify 2 associated companies on results page") {
      When("the user inputs 1 associated companies for the first part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 1 associated companies for the first part of accounting period

      When("the user inputs 3 associated companies for the second part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 3 associated companies for the second part of accounting period

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then("the user validates associated companies for the first part of financial year as 1")
        // ⚠️ No step-def match found for: the user validates associated companies for the first part of financial year as 1

      Then("the user validates associated companies for the second part of financial year as 3")
        // ⚠️ No step-def match found for: the user validates associated companies for the second part of financial year as 3

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £612.07")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

      And("the user validates the associated companies on the results page as 2026 to 2027: 1")
        // ⚠️ No step-def match found for: the user validates the associated companies on the results page as 2026 to 2027: 1

      And("the user validates the associated companies on the results page as 2027 to 2028: 3")
        // ⚠️ No step-def match found for: the user validates the associated companies on the results page as 2027 to 2028: 3

    }

    Scenario("Verify 2 associated companies on detailed calculation page") {
      When("the user inputs 1 associated companies for the first part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 1 associated companies for the first part of accounting period

      When("the user inputs 3 associated companies for the second part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 3 associated companies for the second part of accounting period

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then("the user validates associated companies for the first part of financial year as 1")
        // ⚠️ No step-def match found for: the user validates associated companies for the first part of financial year as 1

      Then("the user validates associated companies for the second part of financial year as 3")
        // ⚠️ No step-def match found for: the user validates associated companies for the second part of financial year as 3

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £612.07")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

      And("the user validates the associated companies on the results page as 2026 to 2027: 1")
        // ⚠️ No step-def match found for: the user validates the associated companies on the results page as 2026 to 2027: 1

      And("the user validates the associated companies on the results page as 2027 to 2028: 3")
        // ⚠️ No step-def match found for: the user validates the associated companies on the results page as 2027 to 2028: 3

      And("the Check Marginal Relief calculation in detail link is displayed")
        // Possible match (best=1.00)
        andTheCheckMarginalReliefCalculationInDetailLinkIsDisplayed()

      When("the user clicks the Check Marginal Relief calculation in detail link")
        // Possible match (best=1.00)
        andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      Then("the user validates the associated companies on the detailed calculation page as 2026 to 2027: 1")
        // ⚠️ No step-def match found for: the user validates the associated companies on the detailed calculation page as 2026 to 2027: 1

      And("the user validates the associated companies on the detailed calculation page as 2027 to 2028: 3")
        // ⚠️ No step-def match found for: the user validates the associated companies on the detailed calculation page as 2027 to 2028: 3

    }

    Scenario("Verify 2 associated companies on PDF page") {
      When("the user inputs 1 associated companies for the first part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 1 associated companies for the first part of accounting period

      When("the user inputs 3 associated companies for the second part of accounting period")
        // ⚠️ No step-def match found for: the user inputs 3 associated companies for the second part of accounting period

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then("the user validates associated companies for the first part of financial year as 1")
        // ⚠️ No step-def match found for: the user validates associated companies for the first part of financial year as 1

      Then("the user validates associated companies for the second part of financial year as 3")
        // ⚠️ No step-def match found for: the user validates associated companies for the second part of financial year as 3

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £612.07")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

      And("the user validates the associated companies on the results page as 2026 to 2027: 1")
        // ⚠️ No step-def match found for: the user validates the associated companies on the results page as 2026 to 2027: 1

      And("the user validates the associated companies on the results page as 2027 to 2028: 3")
        // ⚠️ No step-def match found for: the user validates the associated companies on the results page as 2027 to 2028: 3

      And("the user clicks the Get A Copy Of Results link")
        // Possible match (best=1.00)
        thenTheUserClicksTheGetACopyOfResultsLink()

      Then("the user is presented with add company details to your result page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithAddCompanyDetailsToYourResultPage()

      And("the user selects option as no on add company details page")
        // ⚠️ No step-def match found for: the user selects option as no on add company details page

      Then("the user validates the associated companies on the PDF page as 2026 to 2027: 1")
        // ⚠️ No step-def match found for: the user validates the associated companies on the PDF page as 2026 to 2027: 1

      And("the user validates the associated companies on the PDF page as 2027 to 2028: 3")
        // ⚠️ No step-def match found for: the user validates the associated companies on the PDF page as 2027 to 2028: 3

    }
  }
}
