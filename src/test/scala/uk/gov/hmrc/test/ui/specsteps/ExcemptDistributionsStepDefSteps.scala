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

import uk.gov.hmrc.test.ui.pages.mrc.ExcemptDistrubutionsPage

object ExcemptDistributionsStepDefSteps {

  // the user selects option {string} for the question Did your company receive any distributions?
  def andTheUserSelectsOptionForTheQuestionDidYourCompanyReceiveAnyDistributions(option: String): Unit =
    if (option.equalsIgnoreCase("yes")) {
      ExcemptDistrubutionsPage.selectOptionYes()
    } else {
      ExcemptDistrubutionsPage.selectOptionNo()
    }

  // the user selects option {string} for the question Do any distributions need to be included with your profits?
  def andTheUserSelectsOptionForTheQuestionDoAnyDistributionsNeedToBeIncludedWithYourProfits(option: String): Unit =
    if (option.equalsIgnoreCase("yes")) {
      ExcemptDistrubutionsPage.yesToIncludeInProfits()
    } else {
      ExcemptDistrubutionsPage.noToIncludeInProfits()
    }

  // the user is provided with an input field to provide distributions
  def thenTheUserIsProvidedWithAnInputFieldToProvideDistributions(): Unit =
    ExcemptDistrubutionsPage.displayDistributions()

  // the user provides {string} as distributions
  def andTheUserProvidesAsDistributions(distributions: String): Unit =
    ExcemptDistrubutionsPage.provideDistributions(distributions)

  // the user clicks the continue button on the distributions page
  def andTheUserClicksTheContinueButtonOnTheDistributionsPage(): Unit =
    ExcemptDistrubutionsPage.submitPage()

  // the user is navigated to the exempt distributions page
  def thenTheUserIsNavigatedToTheExemptDistributionsPage(): Unit =
    ExcemptDistrubutionsPage.verifyTitle()

  // the user is navigated to the Second exempt distributions page
  def thenTheUserIsNavigatedToTheSecondExemptDistributionsPage(): Unit =
    ExcemptDistrubutionsPage.verifySecondPageTitle()

  // the user changes the distributions value to {string}
  def thenTheUserChangesTheDistributionsValueTo(distributions: String): Unit =
    ExcemptDistrubutionsPage.provideDistributions(distributions)

  // the user can see the options yes, no are not selected
  def thenTheUserCanSeeTheOptionsYesNoAreNotSelected(): Unit =
    ExcemptDistrubutionsPage.verifyYesNoNotSelected()

  // the user can see the options yes,no are not selected on the Second exempt distributions page
  def thenTheUserCanSeeTheOptionsYesnoAreNotSelectedOnTheSecondExemptDistributionsPage(): Unit =
    ExcemptDistrubutionsPage.verifyYesNoNotSelectedForIncludeInProfits()

}
