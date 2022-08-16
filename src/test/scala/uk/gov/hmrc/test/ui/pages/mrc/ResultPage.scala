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

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.{FindBy, How, PageFactory}
import uk.gov.hmrc.test.ui.pages.BasePage

object ResultPage extends BasePage {
  val resultsPage =
    "Marginal Relief Results - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  @FindBy(how = How.CSS, using = "#main-content > div > div > a") var runAnotherCalculationButton: WebElement = _
  @FindBy(how = How.CSS, using = "div.govuk-heading-s") var HMRCFinancialYearsHeader: WebElement = _
  @FindBy(how = How.XPATH, using = "//main/div/div/p") var HMRCFinancialYearsSection: WebElement = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-panel__body']") var panelMessage: WebElement            = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-heading-l']") var ctAmount: WebElement                  = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][1]") var singleYearCTBody: WebElement            = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][2]") var dualYearCTBody: WebElement              = _
  @FindBy(how = How.LINK_TEXT, using = "Corporation Tax liability") var ctTable: WebElement                   = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/table/thead/tr/th[4]") var ctThirdRow
    : WebElement                                                                                              = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/table/thead/tr/th[2]") var ctFirstRow
    : WebElement                                                                                              = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/table/thead/tr/th[3]") var ctSecondRow
    : WebElement                                                                                              = _

  PageFactory.initElements(driver, this)

  def verifyPageTitle(): Unit =
    assert(driver.getTitle.contains(resultsPage))

  def clickRunAnotherCalculation(): Unit =
    runAnotherCalculationButton.click()

  def runAnotherCalculationIsEnabled(): Unit =
    runAnotherCalculationButton.isEnabled()

  def greenBoxMessage(): String = {
    Thread.sleep(1000)
    panelMessage.getText
  }

  def corporationTaxLiabilityHeader(): String =
    ctAmount.getText

  def dualYearCTLiability(): String =
    dualYearCTBody.getText

  def singlelYearCTLiability(): String =
    singleYearCTBody.getText

  def verifyCorporationTaxLiabilityBody(): Unit = {
    val corporationTaxLiabilityBody = driver.getPageSource.contains("Reduced from")
    assert(corporationTaxLiabilityBody === false)
  }

  def verifyRows: Boolean =
    ctFirstRow.getText.contains("2022 to 2023")
  ctSecondRow.getText.contains("2022 to 2023")
  ctThirdRow.getText.contains("Overall")

  def verifyRowsCount(): Unit = {
    val rows  = driver.findElements(By.xpath("//tr[@class='govuk-table__row']"))
    val count = rows.size
    assert(count == 9)
  }
  def verifyRowsCountForNOMRC(): Unit = {
    val rows  = driver.findElements(By.xpath("//tr[@class='govuk-table__row']"))
    val count = rows.size
    assert(count == 6)
  }

  def verifyColumnCount(): Unit = {
    val cols  = driver.findElements(By.xpath("//*[@scope='col']"))
    val count = cols.size
    assert(count == 8)
  }

  def verifyColumnCountForSingleYear(): Unit = {
    val cols  = driver.findElements(By.xpath("//*[@scope='col']"))
    val count = cols.size
    assert(count == 4)

  }
  def HMRCFinancialYearsHeaderText(): String = {
    HMRCFinancialYearsHeader.getText
  }

  def HMRCFinancialYearsSectionText(): String = {
    HMRCFinancialYearsSection.getText
  }

}
