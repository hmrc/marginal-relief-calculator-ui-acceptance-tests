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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages.mrc.AccountingPeriodPage.verifyLinkText
import uk.gov.hmrc.test.ui.pages.mrc.BeforeYouStartPage

import java.time.Duration

object BeforeYouStartStepDefSteps {

  // Marginal Relief Calculator is launched
  def givenMarginalReliefCalculatorIsLaunched(): Unit =
    BeforeYouStartPage.loadPage()

  // the user lands on the before you start page
  def thenTheUserLandsOnTheBeforeYouStartPage(): Unit =
    BeforeYouStartPage.verifyTitle()

  // the user can see the breadcrumbs on the page
  def andTheUserCanSeeTheBreadcrumbsOnThePage(): Unit =
    BeforeYouStartPage.verifyBreadcrumbs()

  // the user can verify that Welsh language is not displayed
  def andTheUserCanVerifyThatWelshLanguageIsNotDisplayed(): Unit =
    BeforeYouStartPage.verifyWelshLanguageLink()

  // Overload for ScalaTest (no DataTable, accepts varargs)
  def theUserCanVerifyTheLinkPresentOnScreen(links: (String, String)*): Unit =
    links.foreach { case (text, url) =>
      val driverWait: WebDriverWait =
        new WebDriverWait(Driver.instance, Duration.ofSeconds(10), Duration.ofSeconds(1))
      driverWait.until(
        ExpectedConditions.elementToBeClickable(
          Driver.instance.findElement(By.id(url))
        )
      )
      verifyLinkText(text)
    }

  // the user clicks the start now button
  def andTheUserClicksTheStartNowButton(): Unit =
    BeforeYouStartPage.clickOnStartNowButton()

}
