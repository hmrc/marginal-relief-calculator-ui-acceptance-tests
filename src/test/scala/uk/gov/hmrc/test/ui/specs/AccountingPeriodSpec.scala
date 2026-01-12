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

class AccountingPeriodSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Accounting Period - Validations") {

    Scenario("Auto generated accounting end date when accounting end date is not provided [accountingStartDate=29/02/2024, ExpectedAccountingEndDate=27/2/2025]") {
      When("the accounting period start date is provided as 29/02/2024")
      And("the user clicks the continue button on the accounting period page")
      And("the user clicks the back button")
      Then("the user can see the accounting end period as 27/2/2025")
    }

    Scenario("Auto generated accounting end date when accounting end date is not provided [accountingStartDate=01/03/2025, ExpectedAccountingEndDate=28/2/2026]") {
      When("the accounting period start date is provided as 01/03/2025")
      And("the user clicks the continue button on the accounting period page")
      And("the user clicks the back button")
      Then("the user can see the accounting end period as 28/2/2026")
    }

    Scenario("Auto generated accounting end date when accounting end date is not provided [accountingStartDate=08/09/2022, ExpectedAccountingEndDate=7/9/2023]") {
      When("the accounting period start date is provided as 08/09/2022")
      And("the user clicks the continue button on the accounting period page")
      And("the user clicks the back button")
      Then("the user can see the accounting end period as 7/9/2023")
    }

    Scenario("Marginal Relief not relevant for accounting period [accountingStartDate=01/04/2022, accountingEndDate=31/03/2023]") {
      When("the accounting period start date is provided as 01/04/2022")
      And("the accounting period end date is provided as 31/03/2023")
      And("the user clicks the continue button on the accounting period page")
      Then("the user is shown the ineligible accounting period page")
    }

    Scenario("Marginal Relief not relevant for accounting period [accountingStartDate=01/10/2022, accountingEndDate=28/02/2023]") {
      When("the accounting period start date is provided as 01/10/2022")
      And("the accounting period end date is provided as 28/02/2023")
      And("the user clicks the continue button on the accounting period page")
      Then("the user is shown the ineligible accounting period page")
    }

    Scenario("Marginal Relief not relevant for accounting period [accountingStartDate=01/04/2022]") {
      When("the accounting period start date is provided as 01/04/2022")
      And("the user clicks the continue button on the accounting period page")
      Then("the user is shown the ineligible accounting period page")
    }

    Scenario("Accounting period-Content change [accountingPeriodContent=Your accounting period cannot be longer than a full year and is normally the same as the financial year covered by your company's annual accounts., accountingPeriodEndDateContent=If you do not enter a date we will default to a full year from the start date]") {
      When("the user reads content on accounting period as Your accounting period cannot be longer than a full year and is normally the same as the financial year covered by your company's annual accounts.")
      Then("the user reads content on accounting end date as If you do not enter a date we will default to a full year from the start date")
    }
  }
}
