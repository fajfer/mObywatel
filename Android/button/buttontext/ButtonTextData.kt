package pl.gov.coi.common.ui.ds.button.buttontext

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.common.ButtonState

data class ButtonTextData(
  val testTag: String? = null,
  val label: Label,
  val buttonState: ButtonState = ButtonState.Enabled,
  val onClick: () -> Unit,
)
