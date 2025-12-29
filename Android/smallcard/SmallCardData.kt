package pl.gov.coi.common.ui.ds.smallcard

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize

data class SmallCardData(
  val title: Label,
  @DrawableRes val iconResId: Int,
  val iconColorProvider: @Composable () -> Color = { Color.Unspecified },
  val indexTag: Int? = null,
  val onClick: () -> Unit,
) {
  internal val iconData: IconData = IconData.Standard(
    iconResId = iconResId,
    iconSize = IconSize.SIZE32,
    iconColorProvider = iconColorProvider,
    contentDescription = Label.EMPTY,
  )
}
