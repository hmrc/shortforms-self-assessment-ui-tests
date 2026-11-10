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

import org.openqa.selenium.By

import scala.collection.JavaConverters.asScalaBufferConverter

object TaxReturnReasons extends BasePage {

  override def pageUrl: String = "/why-tax-return"

  override def pageTitle: String =
    "Why do you need to complete a tax return? - Registering for Self Assessment - GOV.UK"

  def selectAllCheckboxes(): Unit =
    driver
      .findElements(By.cssSelector("input[type='checkbox']"))
      .asScala
      .filterNot(_.isSelected)
      .foreach(_.click())

  def unselectAllCheckboxes(): Unit =
    driver
      .findElements(By.cssSelector("input[type='checkbox']"))
      .asScala
      .filter(_.isSelected)
      .foreach(_.click())


  val cbkDirectorUntaxedEarnings = "#value_0"
  val cbkIncomeLandAndProperty = "#value_1"
  val cbkTaxableForeignIncomeDividends = "#value_2"
  val cbkAnnualTrustOrSettlementIncome = "#value_3"
  val cbkAnnualIncomeExceedThreshold = "#value_4"
  val cbkUntaxedIncomeNotCollectedViaPAYE = "#value_5"
  val cbkHighIncomeChildBenefitCharge = "#value_6"
  val cbkCapitalGainsTax = "#value_7"
  val cbkOtherReason = "#value_8"

  def selectTaxReturnReasons(contactType: String, selected: Boolean): this.type = {
    val contactBtn = contactType match {
      case "Company Director Untaxed Earnings" => cbkDirectorUntaxedEarnings
      case "Land and Property Income" => cbkIncomeLandAndProperty
      case "Taxable Foreign Income or Dividends" => cbkTaxableForeignIncomeDividends
      case "Trust or Settlement Income" => cbkAnnualTrustOrSettlementIncome
      case "Annual Income Exceeds Threshold" => cbkAnnualIncomeExceedThreshold
      case "Untaxed Income not collected via PAYE" => cbkUntaxedIncomeNotCollectedViaPAYE
      case "High Income Child Benefit Charge" => cbkHighIncomeChildBenefitCharge
      case "Capital Gains Tax" => cbkCapitalGainsTax
      case "Other Reason" => cbkOtherReason
      case _                          => throw new IllegalArgumentException(s"Invalid link: $contactType")
    }
    checkbox(contactBtn, selected)
    this
  }


}
//
