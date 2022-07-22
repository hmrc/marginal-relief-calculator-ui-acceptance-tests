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

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.BasePage

object AssociatedCompaniesPage extends BasePage {

  def titleMessage: String = {
    Thread.sleep(1000)
    driver.findElement(By.xpath("h1")).getText
  }

  def verifyPageTitle: Unit =
    assert(driver.getTitle().equals("Number of associated companies - marginal-relief-calculator-frontend - GOV.UK"))

  def verifyYesAndNoOptionsPresent: Unit = {
    driver.findElement(By.id("associatedCompanies")).isDisplayed
    driver.findElement(By.id("associatedCompanies-2")).isDisplayed
  }

  def verifyYesAndNoOptionsNotSelected: Unit = {
    Assert.assertFalse(driver.findElement(By.id("associatedCompanies")).isSelected)
    Assert.assertFalse(driver.findElement(By.id("associatedCompanies-2")).isSelected)
  }

  def selectOptionYes: Unit = {
    driver.findElement(By.id("associatedCompanies")).click
    driver.findElement(By.id("associatedCompanies")).isSelected
  }

  def selectOptionNo: Unit = {
    driver.findElement(By.id("associatedCompanies-2")).click
    driver.findElement(By.id("associatedCompanies-2")).isSelected
  }

  def isAssociatedCompaniesCountInputDisplayed: Unit =
    driver.findElement(By.id("associatedCompaniesCount")).isDisplayed

  def clickOnContinue: Unit =
    driver.findElement(By.cssSelector("form > button")).click()

  def inputAssociatedCompanies(noOfAssociatedCompanies: String): Unit =
    driver.findElement(By.id("associatedCompaniesCount")).sendKeys(noOfAssociatedCompanies)

  def errorMessage: String = {
    Thread.sleep(3000)
    driver.findElement(By.cssSelector(".govuk-error-summary__body a")).getText
  }
}
