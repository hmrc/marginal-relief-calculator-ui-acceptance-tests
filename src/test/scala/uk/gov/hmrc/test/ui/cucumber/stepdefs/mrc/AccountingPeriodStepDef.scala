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
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage.{accountingPeriodLengthError, accountingPeriodMandatoryFieldError, accountingPeriodMandatoryValueError, accountingPeriodMessage, errorMessage}

class AccountingPeriodStepDef extends BaseStepDef {
  Then("the user lands on accounting period page") { () =>
    AccountingPeriodPage.verifyTitle()
  }
  Then("I am navigated to accounting period page") { () =>
    AccountingPeriodPage.verifyTitle()
  }

  When("the accounting period start day is empty") { () =>
    AccountingPeriodPage.provideEmptyAccountingStartDay
    AccountingPeriodPage.submitPage()
  }
  When("the accounting period start date is empty") { () =>
    AccountingPeriodPage.provideEmptyAccountingStartDate
    AccountingPeriodPage.submitPage()
  }
  Then("the user is alerted to a mandatory value error") { () =>
    errorMessage should be(accountingPeriodMandatoryValueError)
  }
  Then("the user is alerted to a mandatory field error") { () =>
    errorMessage should be(accountingPeriodMandatoryFieldError)
  }
  Then("the user is alerted to an accounting period length error") { () =>
    errorMessage should be(accountingPeriodLengthError)
  }
  When("the accounting period start date is valid") { () =>
    AccountingPeriodPage.provideValidAccountingStartDate()
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
  And("the user clicks continue button on accounting period page") { () =>
    AccountingPeriodPage.submitPage()
  }
  When("the accounting period greater than one Year") { () =>
    AccountingPeriodPage.provideInvalidAccountingEndDate()
    AccountingPeriodPage.submitPage()
  }
  When("the accounting period end date is valid") { () =>
    AccountingPeriodPage.provideValidAccountingEndDate()
    AccountingPeriodPage.submitPage()
  }
  Then("the user should given with an irrelevant accounting period page") { () =>
    AccountingPeriodPage.validatePageTitle()
    AccountingPeriodPage.validatePageContent()
    AccountingPeriodPage.verifyRestartButton()
    AccountingPeriodPage.verifyReferenceLink()
  }
  Then("""the user is displayed with error message {string} for accounting period""") { (errorMessage: String) =>
    AccountingPeriodPage.errorMessage contains errorMessage
  }

  Then("I can see accounting period start and end dates as null") { () =>
    AccountingPeriodPage.VerifyAccountingPeriodsDatesAsNUll()
  }
  Then("""the user reads content on accounting period as {string}""") { (accountingPeriodContent: String) =>
    accountingPeriodMessage should be(accountingPeriodContent)
  }
  Then("""the user reads content on accounting end date as "{string}""") { (accountEndDateMessage: String) =>
    accountEndDateMessage should be(accountEndDateMessage)
  }
}
