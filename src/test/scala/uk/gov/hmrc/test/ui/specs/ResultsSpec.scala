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

class ResultsSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Results - Validations") {

    Scenario("Your taxable profits are above the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 260000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option No for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type Your taxable profits are above the Marginal Relief limit")
    }

    Scenario("Your taxable profits and included distributions are above the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 260000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option Yes for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      Then("the user is provided with an input field to provide distributions")
      And("the user provides £5,000 as distributions")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type Your taxable profits and included distributions are above the Marginal Relief limit")
    }

    Scenario("Your taxable profits are below the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 45000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option No for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type Your taxable profits are below the Marginal Relief limit")
    }

    Scenario("Your taxable profits and included distributions are below the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 44500")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option Yes for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      Then("the user is provided with an input field to provide distributions")
      And("the user provides £5,000 as distributions")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      Then("the user is presented with the Check Your Answers page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type Your taxable profits and included distributions are below the Marginal Relief limit")
    }

    Scenario("Your taxable profits and included distributions are above the Marginal Relief limit with value") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 60000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option Yes for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      Then("the user is provided with an input field to provide distributions")
      And("the user provides £5,000 as distributions")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type £1,922.80")
    }

    Scenario("CT liability payable- MRC Dual year") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type £2,026.53")
      Then("the corporation tax liability heading is displayed as £14,437.85")
      Then("the accounting period covering 2 years section is displayed")
      And("the corporation tax liability body is displayed as Reduced from £16,464.38 after £2,026.53 Marginal Relief for dual year")
      And("the dual year corporation tax liability table is displayed")
    }

    Scenario("CT liability payable- MRC Single year") {
      When("the accounting period start date is provided as 01/06/2023")
      And("the accounting period end date is provided as 31/12/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      And("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user lands on the associated companies page")
      And("the user selects option no for the question Did your company have any active associated companies?")
      And("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type £1,148.63")
      And("the corporation tax liability heading is displayed as £16,351.37")
      And("the corporation tax liability body is displayed as Reduced from £17,500 after £1,148.63 Marginal Relief for single year")
      And("the single year corporation tax liability table is displayed")
    }

    Scenario("CT liability payable- No MRC") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 45000")
      Then("the user clicks continue button on taxable profit page")
      And("the user selects option No for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("the user lands on the associated companies page")
      When("the user selects option no for the question Did your company have any active associated companies?")
      Then("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      Then("display the green box of type Your taxable profits are below the Marginal Relief limit")
      And("the corporation tax liability heading is displayed as £8,550")
      And("the corporation tax liability body is not displayed")
      And("the NO MRC dual year corporation tax liability table is displayed")
    }

    Scenario("Effective tax rate- MRC Dual year") {
      When("the accounting period start date is provided as 01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      And("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user lands on the associated companies page")
      And("the user selects option no for the question Did your company have any active associated companies?")
      And("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the effective tax rate heading is displayed as 20.63%")
      And("the effective tax body is displayed as Reduced from 23.52% after Marginal Relief for dual year")
      And("the dual year effective tax table is displayed")
    }

    Scenario("Effective tax rate- MRC Single year") {
      When("the accounting period start date is provided as 01/06/2023")
      When("the accounting period end date is provided as 31/12/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 70000")
      And("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user lands on the associated companies page")
      And("the user selects option no for the question Did your company have any active associated companies?")
      And("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the effective tax rate heading is displayed as 23.36%")
      And("the effective tax body is displayed as Reduced from 25% after Marginal Relief for single year")
      And("the single year effective tax table is displayed")
    }

    Scenario("Effective tax rate- NO MRC Dual year") {
      When("the accounting period start date is provided as 01/01/2023")
      When("the accounting period end date is provided as 31/12/2023")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 37000")
      And("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user lands on the associated companies page")
      And("the user selects option no for the question Did your company have any active associated companies?")
      And("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the effective tax rate heading is displayed as 19%")
      And("the NO MRC effective tax table is displayed")
    }

    Scenario("Effective tax rate- Small profit rate") {
      When("the accounting period start date is provided as 01/01/2024")
      Then("the user clicks the continue button on the accounting period page")
      When("the profit is 25000")
      And("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      And("the user lands on the associated companies page")
      And("the user selects option no for the question Did your company have any active associated companies?")
      And("the user clicks the continue button on the associated companies page")
      And("the user clicks the calculate marginal relief button on the check your answers page")
      And("the effective tax rate heading is displayed as 19%")
      And("the Small profit rate effective tax table is displayed")
    }
  }
}
