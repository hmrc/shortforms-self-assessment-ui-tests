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

object EnterAddress extends BasePage {

  override def pageUrl: String = "self-assessment-forms/sa1/address"

  override def pageTitle: String =
    "What is your address? - Registering for Self Assessment - GOV.UK"

  def enterManualAddress(
                          addressLine1: String,
                          addressLine2: String,
                          addressLine3: String,
                          town: String,
                          postcode: String
                        ): Unit = {
    input(Locators.txtAddressLine1, addressLine1)
    input(Locators.txtAddressLine2, addressLine2)
    input(Locators.txtAddressLine3, addressLine3)
    input(Locators.txtTown, town)
    input(Locators.txtPostalcode, postcode)
    saveAndContinue()
  }
}
//
