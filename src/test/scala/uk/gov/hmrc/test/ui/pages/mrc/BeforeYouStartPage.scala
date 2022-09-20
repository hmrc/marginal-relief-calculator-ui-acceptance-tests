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

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.{FindBy, How, PageFactory}
import uk.gov.hmrc.test.ui.pages.BasePage

object BeforeYouStartPage extends BasePage {
  val beforeYouStartPage    =
    "marginal-relief-calculator-frontend - Calculate Marginal Relief for Corporation Tax - GOV.UK"
  val url: String           = "https://www.qa.tax.service.gov.uk/marginal-relief-calculator"
  val mrcBeforeYouStartPage =
    "marginal-relief-calculator-frontend - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  @FindBy(how = How.XPATH, using = "//a[contains(text(),'Start now')]") var startNowButton: WebElement = _
  @FindBy(how = How.CLASS_NAME, using = "govuk-breadcrumbs__list") var breadcrumbs: WebElement         = _

  PageFactory.initElements(driver, this)

  def loadPage(): Unit = {
    driver.manage().deleteAllCookies()
    driver.navigate().to(url)
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
    val welshLanguageLinkPresent = driver.getPageSource.contains("Welsh")
    assert(welshLanguageLinkPresent === false)
  }
}
