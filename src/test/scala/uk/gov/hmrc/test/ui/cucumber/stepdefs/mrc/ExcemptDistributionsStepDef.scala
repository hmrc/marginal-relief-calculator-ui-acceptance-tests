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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.mrc

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage.error
import uk.gov.hmrc.test.ui.pages.mrc.{AssociatedCompaniesPage, ExcemptDistrubutionsPage, TaxableProfitPage}

class ExcemptDistributionsStepDef extends BaseStepDef {
  And("""the user selects option {string} for the question Did your company receive any distributions?""") {
    (option: String) =>
      if (option.equalsIgnoreCase("yes")) {
        ExcemptDistrubutionsPage.selectOptionYes
      } else {
        ExcemptDistrubutionsPage.selectOptionNo
      }
  }
  And(
    """the user selects option {string} for the question Do any distributions need to be included with your profits?"""
  ) { (option: String) =>
    if (option.equalsIgnoreCase("yes")) {
      ExcemptDistrubutionsPage.yesToIncludeInProfits
    } else {
      ExcemptDistrubutionsPage.noToIncludeInProfits
    }
  }
  Then("the user is provided with input field to provide distributions") { () =>
    ExcemptDistrubutionsPage.inputExcemptDistribution.isDisplayed
  }

  And("""the user provides {string} as distributions""") { (distributions: String) =>
    ExcemptDistrubutionsPage.provideDistributions(distributions)
  }

  And("the user clicks continue button on distributions page") { () =>
    ExcemptDistrubutionsPage.submitPage()
  }

  Then("""the user is displayed with error message {string} for distributions""") { (message: String) =>
    AssociatedCompaniesPage.errorMessage contains message
  }
}