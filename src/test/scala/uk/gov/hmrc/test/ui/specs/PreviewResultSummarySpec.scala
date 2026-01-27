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

import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CompanyDetailsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.PreviewSummaryStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.DetailedCalculationStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*

class PreviewResultSummarySpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()
    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()
    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()
  }

  Feature("Preview Result Summary  - Validations") {
    Scenario("Preview results summary information before retaining a calculation") {
      givenDefaultState()

      And("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      And("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      And("the profit is 70000")
      andTheProfitIs("70000")

      And("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And(s"the user selects option No for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the Check Marginal Relief calculation in detail link is displayed")
      andTheCheckMarginalReliefCalculationInDetailLinkIsDisplayed()

      When("the user clicks the Get A Copy Of Results link")
      thenTheUserClicksTheGetACopyOfResultsLink()

      And("the user selects option as Yes on add company details page")
      andTheUserSelectsOptionAsOnAddCompanyDetailsPage("yes")

      And("the user clicks the continue button on the company details page")
      theUserClicksTheContinueButtonOnTheCompanyDetailsPage()

      Then("Print your calculation should be displayed")
      andShouldBeDisplayed("Print your calculation")

      And("Print your full calculation link is available")
      andLinkIsAvailable("Print your full calculation")

      And("marginal results are shown")
      andMarginalResultsAreShown()

    }
  }
}
