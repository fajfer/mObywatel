package pl.gov.coi.common.ui.ds.custom.documentrow

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.singlecard.SingleCardClickableRadioButtonState
import pl.gov.coi.common.ui.ds.singlecard.toIconState
import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeData

data class DocumentRowData(
  val testTag: String? = null,
  @DrawableRes val iconResId: Int,
  val iconColorProvider: @Composable () -> Color = { Color.Unspecified },
  val title: Label,
  val description: Label? = null,
  val modifier: Modifier = Modifier,
  val badgeData: StatusBadgeData.WithIcon?,
  val onClick: () -> Unit,
) {
  internal val iconData: IconData = IconData.Standard(
    testTag = testTag?.let { tag -> tag + "Icon" },
    iconResId = iconResId,
    iconSize = IconSize.SIZE24,
    iconColorProvider = iconColorProvider,
    contentDescription = Label.EMPTY,
    iconState = SingleCardClickableRadioButtonState.ENABLED.toIconState(),
  )

  internal val trailingIcon = IconData.Standard(
    testTag = testTag?.let { tag -> tag + "TrailingIcon" },
    iconResId = DEFAULT_TRAILING_ICON_RES_ID,
    iconSize = IconSize.SIZE24,
    iconColorProvider = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
    iconState = SingleCardClickableRadioButtonState.ENABLED.toIconState(),
    contentDescription = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
  )

  private companion object {
    val DEFAULT_TRAILING_ICON_RES_ID = R.drawable.ab006_chevron_right
    val DEFAULT_TRAILING_ICON_COLOR_PROVIDER: @Composable () -> Color = { Color.Unspecified }
    val DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION = Label.EMPTY
  }
}
