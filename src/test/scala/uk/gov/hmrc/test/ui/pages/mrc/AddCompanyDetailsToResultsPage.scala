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

object AddCompanyDetailsToResultsPage extends BasePage {
  @FindBy(how = How.ID, using = "pdfAddCompanyDetails") var yesOption: WebElement  = _
  @FindBy(how = How.ID, using = "pdfAddCompanyDetails-2") var noOption: WebElement = _

  PageFactory.initElements(driver, this)

  def selectOptionYes(): Unit = {
    yesOption.click()
    yesOption.isSelected
  }

  def selectOptionNo(): Unit = {
    noOption.click()
    noOption.isSelected
  }

  def clickOnContinueButton(): Unit =
    driver.findElement(By.cssSelector("button.govuk-button")).click()

}
