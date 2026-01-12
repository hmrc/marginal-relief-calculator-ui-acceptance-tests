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

class EditTaxableProfitSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Edit Taxable Profit - Validations") {

    Scenario("Edit Taxable Profit") {
      And("the user is presented with a change link next to the company's profit")
        // Possible match (best=0.85)
        thenTheUserIsPresentedWithAChangeLinkNextToTheCompanyProfit()

      Then("the user can validate their company profit as £50,000")
        // ⚠️ No step-def match found for: the user can validate their company profit as £50,000

      And("the user clicks the change link next to the company's profit")
        // Possible match (best=0.85)
        thenTheUserClicksTheChangeLinkNextToTheCompanyProfit()

      And("I am navigated to taxable profit page")
        // Possible match (best=1.00)
        thenIAmNavigatedToTaxableProfitPage()

      And("I validate company profit is pre-populated as 50000")
        // ⚠️ No step-def match found for: I validate company profit is pre-populated as 50000

      And("the profit is 100000")
        // ⚠️ No step-def match found for: the profit is 100000

      And("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      Then("the user is presented with a change link next to the company's profit")
        // Possible match (best=0.85)
        thenTheUserIsPresentedWithAChangeLinkNextToTheCompanyProfit()

      And("the user can validate their company profit as £100,000")
        // ⚠️ No step-def match found for: the user can validate their company profit as £100,000

    }
  }
}
