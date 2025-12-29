package pl.gov.coi.common.ui.ds.alert

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

sealed class AlertData(
  val testTag: String?,
  val alertContentDescription: Label,
  val title: Label?,
  val bodyText: Label,
  iconResId: Int,
  iconColorProvider: @Composable () -> Color,
  onCloseButtonClick: (() -> Unit)?,
  closeIconContentDescription: Label,
  val alertButtonData: AlertButtonData?,
) {

  internal val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
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
    contentDescription = null,
  )

  class Info(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c1_info,
    iconColorProvider = { AppTheme.colors.supportBlue100 },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )

  class Warning(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityWarningInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseWarningInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c2_warning_mark,
    iconColorProvider = { AppTheme.colors.supportOrange100 },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )

  class Success(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilitySuccessInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseSuccessInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c4_success,
    iconColorProvider = {
      val alertSuccessIconColor = Color(0xFF427639)
      alertSuccessIconColor
    },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )

  class Error(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityErrorInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseSuccessInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c3_error_mark,
    iconColorProvider = { AppTheme.colors.supportRed100 },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )
}
