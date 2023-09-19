/*
 * Copyright 2023 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.mrc.ExcemptDistrubutionsPage

class ExcemptDistributionsStepDef extends BaseStepDef {
  And("""the user selects option {string} for the question Did your company receive any distributions?""") {
    (option: String) =>
      if (option.equalsIgnoreCase("yes")) {
        ExcemptDistrubutionsPage.selectOptionYes()
      } else {
        ExcemptDistrubutionsPage.selectOptionNo()
      }
  }
  And(
    """the user selects option {string} for the question Do any distributions need to be included with your profits?"""
  ) { (option: String) =>
    if (option.equalsIgnoreCase("yes")) {
      ExcemptDistrubutionsPage.yesToIncludeInProfits()
    } else {
      ExcemptDistrubutionsPage.noToIncludeInProfits()
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

  Then("I am navigated to exempt distributions page") { () =>
    ExcemptDistrubutionsPage.verifyTitle()
  }

  Then("I am navigated to Second exempt distributions page") { () =>
    ExcemptDistrubutionsPage.verifySecondPageTitle()
  }

  Then("""I change the distributions value to {string}""") { (distributions: String) =>
    ExcemptDistrubutionsPage.provideDistributions(distributions)
  }

  Then("I can see options yes, no are not selected") { () =>
    ExcemptDistrubutionsPage.verifyYesNoNotSelected()
  }

  Then("I can see options yes,no are not selected on Second exempt distributions page") { () =>
    ExcemptDistrubutionsPage.verifyYesNoNotSelectedForIncludeInProfits()
  }
}
