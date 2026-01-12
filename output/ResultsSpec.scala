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

class ResultsSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {

  Feature("Results - Validations") {

    Scenario("Your taxable profits are above the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 260000")
        // ⚠️ No step-def match found for: the profit is 260000

      Then("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option No for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option No for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits are above the Marginal Relief limit")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

    }

    Scenario("Your taxable profits and included distributions are above the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 260000")
        // ⚠️ No step-def match found for: the profit is 260000

      Then("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Do any distributions need to be included with your profits?

      Then("the user is provided with an input field to provide distributions")
        // Possible match (best=1.00)
        thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £5,000 as distributions")
        // ⚠️ No step-def match found for: the user provides £5,000 as distributions

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits and included distributions are above the Marginal Relief limit")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

    }

    Scenario("Your taxable profits are below the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 45000")
        // ⚠️ No step-def match found for: the profit is 45000

      Then("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option No for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option No for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits are below the Marginal Relief limit")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

    }

    Scenario("Your taxable profits and included distributions are below the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 44500")
        // ⚠️ No step-def match found for: the profit is 44500

      Then("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Do any distributions need to be included with your profits?

      Then("the user is provided with an input field to provide distributions")
        // Possible match (best=1.00)
        thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £5,000 as distributions")
        // ⚠️ No step-def match found for: the user provides £5,000 as distributions

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
        // Possible match (best=1.00)
        thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits and included distributions are below the Marginal Relief limit")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

    }

    Scenario("Your taxable profits and included distributions are above the Marginal Relief limit") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 60000")
        // ⚠️ No step-def match found for: the profit is 60000

      Then("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option Yes for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
        // ⚠️ No step-def match found for: the user selects option Yes for the question Do any distributions need to be included with your profits?

      Then("the user is provided with an input field to provide distributions")
        // Possible match (best=1.00)
        thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

      And("the user provides £5,000 as distributions")
        // ⚠️ No step-def match found for: the user provides £5,000 as distributions

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £1,922.80")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

    }

    Scenario("CT liability payable- MRC Dual year") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
        // ⚠️ No step-def match found for: the profit is 70000

      Then("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £2,026.53")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

      Then("the corporation tax liability heading is displayed as £14,437.85")
        // Possible match (best=0.77)
        thenTheCorporationTaxLiabilityHeadingIsDisplayedAs("")

      Then("the accounting period covering 2 years section is displayed")
        // Possible match (best=1.00)
        thenTheAccountingPeriodCovering2YearsSectionIsDisplayed()

      And("the corporation tax liability body is displayed as Reduced from £16,464.38 after £2,026.53 Marginal Relief for dual year")
        // Possible match (best=0.79)
        thenTheCorporationTaxLiabilityBodyIsDisplayedAsForDualYear("")
        // --- Other possible matches ---
        // thenTheCorporationTaxLiabilityBodyIsNotDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the corporation tax liability body is not displayed

      And("the dual year corporation tax liability table is displayed")
        // Possible match (best=1.00)
        thenTheDualYearCorporationTaxLiabilityTableIsDisplayed()
        // --- Other possible matches ---
        // thenTheSingleYearCorporationTaxLiabilityTableIsDisplayed() [0.77] (ResultsStepDefSteps.scala) pattern: the single year corporation tax liability table is displayed
        // thenTheDualYearEffectiveTaxTableIsDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the dual year effective tax table is displayed

    }

    Scenario("CT liability payable- MRC Single year") {
      When("the accounting period start date is provided as 01/06/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/06/2023

      And("the accounting period end date is provided as 31/12/2023")
        // ⚠️ No step-def match found for: the accounting period end date is provided as 31/12/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
        // ⚠️ No step-def match found for: the profit is 70000

      And("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type £1,148.63")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

      And("the corporation tax liability heading is displayed as £16,351.37")
        // Possible match (best=0.77)
        thenTheCorporationTaxLiabilityHeadingIsDisplayedAs("")

      And("the corporation tax liability body is displayed as Reduced from £17,500 after £1,148.63 Marginal Relief for single year")
        // Possible match (best=0.79)
        thenTheCorporationTaxLiabilityBodyIsDisplayedAsForSingleYear("")
        // --- Other possible matches ---
        // thenTheCorporationTaxLiabilityBodyIsNotDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the corporation tax liability body is not displayed

      And("the single year corporation tax liability table is displayed")
        // Possible match (best=1.00)
        thenTheSingleYearCorporationTaxLiabilityTableIsDisplayed()
        // --- Other possible matches ---
        // thenTheDualYearCorporationTaxLiabilityTableIsDisplayed() [0.77] (ResultsStepDefSteps.scala) pattern: the dual year corporation tax liability table is displayed
        // thenTheSingleYearEffectiveTaxTableIsDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the single year effective tax table is displayed

    }

    Scenario("CT liability payable- No MRC") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 45000")
        // ⚠️ No step-def match found for: the profit is 45000

      Then("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option No for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option No for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      Then("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      When("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      Then("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then("display the green box of type Your taxable profits are below the Marginal Relief limit")
        // Possible match (best=0.75)
        thenDisplayTheGreenBoxOfType("")

      And("the corporation tax liability heading is displayed as £8,550")
        // Possible match (best=0.77)
        thenTheCorporationTaxLiabilityHeadingIsDisplayedAs("")

      And("the corporation tax liability body is not displayed")
        // Possible match (best=1.00)
        thenTheCorporationTaxLiabilityBodyIsNotDisplayed()

      And("the NO MRC dual year corporation tax liability table is displayed")
        // Possible match (best=1.00)
        thenTheNOMRCDualYearCorporationTaxLiabilityTableIsDisplayed()
        // --- Other possible matches ---
        // thenTheDualYearCorporationTaxLiabilityTableIsDisplayed() [0.85] (ResultsStepDefSteps.scala) pattern: the dual year corporation tax liability table is displayed
        // thenTheSingleYearCorporationTaxLiabilityTableIsDisplayed() [0.77] (ResultsStepDefSteps.scala) pattern: the single year corporation tax liability table is displayed
        // thenTheDualYearEffectiveTaxTableIsDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the dual year effective tax table is displayed
        // thenTheNOMRCEffectiveTaxTableIsDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the NO MRC effective tax table is displayed

    }

    Scenario("Effective tax rate- MRC Dual year") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
        // ⚠️ No step-def match found for: the profit is 70000

      And("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 20.63%")
        // Possible match (best=0.77)
        thenTheEffectiveTaxRateHeadingIsDisplayedAs("")

      And("the effective tax body is displayed as Reduced from 23.52% after Marginal Relief for dual year")
        // Possible match (best=0.79)
        thenTheEffectiveTaxBodyIsDisplayedAsForDualYear("")

      And("the dual year effective tax table is displayed")
        // Possible match (best=1.00)
        thenTheDualYearEffectiveTaxTableIsDisplayed()
        // --- Other possible matches ---
        // thenTheSingleYearEffectiveTaxTableIsDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the single year effective tax table is displayed
        // thenTheEffectiveTaxTableIsDisplayed() [0.75] (ResultsStepDefSteps.scala) pattern: the {string} effective tax table is displayed

    }

    Scenario("Effective tax rate- MRC Single year") {
      When("the accounting period start date is provided as 01/06/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/06/2023

      When("the accounting period end date is provided as 31/12/2023")
        // ⚠️ No step-def match found for: the accounting period end date is provided as 31/12/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 70000")
        // ⚠️ No step-def match found for: the profit is 70000

      And("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 23.36%")
        // Possible match (best=0.77)
        thenTheEffectiveTaxRateHeadingIsDisplayedAs("")

      And("the effective tax body is displayed as Reduced from 25% after Marginal Relief for single year")
        // Possible match (best=0.79)
        thenTheEffectiveTaxBodyIsDisplayedAsForSingleYear("")

      And("the single year effective tax table is displayed")
        // Possible match (best=1.00)
        thenTheSingleYearEffectiveTaxTableIsDisplayed()
        // --- Other possible matches ---
        // thenTheDualYearEffectiveTaxTableIsDisplayed() [0.76] (ResultsStepDefSteps.scala) pattern: the dual year effective tax table is displayed
        // thenTheEffectiveTaxTableIsDisplayed() [0.75] (ResultsStepDefSteps.scala) pattern: the {string} effective tax table is displayed

    }

    Scenario("Effective tax rate- NO MRC Dual year") {
      When("the accounting period start date is provided as 01/01/2023")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2023

      When("the accounting period end date is provided as 31/12/2023")
        // ⚠️ No step-def match found for: the accounting period end date is provided as 31/12/2023

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 37000")
        // ⚠️ No step-def match found for: the profit is 37000

      And("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 19%")
        // Possible match (best=0.77)
        thenTheEffectiveTaxRateHeadingIsDisplayedAs("")

      And("the NO MRC effective tax table is displayed")
        // Possible match (best=1.00)
        thenTheNOMRCEffectiveTaxTableIsDisplayed()
        // --- Other possible matches ---
        // thenTheEffectiveTaxTableIsDisplayed() [0.75] (ResultsStepDefSteps.scala) pattern: the {string} effective tax table is displayed

    }

    Scenario("Effective tax rate- Small profit rate") {
      When("the accounting period start date is provided as 01/01/2024")
        // ⚠️ No step-def match found for: the accounting period start date is provided as 01/01/2024

      Then("the user clicks the continue button on the accounting period page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      When("the profit is 25000")
        // ⚠️ No step-def match found for: the profit is 25000

      And("the user clicks continue button on taxable profit page")
        // Possible match (best=1.00)
        andTheUserClicksContinueButtonOnTaxableProfitPage()

      And("the user selects option no for the question Did your company receive any distributions?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company receive any distributions?

      And("the user clicks the continue button on the distributions page")
        // Possible match (best=1.00)
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

      And("the user lands on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserLandsOnTheAssociatedCompaniesPage()

      And("the user selects option no for the question Did your company have any active associated companies?")
        // ⚠️ No step-def match found for: the user selects option no for the question Did your company have any active associated companies?

      And("the user clicks the continue button on the associated companies page")
        // Possible match (best=1.00)
        thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      And("the user clicks the calculate marginal relief button on the check your answers page")
        // Possible match (best=1.00)
        whenTheUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      And("the effective tax rate heading is displayed as 19%")
        // Possible match (best=0.77)
        thenTheEffectiveTaxRateHeadingIsDisplayedAs("")

      And("the Small profit rate effective tax table is displayed")
        // Possible match (best=0.75)
        thenTheEffectiveTaxTableIsDisplayed("")

    }
  }
}
