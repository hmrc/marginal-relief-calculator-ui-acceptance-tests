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

import uk.gov.hmrc.test.ui.pages.mrc.TaxableProfitPage

object TaxableProfitStepDefSteps {

  // the profit is {string}
  def andTheProfitIs(profitValue: String): Unit =
    TaxableProfitPage.provideProfit(profitValue)

  // the user clicks continue button on taxable profit page
  def andTheUserClicksContinueButtonOnTaxableProfitPage(): Unit =
    TaxableProfitPage.submitPage()

  // I can see companies taxable profit as null
  def thenICanSeeCompaniesTaxableProfitAsNull(): Unit =
    TaxableProfitPage.verifyCompaniesProfitAsNull()

  // I am navigated to taxable profit page
  def thenIAmNavigatedToTaxableProfitPage(): Unit =
    TaxableProfitPage.verifyTitle()

  // I validate company profit is pre-populated as {string}
  def thenIValidateCompanyProfitIsPrepopulatedAs(profit: String): Unit =
    TaxableProfitPage.verifyProfitValue(profit)

}
