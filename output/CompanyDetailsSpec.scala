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

class CompanyDetailsSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Company Details  - Validations") {

    Scenario("Company Details- Valid Scenario [validCompanyName=Test-Company name, validUTRNumber=0987654321]") {
      Then("the user lands on AddCompanyDetails page")
        // Possible match (best=1.00)
        thenTheUserLandsOnAddCompanyDetailsPage()

      When("the user provides a Test-Company name on Company name field")
        // ⚠️ No step-def match found for: the user provides a Test-Company name on Company name field

      And("the user provides a 0987654321 on UTR number field")
        // ⚠️ No step-def match found for: the user provides a 0987654321 on UTR number field

      And("the user clicks the continue button on the company details page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheCompanyDetailsPage()

      Then("the user verifies the same name is displayed on the Preview summary page")
        // Possible match (best=1.00)
        andTheUserVerifiesTheSameNameIsDisplayedOnThePreviewSummaryPage()

    }
  }
}
