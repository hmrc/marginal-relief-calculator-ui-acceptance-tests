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

import uk.gov.hmrc.test.ui.specsteps.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.ExcemptDistributionsStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AccountingPeriodStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.TaxableProfitStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.BeforeYouStartStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.AssociatedCompaniesStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.PreviewSummaryStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.DetailedCalculationStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.CheckYourAnswersStepDefSteps.*
import uk.gov.hmrc.test.ui.specsteps.ResultsStepDefSteps.*
import org.scalatest.Ignore

@Ignore
class FutureScenariosSpec extends BaseSpec {

  def givenDefaultState(): Unit = {
    Given("Marginal Relief Calculator is launched")
    givenMarginalReliefCalculatorIsLaunched()

    When("the user clicks the start now button")
    andTheUserClicksTheStartNowButton()

    Then("the user lands on the accounting period page")
    theUserLandsOnTheAccountingPeriodPage()

    When("""the accounting period start date is provided as "01/01/2027""")
    theAccountingPeriodStartDateIsProvidedAs("01/01/2027")

    And("the accounting period end date is provided as 31/12/2027")
    provideAccountingPeriodEndDate("31/12/2027")

    Then("the user clicks the continue button on the accounting period page")
    andTheUserClicksTheContinueButtonOnTheAccountingPeriodPage()

    And("""the profit is "50000"""")
    andTheProfitIs("50000")

    Then("the user clicks continue button on taxable profit page")
    andTheUserClicksContinueButtonOnTaxableProfitPage()

    And("""the user selects option "yes" for the question Did your company receive any distributions?""")
    andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions("yes")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    And("the user selects option Yes for the question Do any distributions need to be included with your profits?")
    andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits("Yes")

    And("""the user provides "£2000" as distributions""")
    andTheUserProvidesAsDistributions("£2000")

    And("the user clicks the continue button on the distributions page")
    andTheUserClicksTheContinueButtonOnTheDistributionsPage()

    Then("the user lands on the associated companies page")
    thenTheUserLandsOnTheAssociatedCompaniesPage()

    And("""display the "Did your company have any active associated companies?" on associated company""")
    thenDisplayTheOnAssociatedCompany("Did your company have any active associated companies?")

    When("""the user selects option "yes" for the question Did your company have any active associated companies?""")
    theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies("yes")

    Then("the user clicks the continue button on the associated companies page")
    thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

    And("""display the "How many active associated companies did you have?" on associated company""")
    thenDisplayTheOnAssociatedCompany("How many active associated companies did you have?")

  }

  Feature("2 Associated companies - Validations on different pages") {

    Scenario("Verify 2 associated companies on check your answers page") {
      givenDefaultState()

      When(s"the user inputs 2 associated companies for the first part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheFirstPartOfAccountingPeriod("2")

      When(s"the user inputs 3 associated companies for the second part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheSecondPartOfAccountingPeriod("3")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then(s"the user validates associated companies for the first part of financial year as 2")
      theUserValidatesAssociatedCompaniesForTheFirstPartOfFinancialYearAs("2")

      Then(s"the user validates associated companies for the second part of financial year as 3")
      theUserValidatesAssociatedCompaniesForTheSecondPartOfFinancialYearAs("3")
    }

    Scenario("Verify 2 associated companies on results page") {
      givenDefaultState()

      When(s"the user inputs 1 associated companies for the first part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheFirstPartOfAccountingPeriod("1")

      When(s"the user inputs 3 associated companies for the second part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheSecondPartOfAccountingPeriod("3")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then(s"the user validates associated companies for the first part of financial year as 2026 to 2027: 1")
      theUserValidatesAssociatedCompaniesForTheFirstPartOfFinancialYearAs("2026 to 2027: 1")

      Then(s"the user validates associated companies for the second part of financial year as 2027 to 2028: 3")
      andTheUserInputsAssociatedCompaniesForTheSecondPartOfAccountingPeriod("2027 to 2028: 3")

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then(s"display the green box of type £612.07")
      thenDisplayTheGreenBoxOfType("£612.07")

      And(s"the user validates the associated companies on the results page as 2026 to 2027: 1")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2026 to 2027: 1")

      And(s"the user validates the associated companies on the results page as 2027 to 2028: 3")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2027 to 2028: 3")
    }

    Scenario("Verify 2 associated companies on detailed calculation page") {
      givenDefaultState()

      When(s"the user inputs 1 associated companies for the first part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheFirstPartOfAccountingPeriod("1")

      When(s"the user inputs 3 associated companies for the second part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheFirstPartOfAccountingPeriod("3")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then(s"the user validates associated companies for the first part of financial year as 1")
      theUserValidatesAssociatedCompaniesForTheFirstPartOfFinancialYearAs("1")

      Then(s"the user validates associated companies for the second part of financial year as 3")
      theUserValidatesAssociatedCompaniesForTheSecondPartOfFinancialYearAs("3")

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then(s"display the green box of type £612.07")
      thenDisplayTheGreenBoxOfType("£612.07")

      And(s"the user validates the associated companies on the results page as 2026 to 2027: 1")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2026 to 2027: 1")

      And(s"the user validates the associated companies on the results page as 2027 to 2028: 3")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2027 to 2028: 3")

      And("the Check Marginal Relief calculation in detail link is displayed")
      andTheCheckMarginalReliefCalculationInDetailLinkIsDisplayed()

      When("the user clicks the Check Marginal Relief calculation in detail link")
      andTheUserClicksTheCheckMarginalReliefCalculationInDetailLink()

      Then(s"the user validates the associated companies on the detailed calculation page as 2026 to 2027: 1")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2026 to 2027: 1")

      And(s"the user validates the associated companies on the detailed calculation page as 2027 to 2028: 3")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2027 to 2028: 3")
    }

    Scenario("Verify 2 associated companies on PDF page") {
      givenDefaultState()

      When(s"the user inputs 1 associated companies for the first part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheFirstPartOfAccountingPeriod("1")

      When(s"the user inputs 3 associated companies for the second part of accounting period")
      andTheUserInputsAssociatedCompaniesForTheSecondPartOfAccountingPeriod("3")

      Then("the user clicks the continue button on the associated companies page")
      thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage()

      Then("the user is presented with the Check Your Answers page")
      thenTheUserIsPresentedWithTheCheckYourAnswersPage()

      Then(s"the user validates associated companies for the first part of financial year as 1")
      theUserValidatesAssociatedCompaniesForTheFirstPartOfFinancialYearAs("1")

      Then(s"the user validates associated companies for the second part of financial year as 3")
      theUserValidatesAssociatedCompaniesForTheSecondPartOfFinancialYearAs("3")

      And("the user clicks the calculate marginal relief button on the check your answers page")
      theUserClicksTheCalculateMarginalReliefButtonOnTheCheckYourAnswersPage()

      Then(s"display the green box of type £612.07")
      And(s"the user validates the associated companies on the results page as 2026 to 2027: 1")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2026 to 2027: 1")

      And(s"the user validates the associated companies on the results page as 2027 to 2028: 3")
      thenTheUserValidatesTheAssociatedCompaniesOnTheResultsPageAs("2027 to 2028: 3")

      And("the user clicks the Get A Copy Of Results link")
      thenTheUserClicksTheGetACopyOfResultsLink()

      Then("the user is presented with add company details to your result page")
      thenTheUserIsPresentedWithAddCompanyDetailsToYourResultPage()

      And(s"the user selects option as No on add company details page")
      andTheUserSelectsOptionAsOnAddCompanyDetailsPage("No")

      Then(s"the user validates the associated companies on the PDF page as 2026 to 2027: 1")
      thenTheUserValidatesTheAssociatedCompaniesOnThePDFPageAs("2026 to 2027: 1")

      And(s"the user validates the associated companies on the PDF page as 2027 to 2028: 3")
      thenTheUserValidatesTheAssociatedCompaniesOnThePDFPageAs("2027 to 2028: 3")
    }
  }
}
