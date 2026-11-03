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

  val nino = "NM772208B"

  Feature("SA1 Self Assessment Application Form") {
    Scenario("Organisation submits SA1 form") {
      Given("User enters login using the Authority Wizard page with confidence level above 250")
      AuthWizard.login(nino, "250", "Organisation")
      When("User navigates to Start details page")
      StartPage.verifyPageTitle(StartPage.pageTitle)
      Then("User begins to Register for Self Assessment")
      StartPage.startNow()

      And("User enters first and last name")
      Name.verifyPageTitle(Name.pageTitle)
      Name.submitName("John", "Doe")

      Then("User has a previous last name")
      AddPreviousLastName.verifyPageTitle(AddPreviousLastName.pageTitle)
      AddPreviousLastName.continueAsYes()

      And("User enters previous last name and date of when last name was changed")
      PreviousLastName.verifyPageTitle(PreviousLastName.pageTitle)
      PreviousLastName.submitPreviousLastName("LastName")
      PreviousLastName.submitDate()
      PreviousLastName.clickContinueButton()

      Then("User enters date of birth")
      DateOfBirth.verifyPageTitle(DateOfBirth.pageTitle)
      DateOfBirth.submitDoB()
      DateOfBirth.clickContinueButton()

      And("User enters contact details")
      ContactDetails.verifyPageTitle(ContactDetails.pageTitle)
      ContactDetails.submitEmailAddress("user.test@digital.hmrc.co.uk")
      ContactDetails.submitPhoneNumber("+77421384211")
      ContactDetails.clickContinueButton()

      Then("User enters an address")
      SelectCountry.verifyPageTitle(SelectCountry.pageTitle)
      SelectCountry.submitCountry("United Kingdom")
      SearchAddress.verifyPageTitle(SearchAddress.pageTitle)
      SearchAddress.chooseManualAddress()
      EnterAddress.verifyPageTitle(EnterAddress.pageTitle)
      EnterAddress.enterManualAddress(
        "25 Oakley Road",
        "Flat 69",
        "Lane 4",
        "City of Test",
        "Z11 1ZZ"
      )
      ReviewAddress.confirmAddress()

      And("User enters date of when they moved to their address")
      AddressMoveDate.verifyPageTitle(AddressMoveDate.pageTitle)

      Then("User has a National Insurance Number")
      AddNino.verifyPageTitle(AddNino.pageTitle)
      AddNino.continueAsYes()

      And("User inputs a National Insurance Number")
      Nino.verifyPageTitle(AddNino.pageTitle)
      Nino.submitNino(nino)

      And("User provides reasons they need to complete a tax return")
      TaxReturnReasons.verifyPageTitle(TaxReturnReasons.pageTitle)
      TaxReturnReasons.selectAllCheckboxes()
      TaxReturnReasons.clickContinueButton()

      Then("User enters date of when they get untaxed income as a director")
      DateUntaxedIncomeDirector.verifyPageTitle(DateUntaxedIncomeDirector.pageTitle)
      DateUntaxedIncomeDirector.submitDate()

      And("User enters date of when they start getting income from land and property in the UK")
      DateLandProperty.verifyPageTitle(DateLandProperty.pageTitle)
      DateLandProperty.submitDate()

      And("User enters date of when they start getting taxable foreign income")
      DateTaxableForeignIncome.verifyPageTitle(DateTaxableForeignIncome.pageTitle)
      DateTaxableForeignIncome.submitDate()

      And("User enters date of when they started getting income from a trust or settlement")
      DateTrustSettlement.verifyPageTitle(DateTrustSettlement.pageTitle)
      DateTrustSettlement.submitDate()

      And("User enters date of when their income first exceeded the threshold")
      DateAnnualIncome.verifyPageTitle(DateAnnualIncome.pageTitle)
      DateAnnualIncome.submitDate()

      And("User enters date of when they started getting untaxed income which was not collected through PAYE tax code")
      DateUntaxedIncomePAYE.verifyPageTitle(DateUntaxedIncomePAYE.pageTitle)
      DateUntaxedIncomePAYE.submitDate()

      And("User enters date of when they start getting High income child benefit charge foreign income")
      DateHighIncomeChildBenefit.verifyPageTitle(DateHighIncomeChildBenefit.pageTitle)
      DateHighIncomeChildBenefit.submitDate()

      And("User enters the last date of the tax year in which they owe Capital Gains Tax")
      DateCapitalGainsTax.verifyPageTitle(DateCapitalGainsTax.pageTitle)
      DateCapitalGainsTax.submitDate()

      And("User enters any other reason for the need to complete a tax return")
      OtherReason.verifyPageTitle(OtherReason.pageTitle)
      OtherReason.inputOtherReason("This is the reason to complete a tax return.")
      OtherReason.submitDate()

      Then("User checks their answers before submitting the application")
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)
      CheckYourAnswers.clickContinueButton()

      And("User declares that the information provided is correct")
      Declaration.verifyPageTitle(Declaration.pageTitle)
      Declaration.submitDeclaration("Test User")

      Then("User confirms the application is submitted")
      Confirmation.verifyPageTitle(Confirmation.pageTitle)
      //Click Back to account link
    }

    Scenario("Organisation submits SA1 form without National Insurance Number") {
      //      Then("User does not have a National Insurance Number")
      //      Then("User provide reason why they do not have a National Insurance Number")
    }
  }
}