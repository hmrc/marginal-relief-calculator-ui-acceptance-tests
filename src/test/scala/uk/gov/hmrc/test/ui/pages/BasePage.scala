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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.support.{FindBy, How}
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.util.List

trait BasePage extends BrowserDriver with Matchers {
  @FindBy(how = How.XPATH, using = "//a[text()='Back']") var backButton: WebElement = _

  def submitPage(): Unit =
    driver.findElement(By.cssSelector("button.govuk-button")).click()

  def verifyPageTitle(pageTitle: String): Unit =
    if (driver.getTitle != pageTitle)
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '${driver.getTitle}' page."
      )

  def verifyLinkText(linkText: String): Unit = {
    val elements: List[WebElement] = driver.findElements(By.tagName("a"))
    print(elements.size())
    print(elements.get(0).getText)

    var linkFound = false
    for (i <- 0 until elements.size())
      if (elements.get(i).getText.contains(linkText))
        linkFound = true

    assert(linkFound)
  }

  def clickBackLink(): Unit =
    backButton.click()

  def verifyTextPresentOnPage(text: String): Boolean =
    driver.getPageSource.contains(text)

  def verifyLinkTextPresentOnPage(text: String): Boolean =
    driver.findElement(By.linkText(text)).isDisplayed
}
case class PageNotFoundException(s: String) extends Exception(s)
