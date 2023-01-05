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

import org.openqa.selenium.support.{FindBy, How, PageFactory}
import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.test.ui.pages.BasePage

import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

object DetailedCalculationPage extends BasePage {
  @FindBy(how = How.XPATH, using = "//a[@href='/marginal-relief-calculator/full-results-page']") var detailLinK
    : WebElement                                                                                                      = _
  @FindBy(how = How.XPATH, using = "//h1") var detailPageHeader: WebElement                                           = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/dl/div[3]/dd") var yourDetailsDistributionAmt
    : WebElement                                                                                                      = _
  @FindBy(how = How.XPATH, using = "//div[1]/dd") var yourDetailsAccountingPeriod: WebElement                         = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/h2[2]") var howItsCalculatedSection: WebElement =
    _
  @FindBy(how = How.XPATH, using = "//table") var taxableProfitSection: WebElement                                    = _

  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/table[1]/tbody/tr") var mrCalculationSteps
    : List[WebElement] = _

  @FindBy(how = How.XPATH, using = "//details/summary/span") var mRFractionLink: WebElement                    = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/p[9]/a") var getCopyOfResult: WebElement = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/h2[3]") var totalMRValue: WebElement     = _
  @FindBy(how = How.XPATH, using = "//*[@id='tab_year2024']") var tabYear2024: WebElement                      = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-tabs__list-item']") var tabYear2025: WebElement          = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/ul/li[2]/b") var lblDate: WebElement     = _
  @FindBy(how = How.XPATH, using = "//h3[@class='govuk-heading-s'][2]") var headerSection: WebElement          = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/ul/li[1]") var lblText: WebElement       = _
  @FindBy(how = How.XPATH, using = "//*[@href='/marginal-relief-calculator/pdf-meta-data']") var linkPrintandSave
    : WebElement                                                                                               = _

  PageFactory.initElements(driver, this)

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
      driver.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/table/tbody/tr")).toList
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
    driver.findElement(By.linkText("Get a copy of these results")).click()

  def getCopyOfResults(): Unit =
    getCopyOfResult.click()

  def verifySectionHeader(): String =
    headerSection.getText

  def verifysectionlable(): String =
    lblText.getText

  def DateInWhatToDoNextSection(): String =
    lblDate.getText

}
