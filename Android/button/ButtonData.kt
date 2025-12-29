package pl.gov.coi.common.ui.ds.button

import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonState
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant

data class ButtonData(
  val testTag: String? = null,
  val buttonSize: ButtonSize,
  val buttonType: ButtonType,
  val buttonVariant: ButtonVariant,
  val buttonState: ButtonState = ButtonState.Enabled,
  val onClick: () -> Unit,
)
