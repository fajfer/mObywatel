package pl.gov.coi.common.ui.ds.errortext

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun ErrorText(
  testTag: String? = null,
  errorText: Label,
  ignoreForAccessibility: Boolean = false,
) {
  Row(
    modifier = Modifier.then(
      if (ignoreForAccessibility) {
        Modifier.clearAndSetSemantics { }
      } else {
        Modifier.semantics(
          mergeDescendants = true,
          properties = {},
        )
      },
    ),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Icon(
      data = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = R.drawable.c3_error_mark,
        iconSize = IconSize.SIZE20,
        iconColorProvider = { AppTheme.colors.supportRed100 },

        contentDescription = Label.EMPTY,
      ),
    )
    Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing50))
    CustomText(
      testTag = testTag?.let { tag -> tag + "Text" },
      textAlign = TextAlign.Start,
      label = errorText,
      style = AppTheme.typography.bodySmallRegular,
      color = AppTheme.colors.supportRed100,
      ignoreForAccessibility = ignoreForAccessibility,
    )
  }
}
