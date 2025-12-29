package pl.gov.coi.common.ui.ds.custom

import android.os.SystemClock
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

data class FileBottomSheetItemData(
  @DrawableRes val iconResId: Int,
  val title: Label,
  val onClick: () -> Unit,
) {
  internal val iconData = IconData.Standard(
    iconResId = iconResId,
    iconSize = IconSize.SIZE24,
    iconColorProvider = { AppTheme.colors.neutral200 },
    contentDescription = null,
  )
}


@Composable
fun FileBottomSheetItem(
  data: FileBottomSheetItemData,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(height = AppTheme.dimensions.spacing600)
      .debounceClick(onClick = data.onClick),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Icon(data = data.iconData)
    Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing200))
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeRegular,
      color = AppTheme.colors.neutral500,
    )
  }
}

@Composable
private fun Modifier.debounceClick(debounceTime: Long = 300L, onClick: () -> Unit): Modifier {
  var lastClickTime = remember { 0L }
  return this then clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = rememberRipple(),
    onClick = {
      val currentTime = SystemClock.elapsedRealtime()
      if ((currentTime - lastClickTime) > debounceTime) {
        lastClickTime = currentTime
        onClick()
      }
    },
  )
}
