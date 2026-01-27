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

import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.DetailedCalculationStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.ResultsStepDefSteps.*

class DetailedCalculationSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()
    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()
    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()
  }

  Feature("Detailed Calculation - Validations") {

    Scenario("2 years of accounting period, and 1 year MR is not applicable") {
      givenDefaultState()

      When("""the accounting period start date is provided as "01/01/2023"""")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("""the profit is "70000""""")
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

      When("the user clicks the Check Marginal Relief calculation in detail link")
      andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      Then("""header displays as "Full Marginal Relief calculation in detail"""")
      thenHeaderDisplaysAs("Full Marginal Relief calculation in detail")

      And("""the Your details page contains "Covers 2 HMRC financial years""""")
      thenTheYourDetailsPageContains("Covers 2 HMRC financial years")

      And(""""the distribution amount has £ prefix and displayed as "£0""""")
      thenTheDistributionAmountHasPrefixAndDisplayedAs("£0")

      And("the How its calculated section is displayed")
      thenTheHowItsCalculatedSectionIsDisplayed()

      And(""""Marginal Relief was not available in financial year 2022 to 2023" is displayed on the page""")
      thenIsDisplayedOnThePage("Marginal Relief was not available in financial year 2022 to 2023")

      And("""the total Marginal relief is "£2,026.53""""")
      thenTheTotalMarginalReliefIs("£2,026.53")

      And(""""5" MR calculation steps are displayed""")
      thenMRCalculationStepsAreDisplayed("5")
      And("What is the marginal rate fraction link is displayed")
      thenWhatIsTheMarginalRateFractionLinkIsDisplayed()

      And("the Taxable Profit section is displayed")
      thenTheTaxableProfitSectionIsDisplayed()

    }

    Scenario(
      "Adjusted taxable profits including distributions is greater than the adjusted upper limit for the financial year"
    ) {
      givenDefaultState()

      When("""the accounting period start date is provided as "01/01/2023"""")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")
      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("""the profit is "120000"""")
      andTheProfitIs("120000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("""the user selects option "yes" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And(
        """the user selects option "yes" for the question Do any distributions need to be included with your profits?"""
      )
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("yes")

      Then("the user is provided with an input field to provide distributions")
      thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("""the user provides "£10,000" as distributions""")
      andTheUserProvidesAsDistributions("£10,000")
      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("""the user selects option yes for the question Did your company have any active associated companies?""")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

      Then("the user is presented with an input field for associated companies")
      andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

      And("""the user inputs a valid number as "1" associated companies""")
      andTheUserInputsAValidNumberAsAssociatedCompanies("1")
      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the Check Marginal Relief calculation in detail link is displayed")
      andTheCheckMarginalReliefCalculationInDetailLinkIsDisplayed()

      When("the user clicks the Check Marginal Relief calculation in detail link")
      andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      Then("""header displays as "Full Marginal Relief calculation in detail"""")
      thenHeaderDisplaysAs("Full Marginal Relief calculation in detail")

      And("""the Your details page contains "Covers 2 HMRC financial years"""")
      thenTheYourDetailsPageContains("Covers 2 HMRC financial years")

      And("""the distribution amount has £ prefix and displayed as "£10,000"""")
      thenTheDistributionAmountHasPrefixAndDisplayedAs("£10,000")

      And("the How its calculated section is displayed")
      thenTheHowItsCalculatedSectionIsDisplayed()

      And(""""Marginal Relief was not available in financial year 2022 to 2023" is displayed on the page""")
      thenIsDisplayedOnThePage("Marginal Relief was not available in financial year 2022 to 2023")

      And("""the total Marginal relief is "£0"""")
      thenTheTotalMarginalReliefIs("£0")

      And(""""3" MR calculation steps are displayed""")
      thenMRCalculationStepsAreDisplayed("3")

      And("the Taxable Profit section is displayed")
      thenTheTaxableProfitSectionIsDisplayed()

    }

    Scenario(
      "Adjusted taxable profits including distributions is less than the adjusted upper limit for the financial year"
    ) {
      givenDefaultState()

      When("""the accounting period start date is provided as "01/01/2023"""")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("""the profit is "15000""""")
      andTheProfitIs("15000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("""the user selects option "yes" for the question Did your company receive any distributions?""")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And(
        """the user selects option "yes" for the question Do any distributions need to be included with your profits?"""
      )
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("yes")

      Then("the user is provided with an input field to provide distributions")
      thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("""the user provides "£7,000" as distributions""")
      andTheUserProvidesAsDistributions("£7,000")

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

      When("the user clicks the Check Marginal Relief calculation in detail link")
      andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      Then("""header displays as "Full Marginal Relief calculation in detail""")
      thenHeaderDisplaysAs("Full Marginal Relief calculation in detail")

      And("""the Your details page contains Covers 2 HMRC financial years""")
      thenTheYourDetailsPageContains("Covers 2 HMRC financial years")

      And(""""the distribution amount has £ prefix and displayed as ""£7,000""""")
      thenTheDistributionAmountHasPrefixAndDisplayedAs("£7,000")

      And("the How its calculated section is displayed")
      thenTheHowItsCalculatedSectionIsDisplayed()

      And("""Marginal Relief was not available in financial year 2022 to 2023 is displayed on the page""")
      thenIsDisplayedOnThePage("Marginal Relief was not available in financial year 2022 to 2023")

      And("""the total Marginal relief is "£0"""")
      thenTheTotalMarginalReliefIs("£0")

      And(""""3" MR calculation steps are displayed""")
      thenMRCalculationStepsAreDisplayed("3")

      And("the Taxable Profit section is displayed")
      thenTheTaxableProfitSectionIsDisplayed()

    }

    Scenario("Display MR detail in tabs") {
      givenDefaultState()

      When("""the accounting period start date is provided as "01/01/2024"""")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2024")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("""the profit is "70000""""")
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

      When("the user clicks the Check Marginal Relief calculation in detail link")
      andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      Then("""header displays as "Full Marginal Relief calculation in detail"""")
      thenHeaderDisplaysAs("Full Marginal Relief calculation in detail")

      And("""the Your details page contains "Covers 2 HMRC financial years""""")
      thenTheYourDetailsPageContains("Covers 2 HMRC financial years")

      And(""""the distribution amount has £ prefix and displayed as "£0""""")
      thenTheDistributionAmountHasPrefixAndDisplayedAs("£0")

      And("the How its calculated section is displayed")
      thenTheHowItsCalculatedSectionIsDisplayed()

      And("the tabs are displayed")
      thenTheTabsAreDisplayed()

      Then("the user clicks 2025 tab and verifies the tab")
      thenTheUserClicks2025TabAndVerifiesTheTab()

    }

    Scenario("Back button") {
      givenDefaultState()

      When("""the accounting period start date is provided as "01/01/2024"""")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2024")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("""the profit is "70000""""")
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

      When("the user clicks the Check Marginal Relief calculation in detail link")
      andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      And("the How its calculated section is displayed")
      thenTheHowItsCalculatedSectionIsDisplayed()

      And("the tabs are displayed")
      thenTheTabsAreDisplayed()

      Then("the user clicks 2025 tab and verifies the tab")
      thenTheUserClicks2025TabAndVerifiesTheTab()

      When("the user clicks the back button")
      theUserClicksTheBackButton()

      Then("""the user navigates back to the result page and displays the green box of type "£2,700"""")
      thenTheUserNavigatesBackToTheResultPageAndDisplaysTheGreenBoxOfType("£2,700")
    }

    Scenario("What to do next") {
      givenDefaultState()

      When("""the accounting period start date is provided as "01/01/2023"""")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("""the profit is "70000""""")
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

      When("the user clicks the Check Marginal Relief calculation in detail link")
      andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      Then("""header displays as "Full Marginal Relief calculation in detail"""")
      thenHeaderDisplaysAs("Full Marginal Relief calculation in detail")

      And("""the Your details page contains "Covers 2 HMRC financial years""""")
      thenTheYourDetailsPageContains("Covers 2 HMRC financial years")

      And(""""the distribution amount has £ prefix and displayed as "£0""""")
      thenTheDistributionAmountHasPrefixAndDisplayedAs("£0")

      And("the How its calculated section is displayed")
      thenTheHowItsCalculatedSectionIsDisplayed()

      And(""""What to do next" section is displayed and it contains "Complete your Corporation Tax return"""")
      thenSectionIsDisplayedAndItContains("What to do next", "Complete your Corporation Tax return")

      And("What to do next session contains date 9months after POA end date which is 1 October 2024")
      thenWhatToDoNextSessionContainsDate9monthsAfterPOAEndDateWhichIs("1 October 2024")

    }
  }
}
