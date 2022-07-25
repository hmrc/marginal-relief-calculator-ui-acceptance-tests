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
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage.{accountingPeriodLengthError, error}
import uk.gov.hmrc.test.ui.pages.mrc.{TaxableProfitPage}

class TaxableProfitStepDef extends BaseStepDef {
  And("""the profit is {string}""") { (profitValue: String) =>
    TaxableProfitPage.provideProfit(profitValue)
  }
  And("""the user is alerted to taxable profits {string}""") { (profitError: String) =>
    error should be(profitError)
  }

  And("the user click on back button") { () =>
    Thread.sleep(2000)
    TaxableProfitPage.clickBackLink()
  }

  And("the user clicks continue button on taxable profit page") { () =>
    TaxableProfitPage.submitPage()
  }
}
