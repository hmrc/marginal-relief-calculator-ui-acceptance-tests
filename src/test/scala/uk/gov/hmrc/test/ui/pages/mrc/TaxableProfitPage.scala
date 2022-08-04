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

object TaxableProfitPage extends BasePage {
  @FindBy(how = How.ID, using = "value") var inputProfitValue: WebElement = _

  PageFactory.initElements(driver, this)

  def provideProfit(profitValue: String) = {
    inputProfitValue.clear()
    inputProfitValue.sendKeys(profitValue)
  }

  def submitAccountingPeriodInformation(): Unit = {
    Thread.sleep(1000)
    submitPage()
  }
}
