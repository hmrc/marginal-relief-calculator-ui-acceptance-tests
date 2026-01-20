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

class EditAssociatedcompaniesSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Edit Associated Companies - Validations") {

    Scenario("Edit Associated Companies, ZapTests") {
      And("the user is presented with a change link next to the associated companies")
        // ⚠️ No step-def match found for: the user is presented with a change link next to the associated companies

      Then("the user can validate the associated companies as 25")
        // ⚠️ No step-def match found for: the user can validate the associated companies as 25

      And("the user clicks the change link next to the associated companies")
        // ⚠️ No step-def match found for: the user clicks the change link next to the associated companies

      And("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

      And("the user validates associated companies are pre-populated as 25")
        // ⚠️ No step-def match found for: the user validates associated companies are pre-populated as 25

      And("the user inputs a valid number as 50 associated companies")
        // ⚠️ No step-def match found for: the user inputs a valid number as 50 associated companies

      Then("the user clicks the continue button on the associated companies page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the associated companies page

      And("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

      And("the user can validate the associated companies as 50")
        // ⚠️ No step-def match found for: the user can validate the associated companies as 50

    }

    Scenario("Edit Associated Companies-No Associated Company") {
      And("the user is presented with a change link next to the associated companies")
        // ⚠️ No step-def match found for: the user is presented with a change link next to the associated companies

      Then("the user can validate the associated companies as 25")
        // ⚠️ No step-def match found for: the user can validate the associated companies as 25

      And("the user clicks the change link next to the associated companies")
        // ⚠️ No step-def match found for: the user clicks the change link next to the associated companies

      And("the user lands on the associated companies page")
        // ⚠️ No step-def match found for: the user lands on the associated companies page

      And("the user validates associated companies are pre-populated as 25")
        // ⚠️ No step-def match found for: the user validates associated companies are pre-populated as 25

      And("the user selects option No for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option No for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the associated companies page

      And("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

      And("the user can validate the associated companies as 0")
        // ⚠️ No step-def match found for: the user can validate the associated companies as 0

    }
  }
}
