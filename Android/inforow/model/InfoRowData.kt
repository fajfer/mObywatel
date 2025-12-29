package pl.gov.coi.common.ui.ds.inforow.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

sealed class InfoRowData(
  internal val description: Label,
  internal val icon: IconData,
) {
  class Bullet(
    description: Label,
  ) : InfoRowData(
    description = description,
    icon = IconData.Standard(
      iconResId = R.drawable.aa046_bullet,
      iconSize = IconSize.SIZE24,
      iconColorProvider = { AppTheme.colors.neutral200 },
      contentDescription = null,
    ),
  )

  class Default(
    description: Label,
    @DrawableRes val iconResId: Int,
    iconColorProvider: @Composable () -> Color,
    val title: Label,
  ) : InfoRowData(
    description = description,
    icon = IconData.Standard(
      iconResId = iconResId,
      iconSize = IconSize.SIZE32,
      iconColorProvider = iconColorProvider,
      contentDescription = null,
    ),
  )
}
