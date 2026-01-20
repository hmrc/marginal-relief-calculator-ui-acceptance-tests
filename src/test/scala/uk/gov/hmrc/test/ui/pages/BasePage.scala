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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.openqa.selenium.{By, ElementClickInterceptedException, StaleElementReferenceException, TimeoutException, WebDriver, WebElement}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.webdriver.Driver

import java.time.Duration
import java.util.List

trait BasePage extends Matchers {

  def backButton: WebElement =
    Driver.instance.findElement(By.xpath("//a[text()='Back']"))

  def waitFor: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(40))
    .pollingEvery(Duration.ofMillis(250))
    .ignoring(classOf[Exception])
    .ignoring(classOf[RuntimeException])
    .ignoring(classOf[ElementClickInterceptedException])
    .ignoring(classOf[StaleElementReferenceException], classOf[NoSuchElementException])

  def submitPage(): Unit =
    Driver.instance.findElement(By.cssSelector("button.govuk-button")).click()

  def verifyPageTitle(pageTitle: String): Unit =
    try
      new FluentWait[WebDriver](Driver.instance)
        .withTimeout(Duration.ofSeconds(40))
        .pollingEvery(Duration.ofMillis(250))
        .ignoring(classOf[Exception])
        .ignoring(classOf[RuntimeException])
        .ignoring(classOf[ElementClickInterceptedException])
        .ignoring(classOf[StaleElementReferenceException], classOf[NoSuchElementException])
        .until(ExpectedConditions.titleContains(pageTitle))
    catch {
      case _: TimeoutException =>
        throw PageNotFoundException(
          s"""Expected title containing '$pageTitle'
             |but found title='${Driver.instance.getTitle}'
             |url='${Driver.instance.getCurrentUrl}'
             |""".stripMargin
        )
    }

  def verifyLinkText(linkText: String): Unit = {
    val elements: List[WebElement] = Driver.instance.findElements(By.tagName("a"))
    print(elements.size())
    print(elements.get(0).getText)

    var linkFound = false
    for (i <- 0 until elements.size())
      if (elements.get(i).getText.contains(linkText))
        linkFound = true

    assert(linkFound)
  }

  def clickBackLink(): Unit = {
    val locator = By.cssSelector("a.govuk-back-link")

    val el = new FluentWait[WebDriver](Driver.instance)
      .withTimeout(Duration.ofSeconds(10))
      .pollingEvery(Duration.ofMillis(200))
      .ignoring(classOf[StaleElementReferenceException])
      .until(ExpectedConditions.elementToBeClickable(locator))

    el.click()
  }

  def verifyTextPresentOnPage(text: String): Boolean =
    Driver.instance.getPageSource.contains(text)

  def verifyLinkTextPresentOnPage(text: String): Boolean =
    Driver.instance.findElement(By.linkText(text)).isDisplayed
}
case class PageNotFoundException(s: String) extends Exception(s)
