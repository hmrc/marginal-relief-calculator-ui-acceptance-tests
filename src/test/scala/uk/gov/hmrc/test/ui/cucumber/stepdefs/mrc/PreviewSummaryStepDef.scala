/*
 * Copyright 2023 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.mrc.PreviewSummaryPage
import uk.gov.hmrc.test.ui.pages.mrc.PreviewSummaryPage.{verifyHeader, verifyLinkPrint}

class PreviewSummaryStepDef extends BaseStepDef {
  And("""{string} should be displayed""") { (header: String) =>
    verifyHeader should be(header)
  }
  And("""{string} link is available""") { (link: String) =>
    verifyLinkPrint should be(link)
  }
  And("marginal results are shown") { () =>
    PreviewSummaryPage.verifyTables()
  }
  And("I verify same name is displayed on Preview summary page") { () =>
    PreviewSummaryPage.verifyCompanydetails()
  }

  Then("""I can validate the associated companies on PDF page as {string}""") { (associateCompanies: String) =>
    PreviewSummaryPage.verifyAssociatedCompanies(associateCompanies)
  }

}
