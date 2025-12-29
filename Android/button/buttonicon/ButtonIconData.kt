package pl.gov.coi.common.ui.ds.button.buttonicon

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.menus.MenuData
import pl.gov.coi.common.ui.theme.AppTheme


data class ButtonIconData(
  val testTag: String? = null,
  @DrawableRes val iconResId: Int,
  val iconColorProvider: @Composable () -> Color = { AppTheme.colors.primary900 },
  val menuData: MenuData? = null,
  val contentDescription: Label = Label.EMPTY,
  val onClick: () -> Unit,
)
