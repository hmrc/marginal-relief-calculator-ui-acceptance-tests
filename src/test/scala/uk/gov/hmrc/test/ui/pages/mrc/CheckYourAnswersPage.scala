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

package uk.gov.hmrc.test.ui.pages.mrc

import uk.gov.hmrc.selenium.webdriver.Driver
import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.test.ui.pages.BasePage

object CheckYourAnswersPage extends BasePage {

  def checkYourAnswers =
    "Check your answers - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  def changeLinkForDist: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(3) > dd >a"))

  def changeLinkForProfit: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(2) > dd >a"))

  def changeLinkForAccPeriod: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(1) > dd >a"))

  def changeLinkForAC: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(4) > dd >a"))

  def calculateMRCButton: WebElement =
    Driver.instance.findElement(By.cssSelector("#main-content > div > div > a"))

  def accountingPeriodDates: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(1) > dd.govuk-summary-list__value"))

  def profit: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(2) > dd.govuk-summary-list__value"))

  def distributions: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(3) > dd.govuk-summary-list__value"))

  def NoOfAssociatedCompanies: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(4) > dd.govuk-summary-list__value"))

  def noOfAcForFirstPartOfFinancialYear: WebElement =
    Driver.instance.findElement(By.cssSelector("div:nth-child(5) > dd.govuk-summary-list__value"))

  def noOfAcForSecondPartOfFinancialYear: WebElement =
    Driver.instance.findElement(By.cssSelector("div:nth-child(6) > dd.govuk-summary-list__value"))

  def verifyPageTitle(): Unit               =
    verifyPageTitle(checkYourAnswers)
  def changeLinkForAccountingPeriod(): Unit =
    changeLinkForAccPeriod.isDisplayed

  def verifyChangeLinkForProfit(): Unit =
    changeLinkForProfit.isDisplayed

  def verifyChangeLinkForAC(): Unit =
    changeLinkForAC.isDisplayed

  def changeLinkForDistributions(): Unit =
    changeLinkForDist.isDisplayed

  def clickOnChangeLinkForDistributions(): Unit =
    changeLinkForDist.click()

  def clickOnChangeLinkForProfit(): Unit =
    changeLinkForProfit.click()

  def clickOnChangeLinkForAccPeriod(): Unit =
    changeLinkForAccPeriod.click()

  def clickOnChangeLinkForAssociatedCompanies(): Unit =
    changeLinkForAC.click()

  def verifyDistributionsValue(distributionsAmount: String): Unit =
    distributions.getText.contains(distributionsAmount)

  def verifyAccountingPeriodValue(AccountingPeriod: String): Unit =
    assert(accountingPeriodDates.getText.contains(AccountingPeriod))

  def verifyProfitValue(profitValue: String): Unit = {
    val TP = profit.getText
    assert(TP === profitValue)
  }

  def verifyNoOfAssociatedCompanies(associatedCompanies: String): Unit = {
    val AC = NoOfAssociatedCompanies.getText
    assert(AC === associatedCompanies)
  }

  def clickOnBackButton(): Unit =
    backButton.click()

  def verifyMRCButtonEnabled(): Unit =
    calculateMRCButton.isEnabled()

  def clickMRCButton(): Unit =
    calculateMRCButton.click()

  def verifyAcForFirstPartofFinancialYear(noOfAc: String): Unit = {
    val AC = noOfAcForFirstPartOfFinancialYear.getText
    assert(AC === noOfAc)
  }

  def verifyAcForSecondPartofFinancialYear(noOfAc: String): Unit = {
    val AC = noOfAcForSecondPartOfFinancialYear.getText
    assert(AC === noOfAc)
  }
}
