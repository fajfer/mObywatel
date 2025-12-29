package pl.gov.coi.common.ui.ds.inputdatetime

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.R

data class InputDateTimeData(
  val label: Label,
  val inputText: String? = null,
  val type: Type,
  val validationState: ValidationState = ValidationState.Default,
  val helperText: Label? = null,
  val enabled: Boolean = true,
  val onClick: () -> Unit,
) {

  sealed class Type(
    val iconResId: Int,
    val placeholder: String,
  ) {
    data object Time : Type(
      iconResId = R.drawable.aa016_history,
      placeholder = TIME_PLACEHOLDER,
    )

    data object Date : Type(
      iconResId = R.drawable.aa007_date_picker,
      placeholder = DATE_PLACEHOLDER,
    )
  }

  companion object {
    private const val DATE_PLACEHOLDER = "DD.MM.RRRR"
    private const val TIME_PLACEHOLDER = "GG:MM"
  }
}
