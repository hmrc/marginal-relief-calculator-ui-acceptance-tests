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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.TestConfiguration

object MarginalReliefCalculatorHomePage extends BasePage {
//  val url: String = TestConfiguration.url("marginal-relief-calculator") + "/accounting-period"
  val url: String     = "https://www.qa.tax.service.gov.uk/marginal-relief-calculator/accounting-period"
  val mrcHomePage     = "What are your accounting period dates? - marginal-relief-calculator-frontend - GOV.UK"
  val mrcErrorSummary = "Error: What are your accounting period dates? - marginal-relief-calculator-frontend - GOV.UK"

  def loadPage: this.type = {
    driver.navigate().to(url)
    onPage(mrcHomePage)
    this
  }
  def provideAccountingStartDate: Unit = {
    driver.findElement(By.id("accountingPeriodStartDate.day")).sendKeys("");
    driver.findElement(By.id("accountingPeriodStartDate.month")).sendKeys("12");
    driver.findElement(By.id("accountingPeriodStartDate.year")).sendKeys("2022");
  }
  def submitaccountingPeriodInformation: Unit = {
    Thread.sleep(1000)
    submitPage()
  }

  def verifyErrorMessage: Unit =
    onPage(mrcErrorSummary)
  val errorMessage             = driver.findElement(By.className("govuk-list govuk-error-summary__list")).getText
  print(errorMessage)
}
