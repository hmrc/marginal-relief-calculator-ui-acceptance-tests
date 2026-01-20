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

import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages.BasePage
import scala.jdk.CollectionConverters.ListHasAsScala

object DetailedCalculationPage extends BasePage {

  def detailLinK: WebElement =
    Driver.instance.findElement(By.xpath("//a[@href='/marginal-relief-calculator/full-results-page']"))

  def detailPageHeader: WebElement =
    Driver.instance.findElement(By.xpath("//h1"))

  def yourDetailsDistributionAmt: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/dl/div[3]/dd"))

  def yourDetailsAccountingPeriod: WebElement =
    Driver.instance.findElement(By.xpath("//div[1]/dd"))

  def howItsCalculatedSection: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/h2[1]"))

  def taxableProfitSection: WebElement =
    Driver.instance.findElement(By.xpath("//table"))

  def mrCalculationSteps: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/table[1]/tbody/tr"))

  def mRFractionLink: WebElement =
    Driver.instance.findElement(By.xpath("//details/summary/span"))

  def associatedCompanies: WebElement =
    Driver.instance.findElement(By.cssSelector("dl > div:nth-child(4) > dd"))

  def getCopyOfResult: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/p[9]/a"))

  def totalMRValue: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/span"))

  def tabYear2024: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id='tab_year2024']"))

  def tabYear2025: WebElement =
    Driver.instance.findElement(By.xpath("//*[@class='govuk-tabs__list-item']"))

  def lblDate: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/ul/li[2]/b"))

  def headerSection: WebElement =
    Driver.instance.findElement(By.xpath("//h2[@class='govuk-heading-m'][4]"))

  def lblText: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/ul/li[1]"))

  def linkPrintandSave: WebElement =
    Driver.instance.findElement(By.xpath("//*[@href='/marginal-relief-calculator/pdf-meta-data']"))

  def verifyDetailLink(): Unit =
    detailLinK.isDisplayed

  def clickDetailLink(): Unit =
    detailLinK.click()

  def detailedPageTitle(): String =
    detailPageHeader.getText

  def yourDetailsAccountingPeriodText(): String =
    yourDetailsAccountingPeriod.getText

  def yourDetailsDistributionAmtText(): String =
    yourDetailsDistributionAmt.getText

  def isHowItsCalculatedSectionDisplayed: Boolean =
    howItsCalculatedSection.isDisplayed

  def isTaxableProfitSectionDisplayed: Boolean =
    taxableProfitSection.isDisplayed

  def validateMrCalculationSteps(calSteps: String): Unit = {
    val steps                             = calSteps.toInt
    val webElementsList: List[WebElement] =
      Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/table/tbody/tr")).asScala.toList
    webElementsList.length shouldBe steps
  }

  def verifyMRFractionLinkPresentOnPage(): Boolean =
    mRFractionLink.isDisplayed

  def validateTotalMR(): String =
    totalMRValue.getText

  def validateTabs(): Unit =
    tabYear2024.isDisplayed

  def clickOn2025tab(): Unit = {
    tabYear2025.click()
    tabYear2025.isDisplayed
  }

  def clickOnGetACopyOfResults(): Unit =
    Driver.instance.findElement(By.linkText("Get a copy of these results")).click()

  def getCopyOfResults(): Unit =
    getCopyOfResult.click()

  def verifySectionHeader(): String =
    headerSection.getText

  def verifysectionlable(): String =
    lblText.getText

  def DateInWhatToDoNextSection(): String =
    lblDate.getText

  def verifyAssociatedCompanies(noOfAssociatedCompanies: String): Unit =
    associatedCompanies.getText.contains(noOfAssociatedCompanies)

}
