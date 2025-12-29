package pl.gov.coi.common.ui.ds.button.common

sealed interface ButtonSize {
  data class Large(
    val fillMaxWidth: Boolean = true,
  ) : ButtonSize

  data object Small : ButtonSize
}
