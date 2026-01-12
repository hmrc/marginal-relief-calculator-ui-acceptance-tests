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

import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen

class DetailedCalculationSpec extends AnyFeatureSpec with GivenWhenThen with Matchers  {

  Feature("Detailed Calculation - Validations") {

    Scenario("2 years of accounting period, and 1 year MR is not applicable") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option No for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the Check Marginal Relief calculation in detail link is displayed")
      When("the user clicks the Check Marginal Relief calculation in detail link")
      Then("header displays as Full Marginal Relief calculation in detail")
      And("the Your details page contains Covers 2 HMRC financial years")
      And("the distribution amount has £ prefix and displayed as £0")
      And("the How its calculated section is displayed")
      And("Marginal Relief was not available in financial year 2022 to 2023 is displayed on the page")
      And("the total Marginal relief is £2,026.53")
      And("5 MR calculation steps are displayed")
      And("What is the marginal rate fraction link is displayed")
      And("the Taxable Profit section is displayed")
    }

    Scenario("Adjusted taxable profits including distributions is greater than the adjusted upper limit for the financial year") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 120000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option Yes for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      Then("the user is provided with an input field to provide distributions")
      And("the user provides £10,000 as distributions")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option yes for the question Did your company have any active associated companies?")
      Then("the user is presented with an input field for associated companies")
      And("the user inputs a valid number as 1 associated companies")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the Check Marginal Relief calculation in detail link is displayed")
      When("the user clicks the Check Marginal Relief calculation in detail link")
      Then("header displays as Full Marginal Relief calculation in detail")
      And("the Your details page contains Covers 2 HMRC financial years")
      And("the distribution amount has £ prefix and displayed as £10,000")
      And("the How its calculated section is displayed")
      And("Marginal Relief was not available in financial year 2022 to 2023 is displayed on the page")
      And("the total Marginal relief is £0")
      And("3 MR calculation steps are displayed")
      And("the Taxable Profit section is displayed")
    }

    Scenario("Adjusted taxable profits including distributions is less than the adjusted upper limit for the financial year") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 15000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option Yes for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      Then("the user is provided with an input field to provide distributions")
      And("the user provides £7,000 as distributions")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the Check Marginal Relief calculation in detail link is displayed")
      When("the user clicks the Check Marginal Relief calculation in detail link")
      Then("header displays as Full Marginal Relief calculation in detail")
      And("the Your details page contains Covers 2 HMRC financial years")
      And("the distribution amount has £ prefix and displayed as £7,000")
      And("the How its calculated section is displayed")
      And("Marginal Relief was not available in financial year 2022 to 2023 is displayed on the page")
      And("the total Marginal relief is £0")
      And("3 MR calculation steps are displayed")
      And("the Taxable Profit section is displayed")
    }

    Scenario("Display MR detail in tabs") {
      When("the accounting period start date is provided as 01/01/2024")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option No for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the Check Marginal Relief calculation in detail link is displayed")
      When("the user clicks the Check Marginal Relief calculation in detail link")
      Then("header displays as Full Marginal Relief calculation in detail")
      And("the Your details page contains Covers 2 HMRC financial years")
      And("the distribution amount has £ prefix and displayed as £0")
      And("the How its calculated section is displayed")
      And("the tabs are displayed")
      Then("the user clicks 2025 tab and verifies the tab")
    }

    Scenario("Back button") {
      When("the accounting period start date is provided as 01/01/2024")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option No for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the Check Marginal Relief calculation in detail link is displayed")
      When("the user clicks the Check Marginal Relief calculation in detail link")
      And("the How its calculated section is displayed")
      And("the tabs are displayed")
      Then("the user clicks 2025 tab and verifies the tab")
      When("the user clicks the back button")
      Then("the user navigates back to the result page and displays the green box of type £2,700")
    }

    Scenario("What to do next") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option No for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the Check Marginal Relief calculation in detail link is displayed")
      When("the user clicks the Check Marginal Relief calculation in detail link")
      Then("header displays as Full Marginal Relief calculation in detail")
      And("the Your details page contains Covers 2 HMRC financial years")
      And("the distribution amount has £ prefix and displayed as £0")
      And("the How its calculated section is displayed")
      And("What to do next section is displayed and it contains Complete your Corporation Tax return")
      And("What to do next session contains date 9months after POA end date which is 1 October 2024")
    }
  }
}
