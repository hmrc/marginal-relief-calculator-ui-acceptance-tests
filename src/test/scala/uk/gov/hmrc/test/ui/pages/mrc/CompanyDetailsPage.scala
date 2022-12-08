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

object CompanyDetailsPage extends BasePage {
  @FindBy(how = How.XPATH, using = "//button[@class='govuk-button']") var btnContinue: WebElement = _
  @FindBy(how = How.XPATH, using = "//input[@id='companyName']") var fldCompanyName: WebElement   = _
  @FindBy(how = How.XPATH, using = "//input[@id='utr']") var fldUTR: WebElement                   = _
  @FindBy(how = How.CSS, using = ".govuk-error-summary__body a") var charaError: WebElement       = _

  PageFactory.initElements(driver, this)

  def provideLongCompanyName(longCompanyName: String) =
    fldCompanyName.sendKeys(longCompanyName)

  def provideUTRnumber(longUTRNumber: String) =
    fldUTR.sendKeys(longUTRNumber)

  def clickOnContinue(): Unit =
    btnContinue.click()

  def charaValidationError(): String =
    charaError.getText

}
