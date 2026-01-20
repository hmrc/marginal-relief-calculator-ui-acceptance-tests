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
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.ResultsStepDefSteps.*

class ResultsSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()
  }

  Feature("Results - Validations") {

    Scenario("Your taxable profits are above the Marginal Relief limit") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 260000")
      andTheProfitIs("260000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option No for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option No for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits are above the Marginal Relief limit")
      thenDisplayTheGreenBoxOfType("Your taxable profits are above the Marginal Relief limit")
    }

    Scenario("Your taxable profits and included distributions are above the Marginal Relief limit") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 260000")
      andTheProfitIs("260000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option yes for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user selects option yes for the question Do any distributions need to be included with your profits?")
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("Yes")

      Then("the user is provided with an input field to provide distributions")
      thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £5,000 as distributions")
      andTheUserProvidesAsDistributions("£50,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option No for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then(
        "display the green box of type Your taxable profits and included distributions are above the Marginal Relief limit"
      )
      thenDisplayTheGreenBoxOfType(
        "Your taxable profits and included distributions are above the Marginal Relief limit"
      )

    }

    Scenario("Your taxable profits are below the Marginal Relief limit") {
      givenDefaultState()

      When(s"the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When(s"the profit is 45000")
      andTheProfitIs("45000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And(s"the user selects option No for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When(s"the user selects option No for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits are below the Marginal Relief limit")
      thenDisplayTheGreenBoxOfType("Your taxable profits are below the Marginal Relief limit")
    }

    Scenario("Your taxable profits and included distributions are below the Marginal Relief limit") {
      givenDefaultState()

      When("the accounting period start date is provided as 1/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When(s"the profit is 44500")
      andTheProfitIs("44500")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option Yes for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("Yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("Yes")

      Then("the user is provided with an input field to provide distributions")
      thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £5,000 as distributions")
      andTheUserProvidesAsDistributions("£5,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When(s"the user selects option No for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then(
        "display the green box of type Your taxable profits and included distributions are below the Marginal Relief limit"
      )
      thenDisplayTheGreenBoxOfType(
        "Your taxable profits and included distributions are below the Marginal Relief limit"
      )
    }

    Scenario("Your taxable profits and included distributions are above the Marginal Relief limit with value") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 60000")
      andTheProfitIs("60000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option Yes for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("yes")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
      andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("Yes")

      Then("the user is provided with an input field to provide distributions")
      thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £5,000 as distributions")
      andTheUserProvidesAsDistributions("£5,000")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option No for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £1,922.80")
      thenDisplayTheGreenBoxOfType("£1,922.80")
    }

    Scenario("CT liability payable- MRC Dual year") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
      andTheProfitIs("70000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £2,026.53")
      thenDisplayTheGreenBoxOfType("£2,026.53")

      Then("the corporation tax liability heading is displayed as £14,437.85")
      thenTheCorporationTaxLiabilityHeadingIsDisplayedAs("£14,437.85")

      Then("the accounting period covering 2 years section is displayed")
      thenTheAccountingPeriodCovering2YearsSectionIsDisplayed()

      And(
        "the corporation tax liability body is displayed as Reduced from £16,464.38 after £2,026.53 Marginal Relief for dual year"
      )
      thenTheCorporationTaxLiabilityBodyIsDisplayedAsForDualYear(
        "Reduced from £16,464.38 after £2,026.53 Marginal Relief"
      )

      And("the dual year corporation tax liability table is displayed")
      thenTheDualYearCorporationTaxLiabilityTableIsDisplayed()

    }

    Scenario("CT liability payable- MRC Single year") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/06/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/06/2023")

      And("the accounting period end date is provided as 31/12/2023")
      provideAccountingPeriodEndDate("31/12/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
      andTheProfitIs("70000")

      And("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("no")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £1,148.63")
      thenDisplayTheGreenBoxOfType("£1,148.63")

      And("the corporation tax liability heading is displayed as £16,357.38")
      thenTheCorporationTaxLiabilityHeadingIsDisplayedAs("£16,351.37")

      And(
        "the corporation tax liability body is displayed as Reduced from £17,500 after £1,148.63 Marginal Relief for single year"
      )
      thenTheCorporationTaxLiabilityBodyIsDisplayedAsForSingleYear(
        "Reduced from £17,500 after £1,148.63 Marginal Relief"
      )

      And("the single year corporation tax liability table is displayed")
      thenTheSingleYearCorporationTaxLiabilityTableIsDisplayed()
    }

    Scenario("CT liability payable- No MRC") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 45000")
      andTheProfitIs("45000")

      Then("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option No for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("no")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits are below the Marginal Relief limit")
      thenDisplayTheGreenBoxOfType("Your taxable profits are below the Marginal Relief limit")

      And("the corporation tax liability heading is displayed as £8,550")
      thenTheCorporationTaxLiabilityHeadingIsDisplayedAs("£8,550")

      And("the corporation tax liability body is not displayed")
      thenTheCorporationTaxLiabilityBodyIsNotDisplayed()

      And("the NO MRC dual year corporation tax liability table is displayed")
      thenTheNOMRCDualYearCorporationTaxLiabilityTableIsDisplayed()

    }

    Scenario("Effective tax rate- MRC Dual year") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
      andTheProfitIs("70000")

      And("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("no")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 20.63%")
      thenTheEffectiveTaxRateHeadingIsDisplayedAs("20.63%")

      And("the effective tax body is displayed as Reduced from 23.52% after Marginal Relief for dual year")
      thenTheEffectiveTaxBodyIsDisplayedAsForDualYear("Reduced from 23.52% after Marginal Relief")

      And("the dual year effective tax table is displayed")
      thenTheDualYearEffectiveTaxTableIsDisplayed()

    }

    Scenario("Effective tax rate- MRC Single year") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/06/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/06/2023")

      When("the accounting period end date is provided as 31/12/2023")
      provideAccountingPeriodEndDate("31/12/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
      andTheProfitIs("70000")

      And("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 23.36%")
      thenTheEffectiveTaxRateHeadingIsDisplayedAs("23.36%")

      And("the effective tax body is displayed as Reduced from 25% after Marginal Relief for single year")
      thenTheEffectiveTaxBodyIsDisplayedAsForSingleYear("Reduced from 25% after Marginal Relief")

      And("the single year effective tax table is displayed")
      thenTheSingleYearEffectiveTaxTableIsDisplayed()

    }

    Scenario("Effective tax rate- NO MRC Dual year") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      When("the accounting period end date is provided as 31/12/2023")
      provideAccountingPeriodEndDate("31/12/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 37000")
      andTheProfitIs("37000")

      And("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 19%")
      thenTheEffectiveTaxRateHeadingIsDisplayedAs("19%")

      And("the NO MRC effective tax table is displayed")
      thenTheNOMRCEffectiveTaxTableIsDisplayed()

    }

    Scenario("Effective tax rate- Small profit rate") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/01/2024")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2024")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 25000")
      andTheProfitIs("25000")

      And("the user clicks continue button on taxable profit page")
      andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
      andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("No")

      And("the user clicks the continue button on the distributions page")
      andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
      thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
      theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("no")

      And("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 19%")
      thenTheEffectiveTaxRateHeadingIsDisplayedAs("19%")

      And("the Small profit rate effective tax table is displayed")
      thenTheEffectiveTaxTableIsDisplayed("Small profit rate")

    }
  }
}
