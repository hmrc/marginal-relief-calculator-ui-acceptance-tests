/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.mrc

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.mrc.ResultPage
import uk.gov.hmrc.test.ui.pages.mrc.ResultPage.{HMRCFinancialYearsHeaderText, HMRCFinancialYearsSectionYearOne, HMRCFinancialYearsSectionYearTwo, corporationTaxLiabilityHeader, dualYearCTLiability, effectiveTaxBodyDual, effectiveTaxBodySingle, effectiveTaxHeader, greenBoxMessage, singleYearCTLiability, verifyETContent}

class ResultsStepDef extends BaseStepDef {
  Then("""display the green box of type {string}""") { (panelBody: String) =>
    greenBoxMessage should be(panelBody)
  }
  Then("""the corporation tax liability heading is displayed as {string}""") { (ctAmount: String) =>
    corporationTaxLiabilityHeader should be(ctAmount)
  }
  Then("""the corporation tax liability body is displayed as {string} for dual year""") { (ctAmountReduced: String) =>
    dualYearCTLiability should be(ctAmountReduced)
  }
  Then("""the corporation tax liability body is displayed as {string} for single year""") { (ctAmountReduced: String) =>
    singleYearCTLiability should be(ctAmountReduced)
  }
  Then("the dual year corporation tax liability table is displayed") { () =>
    ResultPage.verifyCTHeaderCountForDualYear()
    ResultPage.verifyCTBodyCountForDualYear()
    ResultPage.verifyHeaderForDualYear
  }
  Then("the single year corporation tax liability table is displayed") { () =>
    ResultPage.verifyCTHeaderCountForSingleYear()
    ResultPage.verifyCTBodyCountForSingleYear()
  }
  Then("the corporation tax liability body is not displayed") { () =>
    ResultPage.verifyCorporationTaxLiabilityBody()
  }
  Then("the NO MRC dual year corporation tax liability table is displayed") { () =>
    ResultPage.verifyCTHeaderCountForNoMrc()
    ResultPage.verifyCTBodyCountForNoMrc()
  }
  Then("the accounting period covering 2 years section is displayed") { () =>
    HMRCFinancialYearsHeaderText     should be("Your accounting period covers 2 HMRC financial years")
    HMRCFinancialYearsSectionYearOne should be("2022 to 2023: 1 January 2023 to 31 March 2023")
    HMRCFinancialYearsSectionYearTwo should be("2023 to 2024: 1 April 2023 to 31 December 2023")

  }
  Then("""the effective tax rate heading is displayed as {string}""") { (effectiveTax: String) =>
    effectiveTaxHeader should be(effectiveTax)
  }
  Then("""the effective tax body is displayed as {string} for dual year""") { (effectiveTaxMsg: String) =>
    effectiveTaxBodyDual should be(effectiveTaxMsg)
  }
  Then("""the effective tax body is displayed as {string} for single year""") { (effectiveTaxMsg: String) =>
    effectiveTaxBodySingle should be(effectiveTaxMsg)
  }
  Then("the dual year effective tax table is displayed") { () =>
    ResultPage.verifyETHeaderCountForDualYear()
    ResultPage.verifyETBodyCountForDualYear()
    ResultPage.verifyHeaderForDualYear
  }
  Then("the single year effective tax table is displayed") { () =>
    ResultPage.verifyETHeaderCountForSingleYear()
    ResultPage.verifyETBodyCountForSingleYear()
  }
  Then("the NO MRC effective tax table is displayed") { () =>
    ResultPage.verifyETHeaderCountForNOMRC()
    ResultPage.verifyETBodyCountForNOMRC()
  }
  Then("""the {string} effective tax table is displayed""") { (smallProfit: String) =>
    ResultPage.verifyETHeaderCountForNOMRC()
    ResultPage.verifyETBodyCountForNOMRC()
    verifyETContent should be(smallProfit)
  }
}
