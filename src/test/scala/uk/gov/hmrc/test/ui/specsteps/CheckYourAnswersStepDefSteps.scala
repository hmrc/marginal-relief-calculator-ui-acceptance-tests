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

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.hmrc.test.ui.pages.mrc.{CheckYourAnswersPage, ResultPage}

object CheckYourAnswersStepDefSteps {

  // the user is presented with change link next to the distribution amount
  def theUserIsPresentedWithChangeLinkNextToTheDistributionAmount(): Unit =
    CheckYourAnswersPage.changeLinkForDistributions()

  // the user can validate their distribution amount as {string}
  def theUserCanValidateTheirDistributionAmountAs(distributionsAmount: String): Unit =
    CheckYourAnswersPage.verifyDistributionsValue(distributionsAmount)

  // the user is presented with a change link next to the accounting period dates
  def theUserIsPresentedWithAChangeLinkNextToTheAccountingPeriodDates(): Unit =
    CheckYourAnswersPage.changeLinkForAccountingPeriod()

  // the user is presented with a change link next to the company's profit
  def theUserIsPresentedWithAChangeLinkNextToTheCompanyProfit(): Unit =
    CheckYourAnswersPage.verifyChangeLinkForProfit()

  // the user is presented with a change link next to the associated companies
  def theUserIsPresentedWithAChangeLinkNextToTheAssociatedCompanies(): Unit =
    CheckYourAnswersPage.verifyChangeLinkForAC()

  // the user can validate their accounting period dates as {string}
  def theUserCanValidateTheirAccountingPeriodDatesAs(AccountingPeriod: String): Unit =
    CheckYourAnswersPage.verifyAccountingPeriodValue(AccountingPeriod)

  // the user can validate their company profit as {string}
  def theUserCanValidateTheirCompanyProfitAs(profit: String): Unit =
    CheckYourAnswersPage.verifyProfitValue(profit)

  // the user can validate the associated companies as {string}
  def theUserCanValidateTheAssociatedCompaniesAs(associatedCompanies: String): Unit =
    CheckYourAnswersPage.verifyNoOfAssociatedCompanies(associatedCompanies)

  // the user clicks the change link next to the distribution amount
  def theUserClicksTheChangeLinkNextToTheDistributionAmount(): Unit =
    CheckYourAnswersPage.clickOnChangeLinkForDistributions()

  // the user clicks the change link next to the company's profit
  def theUserClicksTheChangeLinkNextToTheCompanyProfit(): Unit =
    CheckYourAnswersPage.clickOnChangeLinkForProfit()

  // the user clicks the change link next to the accounting period dates
  def theUserClicksTheChangeLinkNextToTheAccountingPeriodDates(): Unit =
    CheckYourAnswersPage.clickOnChangeLinkForAccPeriod()

  // the user clicks the change link next to the associated companies
  def theUserClicksTheChangeLinkNextToTheAssociatedCompanies(): Unit =
    CheckYourAnswersPage.clickOnChangeLinkForAssociatedCompanies()

  // the user clicks the back button
  def theUserClicksTheBackButton(): Unit =
    CheckYourAnswersPage.clickBackLink()

  // the user clicks the calculate marginal relief button on the check your answers page
  def theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage(): Unit =
    eventually {
      CheckYourAnswersPage.clickMRCButton()
    }

  // the user can see the calculate margin relief button enabled
  def theUserCanSeeTheCalculateMarginReliefButtonEnabled(): Unit =
    CheckYourAnswersPage.verifyMRCButtonEnabled()

  // the user can click on the calculate margin relief button
  def theUserCanClickOnTheCalculateMarginReliefButton(): Unit =
    CheckYourAnswersPage.clickMRCButton()

  // the user can validate the accounting period as {string}
  def theUserCanValidateTheAccountingPeriodAs(accountingPeriod: String): Unit =
    if (accountingPeriod.contains("\\n")) {
      val expectedText = accountingPeriod.split("\\\\n")
      for (h <- expectedText)
        CheckYourAnswersPage.verifyAccountingPeriodValue(h)
    } else {
      CheckYourAnswersPage.verifyAccountingPeriodValue(accountingPeriod)
    }

  // the user can validate profit as {string}
  def theUserCanValidateProfitAs(profit: String): Unit =
    CheckYourAnswersPage.verifyProfitValue(profit)

  // the user can see the run another calculation button enabled
  def theUserCanSeeTheRunAnotherCalculationButtonEnabled(): Unit =
    ResultPage.runAnotherCalculationIsEnabled()

  // the user clicks the run another calculation button
  def theUserClicksTheRunAnotherCalculationButton(): Unit =
    ResultPage.clickRunAnotherCalculation()

  // the user can validate distributions included as {string}
  def theUserCanValidateDistributionsIncludedAs(distributions: String): Unit =
    CheckYourAnswersPage.verifyDistributionsValue(distributions)

  // the user can validate associated companies as {string}
  def theUserCanValidateAssociatedCompaniesAs(associatedCompanies: String): Unit =
    CheckYourAnswersPage.verifyNoOfAssociatedCompanies(associatedCompanies)

  // the user validates associated companies for the first part of financial year as {string}
  def theUserValidatesAssociatedCompaniesForTheFirstPartOfFinancialYearAs(ac: String): Unit =
    CheckYourAnswersPage.verifyAcForFirstPartofFinancialYear(ac)

  // the user validates associated companies for the second part of financial year as {string}
  def theUserValidatesAssociatedCompaniesForTheSecondPartOfFinancialYearAs(ac: String): Unit =
    CheckYourAnswersPage.verifyAcForSecondPartofFinancialYear(ac)

}
