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
import uk.gov.hmrc.test.ui.pages.mrc.ResultPage.{corporationTaxLiabilityBody, corporationTaxLiabilityHeader, greenBoxMessage}

class ResultsStepDef extends BaseStepDef {
  Then("""display the green box of type {string}""") { (panelBody: String) =>
    greenBoxMessage should be(panelBody)
  }
  Then("""the corporation tax liability heading is displayed as {string}""") { (ctAmount: String) =>
    corporationTaxLiabilityHeader should be(ctAmount)
  }
  Then("""the corporation tax liability body is displayed as {string}""") { (ctAmountReduced: String) =>
    corporationTaxLiabilityBody should be(ctAmountReduced)
  }
  Then("the dual year corporation tax liability table is displayed") { () =>
    ResultPage.verifyTable
    ResultPage.verifyRowsCountForDualYear
    ResultPage.verifyRows
  }
  Then("the single year corporation tax liability table is displayed") { () =>
    ResultPage.verifyTable
    ResultPage.verifyRowsCountForSingleYear
    ResultPage.verifyRows
  }
  Then("the corporation tax liability body is not displayed") { () =>
    ResultPage.verifycorporationTaxLiabilityBody
  }
}
