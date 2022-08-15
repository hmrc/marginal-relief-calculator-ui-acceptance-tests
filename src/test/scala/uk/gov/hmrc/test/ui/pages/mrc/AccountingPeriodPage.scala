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
  @FindBy(how = How.ID, using = "accountingPeriodStartDate.day") var accountingStartDay: WebElement     = _
  @FindBy(how = How.ID, using = "accountingPeriodStartDate.month") var accountingStartMonth: WebElement = _
  @FindBy(how = How.ID, using = "accountingPeriodStartDate.year") var accountingStartYear: WebElement   = _

  @FindBy(how = How.ID, using = "accountingPeriodEndDate.day") var accountingEndDay: WebElement           = _
  @FindBy(how = How.ID, using = "accountingPeriodEndDate.month") var accountingEndMonth: WebElement       = _
  @FindBy(how = How.ID, using = "accountingPeriodEndDate.year") var accountingEndYear: WebElement         = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-heading-xl']") var irrelevantPageHeader: WebElement = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][1]") var irrelevantPageContent: WebElement   = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][2]") var restartButton: WebElement           = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][3]") var referenceLink: WebElement           = _

  PageFactory.initElements(driver, this)

  val accountingPeriodPage                =
    "What are your accounting period dates? - Calculate Marginal Relief for Corporation Tax - GOV.UK"
  val mrcHomePageError                    = "Error: What are your accounting period dates? - marginal-relief-calculator-frontend - GOV.UK"
  val accountingPeriodMandatoryValueError = "The start date must include day"
  val accountingPeriodMandatoryFieldError = "Enter a valid start date for the accounting period, like 27 3 2023"
  val irrelevantPageTitle                 = "You're not eligible for Marginal Relief"
  val irrelevantPageMessage               = "Your accounting period is before the 1 April 2023 start date for Marginal Relief."
  val accountingPeriodLengthError         =
    "The accounting period End date must be less than or equal to a full calendar year from the start date"

  def verifyTitle(): Unit =
    verifyPageTitle(accountingPeriodPage)

  def provideEmptyAccountingStartDay(): Unit = {
    accountingStartDay.sendKeys("")
    accountingStartMonth.sendKeys("12")
    accountingStartYear.sendKeys("2022")
  }

  def provideEmptyAccountingStartDate(): Unit = {
    accountingStartDay.sendKeys("")
    accountingStartMonth.sendKeys("")
    accountingStartYear.sendKeys("")
  }

  def provideValidAccountingStartDate(): Unit = {
    accountingStartDay.clear()
    accountingStartDay.sendKeys("01")
    accountingStartMonth.clear()
    accountingStartMonth.sendKeys("01")
    accountingStartYear.clear()
    accountingStartYear.sendKeys("2023")
  }

  def provideValidAccountingStartDate(accountingStartDate: String): Unit = {
    val date = accountingStartDate.split("/")
    accountingStartDay.clear()
    accountingStartDay.sendKeys(date(0))
    accountingStartMonth.clear()
    accountingStartMonth.sendKeys(date(1))
    accountingStartYear.clear()
    accountingStartYear.sendKeys(date(2))
  }

  def provideValidAccountingEndDate(accountingEndDate: String): Unit = {
    val date = accountingEndDate.split("/")
    accountingEndDay.clear()
    accountingEndDay.sendKeys(date(0))
    accountingEndMonth.clear()
    accountingEndMonth.sendKeys(date(1))
    accountingEndYear.clear()
    accountingEndYear.sendKeys(date(2))

  }

  def verifyAccountingEndDate(accountingEndDate: String): Unit = {
    val date = accountingEndDate.split("/")
    accountingEndDay.getAttribute("value").contains(date(0))
    accountingEndMonth.getAttribute("value").contains(date(1))
    accountingEndYear.getAttribute("value").contains(date(2))
  }

  def provideInvalidAccountingEndDate(): Unit = {
    accountingEndDay.sendKeys("01")
    accountingEndMonth.sendKeys("01")
    accountingEndYear.sendKeys("2024")
  }

  def provideValidAccountingEndDate(): Unit = {
    accountingEndDay.clear()
    accountingEndDay.sendKeys("31")
    accountingEndMonth.clear()
    accountingEndMonth.sendKeys("12")
    accountingEndYear.clear()
    accountingEndYear.sendKeys("2023")
  }

  def validatePageTitle(): Unit =
    irrelevantPageHeader.getText.contains(irrelevantPageTitle)

  def validatePageContent(): Unit =
    irrelevantPageContent.getText.contains(irrelevantPageMessage)

  def verifyRestartButton(): Unit =
    restartButton.isDisplayed

  def verifyReferenceLink(): Unit =
    referenceLink.isDisplayed

  def VerifyAccountingPeriodsDatesAsNUll(): Unit = {
    accountingStartDay.getAttribute("value").contains("")
    accountingStartMonth.getAttribute("value").contains("")
    accountingStartYear.getAttribute("value").contains("")

    accountingEndDay.getAttribute("value").contains("")
    accountingEndMonth.getAttribute("value").contains("")
    accountingEndYear.getAttribute("value").contains("")
  }
}
