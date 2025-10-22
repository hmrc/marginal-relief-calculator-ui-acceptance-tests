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
import org.openqa.selenium.support.{FindBy, How, PageFactory}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.hmrc.test.ui.pages.mrc.TaxableProfitPage.inputProfitValue
import uk.gov.hmrc.test.ui.pages.BasePage


object AssociatedCompaniesPage extends BasePage {

  @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/div/div/form/h1") var headerMessage: WebElement = _
  @FindBy(how = How.XPATH, using = "//*[@class='govuk-details__summary-text']") var refLink: WebElement       = _
  @FindBy(how = How.ID, using = "associatedCompanies") var yesOption: WebElement                              = _
  @FindBy(how = How.ID, using = "associatedCompanies-2") var noOption: WebElement                             = _
  @FindBy(how = How.ID, using = "associatedCompaniesFY1Count") var acForFirstPartOfFinancialYear: WebElement  = _
  @FindBy(how = How.ID, using = "associatedCompaniesFY2Count") var acForSecondPartOfFinancialYear: WebElement = _
  @FindBy(
    how = How.XPATH,
    using = "//*[@class='govuk-label']/following-sibling::input"
  ) var inputAssociatedCompaniesCount: WebElement                                                             = _
  @FindBy(how = How.CSS, using = "form > button") var continueButton: WebElement                              = _

  PageFactory.initElements(driver, this)

  val pageHeading = By.cssSelector("h1.govuk-heading-l")
  val suffix = " - Calculate Marginal Relief for Corporation Tax - GOV.UK"

  def titleMessage(): String =
    eventually {
      headerMessage.getText
    }



  def validatePageTitle()(implicit driver: WebDriver): Unit = {
    waitFor.until(ExpectedConditions.titleContains("associated companies"))
    val headingElement = waitFor.until(ExpectedConditions.presenceOfElementLocated(pageHeading))
    val heading = headingElement.getText.trim
    verifyPageTitle(heading + suffix)
  }


  def verifyYesAndNoOptionsPresent(): Unit = {
    yesOption.isDisplayed
    noOption.isDisplayed
  }

  def verifyYesAndNoOptionsNotSelected(): Unit = {
    assert(!yesOption.isSelected)
    assert(!noOption.isSelected)
  }

  def selectOptionYes(): Unit = {
    yesOption.click()
    yesOption.isSelected()
  }

  def selectOptionNo(): Unit = {
    noOption.click()
    noOption.isSelected()
  }

  def isAssociatedCompaniesCountInputDisplayed: Boolean =
    inputAssociatedCompaniesCount.isDisplayed

  def clickOnContinue(): Unit =
    continueButton.click()

  def inputAssociatedCompanies(noOfAssociatedCompanies: String): Unit = {
    inputAssociatedCompaniesCount.clear()
    inputAssociatedCompaniesCount.sendKeys(noOfAssociatedCompanies)
  }

  def associatedCompaniesCountAsNull(): Unit =
    inputAssociatedCompaniesCount.getAttribute("value").contains("")

  def verifyCompaniesProfitAsNull(): Unit = {
    val el = waitFor.until(ExpectedConditions.presenceOfElementLocated(inputProfitValue))
    el.getAttribute("value").contains("")
  }

  def verifyAssociatedCompanies(associatedCo: String): Unit = {
    val AC = inputAssociatedCompaniesCount.getAttribute("value")
    assert(AC === associatedCo)
  }

  def clickOnQuestion(): Unit =
    refLink.click()

  def inputAcForFirstPartOfFinancialYear(noOfAc: String): Unit =
    acForFirstPartOfFinancialYear.sendKeys(noOfAc)

  def inputAcForSecondPartOfFinancialYear(noOfAc: String): Unit =
    acForSecondPartOfFinancialYear.sendKeys(noOfAc)
}
