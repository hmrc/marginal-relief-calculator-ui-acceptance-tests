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

package uk.gov.hmrc.test.ui.pages.mrc

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.{FindBy, How, PageFactory}
import uk.gov.hmrc.test.ui.pages.BasePage

object AccountingPeriodPage extends BasePage {

  @FindBy(how = How.CSS, using = ".govuk-error-summary__body a") var errorMessage: WebElement = _

  @FindBy(how = How.ID, using = "accountingPeriodStartDate.day") var accountingStartDay: WebElement     = _
  @FindBy(how = How.ID, using = "accountingPeriodStartDate.month") var accountingStartMonth: WebElement = _
  @FindBy(how = How.ID, using = "accountingPeriodStartDate.year") var accountingStartYear: WebElement   = _

  @FindBy(how = How.ID, using = "accountingPeriodEndDate.day") var accountingEndDay: WebElement     = _
  @FindBy(how = How.ID, using = "accountingPeriodEndDate.month") var accountingEndMonth: WebElement = _
  @FindBy(how = How.ID, using = "accountingPeriodEndDate.year") var accountingEndYear: WebElement   = _

  PageFactory.initElements(driver, this)

  val url: String                         = "https://www.qa.tax.service.gov.uk/marginal-relief-calculator/accounting-period"
  val mrcHomePage                         = "What are your accounting period dates? - marginal-relief-calculator-frontend - GOV.UK"
  val mrcHomePageError                    = "Error: What are your accounting period dates? - marginal-relief-calculator-frontend - GOV.UK"
  val accountingPeriodMandatoryValueError = "The Start date must include day"
  val accountingPeriodMandatoryFieldError = "Enter a valid Start date for the accounting period, like 27 3 2023"
  val accountingPeriodLengthError         =
    "The accounting period End date must be less than or equal to a full calendar year from the Start date"

  def loadPage: this.type = {
    driver.manage().deleteAllCookies()
    driver.navigate().to(url)
    verifyPageTitle(mrcHomePage)
    this
  }

  def error: String =
    errorMessage.getText

  def provideEmptyAccountingStartDay: Unit = {
    accountingStartDay.sendKeys("")
    accountingStartMonth.sendKeys("12")
    accountingStartYear.sendKeys("2022")
  }

  def provideEmptyAccountingStartDate: Unit = {
    accountingStartDay.sendKeys("")
    accountingStartMonth.sendKeys("")
    accountingStartYear.sendKeys("")
  }

  def provideValidAccountingStartDate: Unit = {
    accountingStartDay.clear()
    accountingStartDay.sendKeys("01")
    accountingStartMonth.clear()
    accountingStartMonth.sendKeys("01")
    accountingStartYear.clear()
    accountingStartYear.sendKeys("2023")
  }

  def provideValidAccountingStartDate(accountingStartDate: String) = {
    val date = accountingStartDate.split("/")
    accountingStartDay.clear()
    accountingStartDay.sendKeys(date(0))
    accountingStartMonth.clear()
    accountingStartMonth.sendKeys(date(1))
    accountingStartYear.clear()
    accountingStartYear.sendKeys(date(2))
  }

  def provideValidAccountingEndDate(accountingEndDate: String) = {
    val date = accountingEndDate.split("/")
    accountingEndDay.clear()
    accountingEndDay.sendKeys(date(0))
    accountingEndMonth.clear()
    accountingEndMonth.sendKeys(date(1))
    accountingEndYear.clear()
    accountingEndYear.sendKeys(date(2))
  }

  def verifyAccountingEndDate(accountingEndDate: String) = {
    val date = accountingEndDate.split("/")
    accountingEndDay.getAttribute("value").contains(date(0))
    accountingEndMonth.getAttribute("value").contains(date(1))
    accountingEndYear.getAttribute("value").contains(date(2))
  }

  def provideInvalidAccountingEndDate: Unit = {
    accountingEndDay.sendKeys("01")
    accountingEndMonth.sendKeys("01")
    accountingEndYear.sendKeys("2024")
  }

  def provideValidAccountingEndDate: Unit = {
    accountingEndDay.clear()
    accountingEndDay.sendKeys("31")
    accountingEndMonth.clear()
    accountingEndMonth.sendKeys("12")
    accountingEndYear.clear()
    accountingEndYear.sendKeys("2023")
  }

}
