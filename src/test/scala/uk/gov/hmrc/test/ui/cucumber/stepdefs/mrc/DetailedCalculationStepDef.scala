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
import uk.gov.hmrc.test.ui.pages.mrc.DetailedCalculationPage
import uk.gov.hmrc.test.ui.pages.mrc.DetailedCalculationPage.{detailedPageContent, detailedPageDistribution, detailedPageTitle}

class DetailedCalculationStepDef extends BaseStepDef {
  And("the Check Marginal Relief calculation in detail link is displayed") { () =>
    DetailedCalculationPage.verifyDetailLink()
  }
  And("the user click on Check Marginal Relief calculation in detail link") { () =>
    DetailedCalculationPage.clickDetailLink()
  }
  Then("""header displays as {string}""") { (headerTitle: String) =>
    detailedPageTitle should be(headerTitle)
  }
  Then("""the Your details page contains {string}""") { (detailedContent: String) =>
    detailedPageContent should be(detailedContent)
  }
  Then("""the distribution amount has £ prefix and displayed as {string}""") { (distributionamt: String) =>
    detailedPageDistribution should be(distributionamt)
  }

}
