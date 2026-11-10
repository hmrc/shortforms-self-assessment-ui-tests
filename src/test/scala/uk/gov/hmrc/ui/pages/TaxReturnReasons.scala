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
}

//
