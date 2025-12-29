package pl.gov.coi.common.ui.ds.button.common

import androidx.annotation.DrawableRes
import pl.gov.coi.common.domain.label.Label

sealed interface ButtonType {
  data class WithText(
    val testTag: String? = null,
    val label: Label,
    val contentDescription: Label = Label.EMPTY,
  ) : ButtonType

  data class WithIcon(
    val testTag: String? = null,
    @DrawableRes val iconResId: Int,
    val contentDescription: Label = Label.EMPTY,
  ) : ButtonType
}
