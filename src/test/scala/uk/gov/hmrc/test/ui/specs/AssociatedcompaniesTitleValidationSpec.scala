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


class AssociatedcompaniesTitleValidationSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Associated companies Title Message - Validations") {

    Scenario("Enter associated companies for a portion of the accounting period [accountingStartDate=01/05/2024, accountingEndDate=31/12/2024, profitValue=50000, message=Did your company have any active associated companies?]") {
      When("the accounting period start date is provided as 01/05/2024")
      And("the accounting period end date is provided as 31/12/2024")
      And("the user clicks the continue button on the accounting period page")
      And("the profit is 50000")
      And("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("display the Did your company have any active associated companies? on associated company")
    }

    Scenario("Enter associated companies for a portion of the accounting period [accountingStartDate=01/01/2023, accountingEndDate=31/12/2023, profitValue=50000, message=Did your company have any active associated companies between 1 April 2023 and 31 December 2023?]") {
      When("the accounting period start date is provided as 01/01/2023")
      And("the accounting period end date is provided as 31/12/2023")
      And("the user clicks the continue button on the accounting period page")
      And("the profit is 50000")
      And("the user clicks continue button on taxable profit page")
      And("the user selects option no for the question Did your company receive any distributions?")
      And("the user clicks the continue button on the distributions page")
      Then("display the Did your company have any active associated companies between 1 April 2023 and 31 December 2023? on associated company")
    }
  }
}
