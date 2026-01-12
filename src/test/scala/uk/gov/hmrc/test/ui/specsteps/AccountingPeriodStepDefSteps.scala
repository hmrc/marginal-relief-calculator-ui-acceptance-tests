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
import org.scalatest.matchers.should.Matchers.convertToStringShouldWrapperForVerb
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage.{accountEndDateMessage, accountingPeriodMessage}

object AccountingPeriodStepDefSteps {

  // the user lands on the accounting period page
  def thenTheUserLandsOnTheAccountingPeriodPage(): Unit = {
    AccountingPeriodPage.verifyTitle()
  }

  // the user is navigated to the accounting period page
  def thenTheUserIsNavigatedToTheAccountingPeriodPage(): Unit = {
    AccountingPeriodPage.verifyTitle()
  }

  // the accounting period start date is provided as {string}
  def provideAccountingPeriodStartDate(accountingStartDate: String): Unit = {
    AccountingPeriodPage.provideValidAccountingStartDate(accountingStartDate)
  }

  // the accounting period end date is provided as {string}
  def provideAccountingPeriodEndDate(accountingEndDate: String): Unit = {
    AccountingPeriodPage.provideValidAccountingEndDate(accountingEndDate)
  }

  // the user can see the accounting end period as {string}
  def UserCanSeeTheAccountingEnd(accountingEndDate: String): Unit = {
    AccountingPeriodPage.verifyAccountingEndDate(accountingEndDate)
  }

  // the user clicks the continue button on the accounting period page
  def andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage(): Unit = {
    AccountingPeriodPage.submitPage()
  }

  // the user is shown the ineligible accounting period page
  def thenTheUserIsShownTheIneligibleAccountingPeriodPage(): Unit = {
    AccountingPeriodPage.validatePageTitle()
        AccountingPeriodPage.validatePageContent()
        AccountingPeriodPage.verifyRestartButton()
        AccountingPeriodPage.verifyReferenceLink()
  }

  // the user can see the accounting period start and end dates as null
  def thenTheUserCanSeeTheAccountingPeriodStartAndEndDatesAsNull(): Unit = {
    AccountingPeriodPage.VerifyAccountingPeriodsDatesAsNUll()
  }

  // the user reads content on accounting period as {string}
  def UserReadsContentOnAccounting(accountingPeriodContent: String): Unit = {
    accountingPeriodMessage() should be(accountingPeriodContent)
  }

  // the user reads content on accounting end date as {string}
  def thenTheUserReadsContentOnAccountingEndDate(accountingPeriodEndDateContent: String): Unit = {
    accountEndDateMessage() should be(accountingPeriodEndDateContent)
  }

}
