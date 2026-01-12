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

class CheckYourAnswersSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Check your answers - Validations") {

    Scenario("Validate all values on check your answers page") {
      Then("the user can validate the accounting period as 1 January 2023 to 31 December 2023.\nEnd date defaulted to a full year from the start date.")
        // ⚠️ No step-def match found for: the user can validate the accounting period as 1 January 2023 to 31 December 2023.\nEnd date defaulted to a full year from the start date.

      Then("the user can validate profit as £50,000")
        // ⚠️ No step-def match found for: the user can validate profit as £50,000

      Then("the user can validate distributions included as £50,000")
        // ⚠️ No step-def match found for: the user can validate distributions included as £50,000

      Then("the user can validate associated companies as 10")
        // ⚠️ No step-def match found for: the user can validate associated companies as 10

      And("the user can see the calculate margin relief button enabled")
        // Possible match (best=1.00)
        andTheUserCanSeeTheCalculateMarginReliefButtonEnabled()

    }

    Scenario("Clicking on back button") {
      When("the user clicks the back button")
        // Possible match (best=1.00)
        whenTheUserClicksTheBackButton()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

    }

    Scenario("Clicking on back button after changing the distributions amount") {
      Then("the user is presented with change link next to the distribution amount")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithChangeLinkNextToTheDistributionAmount()
        // --- Other possible matches ---
        // thenTheUserClicksTheChangeLinkNextToTheDistributionAmount() [0.79] (CheckYourAnswersStepDefSteps.scala) pattern: the user clicks the change link next to the distribution amount

      And("the user can validate their distribution amount as £50,000")
        // ⚠️ No step-def match found for: the user can validate their distribution amount as £50,000

      When("the user clicks the change link next to the distribution amount")
        // Possible match (best=1.00)
        thenTheUserClicksTheChangeLinkNextToTheDistributionAmount()

      Then("the user is navigated to the exempt distributions page")
        // Possible match (best=1.00)
        thenTheUserIsNavigatedToTheExemptDistributionsPage()
        // --- Other possible matches ---
        // thenTheUserIsNavigatedToTheSecondExemptDistributionsPage() [0.78] (ExcemptDistributionsStepDefSteps.scala) pattern: the user is navigated to the Second exempt distributions page

      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      When("the user changes the distributions value to £30,000")
        // ⚠️ No step-def match found for: the user changes the distributions value to £30,000

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user can validate their distribution amount as £30,000")
        // ⚠️ No step-def match found for: the user can validate their distribution amount as £30,000

      When("the user clicks the back button")
        // Possible match (best=1.00)
        whenTheUserClicksTheBackButton()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

    }

    Scenario("Verify message for default accounting period end date") {
      Then("the user can validate the accounting period as 1 January 2023 to 31 December 2023.\nEnd date defaulted to a full year from the start date.")
        // ⚠️ No step-def match found for: the user can validate the accounting period as 1 January 2023 to 31 December 2023.\nEnd date defaulted to a full year from the start date.

      When("the user clicks the change link next to the accounting period dates")
        // Possible match (best=1.00)
        thenTheUserClicksTheChangeLinkNextToTheAccountingPeriodDates()

      Then("the user is navigated to the accounting period page")
        // Possible match (best=1.00)
        thenTheUserIsNavigatedToTheAccountingPeriodPage()

      Then("the user can see the accounting end period as 31/12/2023")
        // ⚠️ No step-def match found for: the user can see the accounting end period as 31/12/2023

      When("the accounting period start date is provided as 01/04/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/04/2023

      And("the accounting period end date is provided as 31/03/2024")
        // ⚠️ No step-def match found for: the accounting period end date is provided as 31/03/2024

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user can validate their accounting period dates as 1 April 2023 to 31 March 2024")
        // ⚠️ No step-def match found for: the user can validate their accounting period dates as 1 April 2023 to 31 March 2024

    }
  }
}
