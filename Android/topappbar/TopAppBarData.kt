package pl.gov.coi.common.ui.ds.topappbar

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.menus.MenuData
import pl.gov.coi.common.ui.ds.progressbar.ProgressBarData
import pl.gov.coi.common.ui.theme.AppTheme

sealed interface TopAppBarData {
  sealed class Small(
    val menuType: MenuType? = null,
    val containerColor: @Composable () -> Color,
  ) : TopAppBarData {
    class Default(
      val navigationButtonData: NavigationButtonData? = null,
      val title: Label? = null,
      val alignment: TitleAlignment = TitleAlignment.Center,
      menuType: MenuType? = null,
      val progressBarData: ProgressBarData? = null,
      val forceTitleFocusTrigger: Boolean? = true,
      containerColor: @Composable () -> Color = { AppTheme.colors.background },
    ) : Small(
      menuType = menuType,
      containerColor = containerColor,
    )

    class Sygnet(
      menuType: MenuType? = null,
      containerColor: @Composable () -> Color = { AppTheme.colors.background },
    ) : Small(
      menuType = menuType,
      containerColor = containerColor,
    )

    class Logo(
      val navigationButtonData: NavigationButtonData? = null,
      containerColor: @Composable () -> Color = { AppTheme.colors.background },
      menuType: MenuType? = null,
    ) : Small(
      menuType = menuType,
      containerColor = containerColor,
    )
  }

  data class Medium(
    val navigationButtonData: NavigationButtonData? = null,
    val title: Label,
    val menuType: MenuType? = null,
    val forceTitleFocusTrigger: Boolean? = true,
    val containerColor: @Composable () -> Color = { AppTheme.colors.background },
  ) : TopAppBarData

  data class Large(
    val navigationButtonData: NavigationButtonData? = null,
    val title: Label,
    val menuType: MenuType? = null,
    val forceTitleFocusTrigger: Boolean? = true,
    val containerColor: @Composable () -> Color = { AppTheme.colors.background },
  ) : TopAppBarData
}

data class NavigationButtonData(
  val icon: Icon,
  val onClick: () -> Unit,
) {
  data class Icon(
    @DrawableRes val iconResId: Int,
    val contentDescription: Label,
  ) {
    companion object {
      val BACK_ARROW: Icon = Icon(
        iconResId = R.drawable.ab004_arrow_left,
        contentDescription = CommonUILabelProvider.topAppBarArrowBack(),
      )
    }
  }
}

enum class TitleAlignment {
  Center, Left
}

sealed interface MenuType {
  data class Icon(
    val menuButtonData: MenuButtonData,
  ) : MenuType

  data class IconList(
    val menuIconList: List<MenuButtonData>,
  ) : MenuType

  data class MenuButtonData(
    val icon: MenuIcon,
    val iconColorProvider: @Composable () -> Color = { AppTheme.colors.neutral200 },
    val menuData: MenuData? = null,
    val onClick: () -> Unit,
  ) {
    fun getButton() = ButtonIconData(
      iconResId = icon.iconResId,
      iconColorProvider = iconColorProvider,
      menuData = menuData,
      contentDescription = icon.contentDescription,
      onClick = onClick,
    )

    interface MenuIcon {
      @get:DrawableRes
      val iconResId: Int
      val contentDescription: Label
    }

    enum class DefaultMenuIcon(
      override val iconResId: Int,
      override val contentDescription: Label,
    ) : MenuIcon {
      CLOSE(
        iconResId = R.drawable.ab009_x_mark,
        contentDescription = CommonUILabelProvider.commonAccessibilityClose(),
      ),
      QUESTION_MARK(
        iconResId = R.drawable.ab015_help,
        contentDescription = CommonUILabelProvider.commonAccessibilityFindOutMore(),
      ),
      EDIT(
        iconResId = R.drawable.ab017_edit,
        contentDescription = CommonUILabelProvider.commonAccessibilityEdit(),
      ),
      DELETE(
        iconResId = R.drawable.aa002_delete,
        contentDescription = CommonUILabelProvider.commonAccessibilityDelete(),
      ),
      SETTINGS(
        iconResId = R.drawable.ab003_settings,
        contentDescription = CommonUILabelProvider.commonAccessibilitySettings(),
      ),
    }
  }

}
