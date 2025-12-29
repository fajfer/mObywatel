package pl.gov.coi.common.ui.ds.checkbox.single.model

import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType

data class CheckBoxSingleData(
  val checkbox: CheckBoxRowData,
  val type: CheckBoxType = CheckBoxType.Default,
  val contentType: CheckboxContentType = CheckboxContentType.DEFAULT,
  val isEnabled: Boolean = true,
)
