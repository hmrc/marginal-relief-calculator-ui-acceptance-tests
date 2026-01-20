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

class AssociatedcompaniesSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Associated companies - Validations") {

    Scenario("Associated companies - Happy path") {
      Then("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

      And("the user can see the options yes and No as not selected")
        // ⚠️ No step-def match found for: the user can see the options yes and No as not selected

      When("the user selects option yes for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option yes for the question Did your company have any active associated companies?

      Then("the user is presented with an input field for associated companies")
        // ⚠️ No step-def match found for: the user is presented with an input field for associated companies

      And("the user inputs a valid number as 10 associated companies")
        // ⚠️ No step-def match found for: the user inputs a valid number as 10 associated companies

      Then("the user clicks the continue button on the associated companies page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the associated companies page

      Then("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

    }

    Scenario("No Associated companies - Happy path") {
      Then("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

      And("the user can see the options yes and No as not selected")
        // ⚠️ No step-def match found for: the user can see the options yes and No as not selected

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the associated companies page

      Then("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

    }
  }
}
