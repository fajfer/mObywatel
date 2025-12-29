package pl.gov.coi.common.ui.ds.button.common

sealed interface ButtonState {
  data object Enabled : ButtonState
  data object Destructive : ButtonState
  data object Disabled : ButtonState
}
