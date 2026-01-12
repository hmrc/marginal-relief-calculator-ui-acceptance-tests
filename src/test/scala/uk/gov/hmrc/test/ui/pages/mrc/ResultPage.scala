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

import org.openqa.selenium.support.{FindBy, How, PageFactory}
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages.BasePage

import scala.compiletime.uninitialized

object ResultPage extends BasePage {
  //  val resultsPage = "Marginal Relief Results - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  @FindBy(how = How.CSS, using = "#main-content > div > div > a") var runAnotherCalculationButton: WebElement   =
    uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-heading-s']") var HMRCFinancialYearsHeader: WebElement    =
    uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body govuk-!-margin-0']") var HMRCFinancialYearsSectionY1
  : WebElement = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][1]") var HMRCFinancialYearsSectionY2: WebElement   =
    uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[1]/div") var panelMessage: WebElement =
    uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-heading-l'][1]") var ctAmount: WebElement                 = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][1]") var singleYearCTBody: WebElement              = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][2]") var dualYearCTBody: WebElement                = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-heading-l'][2]") var ETHeader: WebElement                 = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][2]") var ETBodySingle: WebElement                  = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-body'][3]") var ETBodyDual: WebElement                    = uninitialized
  @FindBy(how = How.CSS, using = "dl > div:nth-child(4) > dd") var TwoAssociatedComapniesText: WebElement       =
    uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[3]/table/tbody/tr[2]/th") var ETContent
  : WebElement = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/table[2]/thead/tr/th[2]") var etFirstRow
  : WebElement = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/table[2]/thead/tr/th[3]") var etSecondRow
  : WebElement = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/table[2]/thead/tr/th[3]") var etThirdRow
  : WebElement = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[2]/table/thead/tr/th[3]") var ctThirdRow
  : WebElement = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[2]/table/thead/tr/th[2]") var ctFirstRow
  : WebElement = uninitialized
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[2]/table/thead/tr/th[3]") var ctSecondRow
  : WebElement = uninitialized

  PageFactory.initElements(Driver.instance, this)

  //  def verifyPageTitle(): Unit =
  //    assert(Driver.instance.getTitle.contains(resultsPage))

  def clickRunAnotherCalculation(): Unit =
    runAnotherCalculationButton.click()

  def runAnotherCalculationIsEnabled(): Unit =
    runAnotherCalculationButton.isEnabled()

  def greenBoxMessage(): String =
    eventually {
      panelMessage.getText
    }

  def corporationTaxLiabilityHeader(): String =
    ctAmount.getText

  def dualYearCTLiability(): String =
    dualYearCTBody.getText

  def singleYearCTLiability(): String =
    singleYearCTBody.getText

  def effectiveTaxHeader(): String =
    ETHeader.getText

  def effectiveTaxBodyDual(): String =
    ETBodyDual.getText

  def effectiveTaxBodySingle(): String =
    ETBodySingle.getText

  def verifyCorporationTaxLiabilityBody(): Unit = {
    val corporationTaxLiabilityBody = Driver.instance.getPageSource.contains("Reduced from")
    assert(corporationTaxLiabilityBody === false)
  }

  def verifyHeaderForDualYear: Boolean = {
    ctFirstRow.getText.contains("2022 to 2023")
    ctSecondRow.getText.contains("2022 to 2023")
    ctThirdRow.getText.contains("Overall")
  }

  def verifyCTHeaderCountForDualYear(): Unit   = {
    val header = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/table/thead/tr/th"))
    val count  = header.size
    assert(count == 3)
  }
  def verifyCTBodyCountForDualYear(): Unit     = {
    val body  = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/table/tbody/tr"))
    val count = body.size
    assert(count == 4)
  }
  def verifyCTHeaderCountForNoMrc(): Unit      = {
    val header = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/table/thead/tr/th"))
    val count  = header.size
    assert(count == 3)
  }
  def verifyCTBodyCountForNoMrc(): Unit        = {
    val body  = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/table/tbody/tr"))
    val count = body.size
    assert(count == 2)
  }
  def verifyETHeaderCountForDualYear(): Unit   = {
    val header = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[3]/table/thead/tr/th"))
    val count  = header.size
    assert(count == 3)
  }
  def verifyETBodyCountForDualYear(): Unit     = {
    val body  = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[3]/table/tbody/tr"))
    val count = body.size
    assert(count == 3)
  }
  def verifyETHeaderCountForSingleYear(): Unit = {
    val header = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[3]/table/thead/tr/th"))
    val count  = header.size
    assert(count == 1)
  }
  def verifyETBodyCountForSingleYear(): Unit   = {
    val body  = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[3]/table/tbody/tr"))
    val count = body.size
    assert(count == 3)
  }
  def verifyCTHeaderCountForSingleYear(): Unit = {
    val header = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/table/thead/tr/th"))
    val count  = header.size
    assert(count == 1)
  }
  def verifyETHeaderCountForNOMRC(): Unit      = {
    val header = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[3]/table/thead/tr/th"))
    val count  = header.size
    assert(count == 3)
  }
  def verifyETBodyCountForNOMRC(): Unit        = {
    val body  = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[3]/table/tbody/tr"))
    val count = body.size
    assert(count == 2)
  }
  def verifyCTBodyCountForSingleYear(): Unit   = {
    val body  = Driver.instance.findElements(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/table/tbody/tr"))
    val count = body.size
    assert(count == 4)
  }

  def HMRCFinancialYearsHeaderText(): String =
    HMRCFinancialYearsHeader.getText

  def HMRCFinancialYearsSectionYearOne(): String =
    HMRCFinancialYearsSectionY1.getText

  def HMRCFinancialYearsSectionYearTwo(): String =
    HMRCFinancialYearsSectionY2.getText

  def verifyETContent(): String =
    ETContent.getText

  def verifyTwoAssociatedCompanies(noOfAssociatedCompanies: String): Unit =
    TwoAssociatedComapniesText.getText.contains(noOfAssociatedCompanies)
}