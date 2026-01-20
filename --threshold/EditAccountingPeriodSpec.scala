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

class EditAccountingPeriodSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Edit Accounting Period - Validations") {

    Scenario("Edit Accounting Period") {
      Then("the user is presented with a change link next to the accounting period dates")
        // ⚠️ No step-def match found for: the user is presented with a change link next to the accounting period dates

      And("the user can validate their accounting period dates as 1 April 2023 to 31 March 2024")
        // ⚠️ No step-def match found for: the user can validate their accounting period dates as 1 April 2023 to 31 March 2024

      When("the user clicks the change link next to the accounting period dates")
        // ⚠️ No step-def match found for: the user clicks the change link next to the accounting period dates

      Then("the user is navigated to the accounting period page")
        // ⚠️ No step-def match found for: the user is navigated to the accounting period page

      Then("the user can see the accounting end period as 31/03/2024")
        // ⚠️ No step-def match found for: the user can see the accounting end period as 31/03/2024

      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      And("the accounting period end date is provided as 31/12/2023")
        // ⚠️ No step-def match found for: the accounting period end date is provided as 31/12/2023

      Then("the user clicks the continue button on the accounting period page")
        // ⚠️ No step-def match found for: the user clicks the continue button on the accounting period page

      Then("the user is presented with the Check Your Answers page")
        // ⚠️ No step-def match found for: the user is presented with the Check Your Answers page

      And("the user can validate their accounting period dates as 1 January 2023 to 31 December 2023")
        // ⚠️ No step-def match found for: the user can validate their accounting period dates as 1 January 2023 to 31 December 2023

    }
  }
}
