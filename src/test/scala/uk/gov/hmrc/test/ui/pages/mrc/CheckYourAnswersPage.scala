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
    "Check your answers - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  @FindBy(how = How.CSS, using = "dl > div:nth-child(3) > dd >a") var changeLinkForDist: WebElement                    = _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(2) > dd >a") var changeLinkForProfit: WebElement                  = _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(1) > dd >a") var changeLinkForAccPeriod: WebElement               = _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(4) > dd >a") var changeLinkForAC: WebElement                      = _
  @FindBy(how = How.CSS, using = "#main-content > div > div > a") var calculateMRCButton: WebElement                   = _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(1) > dd.govuk-summary-list__value") var accountingPeriodDates
    : WebElement                                                                                                       = _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(2) > dd.govuk-summary-list__value") var profit: WebElement        = _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(3) > dd.govuk-summary-list__value") var distributions: WebElement =
    _
  @FindBy(how = How.CSS, using = "dl > div:nth-child(4) > dd.govuk-summary-list__value") var NoOfAssociatedCompanies
    : WebElement                                                                                                       = _

  PageFactory.initElements(driver, this)

  def verifyPageTitle(): Unit               =
    verifyPageTitle(checkYourAnswers)
  def changeLinkForAccountingPeriod(): Unit =
    changeLinkForAccPeriod.isDisplayed

  def verifyChangeLinkForProfit(): Unit =
    changeLinkForProfit.isDisplayed

  def verifyChangeLinkForAC(): Unit =
    changeLinkForAC.isDisplayed

  def changeLinkForDistributions(): Unit =
    changeLinkForDist.isDisplayed

  def clickOnChangeLinkForDistributions(): Unit =
    changeLinkForDist.click()

  def clickOnChangeLinkForProfit(): Unit =
    changeLinkForProfit.click()

  def clickOnChangeLinkForAccPeriod(): Unit =
    changeLinkForAccPeriod.click()

  def clickOnChangeLinkForAssociatedCompanies(): Unit =
    changeLinkForAC.click()

  def verifyDistributionsValue(distributionsAmount: String): Unit =
    distributions.getText.contains(distributionsAmount)

  def verifyAccountingPeriodValue(AccountingPeriod: String): Unit =
    distributions.getText.contains(AccountingPeriod)

  def verifyProfitValue(profitValue: String): Unit = {
    val TP = profit.getText
    assert(TP === profitValue)
  }

  def verifyNoOfAssociatedCompanies(associatedCompanies: String): Unit = {
    val AC = NoOfAssociatedCompanies.getText
    assert(AC === associatedCompanies)
  }

  def clickOnBackButton(): Unit =
    backButton.click()

  def verifyMRCButtonEnabled(): Unit =
    calculateMRCButton.isEnabled()

  def clickMRCButton(): Unit =
    calculateMRCButton.click()

}
