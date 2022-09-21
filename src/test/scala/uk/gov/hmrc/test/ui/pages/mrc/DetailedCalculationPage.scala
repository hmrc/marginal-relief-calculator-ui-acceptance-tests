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

import org.openqa.selenium.support.{FindBy, How, PageFactory}
import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.test.ui.pages.BasePage

object DetailedCalculationPage extends BasePage {
  @FindBy(how = How.XPATH, using = "//a[@href='/marginal-relief-calculator/full-results-page']") var detailLinK
    : WebElement                                                                                              = _
  @FindBy(how = How.XPATH, using = "//h1") var detailPageHeader: WebElement                                   = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/dl/div[1]/dd/p[2]") var detailedPageMessage: WebElement         = _
  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/dl/div[3]/dd") var detailedPageDistributionAmt: WebElement = _
  PageFactory.initElements(driver, this)
  def verifyDetailLink(): Boolean                                                                             =
    detailLinK.isDisplayed()

  def clickDetailLink(): Unit =
    detailLinK.click()

  def detailedPageTitle(): String =
    detailPageHeader.getText

  def detailedPageContent(): String =
    detailedPageMessage.getText

  def detailedPageDistribution(): String =
    detailedPageDistributionAmt.getText

}
