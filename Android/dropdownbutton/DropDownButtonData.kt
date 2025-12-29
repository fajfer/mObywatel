package pl.gov.coi.common.ui.ds.dropdownbutton

import pl.gov.coi.common.domain.label.Label

data class DropDownButtonData(
  val label: Label,
  val items: List<Label>,
  val initialSelectedItem: Int? = null,
  val buttonType: DropDownButtonState = DropDownButtonState.Enabled(),
  val placeholder: Label,
  val onClick: (DropDownButtonData) -> Unit,
)

sealed interface DropDownButtonState {

  data class Error(
    val errorText: Label? = null,
  ) : DropDownButtonState

  data class Enabled(
    val helperText: Label? = null,
  ) : DropDownButtonState

  data class Disabled(
    val helperText: Label? = null,
  ) : DropDownButtonState

}
