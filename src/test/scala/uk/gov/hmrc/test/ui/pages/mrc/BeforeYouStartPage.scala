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
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.selenium.webdriver.Driver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import java.time.Duration

object BeforeYouStartPage extends BasePage {
  val beforeYouStartPage    =
    "Calculate Marginal Relief for Corporation Tax - Calculate Marginal Relief for Corporation Tax - GOV.UK"
  val url: String           = TestConfiguration.url("marginal-relief-calculator-frontend")
  // val url: String           = "https://www.qa.tax.service.gov.uk/marginal-relief-calculator"
  // val url: String           = "https://www.development.tax.service.gov.uk/marginal-relief-calculator"
  val mrcBeforeYouStartPage =
    "Calculate Marginal Relief for Corporation Tax - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  def startNowButton: WebElement =
    new WebDriverWait(Driver.instance, Duration.ofSeconds(10))
      .until(
        ExpectedConditions.elementToBeClickable(
          By.xpath("//a[contains(normalize-space(), 'Start now')]")
        )
      )

  def breadcrumbs: WebElement =
    new WebDriverWait(Driver.instance, Duration.ofSeconds(5))
      .until(
        ExpectedConditions.presenceOfElementLocated(
          By.cssSelector(".govuk-breadcrumbs__list")
        )
      )

  def loadPage(): Unit = {
    Driver.instance.manage().deleteAllCookies()
    Driver.instance.navigate().to(url)
    // driver.switchTo.alert.sendKeys("mrc")
    verifyPageTitle(mrcBeforeYouStartPage)
  }

  def verifyTitle(): Unit =
    verifyPageTitle(beforeYouStartPage)

  def verifyBreadcrumbs(): Unit = {
    breadcrumbs.getText.contains("Home")
    breadcrumbs.getText.contains("Corporation Tax")
    breadcrumbs.getText.contains("Marginal Relief for Corporation Tax")
  }

  def clickOnStartNowButton(): Unit =
    startNowButton.click()

  def verifyWelshLanguageLink(): Unit = {
    val welshLanguageLinkPresent = Driver.instance.getPageSource.contains("Welsh")
    assert(welshLanguageLinkPresent === false)
  }
}
