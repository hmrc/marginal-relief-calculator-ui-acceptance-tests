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
import uk.gov.hmrc.test.ui.pages.mrc.DetailedCalculationPage.{DateInWhatToDoNextSection, detailedPageTitle, validateTotalMR, verifySectionHeader, verifysectionlable, yourDetailsAccountingPeriodText, yourDetailsDistributionAmtText}
import uk.gov.hmrc.test.ui.pages.mrc.{AddCompanyDetailsToResultsPage, DetailedCalculationPage}

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
    yourDetailsAccountingPeriodText contains detailedContent
  }
  Then("""the distribution amount has £ prefix and displayed as {string}""") { (distributionamt: String) =>
    yourDetailsDistributionAmtText should be(distributionamt)
  }
  Then("""the How its calculated section is displayed""") { () =>
    DetailedCalculationPage.isHowItsCalculatedSectionDisplayed
  }
  Then("""the Taxable Profit section is displayed""") { () =>
    DetailedCalculationPage.isTaxableProfitSectionDisplayed
  }
  Then("""{string} is displayed on the page""") { (string: String) =>
    DetailedCalculationPage.verifyTextPresentOnPage(string)
  }
  Then("""{string} MR calculation steps are displayed""") { (calSteps: String) =>
    DetailedCalculationPage.validateMrCalculationSteps(calSteps)
  }
  Then("""What is the marginal rate fraction link is displayed""") { () =>
    DetailedCalculationPage.verifyMRFractionLinkPresentOnPage()
  }
  Then("""the total Marginal relief is {string}""") { (totalMR: String) =>
    validateTotalMR should be(totalMR)
  }
  Then("the tabs are displayed") { () =>
    DetailedCalculationPage.validateTabs()
  }
  Then("I click on 2025 tab and verify the tab") { () =>
    DetailedCalculationPage.clickOn2025tab()
  }
  Then("the user clicks on Print or save your calculation link") { () =>
    DetailedCalculationPage.clickOnGetACopyOfResults()
  }
  Then("""{string} section is displayed and it contains {string}""") { (sectionHeader: String, sectionText: String) =>
    verifySectionHeader should be(sectionHeader)
    verifysectionlable  should be(sectionText)
  }
  Then("""What to do next session contains date 9months after POA end date which is {string}""") { (date: String) =>
    DateInWhatToDoNextSection should be(date)
  }
  Then("the user is presented with add company details to your result page") { () =>
    AddCompanyDetailsToResultsPage.verifyPageTitle(
      "Do you want to add company details to your results? - Calculate Marginal Relief for Corporation Tax - GOV.UK"
    )
  }
  And("""the user selects option as {string} on add company details page""") { (option: String) =>
    if (option.equalsIgnoreCase("yes")) {
      AddCompanyDetailsToResultsPage.selectOptionYes()
    } else {
      AddCompanyDetailsToResultsPage.selectOptionNo()
    }
    AddCompanyDetailsToResultsPage.clickOnContinueButton()
  }

}
