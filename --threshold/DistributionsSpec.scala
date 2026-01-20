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

class DistributionsSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Exempt Distributions - Validations") {

    Scenario("User selects No for question Did your company receive any distributions") {
      And("the user selects option No for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option No for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      Then("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

    }

    Scenario("User selects Yes for question Did your company receive any distributions and No to include in profits") {
      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      And("the user selects option No for the question Do any distributions need to be included with your profits?")
        // ⚠️ No step-def match found for: the user selects option No for the question Do any distributions need to be included with your profits?

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      Then("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

    }

    Scenario("Happy Path - Yes for question Did your company receive any distributions and Yes to include in profits") {
      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Do any distributions need to be included with your profits?

      Then("the user is provided with an input field to provide distributions")
        // ⚠️ No step-def match found for: the user is provided with an input field to provide distributions

      And("the user provides £50,000 as distributions")
        // ⚠️ No step-def match found for: the user provides £50,000 as distributions

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      Then("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

    }

    Scenario("Happy Path - Distributions amount is displayed on check your answers page") {
      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Do any distributions need to be included with your profits?

      And("the user provides £200,500,000 as distributions")
        // ⚠️ No step-def match found for: the user provides £200,500,000 as distributions

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      Then("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

      When("the user selects option yes for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option yes for the question Did your company have any active associated companies?

      And("the user inputs a valid number as 1 associated companies")
        // ⚠️ No step-def match found for: the user inputs a valid number as 1 associated companies

      Then("the user clicks the continue button on the associated companies page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the associated companies page

      Then("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

      Then("the user is presented with change link next to the distribution amount")
        // ⚠️ No step-def match found for: the user is presented with change link next to the distribution amount

      And("the user can validate their distribution amount as £200,500,000")
        // ⚠️ No step-def match found for: the user can validate their distribution amount as £200,500,000

      When("the user clicks the change link next to the distribution amount")
        // ⚠️ No step-def match found for: the user clicks the change link next to the distribution amount

      Then("the user is navigated to the exempt distributions page")
        // ⚠️ No step-def match found for: the user is navigated to the exempt distributions page

      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      When("the user changes the distributions value to £30,000")
        // ⚠️ No step-def match found for: the user changes the distributions value to £30,000

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      Then("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

      And("the user can validate their distribution amount as £30,000")
        // ⚠️ No step-def match found for: the user can validate their distribution amount as £30,000

    }

    Scenario("Zero Distributions Shown as NONE on check your answers page") {
      And("the user selects option No for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option No for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the distributions page

      Then("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the associated companies page

      Then("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

      And("the user can validate their distribution amount as None")
        // ⚠️ No step-def match found for: the user can validate their distribution amount as None

    }
  }
}
