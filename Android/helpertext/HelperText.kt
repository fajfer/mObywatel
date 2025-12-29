package pl.gov.coi.common.ui.ds.helpertext

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun HelperText(
  testTag: String? = null,
  helperLabel: Label,
  ignoreForAccessibility: Boolean = false,
) {
  CustomText(
    testTag = testTag,
    textAlign = TextAlign.Start,
    label = helperLabel,
    style = AppTheme.typography.bodySmallRegular,
    color = AppTheme.colors.neutral200,
    ignoreForAccessibility = ignoreForAccessibility,
  )
}
