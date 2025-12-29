package pl.gov.coi.common.ui.ds.menus

import androidx.annotation.DrawableRes
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

data class MenuData(
  val isMenuVisible: Boolean,
  val onMenuClose: () -> Unit,
  val items: List<MenuItem>,
)

class MenuItem(
  val testTag: String? = null,
  val label: Label,
  @DrawableRes leftIconResId: Int?,
  @DrawableRes rightIconResId: Int?,
  val onItemClick: () -> Unit,
) {
  internal val leftIconData = leftIconResId?.let {
    IconData.Standard(
      iconResId = leftIconResId,
      iconSize = IconSize.SIZE24,
      iconColorProvider = { AppTheme.colors.neutral200 },
      contentDescription = Label.EMPTY,
    )
  }

  internal val rightIconData = rightIconResId?.let {
    IconData.Standard(
      iconResId = rightIconResId,
      iconSize = IconSize.SIZE24,
      iconColorProvider = { AppTheme.colors.neutral200 },
      contentDescription = Label.EMPTY,
    )
  }
}
