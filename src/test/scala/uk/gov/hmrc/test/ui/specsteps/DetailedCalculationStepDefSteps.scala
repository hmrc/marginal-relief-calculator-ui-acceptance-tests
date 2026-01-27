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

import org.scalatest.matchers.should.Matchers._
import uk.gov.hmrc.test.ui.pages.mrc.DetailedCalculationPage.{DateInWhatToDoNextSection, detailedPageTitle, validateTotalMR, verifySectionHeader, verifysectionlable, yourDetailsAccountingPeriodText, yourDetailsDistributionAmtText}
import uk.gov.hmrc.test.ui.pages.mrc.{AddCompanyDetailsToResultsPage, DetailedCalculationPage}

object DetailedCalculationStepDefSteps {

  // the Check Marginal Relief calculation in detail link is displayed
  def andTheCheckMarginalReliefCalculationInDetailLinkIsDisplayed(): Unit =
    DetailedCalculationPage.verifyDetailLink()

  // the user clicks the Check Marginal Relief calculation in detail link
  def andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink(): Unit =
    DetailedCalculationPage.clickDetailLink()

  // header displays as {string}
  def thenHeaderDisplaysAs(headerTitle: String): Unit =
    detailedPageTitle() shouldBe headerTitle

  // the Your details page contains {string}
  def thenTheYourDetailsPageContains(detailedContent: String): Unit =
    yourDetailsAccountingPeriodText().contains(detailedContent)

  // the distribution amount has £ prefix and displayed as {string}
  def thenTheDistributionAmountHasPrefixAndDisplayedAs(distributionamt: String): Unit =
    yourDetailsDistributionAmtText() shouldBe distributionamt

  // the How its calculated section is displayed
  def thenTheHowItsCalculatedSectionIsDisplayed(): Unit =
    DetailedCalculationPage.isHowItsCalculatedSectionDisplayed

  // the Taxable Profit section is displayed
  def thenTheTaxableProfitSectionIsDisplayed(): Unit =
    DetailedCalculationPage.isTaxableProfitSectionDisplayed

  // {string} is displayed on the page
  def thenIsDisplayedOnThePage(string: String): Unit =
    DetailedCalculationPage.verifyTextPresentOnPage(string)

  // {string} MR calculation steps are displayed
  def thenMRCalculationStepsAreDisplayed(calSteps: String): Unit =
    DetailedCalculationPage.validateMrCalculationSteps(calSteps)

  // What is the marginal rate fraction link is displayed
  def thenWhatIsTheMarginalRateFractionLinkIsDisplayed(): Unit =
    DetailedCalculationPage.verifyMRFractionLinkPresentOnPage()

  // the total Marginal relief is {string}
  def thenTheTotalMarginalReliefIs(totalMR: String): Unit =
    validateTotalMR() shouldBe totalMR

  // the tabs are displayed
  def thenTheTabsAreDisplayed(): Unit =
    DetailedCalculationPage.validateTabs()

  // the user clicks 2025 tab and verifies the tab
  def thenTheUserClicks2025TabAndVerifiesTheTab(): Unit =
    DetailedCalculationPage.clickOn2025tab()

  // the user clicks the Get A Copy Of Results link
  def thenTheUserClicksTheGetACopyOfResultsLink(): Unit =
    DetailedCalculationPage.clickOnGetACopyOfResults()

  // {string} section is displayed and it contains {string}
  def thenSectionIsDisplayedAndItContains(sectionHeader: String, sectionText: String): Unit = {
    verifySectionHeader() shouldBe sectionHeader
    verifysectionlable()  shouldBe sectionText
  }

  // What to do next session contains date 9months after POA end date which is {string}
  def thenWhatToDoNextSessionContainsDate9monthsAfterPOAEndDateWhichIs(date: String): Unit =
    DateInWhatToDoNextSection() shouldBe date

  // the user is presented with add company details to your result page
  def thenTheUserIsPresentedWithAddCompanyDetailsToYourResultPage(): Unit =
    AddCompanyDetailsToResultsPage.verifyPageTitle(
      "Do you want to add company details to your results? - Calculate Marginal Relief for Corporation Tax - GOV.UK"
    )

  // the user selects option as {string} on add company details page
  def andTheUserSelectsOptionAsOnAddCompanyDetailsPage(option: String): Unit = {
    if (option.equalsIgnoreCase("yes")) {
      AddCompanyDetailsToResultsPage.selectOptionYes()
    } else {
      AddCompanyDetailsToResultsPage.selectOptionNo()
    }
    AddCompanyDetailsToResultsPage.clickOnContinueButton()
  }

  // the user validates the associated companies on the detailed calculation page as {string}
  def thenTheUserValidatesTheAssociatedCompaniesOnTheDetailedCalculationPageAs(associateCompanies: String): Unit =
    DetailedCalculationPage.verifyAssociatedCompanies(associateCompanies)

}
