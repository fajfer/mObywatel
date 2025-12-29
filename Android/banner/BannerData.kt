package pl.gov.coi.common.ui.ds.banner

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

sealed class BannerData(
  val title: Label?,
  val bodyText: Label,
  iconResId: Int,
  iconColorProvider: @Composable () -> Color,
  iconContentDescription: Label,
  onCloseButtonClick: (() -> Unit)?,
  closeIconContentDescription: Label,
) {

  internal open val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
    ButtonIconData(
      iconResId = R.drawable.ab009_x_mark,
      iconColorProvider = { AppTheme.colors.neutral200 },
      onClick = onCloseButtonClick,
      contentDescription = closeIconContentDescription,
    )
  }

  internal val iconData: IconData = IconData.Standard(
    iconResId = iconResId,
    iconSize = IconSize.SIZE24,
    iconColorProvider = iconColorProvider,
    contentDescription = iconContentDescription,
  )

  class Info(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonTextData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c1_info,
    iconColorProvider = { AppTheme.colors.supportBlue100 },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  )

  class Error(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonTextData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c3_error_mark,
    iconColorProvider = { AppTheme.colors.supportRed100 },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  )

  class HighEmphasisInfo(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c1_info,
    iconColorProvider = { AppTheme.colors.white },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  ) {
    override val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
      ButtonIconData(
        iconResId = R.drawable.ab009_x_mark,
        iconColorProvider = { AppTheme.colors.white },
        onClick = onCloseButtonClick,
        contentDescription = closeIconContentDescription,
      )
    }
  }

  class HighEmphasisError(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c3_error_mark,
    iconColorProvider = { AppTheme.colors.white },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  ) {
    override val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
      ButtonIconData(
        iconResId = R.drawable.ab009_x_mark,
        iconColorProvider = { AppTheme.colors.white },
        onClick = onCloseButtonClick,
        contentDescription = closeIconContentDescription,
      )
    }
  }
}
