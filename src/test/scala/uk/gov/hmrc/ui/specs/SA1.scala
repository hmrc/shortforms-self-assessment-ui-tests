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

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.{CheckYourAnswers, *}

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
      AddPreviousLastName.continueAsNo()

      Then("User enters date of birth")
      DateOfBirth.verifyPageTitle(DateOfBirth.pageTitle)
      DateOfBirth.submitDoB()
      DateOfBirth.clickContinueButton()

      And("User enters contact details")
      ContactDetails.verifyPageTitle(ContactDetails.pageTitle)
      ContactDetails.submitEmailAddress("user.test@digital.hmrc.co.uk")
      ContactDetails.submitPhoneNumber("+77421384211")
      ContactDetails.clickContinueButton()

      // TODO - DEFECT - DTR-9970 - Incorrect Address Look Up Service Page Titles
      Then("User enters an address")
      // SelectCountry.verifyPageTitle(SelectCountry.pageTitle)
      SelectCountry.submitCountry("United Kingdom")
      // SearchAddress.verifyPageTitle(SearchAddress.pageTitle)
      SearchAddress.chooseManualAddress()
      // EnterAddress.verifyPageTitle(EnterAddress.pageTitle)
      EnterAddress.enterManualAddress(
        "25 Oakley Road",
        "Flat 69",
        "Lane 4",
        "City of Test",
        "Z11 1ZZ"
      )
      // ReviewAddress.verifyPageTitle(ReviewAddress.pageTitle)
      ReviewAddress.confirmAddress()

      And("User enters date of when they moved to their address")
      AddressMoveDate.verifyPageTitle(AddressMoveDate.pageTitle)
      AddressMoveDate.submitDate(AddressMoveDate.Locators.moveAddressDate)
      AddressMoveDate.clickContinueButton()

      Then("User has a National Insurance Number")
      AddNino.verifyPageTitle(AddNino.pageTitle)
      AddNino.continueAsNo()

      And("User provides reason to not having a National Insurance Number")
      NoNino.verifyPageTitle(NoNino.pageTitle)
      NoNino.inputOtherReason("This is the reason for User not having a NINO")
      NoNino.clickContinueButton()

      And("User provides reasons they need to complete a tax return")
      TaxReturnReasons.verifyPageTitle(TaxReturnReasons.pageTitle)
      TaxReturnReasons.unselectAllCheckboxes()
      TaxReturnReasons.selectTaxReturnReasons("Other Reason", true)
      TaxReturnReasons.clickContinueButton()

      And("User enters any other reason for the need to complete a tax return")
      OtherReason.verifyPageTitle(OtherReason.pageTitle)
      OtherReason.inputOtherReason("This is the reason to complete a tax return.")
      OtherReason.submitDate(OtherReason.Locators.dateOtherReason)
      OtherReason.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updates their first name")
      CheckYourAnswers.clickChangeLink("First Name")
      Name.verifyPageTitle(Name.pageTitle)
      Name.submitName("John Updated", "Doe")
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates their last name")
      CheckYourAnswers.clickChangeLink("Last Name")
      Name.verifyPageTitle(Name.pageTitle)
      Name.submitName("John Updated", "Doe Updated")
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User adds a previous last name")
      CheckYourAnswers.clickChangeLink("Check Previous Last Name")
      AddPreviousLastName.verifyPageTitle(AddPreviousLastName.pageTitle)
      AddPreviousLastName.continueAsYes()
      PreviousLastName.verifyPageTitle(PreviousLastName.pageTitle)
      PreviousLastName.submitPreviousLastName("Previous Last Name")
      PreviousLastName.submitDate(PreviousLastName.Locators.lastNameChangeDate)
      PreviousLastName.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates previous last name")
      CheckYourAnswers.clickChangeLink("Previous Last Name")
      PreviousLastName.verifyPageTitle(PreviousLastName.pageTitle)
      PreviousLastName.submitPreviousLastName("Previous LN Updated")
      PreviousLastName.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updates previous last name changed date")
      CheckYourAnswers.clickChangeLink("Previous Last Name Date")
      PreviousLastName.verifyPageTitle(PreviousLastName.pageTitle)
      PreviousLastName.submitDate(PreviousLastName.Locators.lastNameChangeDate)
      PreviousLastName.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates Date of Birth")
      CheckYourAnswers.clickChangeLink("Date of Birth")
      DateOfBirth.verifyPageTitle(DateOfBirth.pageTitle)
      DateOfBirth.submitDoB()
      DateOfBirth.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      // TODO - DEFECT - DTR-9970 - Incorrect Address Look Up Service Page Titles
      Then("User enters an address")
      CheckYourAnswers.clickChangeLink("Address")
      // SelectCountry.verifyPageTitle(SelectCountry.pageTitle)
      SelectCountry.submitCountry("United Kingdom")
      // SearchAddress.verifyPageTitle(SearchAddress.pageTitle)
      SearchAddress.chooseManualAddress()
      // EnterAddress.verifyPageTitle(EnterAddress.pageTitle)
      EnterAddress.enterManualAddress(
        "Updated Address 1",
        "Updated Address 2",
        "Updated Address 3",
        "Updated Test City",
        "Z11 1ZZ"
      )
      // ReviewAddress.verifyPageTitle(ReviewAddress.pageTitle)
      ReviewAddress.confirmAddress()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates date of when they moved to their address")
      CheckYourAnswers.clickChangeLink("Address Move Date")
      AddressMoveDate.verifyPageTitle(AddressMoveDate.pageTitle)
      AddressMoveDate.submitDate(AddressMoveDate.Locators.moveAddressDate)
      AddressMoveDate.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updates email address")
      CheckYourAnswers.clickChangeLink("Email Address")
      ContactDetails.verifyPageTitle(ContactDetails.pageTitle)
      ContactDetails.submitEmailAddress("user.test@digital.hmrc.co.uk")
      ContactDetails.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates phone number")
      CheckYourAnswers.clickChangeLink("Email Address")
      ContactDetails.verifyPageTitle(ContactDetails.pageTitle)
      ContactDetails.submitPhoneNumber("07123123123")
      ContactDetails.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updated reason for not having a National Insurance Number")
      CheckYourAnswers.clickChangeLink("National Insurance Number Reason")
      NoNino.verifyPageTitle(NoNino.pageTitle)
      NoNino.inputOtherReason("This is the updated reason for not having a NINO")
      NoNino.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User adds a National Insurance Number")
      CheckYourAnswers.clickChangeLink("Check National Insurance Number")
      AddNino.verifyPageTitle(AddNino.pageTitle)
      AddNino.continueAsYes()
      Nino.verifyPageTitle(Nino.pageTitle)
      Nino.submitNino(nino)
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates their National Insurance Number")
      CheckYourAnswers.clickChangeLink("National Insurance Number")
      Nino.verifyPageTitle(Nino.pageTitle)
      Nino.submitNino("NM772208 B")
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User user updates other reason date")
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)
      CheckYourAnswers.clickChangeLink("Other Reason Date")
      OtherReason.verifyPageTitle(OtherReason.pageTitle)
      OtherReason.submitDate(OtherReason.Locators.dateOtherReason)
      OtherReason.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User selects all reasons to complete a tax return")
      CheckYourAnswers.clickChangeLink("Other Reason")
      TaxReturnReasons.verifyPageTitle(TaxReturnReasons.pageTitle)
      TaxReturnReasons.unselectAllCheckboxes()
      TaxReturnReasons.selectAllCheckboxes()
      TaxReturnReasons.clickContinueButton()

      And("User enters date of when they get untaxed income as a director")
      DateUntaxedIncomeDirector.verifyPageTitle(DateUntaxedIncomeDirector.pageTitle)
      DateUntaxedIncomeDirector.submitDate(DateUntaxedIncomeDirector.Locators.dateUntaxedIncomeDirector)
      DateUntaxedIncomeDirector.clickContinueButton()

      Then("User enters date of when they start getting income from land and property in the UK")
      DateLandProperty.verifyPageTitle(DateLandProperty.pageTitle)
      DateLandProperty.submitDate(DateLandProperty.Locators.dateLandPropertyUk)
      DateLandProperty.clickContinueButton()

      And("User enters date of when they start getting taxable foreign income")
      DateTaxableForeignIncome.verifyPageTitle(DateTaxableForeignIncome.pageTitle)
      DateTaxableForeignIncome.submitDate(DateTaxableForeignIncome.Locators.dateTaxableForeignIncome)
      DateTaxableForeignIncome.clickContinueButton()

      Then("User enters date of when they started getting income from a trust or settlement")
      DateTrustSettlement.verifyPageTitle(DateTrustSettlement.pageTitle)
      DateTrustSettlement.submitDate(DateTrustSettlement.Locators.dateTrustSettlement)
      DateTrustSettlement.clickContinueButton()

      And("User enters date of when their income first exceeded the threshold")
      DateAnnualIncome.verifyPageTitle(DateAnnualIncome.pageTitle)
      DateAnnualIncome.submitDate(DateAnnualIncome.Locators.dateAnnualIncome)
      DateAnnualIncome.clickContinueButton()

      Then("User enters date of when they started getting untaxed income which was not collected through PAYE tax code")
      DateUntaxedIncomePAYE.verifyPageTitle(DateUntaxedIncomePAYE.pageTitle)
      DateUntaxedIncomePAYE.submitDate(DateUntaxedIncomePAYE.Locators.dateUntaxedIncomePAYE)
      DateUntaxedIncomePAYE.clickContinueButton()

      And("User enters date of when they start getting High income child benefit charge foreign income")
      DateHighIncomeChildBenefit.verifyPageTitle(DateHighIncomeChildBenefit.pageTitle)
      DateHighIncomeChildBenefit.submitDate(DateHighIncomeChildBenefit.Locators.dateHighIncomeChildBenefit)
      DateHighIncomeChildBenefit.clickContinueButton()

      Then("User enters the last date of the tax year in which they owe Capital Gains Tax")
      DateCapitalGainsTax.verifyPageTitle(DateCapitalGainsTax.pageTitle)
      DateCapitalGainsTax.submitDate(DateCapitalGainsTax.Locators.dateCapitalGainsTax)
      DateCapitalGainsTax.clickContinueButton()

      And("User checks their answers before submitting the application")
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updates date of when they get untaxed income as a director")
      CheckYourAnswers.clickChangeLink("Company Director Untaxed Earnings Date")
      DateUntaxedIncomeDirector.verifyPageTitle(DateUntaxedIncomeDirector.pageTitle)
      DateUntaxedIncomeDirector.submitDate(DateUntaxedIncomeDirector.Locators.dateUntaxedIncomeDirector)
      DateUntaxedIncomeDirector.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates date of when they start getting income from land and property in the UK")
      CheckYourAnswers.clickChangeLink("Land and Property Income Date")
      DateLandProperty.verifyPageTitle(DateLandProperty.pageTitle)
      DateLandProperty.submitDate(DateLandProperty.Locators.dateLandPropertyUk)
      DateLandProperty.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updates date of when they start getting taxable foreign income")
      CheckYourAnswers.clickChangeLink("Taxable Foreign Income or Dividends Date")
      DateTaxableForeignIncome.verifyPageTitle(DateTaxableForeignIncome.pageTitle)
      DateTaxableForeignIncome.submitDate(DateTaxableForeignIncome.Locators.dateTaxableForeignIncome)
      DateTaxableForeignIncome.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates date of when they started getting income from a trust or settlement")
      CheckYourAnswers.clickChangeLink("Trust or Settlement Income Date")
      DateTrustSettlement.verifyPageTitle(DateTrustSettlement.pageTitle)
      DateTrustSettlement.submitDate(DateTrustSettlement.Locators.dateTrustSettlement)
      DateTrustSettlement.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updates date of when their income first exceeded the threshold")
      CheckYourAnswers.clickChangeLink("Annual Income Exceeds Threshold Date")
      DateAnnualIncome.verifyPageTitle(DateAnnualIncome.pageTitle)
      DateAnnualIncome.submitDate(DateAnnualIncome.Locators.dateAnnualIncome)
      DateAnnualIncome.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates date of when they started getting untaxed income which was not collected through PAYE tax code")
      CheckYourAnswers.clickChangeLink("Untaxed Income not collected via PAYE Date")
      DateUntaxedIncomePAYE.verifyPageTitle(DateUntaxedIncomePAYE.pageTitle)
      DateUntaxedIncomePAYE.submitDate(DateUntaxedIncomePAYE.Locators.dateUntaxedIncomePAYE)
      DateUntaxedIncomePAYE.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      Then("User updates date of when they start getting High income child benefit charge foreign income")
      CheckYourAnswers.clickChangeLink("High Income Child Benefit Charge Date")
      DateHighIncomeChildBenefit.verifyPageTitle(DateHighIncomeChildBenefit.pageTitle)
      DateHighIncomeChildBenefit.submitDate(DateHighIncomeChildBenefit.Locators.dateHighIncomeChildBenefit)
      DateHighIncomeChildBenefit.clickContinueButton()
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)

      And("User updates the last date of the tax year in which they owe Capital Gains Tax")
      CheckYourAnswers.clickChangeLink("Capital Gains Tax Date")
      DateCapitalGainsTax.verifyPageTitle(DateCapitalGainsTax.pageTitle)
      DateCapitalGainsTax.submitDate(DateCapitalGainsTax.Locators.dateCapitalGainsTax)
      DateCapitalGainsTax.clickContinueButton()

      Then("User updates their answers before submitting the application")
      CheckYourAnswers.verifyPageTitle(CheckYourAnswers.pageTitle)
      CheckYourAnswers.clickContinueButton()

      And("User declares that the information provided is correct")
      Declaration.verifyPageTitle(Declaration.pageTitle)
      Declaration.submitDeclaration("Test User")
    }
  }
}
