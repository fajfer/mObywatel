package pl.gov.coi.common.ui.ds.checkbox.common.model

import pl.gov.coi.common.domain.label.Label

sealed interface CheckBoxType {
  data class Error(
    val testTag: String? = null,
    val errorText: Label? = null,
  ) : CheckBoxType
  data class Helper(
    val testTag: String? = null,
    val helperText: Label,
  ) : CheckBoxType
  data object Default : CheckBoxType
}
