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

object CheckYourAnswersPage extends BasePage {
  val checkYourAnswers =
    "Check Your Answers - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  @FindBy(how = How.CSS, using = "dl > div:nth-child(3) > dd >a") var changeLinkForDist: WebElement      = _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(1) > dd >a") var changeLinkForAccPeriod: WebElement = _
  @FindBy(how = How.CSS, using = "div:nth-child(3) > dd") var distributions: WebElement                  = _

  PageFactory.initElements(driver, this)

  def verifyPageTitle: Unit = {
    Thread.sleep(4000)
    verifyPageTitle(checkYourAnswers)
  }
  def changeLinkForAccountingPeriod(): Unit =
    changeLinkForAccPeriod.isDisplayed

  def changeLinkForDistributions(): Unit =
    changeLinkForDist.isDisplayed

  def clickOnChangeLinkForDistributions(): Unit =
    changeLinkForDist.click()

  def clickOnChangeLinkForAccPeriod(): Unit =
    changeLinkForAccPeriod.click()

  def verifyDistributionsValue(distributionsAmount: String): Unit =
    distributions.getText().contains(distributionsAmount)

  def verifyAccountingPeriodValue(distributionsAmount: String): Unit =
    distributions.getText().contains(distributionsAmount)

  def clickOnBackButton(): Unit =
    backButton.click()

}
