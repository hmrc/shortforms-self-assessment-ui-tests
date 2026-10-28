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

object AddPreviousLastName extends BasePage {

  override def pageUrl: String = "self-assessment-forms/sa1/previous-last-name"

  override def pageTitle: String =
    "Do you have a previous last name? - Registering for Self Assessment - GOV.UK"

  def continueAsYes(): Unit = {
    radioButton(Locators.rdoYes)
    saveAndContinue()
  }

  def continueAsNo(): Unit = {
    radioButton(Locators.rdoNo)
    saveAndContinue()
  }
}
//
