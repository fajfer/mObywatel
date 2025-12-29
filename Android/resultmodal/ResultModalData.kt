package pl.gov.coi.common.ui.ds.resultmodal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

class ResultModalData(
  iconRes: Int,
  iconColorProvider: @Composable () -> Color,
  iconContentDescription: Label,
  val title: Label,
  val dataTitle1: Label,
  val data1: Label,
  val dataTitle2: Label,
  val data2: Label,
  val primaryButton: ButtonData?,
  val secondaryButton: ButtonData?,
  val tertiaryButton: ButtonData?,
  closeIconContentDescription: Label,
  closeAction: () -> Unit,
) {
  val closeIconButtonData = ButtonIconData(
    iconResId = R.drawable.ab009_x_mark,
    iconColorProvider = { AppTheme.colors.neutral500 },
    contentDescription = closeIconContentDescription,
    onClick = closeAction,
  )
  val iconData: IconData = IconData.Standard(
    iconResId = iconRes,
    iconSize = IconSize.SIZE64,
    iconColorProvider = iconColorProvider,
    contentDescription = iconContentDescription,
  )
}
