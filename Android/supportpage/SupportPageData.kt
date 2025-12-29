package pl.gov.coi.common.ui.ds.supportpage

import androidx.annotation.DrawableRes
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

class SupportPageData<CONTENT_DATA>(
  internal val topBarTitle: Label,
  @DrawableRes topBarIconMainResId: Int?,
  onTopBarIconMainClick: (() -> Unit)?,
  @DrawableRes topBarIconMenuResId: Int?,
  onTopBarIconMenuClick: (() -> Unit)?,
  @DrawableRes iconResId: Int,
  iconContentDescription: Label,
  internal val title: Label,
  internal val message: Label?,
  internal val contentData: CONTENT_DATA,
  internal val buttonData: ButtonData?,
) {
  internal val iconData: IconData.Background = IconData.Background(
    iconResId = iconResId,
    backgroundSize = IconSize.SIZE96,
    iconSize = IconSize.SIZE64,
    iconColorProvider = { AppTheme.colors.primary900 },
    backgroundColorProvider = { AppTheme.colors.secondary900 },
    backgroundShape = BackgroundShape.Rounded,
    contentDescription = iconContentDescription,
  )

  internal val mainButtonData: ButtonIconData? =
    topBarIconMainResId?.let {
      ButtonIconData(

        iconResId = it,
        iconColorProvider = { AppTheme.colors.neutral200 },
        onClick = onTopBarIconMainClick ?: {},
      )
    }

  internal val menuButtonData: ButtonIconData? =
    topBarIconMenuResId?.let {
      ButtonIconData(

        iconResId = it,
        iconColorProvider = { AppTheme.colors.neutral200 },
        onClick = onTopBarIconMenuClick ?: {},
      )
    }
}
