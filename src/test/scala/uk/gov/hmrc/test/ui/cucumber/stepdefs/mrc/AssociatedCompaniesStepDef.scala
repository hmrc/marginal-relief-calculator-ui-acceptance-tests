/*
 * Copyright 2023 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.mrc.AssociatedCompaniesPage.titleMessage
import uk.gov.hmrc.test.ui.pages.mrc.{AssociatedCompaniesPage, CheckYourAnswersPage}

class AssociatedCompaniesStepDef extends BaseStepDef {
  Then("""display the {string} on associated company""") { (message: String) =>
    titleMessage should be(message)
  }
  Then("user is landed on associated companies page") { () =>
    AssociatedCompaniesPage.verifyPageTitle()
  }

  Then("""I validate associated companies is pre-populated as {string}""") { (associatedCo: String) =>
    AssociatedCompaniesPage.verifyAssociatedCompanies(associatedCo)
  }
  And("user can see the options yes and No as not selected") { () =>
    AssociatedCompaniesPage.verifyYesAndNoOptionsPresent()
    AssociatedCompaniesPage.verifyYesAndNoOptionsNotSelected()
  }

  When("""the user selects option {string} for the question Did your company have any active associated companies?""") {
    (option: String) =>
      if (option.equalsIgnoreCase("yes")) {
        AssociatedCompaniesPage.selectOptionYes()
      } else {
        AssociatedCompaniesPage.selectOptionNo()
      }
  }

  And("user is presented with input field for associated companies") { () =>
    AssociatedCompaniesPage.isAssociatedCompaniesCountInputDisplayed
  }

  And("""user inputs a valid number as {string} associated companies""") { (associatedCo: String) =>
    AssociatedCompaniesPage.inputAssociatedCompanies(associatedCo)
  }

  Then("the user clicks continue button on associated companies page") { () =>
    AssociatedCompaniesPage.clickOnContinue()
  }

  Then("user is presented with Check Your Answers page") { () =>
    CheckYourAnswersPage.verifyPageTitle()
  }

  And("user is presented with input field for associated companies with value as null") { () =>
    AssociatedCompaniesPage.associatedCompaniesCountAsNull()
  }
  And("the user click on What are associated companies?") { () =>
    AssociatedCompaniesPage.clickOnQuestion()
  }

  And("""the user inputs {string} as associated companies for first part of accounting period""") { (noOfAc: String) =>
    AssociatedCompaniesPage.inputAcForFirstPartOfFinancialYear(noOfAc)
  }

  And("""the user inputs {string} as associated companies for second part of accounting period""") { (noOfAc: String) =>
    AssociatedCompaniesPage.inputAcForSecondPartOfFinancialYear(noOfAc)
  }
}
