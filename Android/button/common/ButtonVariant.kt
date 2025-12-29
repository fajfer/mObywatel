package pl.gov.coi.common.ui.ds.button.common

sealed interface ButtonVariant {
  data object Primary : ButtonVariant
  data class Secondary(
    val reversedColor: Boolean = false,
  ) : ButtonVariant

  data object Tertiary : ButtonVariant
}
