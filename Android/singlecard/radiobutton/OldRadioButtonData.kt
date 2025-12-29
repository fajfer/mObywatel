package pl.gov.coi.common.ui.ds.singlecard.radiobutton

import pl.gov.coi.common.domain.validators.ValidationState

data class OldRadioButtonData(
  val id: RadioButtonId,
  val isSelected: Boolean = false,
  val enabled: Boolean = true,
  val validationState: ValidationState = ValidationState.Default,
)

interface RadioButtonId {
  object Default : RadioButtonId
}
