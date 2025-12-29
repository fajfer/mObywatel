package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttondescription

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
internal fun RadioButtonDescription(
  description: Label?,
) {
  description?.let { descriptionLabel ->
    Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
    CustomText(
      label = descriptionLabel,
      style = AppTheme.typography.bodyLargeRegular,
      color = AppTheme.colors.neutral200,
    )
  }
}
