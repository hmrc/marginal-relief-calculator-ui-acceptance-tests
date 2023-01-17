/*
 * Copyright 2022 HM Revenue & Customs
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

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.mrc.{CheckYourAnswersPage, ResultPage}

class CheckYourAnswersStepDef extends BaseStepDef {
  Then("I am presented with change link next to the distribution amount") { () =>
    CheckYourAnswersPage.changeLinkForDistributions()
  }

  Then("""I can validate my distribution amount as {string}""") { (distributionsAmount: String) =>
    CheckYourAnswersPage.verifyDistributionsValue(distributionsAmount)
  }
  Then("I am presented with change link next to the accounting period dates") { () =>
    CheckYourAnswersPage.changeLinkForAccountingPeriod()
  }
  Then("I am presented with change link next to the company's profit") { () =>
    CheckYourAnswersPage.verifyChangeLinkForProfit()
  }
  Then("I am presented with change link next to the associated companies") { () =>
    CheckYourAnswersPage.verifyChangeLinkForAC()
  }
  Then("""I can validate my accounting period dates as {string}""") { (AccountingPeriod: String) =>
    CheckYourAnswersPage.verifyAccountingPeriodValue(AccountingPeriod)
  }
  Then("""I can validate my company profit as {string}""") { (profit: String) =>
    CheckYourAnswersPage.verifyProfitValue(profit)
  }
  Then("""I can validate the associated companies as {string}""") { (associatedCompanies: String) =>
    CheckYourAnswersPage.verifyNoOfAssociatedCompanies(associatedCompanies)
  }
  Then("I click on change link next to the distribution amount") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForDistributions()
  }
  Then("I click on change link next to the company's profit") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForProfit()
  }
  Then("I click on change link next to the accounting period dates") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForAccPeriod()
  }
  Then("I click on change link next to the associated companies") { () =>
    CheckYourAnswersPage.clickOnChangeLinkForAssociatedCompanies()
  }
  When("the user clicks on back button") { () =>
    eventually {
      CheckYourAnswersPage.clickBackLink()
    }
  }
  When("the user clicks on calculate marginal relief button on check you answers page") { () =>
    eventually {
      CheckYourAnswersPage.clickMRCButton()
    }
  }

  And("I can see calculate margin relief button enabled") { () =>
    CheckYourAnswersPage.verifyMRCButtonEnabled()
  }

  When("I can click on calculate margin relief button") { () =>
    CheckYourAnswersPage.clickMRCButton()
  }

  Then("""I can validate accounting period as {string}""") { (accountingPeriod: String) =>
    if (accountingPeriod.contains("\\n")) {
      val expectedText = accountingPeriod.split("\\\\n")
      for (h <- expectedText)
        CheckYourAnswersPage.verifyAccountingPeriodValue(h)
    } else {
      CheckYourAnswersPage.verifyAccountingPeriodValue(accountingPeriod)
    }
  }

  Then("""I can validate profit as {string}""") { (profit: String) =>
    CheckYourAnswersPage.verifyProfitValue(profit)
  }

  Then("I can see run another calculation button enabled") { () =>
    ResultPage.runAnotherCalculationIsEnabled()
  }

  Then("I click on run another calculation button") { () =>
    ResultPage.clickRunAnotherCalculation()
  }

  Then("""I can validate distributions included as {string}""") { (distributions: String) =>
    CheckYourAnswersPage.verifyDistributionsValue(distributions)
  }

  Then("""I can validate associated companies as {string}""") { (associatedCompanies: String) =>
    CheckYourAnswersPage.verifyNoOfAssociatedCompanies(associatedCompanies)
  }

  Then("""I can validate associated companies for first part of financial year as {string}""") { (ac: String) =>
    CheckYourAnswersPage.verifyAcForFirstPartofFinancialYear(ac)
  }

  Then("""I can validate associated companies for second part of financial year as {string}""") { (ac: String) =>
    CheckYourAnswersPage.verifyAcForSecondPartofFinancialYear(ac)
  }
}
