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

package uk.gov.hmrc.test.ui.specsteps

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

import org.scalatest.matchers.must.Matchers.be
import uk.gov.hmrc.test.ui.pages.mrc.ResultPage
import uk.gov.hmrc.test.ui.pages.mrc.ResultPage.{HMRCFinancialYearsHeaderText, HMRCFinancialYearsSectionYearOne, HMRCFinancialYearsSectionYearTwo, convertToStringShouldWrapperForVerb, corporationTaxLiabilityHeader, dualYearCTLiability, effectiveTaxBodyDual, effectiveTaxBodySingle, effectiveTaxHeader, greenBoxMessage, singleYearCTLiability, verifyETContent}

object ResultsStepDefSteps {

  // display the green box of type {string}
  def thenDisplayTheGreenBoxOfType(panelBody: String): Unit = {
    greenBoxMessage() should be(panelBody)
  }

  // the corporation tax liability heading is displayed as {string}
  def thenTheCorporationTaxLiabilityHeadingIsDisplayedAs(ctAmount: String): Unit = {
    corporationTaxLiabilityHeader() should be(ctAmount)
  }

  // the corporation tax liability body is displayed as {string} for dual year
  def thenTheCorporationTaxLiabilityBodyIsDisplayedAsForDualYear(ctAmountReduced: String): Unit = {
    dualYearCTLiability() should be(ctAmountReduced)
  }

  // the corporation tax liability body is displayed as {string} for single year
  def thenTheCorporationTaxLiabilityBodyIsDisplayedAsForSingleYear(ctAmountReduced: String): Unit = {
    singleYearCTLiability() should be(ctAmountReduced)
  }

  // the dual year corporation tax liability table is displayed
  def thenTheDualYearCorporationTaxLiabilityTableIsDisplayed(): Unit = {
    ResultPage.verifyCTHeaderCountForDualYear()
        ResultPage.verifyCTBodyCountForDualYear()
        ResultPage.verifyHeaderForDualYear
  }

  // the single year corporation tax liability table is displayed
  def thenTheSingleYearCorporationTaxLiabilityTableIsDisplayed(): Unit = {
    ResultPage.verifyCTHeaderCountForSingleYear()
        ResultPage.verifyCTBodyCountForSingleYear()
  }

  // the corporation tax liability body is not displayed
  def thenTheCorporationTaxLiabilityBodyIsNotDisplayed(): Unit = {
    ResultPage.verifyCorporationTaxLiabilityBody()
  }

  // the NO MRC dual year corporation tax liability table is displayed
  def thenTheNOMRCDualYearCorporationTaxLiabilityTableIsDisplayed(): Unit = {
    ResultPage.verifyCTHeaderCountForNoMrc()
        ResultPage.verifyCTBodyCountForNoMrc()
  }

  // the accounting period covering 2 years section is displayed
  def thenTheAccountingPeriodCovering2YearsSectionIsDisplayed(): Unit = {
    HMRCFinancialYearsHeaderText()     should be("Your accounting period covers 2 HMRC financial years")
        HMRCFinancialYearsSectionYearOne() should be("2022 to 2023: 1 January 2023 to 31 March 2023")
        HMRCFinancialYearsSectionYearTwo() should be("2023 to 2024: 1 April 2023 to 31 December 2023")
  }

  // the effective tax rate heading is displayed as {string}
  def thenTheEffectiveTaxRateHeadingIsDisplayedAs(effectiveTax: String): Unit = {
    effectiveTaxHeader() should be(effectiveTax)
  }

  // the effective tax body is displayed as {string} for dual year
  def thenTheEffectiveTaxBodyIsDisplayedAsForDualYear(effectiveTaxMsg: String): Unit = {
    effectiveTaxBodyDual() should be(effectiveTaxMsg)
  }

  // the effective tax body is displayed as {string} for single year
  def thenTheEffectiveTaxBodyIsDisplayedAsForSingleYear(effectiveTaxMsg: String): Unit = {
    effectiveTaxBodySingle() should be(effectiveTaxMsg)
  }

  // the dual year effective tax table is displayed
  def thenTheDualYearEffectiveTaxTableIsDisplayed(): Unit = {
    ResultPage.verifyETHeaderCountForDualYear()
        ResultPage.verifyETBodyCountForDualYear()
        ResultPage.verifyHeaderForDualYear
  }

  // the single year effective tax table is displayed
  def thenTheSingleYearEffectiveTaxTableIsDisplayed(): Unit = {
    ResultPage.verifyETHeaderCountForSingleYear()
        ResultPage.verifyETBodyCountForSingleYear()
  }

  // the NO MRC effective tax table is displayed
  def thenTheNOMRCEffectiveTaxTableIsDisplayed(): Unit = {
    ResultPage.verifyETHeaderCountForNOMRC()
        ResultPage.verifyETBodyCountForNOMRC()
  }

  // the {string} effective tax table is displayed
  def thenTheEffectiveTaxTableIsDisplayed(smallProfit: String): Unit = {
    ResultPage.verifyETHeaderCountForNOMRC()
        ResultPage.verifyETBodyCountForNOMRC()
        verifyETContent() should be(smallProfit)
  }

  // the user navigates back to the result page and displays the green box of type {string}
  def thenTheUserNavigatesBackToTheResultPageAndDisplaysTheGreenBoxOfType(panelBody: String): Unit = {
    greenBoxMessage() should be(panelBody)
  }

  // the user validates the associated companies on the results page as {string}
  def thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs(associateCompanies: String): Unit = {
    ResultPage.verifyTwoAssociatedCompanies(associateCompanies)
  }

}
