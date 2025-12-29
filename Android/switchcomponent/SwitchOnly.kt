package pl.gov.coi.common.ui.ds.switchcomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.semanticsContentDescription

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun SwitchOnly(
  data: SwitchData.SwitchOnly,
) {
  Box(
    contentAlignment = Alignment.Center,
  ) {
    Switch(
      modifier = Modifier
        .semanticsContentDescription(data.contentDescription?.text ?: "")
        .semantics { testTagsAsResourceId = true }
        .semantics { testTag = data.testTag ?: "switch${data.testIndexTag?.let { "_${data.testIndexTag}" } ?: ""}" },
      checked = data.checked,
      enabled = data.enabled,
      colors = SwitchDefaults.colors(
        checkedThumbColor = AppTheme.colors.white,
        checkedTrackColor = AppTheme.colors.primary900,
        uncheckedThumbColor = AppTheme.colors.neutral80,
        uncheckedTrackColor = AppTheme.colors.neutral10,
        uncheckedBorderColor = AppTheme.colors.neutral80,
        disabledCheckedThumbColor = AppTheme.colors.white,
        disabledCheckedTrackColor = AppTheme.colors.neutral10,
        disabledUncheckedThumbColor = AppTheme.colors.neutral60,
        disabledUncheckedTrackColor = AppTheme.colors.neutral10,
        disabledUncheckedBorderColor = AppTheme.colors.neutral30,
      ),
      onCheckedChange = data.onCheckedChange,
    )
  }
}
