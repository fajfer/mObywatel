package pl.gov.coi.common.ui.ds.smallcards

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label

data class SmallCardSData(
  val testTag: String? = null,
  val title: Label,
  @DrawableRes val iconResId: Int,
  val iconColorProvider: @Composable () -> Color = { Color.Unspecified },
  val onClick: () -> Unit,
)
