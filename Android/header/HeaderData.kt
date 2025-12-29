package pl.gov.coi.common.ui.ds.header

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.custom.icon.IconState

class HeaderData(
  @DrawableRes iconResId: Int,
  iconColorProvider: @Composable () -> Color,
  iconBackgroundColorProvider: @Composable () -> Color,
  internal val title: Label,
  internal val message: Label?,
) {
  internal val iconData: IconData = IconData.Background(
    iconResId = iconResId,
    iconColorProvider = iconColorProvider,
    backgroundSize = IconSize.SIZE72,
    iconSize = IconSize.SIZE40,
    backgroundColorProvider = iconBackgroundColorProvider,
    backgroundShape = BackgroundShape.Rounded,
    contentDescription = null,
  )
}

class CustomHeaderIconData(
  internal val iconResId: Int,
  internal val iconColorProvider: @Composable () -> Color,
  internal val backgroundColorProvider: @Composable () -> Color,
  internal val contentDescription: Label?,
  internal val iconState: IconState = IconState.ENABLED,
)
