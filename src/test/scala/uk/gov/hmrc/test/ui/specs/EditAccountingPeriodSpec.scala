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

import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*

class EditAccountingPeriodSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()

    When("""the accounting period start date is provided as "01/04/2023"""")
    theAccountingPeriodStartDateIsProvidedAs("01/04/2023")

    Then("the user clicks the continue button on the accounting period page")
    andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

    And("""the profit is "50000"""")
    andTheProfitIs("50000")

    Then("the user clicks continue button on taxable profit page")
    andTheUserClicksContinueButtonOnTaxableProfitPage()

    And("""the user selects option "Yes" for the question Did your company receive any distributions?""")
    andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("Yes")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    And(
      """the user selects option "Yes" for the question Do any distributions need to be included with your profits?"""
    )
    andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("Yes")

    Then("the user is provided with an input field to provide distributions")
    thenTheUserIsProvidedWithAnInputFieldToProvideDistributions()

    And("""the user provides "£50,000" as distributions""")
    andTheUserProvidesAsDistributions("£50,000")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    Then("the user lands on the associated companies page")
    thenTheUserLandsOnTheAssociatedCompaniesPage()

    When("""the user selects option "yes" for the question Did your company have any active associated companies?""")
    theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

    Then("the user is presented with an input field for associated companies")
    andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies()

    And("""the user inputs a valid number as "10" associated companies""")
    andTheUserInputsAValidNumberAsAssociatedCompanies("10")

    Then("the user clicks the continue button on the associated companies page")
    thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

    Then("the user is presented with the Check Your Answers page")
    thenTheUserIsPresentedWithTheCheckYourAnswersPage()
  }

  Feature("Edit Accounting Period - Validations") {

    Scenario("Edit Accounting Period") {
      givenDefaultState()

      Then("the user is presented with a change link next to the accounting period dates")
      theUserIsPresentedWithAChangeLinkNextToTheAccountingPeriodDates()

      And(s"the user can validate their accounting period dates as 1 April 2023 to 31 March 2024")
      theUserCanValidateTheirAccountingPeriodDatesAs("1 April 2023 to 31 March 2024")

      When("the user clicks the change link next to the accounting period dates")
      theUserClicksTheChangeLinkNextToTheAccountingPeriodDates()

      Then("the user is navigated to the accounting period page")
      theUserLandsOnTheAccountingPeriodPage()

      Then(s"the user can see the accounting end period as 31/03/2024")
      theUserCanSeeTheAccountingEnd("31/03/2024")

      When(s"the accounting period start date is provided as 01/01/2023")
      theAccountingPeriodStartDateIsProvidedAs("01/01/2023")

      And(s"the accounting period end date is provided as 31/12/2023")
      provideAccountingPeriodEndDate("31/12/2023")

      Then("the user clicks the continue button on the accounting period page")
      andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      And(s"the user can validate their accounting period dates as 1 January 2023 to 31 December 2023")
      theUserCanValidateTheirAccountingPeriodDatesAs("1 January 2023 to 31 December 2023")

    }
  }
}
