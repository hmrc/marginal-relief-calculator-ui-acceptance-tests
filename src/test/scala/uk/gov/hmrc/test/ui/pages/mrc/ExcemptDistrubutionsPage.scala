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
import uk.gov.hmrc.test.ui.pages.BasePage

import java.util
object ExcemptDistrubutionsPage extends BasePage {
  val distributionsPageTitle  =
    "Did your company receive any distributions? - Calculate Marginal Relief for Corporation Tax - GOV.UK"
  val distributionsPageTitle2 =
    "Do any distributions need to be included with your profits? - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  @FindBy(how = How.ID, using = "distributionsIncludedAmount") var inputExcemptDistribution: WebElement = null
  @FindBy(how = How.ID, using = "value_0") var yesOption: WebElement                                    = null
  @FindBy(how = How.ID, using = "value_1") var noOption: WebElement                                     = null
  @FindBy(how = How.ID, using = "distributionsIncluded") var yesForIncludeInProfits: WebElement         = null
  @FindBy(how = How.ID, using = "distributionsIncluded-2") var noForIncludeInProfits: WebElement        = null

  @FindBy(how = How.CSS, using = "#value_0:checked") var yesOptionChecked: List[WebElement]                            = null
  @FindBy(how = How.CSS, using = "#value_1:checked") var noOptionChecked: List[WebElement]                             = null
  @FindBy(how = How.CSS, using = "#distributionsIncluded:checked") var yesForIncludeInProfitsChecked: List[WebElement] =
    null
  @FindBy(how = How.CSS, using = "#distributionsIncluded-2:checked") var noForIncludeInProfitsChecked
    : List[WebElement]                                                                                                 = null

  PageFactory.initElements(driver, this)

  def verifyTitle(): Unit =
    verifyPageTitle(distributionsPageTitle)

  def verifySecondPageTitle(): Unit =
    verifyPageTitle(distributionsPageTitle2)

  def selectOptionYes(): Unit = {
    yesOption.click()
    yesOption.isSelected
  }

  def selectOptionNo(): Unit = {
    noOption.click()
    noOption.isSelected
  }

  def yesToIncludeInProfits(): Unit = {
    yesForIncludeInProfits.click()
    yesForIncludeInProfits.isSelected
  }

  def noToIncludeInProfits(): Unit = {
    noForIncludeInProfits.click()
    noForIncludeInProfits.isSelected
  }

  def provideDistributions(distributions: String): Unit = {
    inputExcemptDistribution.clear()
    inputExcemptDistribution.sendKeys(distributions)
  }

  def verifyYesNoNotSelected(): Unit = {
    val elementsYes: util.List[WebElement] = driver.findElements(By.cssSelector("#value_0:checked"))
    val elementsNo: util.List[WebElement]  = driver.findElements(By.cssSelector("#value_1:checked"))
    assert(((elementsYes.size === 0) && (elementsNo.size === 0)) === true)
  }

  def verifyYesNoNotSelectedForIncludeInProfits(): Unit = {
    val elementsYes: util.List[WebElement] = driver.findElements(By.cssSelector("#distributionsIncluded:checked"))
    val elementsNo: util.List[WebElement]  = driver.findElements(By.cssSelector("#distributionsIncluded-2:checked"))
    assert(((elementsYes.size === 0) && (elementsNo.size === 0)) === true)
  }

}
