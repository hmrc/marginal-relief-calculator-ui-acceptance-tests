/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specsteps

/*
 * Copyright 2026 HM Revenue & Customs
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

import uk.gov.hmrc.selenium.webdriver.Driver.instance
import uk.gov.hmrc.test.ui.pages.mrc.CompanyDetailsPage

object CompanyDetailsStepDefSteps {

  // the user provides a {string} on Company name field
  def thenTheUserProvidesOnCompanyNameField(longCompanyName: String): Unit = {
    CompanyDetailsPage.provideLongCompanyName(longCompanyName)
  }

  // the user provides a {string} on UTR number field
  def thenTheUserProvidesOnUTRNumberField(longUTRNumber: String): Unit = {
    CompanyDetailsPage.provideUTRnumber(longUTRNumber)
  }

  // the user clicks the continue button on the company details page
  def thenTheUserClicksTheContinueButtonOnTheCompanyDetailsPage(): Unit = {
    CompanyDetailsPage.clickOnContinue()
  }

  // the user lands on AddCompanyDetails page
  def thenTheUserLandsOnAddCompanyDetailsPage(): Unit = {
    CompanyDetailsPage.verifyPageTitle(
          "Add company details before you print or save your calculation - Calculate Marginal Relief for Corporation Tax - GOV.UK"
        )
  }

  // the user selects {string} and continue on add company details page
  def thenTheUserSelectsAndContinueOnAddCompanyDetailsPage(option: String): Unit = {
    if (option.equalsIgnoreCase("yes")) {
          CompanyDetailsPage.selectOptionYes()
        } else {
          CompanyDetailsPage.selectOptionNo()
        }
        CompanyDetailsPage.clickOnContinue()
  }

}
