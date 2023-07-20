/*
 * Copyright 2023 HM Revenue & Customs
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

object PreviewSummaryPage extends BasePage {
  @FindBy(how = How.XPATH, using = "//h1[@class='govuk-heading-xl']") var lblHeader: WebElement                        = _
  @FindBy(how = How.XPATH, using = "//a[@class='govuk-link print-this__print']") var linkPrint: WebElement            = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[2]/div[2]/div[1]/h2") var tblCT: WebElement =
    _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[2]/div[2]/div[2]/h2") var tblET: WebElement =
    _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[2]/div[1]/div[2]/p") var lblCompanyName
    : WebElement                                                                                                      = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/div[2]/div[1]/div[3]/p") var lblUTR: WebElement =
    _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(4) > dd") var twoAssociatedCompaniesText: WebElement             = _

  PageFactory.initElements(driver, this)

  def verifyHeader(): String =
    lblHeader.getText

  def verifyLinkPrint(): String =
    linkPrint.getText

  def verifyTables(): Unit = {
    tblCT.isDisplayed
    tblET.isDisplayed
  }
  def verifyCompanydetails(): Unit = {
    lblCompanyName.getText.contains("Test-Company name")
    lblUTR.getText.contains("987654321")
  }

  def verifyAssociatedCompanies(noOfAssociatedCompanies: String): Unit =
    twoAssociatedCompaniesText.getText.contains(noOfAssociatedCompanies)
}
