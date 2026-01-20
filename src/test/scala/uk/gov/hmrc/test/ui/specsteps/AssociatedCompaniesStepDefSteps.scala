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

import uk.gov.hmrc.test.ui.pages.mrc.AssociatedCompaniesPage.titleMessage
import uk.gov.hmrc.test.ui.pages.mrc.{AssociatedCompaniesPage, CheckYourAnswersPage}
import org.scalatest.matchers.should.Matchers._

object AssociatedCompaniesStepDefSteps {

  // display the {string} on associated company
  def thenDisplayTheOnAssociatedCompany(message: String): Unit =
    titleMessage() shouldBe message

  // the user lands on the associated companies page
  def thenTheUserLandsOnTheAssociatedCompaniesPage(): Unit =
    AssociatedCompaniesPage.validatePageTitle()

  // the user validates associated companies are pre-populated as {string}
  def thenTheUserValidatesAssociatedCompaniesArePrepopulatedAs(associatedCo: String): Unit =
    AssociatedCompaniesPage.verifyAssociatedCompanies(associatedCo)

  // the user can see the options yes and No as not selected
  def andTheUserCanSeeTheOptionsYesAndNoAsNotSelected(): Unit = {
    AssociatedCompaniesPage.verifyYesAndNoOptionsPresent()
    AssociatedCompaniesPage.verifyYesAndNoOptionsNotSelected()
  }

  // the user selects option {string} for the question Did your company have any active associated companies?
  def theUserSelectsOptionForTheQuestionDidYourCompanyHaveAnyActiveAssociatedCompanies(option: String): Unit =
    if (option.equalsIgnoreCase("yes")) {
      AssociatedCompaniesPage.selectOptionYes()
    } else {
      AssociatedCompaniesPage.selectOptionNo()
    }

  // the user is presented with an input field for associated companies
  def andTheUserIsPresentedWithAnInputFieldForAssociatedCompanies(): Unit =
    AssociatedCompaniesPage.isAssociatedCompaniesCountInputDisplayed

  // the user inputs a valid number as {string} associated companies
  def andTheUserInputsAValidNumberAsAssociatedCompanies(associatedCo: String): Unit =
    AssociatedCompaniesPage.inputAssociatedCompanies(associatedCo)

  // the user clicks the continue button on the associated companies page
  def thenTheUserClicksTheContinueButtonOnTheAssociatedCompaniesPage(): Unit =
    AssociatedCompaniesPage.clickOnContinue()

  // the user is presented with the Check Your Answers page
  def thenTheUserIsPresentedWithTheCheckYourAnswersPage(): Unit =
    CheckYourAnswersPage.verifyPageTitle()

  // the user is presented with an input field for associated companies with the value as null
  def andTheUserIsPresentedWithAnInputFieldForAssociatedCompaniesWithTheValueAsNull(): Unit =
    AssociatedCompaniesPage.associatedCompaniesCountAsNull()

  // the user clicks on What are associated companies?
  def andTheUserClicksOnWhatAreAssociatedCompanies(): Unit =
    AssociatedCompaniesPage.clickOnQuestion()

  // the user inputs {string} associated companies for the first part of accounting period
  def andTheUserInputsAssociatedCompaniesForTheFirstPartOfAccountingPeriod(noOfAc: String): Unit =
    AssociatedCompaniesPage.inputAcForFirstPartOfFinancialYear(noOfAc)

  // the user inputs {string} associated companies for the second part of accounting period
  def andTheUserInputsAssociatedCompaniesForTheSecondPartOfAccountingPeriod(noOfAc: String): Unit =
    AssociatedCompaniesPage.inputAcForSecondPartOfFinancialYear(noOfAc)

}
