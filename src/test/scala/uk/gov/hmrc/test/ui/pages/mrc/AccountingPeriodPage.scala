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

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.BasePage

object AccountingPeriodPage extends BasePage {
  //  val url: String = TestConfiguration.url("marginal-relief-calculator") + "/accounting-period"
  val url: String                         = "https://www.qa.tax.service.gov.uk/marginal-relief-calculator/accounting-period"
  val mrcHomePage                         = "What are your accounting period dates? - marginal-relief-calculator-frontend - GOV.UK"
  val mrcHomePageError                    = "Error: What are your accounting period dates? - marginal-relief-calculator-frontend - GOV.UK"
  val accountingPeriodMandatoryValueError = "The Start date must include day"
  val accountingPeriodMandatoryFieldError = "Enter a valid Start date for the accounting period, like 27 3 2023"
  val accountingPeriodLengthError         =
    "The accounting period End date must be less than or equal to a full calendar year from the Start date"

  def loadPage: this.type = {
    driver.navigate().to(url)
    onPage(mrcHomePage)
    this
  }

  def error: String = {
    Thread.sleep(1000)
    driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/form/div[1]/div/ul/li/a")).getText
  }

  def provideEmptyAccountingStartDay: Unit = {
    driver.findElement(By.id("accountingPeriodStartDate.day")).sendKeys("")
    driver.findElement(By.id("accountingPeriodStartDate.month")).sendKeys("12")
    driver.findElement(By.id("accountingPeriodStartDate.year")).sendKeys("2022")
  }
  def provideEmptyAccountingStartDate: Unit = {
    driver.findElement(By.id("accountingPeriodStartDate.day")).sendKeys("")
    driver.findElement(By.id("accountingPeriodStartDate.month")).sendKeys("")
    driver.findElement(By.id("accountingPeriodStartDate.year")).sendKeys("")
  }

  def provideValidAccountingStartDate: Unit = {
    driver.findElement(By.id("accountingPeriodStartDate.day")).clear()
    driver.findElement(By.id("accountingPeriodStartDate.day")).sendKeys("01")
    driver.findElement(By.id("accountingPeriodStartDate.month")).clear()
    driver.findElement(By.id("accountingPeriodStartDate.month")).sendKeys("01")
    driver.findElement(By.id("accountingPeriodStartDate.year")).clear()
    driver.findElement(By.id("accountingPeriodStartDate.year")).sendKeys("2023")
  }

  def provideInvalidAccountingEndDate: Unit = {
    driver.findElement(By.id("accountingPeriodEndDate.day")).sendKeys("01")
    driver.findElement(By.id("accountingPeriodEndDate.month")).sendKeys("01")
    driver.findElement(By.id("accountingPeriodEndDate.year")).sendKeys("2024")
  }
  def provideValidAccountingEndDate: Unit = {
    driver.findElement(By.id("accountingPeriodEndDate.day")).clear()
    driver.findElement(By.id("accountingPeriodEndDate.day")).sendKeys("31")
    driver.findElement(By.id("accountingPeriodEndDate.month")).clear()
    driver.findElement(By.id("accountingPeriodEndDate.month")).sendKeys("12")
    driver.findElement(By.id("accountingPeriodEndDate.year")).clear()
    driver.findElement(By.id("accountingPeriodEndDate.year")).sendKeys("2023")
  }

}
