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
import uk.gov.hmrc.test.ui.pages.mrc.CheckYourAnswersPage

class CheckYourAnswersStepDef extends BaseStepDef {

  When("the user clicks on back button") { () =>
    Thread.sleep(2000)
    CheckYourAnswersPage.clickBackLink()
  }

  And("I can see calculate margin relief button enabled") { () =>
    CheckYourAnswersPage.verifyMRCButtonEnabled()
  }

  Then("""I can validate accounting period as {string}""") { (accountingPeriod: String) =>
    CheckYourAnswersPage.verifyAccountingPeriodValue(accountingPeriod)
  }

  Then("""I can validate profit as {string}""") { (profit: String) =>
    CheckYourAnswersPage.verifyProfitValue(profit)
  }

  Then("""I can validate distributions included as {string}""") { (distributions: String) =>
    CheckYourAnswersPage.verifyDistributionsValue(distributions)
  }

  Then("""I can validate associated companies as {string}""") { (associatedCompanies: String) =>
    CheckYourAnswersPage.verifyNoOfAssociatedCompanies(associatedCompanies)
  }
}
