/*
 * Copyright 2024 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.mrc.{CheckYourAnswersPage, ResultPage}

class CheckYourAnswersStepDef extends BaseStepDef {
  Then("the user is presented with change link next to the distribution amount") { () =>
    CheckYourAnswersPage.changeLinkForDistributions()
  }

  Then("""the user can validate their distribution amount as {string}""") { (distributionsAmount: String) =>
    CheckYourAnswersPage.verifyDistributionsValue(distributionsAmount)
  }
  Then("the user is presented with a change link next to the accounting period dates") { () =>
    CheckYourAnswersPage.changeLinkForAccountingPeriod()
  }
  Then("the user is presented with a change link next to the company's profit") { () =>
    CheckYourAnswersPage.verifyChangeLinkForProfit()
  }
  Then("the user is presented with a change link next to the associated companies") { () =>
    CheckYourAnswersPage.verifyChangeLinkForAC()
  }
  Then("""the user can validate their accounting period dates as {string}""") { (AccountingPeriod: String) =>
    CheckYourAnswersPage.verifyAccountingPeriodValue(AccountingPeriod)
  }
  Then("""the user can validate their company profit as {string}""") { (profit: String) =>
    CheckYourAnswersPage.verifyProfitValue(profit)
  }
  Then("""the user can validate the associated companies as {string}""") { (associatedCompanies: String) =>
    CheckYourAnswersPage.verifyNoOfAssociatedCompanies(associatedCompanies)
  }
  Then("the user clicks the change link next to the distribution amount") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForDistributions()
  }
  Then("the user clicks the change link next to the company's profit") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForProfit()
  }
  Then("the user clicks the change link next to the accounting period dates") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForAccPeriod()
  }
  Then("the user clicks the change link next to the associated companies") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForAssociatedCompanies()
  }
  When("the user clicks the back button") { () =>
    eventually {
      CheckYourAnswersPage.clickBackLink()
    }
  }
  When("the user clicks the calculate marginal relief button on the check your answers page") { () =>
    eventually {
      CheckYourAnswersPage.clickMRCButton()
    }
  }

  And("the user can see the calculate margin relief button enabled") { () =>
    CheckYourAnswersPage.verifyMRCButtonEnabled()
  }

  When("the user can click on the calculate margin relief button") { () =>
    CheckYourAnswersPage.clickMRCButton()
  }

  Then("""the user can validate the accounting period as {string}""") { (accountingPeriod: String) =>
    if (accountingPeriod.contains("\\n")) {
      val expectedText = accountingPeriod.split("\\\\n")
      for (h <- expectedText)
        CheckYourAnswersPage.verifyAccountingPeriodValue(h)
    } else {
      CheckYourAnswersPage.verifyAccountingPeriodValue(accountingPeriod)
    }
  }

  Then("""the user can validate profit as {string}""") { (profit: String) =>
    CheckYourAnswersPage.verifyProfitValue(profit)
  }

  Then("the user can see the run another calculation button enabled") { () =>
    ResultPage.runAnotherCalculationIsEnabled()
  }

  Then("the user clicks the run another calculation button") { () =>
    ResultPage.clickRunAnotherCalculation()
  }

  Then("""the user can validate distributions included as {string}""") { (distributions: String) =>
    CheckYourAnswersPage.verifyDistributionsValue(distributions)
  }

  Then("""the user can validate associated companies as {string}""") { (associatedCompanies: String) =>
    CheckYourAnswersPage.verifyNoOfAssociatedCompanies(associatedCompanies)
  }

  Then("""the user validates associated companies for the first part of financial year as {string}""") { (ac: String) =>
    CheckYourAnswersPage.verifyAcForFirstPartofFinancialYear(ac)
  }

  Then("""the user validates associated companies for the second part of financial year as {string}""") { (ac: String) =>
    CheckYourAnswersPage.verifyAcForSecondPartofFinancialYear(ac)
  }
}
