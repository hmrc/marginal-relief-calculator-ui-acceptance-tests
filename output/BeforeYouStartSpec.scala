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

class BeforeYouStartSpec extends  AnyFeatureSpec with GivenWhenThen with Matchers  {

  Feature("Before you start page - Validations") {

    Scenario("Validating before you start page validations") {
      Given("Marginal Relief Calculator is launched")
        // Possible match (best=1.00)
        givenMarginalReliefCalculatorIsLaunched()

      When("the user lands on the before you start page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheBeforeYouStartPage()

      Then("the user can see the breadcrumbs on the page")
        // Possible match (best=1.00)
        andTheUserCanSeeTheBreadcrumbsOnThePage()

      And("the user can verify that Welsh language is not displayed")
        // Possible match (best=1.00)
        andTheUserCanVerifyThatWelshLanguageIsNotDisplayed()

      Then("the user can verify the link present on screen")
        // Possible match (best=1.00)
        andTheUserCanVerifyTheLinkPresentOnScreen(null)

      When("the user clicks the start now button")
        // Possible match (best=1.00)
        andTheUserClicksTheStartNowButton()

      Then("the user lands on the accounting period page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAccountingPeriodPage()

    }
  }
}
