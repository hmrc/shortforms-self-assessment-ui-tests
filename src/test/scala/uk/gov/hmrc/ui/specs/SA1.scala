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

package uk.gov.hmrc.ui.specs

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.*

class SA1
  extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Short forms start page Journeys") {
    Scenario("Open start page with confidence level above 250") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login("NM772208B", "250", "Organisation")
      When("User navigates to Start details page")
      StartPage.verifyPageTitle(StartPage.pageTitle)

      Then("User begins to Register for Self Assessment")
      StartPage.startNow()

      And("User enters first and last name")
      Name.verifyPageTitle(Name.pageTitle)
      Name.submitName("John", "Doe")

      Then("User has a previous last name")
//      AuthWizard.navigateToPage(s"$localurlstub/previous-last-name"
//      )

      AddPreviousLastName.verifyPageTitle(AddPreviousLastName.pageTitle)
      AddPreviousLastName.continueAsYes()

      And("User enters previous last name and date of when last name was changed")
      PreviousLastName.verifyPageTitle(PreviousLastName.pageTitle)
      PreviousLastName.submitPreviousLastName("LastName")
      PreviousLastName.submitDate()

      Then("User enters date of birth")
      DateOfBirth.verifyPageTitle(DateOfBirth.pageTitle)
      DateOfBirth.submitDate()

      And("User enters contact details")
      ContactDetails.verifyPageTitle(ContactDetails.pageTitle)

      //      Then("User searches for address")
      //      And("User finds address")
      //      And("User enters address")
      //      Then("User reviews address")
      //      And("User enters date of when they moved to their address")
      //      Then("User has a National Insurance Number")
      //      Then("User does not have a National Insurance Number")
      //      And("User provides reasons they need to complete a tax return")
      //      Then("User enters date of when they get untaxed income as a director")
      //      And("User enters date of when they start getting taxable foreign income")
      //      And("User enters date of when they start getting income from land and property in the UK")
      //      And("User enters date of when they start getting High income child benefit charge foreign income")
      //      And("User enters date of when their income first exceeded the threshold")
      //      And("User enters date of when they started getting untaxed income which was not collected through PAYE tax code")
      //      And("User enters date of when they started getting income from a trust or settlement")
      //      And("User enters the last date of the tax year in which they owe Capital Gains Tax")
      //      And("User enters any other reason for the need to complete a tax return")
      //      Then("User checks their answers before submitting the application")
      //      And("User declares that the information provided is correct")
    }
  }
}
