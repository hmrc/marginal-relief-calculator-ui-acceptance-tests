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

object ExcemptDistrubutionsPage extends BasePage {
  @FindBy(how = How.ID, using = "distributionsIncludedAmount") var inputExcemptDistribution: WebElement = _
  @FindBy(how = How.ID, using = "value_0") var yesOption: WebElement                                    = _
  @FindBy(how = How.ID, using = "value_1") var noOption: WebElement                                     = _
  @FindBy(how = How.ID, using = "distributionsIncluded") var yesForIncludeInProfits: WebElement         = _
  @FindBy(how = How.ID, using = "distributionsIncluded-2") var noForIncludeInProfits: WebElement        = _

  PageFactory.initElements(driver, this)

  def selectOptionYes: Unit = {
    yesOption.click
    yesOption.isSelected
  }

  def selectOptionNo: Unit = {
    noOption.click
    noOption.isSelected
  }

  def yesToIncludeInProfits: Unit = {
    yesForIncludeInProfits.click
    yesForIncludeInProfits.isSelected
  }

  def noToIncludeInProfits: Unit = {
    noForIncludeInProfits.click
    noForIncludeInProfits.isSelected
  }

  def provideDistributions(distributions: String) =
    inputExcemptDistribution.sendKeys(distributions)

  def submitaccountingPeriodInformation: Unit = {
    Thread.sleep(1000)
    submitPage()
  }

}
