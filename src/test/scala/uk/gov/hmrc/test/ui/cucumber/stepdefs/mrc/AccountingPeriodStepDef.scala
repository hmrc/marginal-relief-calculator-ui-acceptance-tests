/*
 * Copyright 2024 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage.{accountEndDateMessage, accountingPeriodMessage}

class AccountingPeriodStepDef extends BaseStepDef {
  Then("the user lands on the accounting period page") { () =>
    AccountingPeriodPage.verifyTitle()
  }
  Then("the user is navigated to the accounting period page") { () =>
    AccountingPeriodPage.verifyTitle()
  }

  And("""the accounting period start date is provided as {string}""") { (accountingStartDate: String) =>
    AccountingPeriodPage.provideValidAccountingStartDate(accountingStartDate)
  }
  And("""the accounting period end date is provided as {string}""") { (accountingEndDate: String) =>
    AccountingPeriodPage.provideValidAccountingEndDate(accountingEndDate)
  }
  Then("""the user can see the accounting end period as {string}""") { (accountingEndDate: String) =>
    AccountingPeriodPage.verifyAccountingEndDate(accountingEndDate)
  }
  And("the user clicks the continue button on the accounting period page") { () =>
    AccountingPeriodPage.submitPage()
  }
  Then("the user is shown the ineligible accounting period page") { () =>
    AccountingPeriodPage.validatePageTitle()
    AccountingPeriodPage.validatePageContent()
    AccountingPeriodPage.verifyRestartButton()
    AccountingPeriodPage.verifyReferenceLink()
  }
  Then("the user can see the accounting period start and end dates as null") { () =>
    AccountingPeriodPage.VerifyAccountingPeriodsDatesAsNUll()
  }
  Then("""the user reads content on accounting period as {string}""") { (accountingPeriodContent: String) =>
    accountingPeriodMessage should be(accountingPeriodContent)
  }
  Then("""the user reads content on accounting end date as {string}""") { (accountingPeriodEndDateContent: String) =>
    accountEndDateMessage should be(accountingPeriodEndDateContent)
  }
}
