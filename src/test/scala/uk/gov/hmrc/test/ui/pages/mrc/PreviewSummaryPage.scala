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

import org.openqa.selenium.WebElement
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages.BasePage
import org.openqa.selenium.By

object PreviewSummaryPage extends BasePage {
  private val headerBy: By = By.cssSelector("#main-content h1.govuk-heading-l") // or just "#main-content h1"

  def linkPrint: WebElement =
    Driver.instance.findElement(By.xpath("//a[@class='govuk-link print-this__print']"))

  def tblCT: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div[2]/div[1]/h2"))

  def tblET: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div[2]/div[2]/h2"))

  def lblCompanyName: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div[1]/div[2]/p"))

  def lblUTR: WebElement =
    Driver.instance.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div[1]/div[3]/p"))

  def twoAssociatedCompaniesText: WebElement =
    Driver.instance.findElement(By.xpath("dl > div:nth-child(4) > dd"))

  def verifyHeader(): String =
    Driver.instance.findElement(headerBy).getText

  def verifyLinkPrint(): String =
    linkPrint.getText

  def verifyTables(): Unit         = {
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
