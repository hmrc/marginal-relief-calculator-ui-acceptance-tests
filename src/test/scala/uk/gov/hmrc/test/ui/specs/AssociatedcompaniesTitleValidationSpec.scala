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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*

class AssociatedcompaniesTitleValidationSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()
  }

  Feature("Associated companies Title Message - Validations") {

    val cases    = Seq(
      ("01/05/2024", "31/12/2024", "50000", "Did your company have any active associated companies?"),
      (
        "01/01/2023",
        "31/12/2023",
        "50000",
        "Did your company have any active associated companies between 1 April 2023 and 31 December 2023?"
      )
    )
    val noAnswer = "no"

    cases.foreach { case (accountingStartDate, accountingEndDate, profitValue, message) =>
      Scenario(
        s"Enter associated companies for a portion of the accounting period [accountingStartDate=$accountingStartDate, accountingEndDate=$accountingEndDate, profitValue=$profitValue, message=$message]"
      ) {
        givenDefaultState()

        When(s"the accounting period start date is provided as $accountingStartDate")
        theAccountingPeriodStartDateIsProvidedAs(accountingStartDate)

        And(s"the accounting period end date is provided as $accountingEndDate")
        provideAccountingPeriodEndDate(accountingEndDate)

        And("the user clicks the continue button on the accounting period page")
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

        And(s"the profit is $profitValue")
        andTheProfitIs(profitValue)

        And("the user clicks continue button on taxable profit page")
        andTheUserClicksContinueButtonOnTaxableProfitPage()

        And(s"the user selects option $noAnswer for the question Did your company receive any distributions?")
        andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions(noAnswer)

        And("the user clicks the continue button on the distributions page")
        andTheUserClicksTheContinueButtonOnTheDistributionsPage()

        Then(s"display the $message on associated company")
        thenDisplayTheOnAssociatedCompany(message)
      }
    }
  }
}
