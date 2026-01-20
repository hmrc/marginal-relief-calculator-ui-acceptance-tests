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

import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CompanyDetailsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.PreviewSummaryStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.DetailedCalculationStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*

class CompanyDetailsSpec extends BaseSpec {

  def givenDefaultState(): Unit = {

    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()

    When("""the accounting period start date is provided as "01/01/2023"""")
    theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

    Then("the user clicks the continue button on the accounting period page")
    andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

    And("""the profit is "70000"""")
    andTheProfitIs("70000")

    Then("the user clicks continue button on taxable profit page")
    andTheUserClicksContinueButtonOnTaxableProfitPage()

    And("""the user selects option "No" for the question Did your company receive any distributions?""")
    andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    Then("the user lands on the associated companies page")
    thenTheUserLandsOnTheAssociatedCompaniesPage()

    When("""the user selects option "no" for the question Did your company have any active associated companies?""")
    theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

    Then("the user clicks the continue button on the associated companies page")
    thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

    Then("the user is presented with the Check Your Answers page")
    thenTheUserIsPresentedWithTheCheckYourAnswersPage()

    And("the user clicks the calculate marginal relief button on the check your answers page")
    theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

    And("the Check Marginal Relief calculation in detail link is displayed")
    andTheCheckMarginalReliefCalculationInDetailLinkIsDisplayed()

    And("the user clicks the Get A Copy Of Results link")
    thenTheUserClicksTheGetACopyOfResultsLink()

    Then("the user is presented with add company details to your result page")
    thenTheUserIsPresentedWithAddCompanyDetailsToYourResultPage()

    And("""the user selects option as "yes" on add company details page""")
    andTheUserSelectsOptionAsOnAddCompanyDetailsPage("yes")
  }

  Feature("Company Details  - Validations") {

    Scenario("Company Details- Valid Scenario") {
      givenDefaultState()

      Then("the user lands on AddCompanyDetails page")
      theUserLandsOnAddCompanyDetailsPage()

      When("""the user provides a "Test-Company name" on Company name field""")
      theUserProvidesOnCompanyNameField("Test-Company name")

      And("""the user provides a "0987654321" on UTR number field""")
      theUserProvidesOnUTRNumberField("0987654321")

      And("the user clicks the continue button on the company details page")
      theUserClicksTheContinueButtonOnTheCompanyDetailsPage()

      Then("the user verifies the same name is displayed on the Preview summary page")
      andTheUserVerifiesTheSameNameIsDisplayedOnThePreviewSummaryPage()
    }
  }
}
