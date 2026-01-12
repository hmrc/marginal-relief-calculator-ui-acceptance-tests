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

import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages.BasePage

import java.util
object ExcemptDistrubutionsPage extends BasePage {
  private val distributionsPageTitle  =
    "Did your company receive any distributions? - Calculate Marginal Relief for Corporation Tax - GOV.UK"
  private val distributionsPageTitle2 =
    "Do any distributions need to be included with your profits? - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  private val inputExcemptDistribution = By.id("distributionsIncludedAmount")
  private val yesOption                = By.id("value_0")
  private val noOption                 = By.id("value_1")
  private val yesForIncludeInProfits   = By.id("distributionsIncluded")
  private val noForIncludeInProfits    = By.id("distributionsIncluded-2")

  def verifyTitle(): Unit =
    verifyPageTitle(distributionsPageTitle)

  def verifySecondPageTitle(): Unit =
    verifyPageTitle(distributionsPageTitle2)

  def selectOptionYes(): Unit = {
    val el = waitFor.until(ExpectedConditions.presenceOfElementLocated(yesOption))
    el.click()
    el.isSelected
  }

  def selectOptionNo(): Unit = {
    val el = waitFor.until(ExpectedConditions.presenceOfElementLocated(noOption))
    el.click()
    el.isSelected
  }

  def yesToIncludeInProfits(): Unit = {
    val el = waitFor.until(ExpectedConditions.presenceOfElementLocated(yesForIncludeInProfits))
    el.click()
    el.isSelected
  }

  def noToIncludeInProfits(): Unit = {
    val el = waitFor.until(ExpectedConditions.presenceOfElementLocated(noForIncludeInProfits))
    el.click()
    el.isSelected
  }

  def provideDistributions(distributions: String): Unit = {
    val el = waitFor.until(ExpectedConditions.presenceOfElementLocated(inputExcemptDistribution))
    el.clear()
    el.sendKeys(distributions)
  }

  def displayDistributions(): Unit = {
    val el = waitFor.until(ExpectedConditions.presenceOfElementLocated(inputExcemptDistribution))
    el.isDisplayed
  }

  def verifyYesNoNotSelected(): Unit = {
    val elementsYes: util.List[WebElement] = Driver.instance.findElements(By.cssSelector("#value_0:checked"))
    val elementsNo: util.List[WebElement]  = Driver.instance.findElements(By.cssSelector("#value_1:checked"))
    assert(((elementsYes.size === 0) && (elementsNo.size === 0)) === true)
  }

  def verifyYesNoNotSelectedForIncludeInProfits(): Unit = {
    val elementsYes: util.List[WebElement] = Driver.instance.findElements(By.cssSelector("#distributionsIncluded:checked"))
    val elementsNo: util.List[WebElement]  = Driver.instance.findElements(By.cssSelector("#distributionsIncluded-2:checked"))
    assert(((elementsYes.size === 0) && (elementsNo.size === 0)) === true)
  }

}