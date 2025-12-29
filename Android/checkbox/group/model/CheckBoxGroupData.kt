package pl.gov.coi.common.ui.ds.checkbox.group.model

import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType

data class CheckBoxGroupData(
  val checkboxes: List<CheckBoxRowData>,
  val header: CheckBoxHeaderData? = null,
  val type: CheckBoxType = CheckBoxType.Default,
  val contentType: CheckboxContentType = CheckboxContentType.DEFAULT,
  val isEnabled: Boolean = true,
)
