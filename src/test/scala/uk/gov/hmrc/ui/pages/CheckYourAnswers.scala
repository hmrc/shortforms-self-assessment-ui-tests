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

package uk.gov.hmrc.ui.pages

object CheckYourAnswers extends BasePage {

  override def pageUrl: String = "/check-answers"

  override def pageTitle: String =
    "Check your answers - Registering for Self Assessment - GOV.UK"

  //Personal Details//
  val lnkChangeFistName = "first-name"
  val lnkChangeLastName = "last-name"
  val lnkChangePreviousLastName = "previous-last-name"
  val lnkChangeCheckPreviousLastName = "previous-last-name-yes-no"
  val lnkChangePreviousLastNameDate = "previous-last-name-date"
  val lnkChangeDateOfBirth = "date-of-birth"
  val lnkChangeAddress = "address"
  val lnkChangeAddressMoveDate = "date-moved-to-address"
  val lnkChangeEmailAddress = "email-address"
  val lnkChangePhoneNumber = "phone-number"
  val lnkChangeCheckNationalInsurance = "national-insurance-number-yes-no"
  val lnkChangeNationalInsurance = "reason-for-no-national-insurance"
  //Application Details//
  val lnkChangeCompanyDirectorUntaxed = "company-director-untaxed"
  val lnkChangeCompanyDirectorUntaxedDate = "company-director-untaxed-date"
  val lnkChangeIncomeLandProperty = "income-land-property"
  val lnkChangeIncomeLandPropertyDate = "income-land-property-date"
  val lnkChangeTaxableForeignIncomeDividends = "taxable-foreign-income-dividends"
  val lnkChangeTaxableForeignIncomeDividendsDate = "taxable-foreign-income-dividends-date"
  val lnkChangeIncomeTrustSettlement = "annual-income-trust-settlement"
  val lnkChangeIncomeTrustSettlementDate = "annual-income-trust-settlement-date"
  val lnkChangeIncomeExceedsAnnualThreshold = "income-exceeds-annual-threshold"
  val lnkChangeIncomeExceedsAnnualThresholdDate = "income-exceeds-annual-threshold-date"
  val lnkChangeUntaxedIncomePaye = "untaxed-income-paye-tax-code"
  val lnkChangeUntaxedIncomePayeDate = "untaxed-income-paye-tax-code-date"
  val lnkChangeHighIncomeChildBenefitCharge = "high-income-child-benefit-charge"
  val lnkChangeHighIncomeChildBenefitChargeDate = "high-income-child-benefit-charge-date"
  val lnkChangeCapitalGainsTax = "capital-gains-tax"
  val lnkChangeCapitalGainsTaxDate = "capital-gains-tax-date"
  val lnkChangeOtherReason = "other-reason"
  val lnkChangeOtherReasonDate = "other-reason-date"

  def clickChangeLink(changeLink: String): this.type = {
    val linkId = changeLink match {
      case "First Name" => lnkChangeFistName
      case "Last Name" => lnkChangeLastName
      case "Check Previous Last Name" => lnkChangeCheckPreviousLastName
      case "Previous Last Name" => lnkChangePreviousLastName
      case "Previous Last Name Date" => lnkChangePreviousLastNameDate
      case "Date of Birth" => lnkChangeDateOfBirth
      case "Address" => lnkChangeAddress
      case "Address Move Date" => lnkChangeAddressMoveDate
      case "Email Address" => lnkChangeEmailAddress
      case "Phone Number" => lnkChangePhoneNumber
      case "Check National Insurance Number" => lnkChangeCheckNationalInsurance
      case "National Insurance Number" => lnkChangeNationalInsurance
      case "Company Director Untaxed Earnings" => lnkChangeCompanyDirectorUntaxed
      case "Company Director Untaxed Earnings Date" => lnkChangeCompanyDirectorUntaxedDate
      case "Land and Property Income" => lnkChangeIncomeLandProperty
      case "Land and Property Income Date" => lnkChangeIncomeLandPropertyDate
      case "Taxable Foreign Income or Dividends" => lnkChangeTaxableForeignIncomeDividends
      case "Taxable Foreign Income or Dividends Date" => lnkChangeTaxableForeignIncomeDividendsDate
      case "Trust or Settlement Income" => lnkChangeIncomeTrustSettlement
      case "Trust or Settlement Income Date" => lnkChangeIncomeTrustSettlementDate
      case "Annual Income Exceeds Threshold" => lnkChangeIncomeExceedsAnnualThreshold
      case "Annual Income Exceeds Threshold Date" => lnkChangeIncomeExceedsAnnualThresholdDate
      case "Untaxed Income not collected via PAYE" => lnkChangeUntaxedIncomePaye
      case "Untaxed Income not collected via PAYE Date" => lnkChangeUntaxedIncomePayeDate
      case "High Income Child Benefit Charge" => lnkChangeHighIncomeChildBenefitCharge
      case "High Income Child Benefit Charge Date" => lnkChangeHighIncomeChildBenefitChargeDate
      case "Capital Gains Tax" => lnkChangeCapitalGainsTax
      case "Capital Gains Tax Date" => lnkChangeCapitalGainsTaxDate
      case "Other Reason" => lnkChangeOtherReason
      case "Other Reason Date" => lnkChangeOtherReasonDate
      case _ => throw new IllegalArgumentException(s"Invalid link: $changeLink")
    }
    clickLinkById(linkId)
    this
  }
}
//
