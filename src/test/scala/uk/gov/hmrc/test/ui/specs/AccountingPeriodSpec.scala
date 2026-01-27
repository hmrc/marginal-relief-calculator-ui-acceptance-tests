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

import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.theUserClicksTheBackButton
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BaseSpec

class AccountingPeriodSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()
  }

  val cases = Seq(
    ("29/02/2024", "27/2/2025"),
    ("01/03/2025", "28/2/2026"),
    ("08/09/2022", "7/9/2023")
  )

  Feature("Accounting Period - Validations") {

    cases.foreach { case (startDate, expectedEndDate) =>
      Scenario(
        s"Auto generated accounting end date when accounting end date is not provided [startDate=$startDate, endDate=$expectedEndDate]"
      ) {
        givenDefaultState()

        When(s"the accounting period start date is provided as $startDate")
        theAccountingPeriodStartDateIsProvidedAs(startDate)

        And("the user clicks the continue button on the accounting period page")
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

        And("the user clicks the back button")
        theUserClicksTheBackButton()

        Then(s"the accounting end date should be $expectedEndDate")
        theUserCanSeeTheAccountingEnd(expectedEndDate)
      }
    }

    val accountingDate = Seq(
      ("01/04/2022", "31/03/2023"),
      ("01/10/2022", "28/02/2023")
    )

    accountingDate.foreach { case (startDate, expectedEndDate) =>
      Scenario(
        s"Marginal Relief not relevant for accounting period [accountingStartDate=$startDate, accountingEndDate=$expectedEndDate]"
      ) {
        givenDefaultState()

        When(s"the accounting period start date is provided as $startDate")
        theAccountingPeriodStartDateIsProvidedAs(startDate)

        And(s"the accounting period end date is provided as $expectedEndDate")
        provideAccountingPeriodEndDate(expectedEndDate)

        And("the user clicks the continue button on the accounting period page")
        andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

        Then("the user is shown the ineligible accounting period page")
        thenTheUserIsShownTheIneligibleAccountingPeriodPage()
      }
    }

    Scenario(s"Marginal Relief not relevant for accounting period") {
      givenDefaultState()

      When("the accounting period start date is provided as 01/04/2022")
      theAccountingPeriodStartDateIsProvidedAs("01/04/2022")

      And("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      Then("the user is shown the ineligible accounting period page")
      thenTheUserIsShownTheIneligibleAccountingPeriodPage()

    }

    val accountingPeriodContent        =
      "Your accounting period cannot be longer than a full year and is normally the same as the financial year covered by your company's annual accounts."
    val accountingPeriodEndDateContent = "If you do not enter a date we will default to a full year from the start date"
    Scenario("Accounting period-Content change") {
      givenDefaultState()

      When(s"the user reads content on accounting period as $accountingPeriodContent")
      thenUserReadsContentOnAccounting(accountingPeriodContent)

      Then(s"the user reads content on accounting end date as $accountingPeriodEndDateContent")
      thenTheUserReadsContentOnAccountingEndDate(accountingPeriodEndDateContent)
    }
  }
}
