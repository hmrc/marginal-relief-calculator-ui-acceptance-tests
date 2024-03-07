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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.mrc

import io.cucumber.datatable.DataTable
import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.mrc.BeforeYouStartPage
import uk.gov.hmrc.test.ui.pages.mrc.BeforeYouStartPage.verifyLinkText

class BeforeYouStartStepDef extends BaseStepDef {

  Given("Marginal Relief Calculator is launched") { () =>
    BeforeYouStartPage.loadPage()
  }

  Then("I am landed on before you start page") { () =>
    BeforeYouStartPage.verifyTitle()
  //Thread.sleep(10000)
  }

  And("I can see the breadcrumbs on the page") { () =>
    BeforeYouStartPage.verifyBreadcrumbs()
  }

  And("I can verify that Welsh language is not displayed") { () =>
    BeforeYouStartPage.verifyWelshLanguageLink()
  }

  And("""I can verify the link present on screen""") { (linkText: DataTable) =>
    for (i <- 0 until linkText.asList().size())
      verifyLinkText(linkText.asList().get(i))
  }

  And("the user clicks on start now button") { () =>
    BeforeYouStartPage.clickOnStartNowButton()
  }
}
