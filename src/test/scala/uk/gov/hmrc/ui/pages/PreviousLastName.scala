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

import org.scalactic.Prettifier.default
import uk.gov.hmrc.ui.pages.Name.{input, saveAndContinue}

import scala.util.Random

object PreviousLastName extends BasePage {

  override def pageUrl: String = "self-assessment-forms/sa1/enter-previous-last-name"

  override def pageTitle: String =
    "Your previous last name - Registering for Self Assessment - GOV.UK"

  def submitPreviousLastName(previousLastName: String): Unit = {
    input(Locators.txtPreviousLastName, previousLastName)
    saveAndContinue()
  }
}
//
