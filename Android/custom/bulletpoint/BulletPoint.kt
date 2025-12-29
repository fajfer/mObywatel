package pl.gov.coi.common.ui.ds.custom.bulletpoint

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

/**
 * Temporary custom component for bullet lists. It will be replaced with a proper one, when it's done.
 */

@Composable
fun BulletPoint(
  text: Label,
) {
  Row(modifier = Modifier.fillMaxWidth()) {
    Box(
      modifier = Modifier.size(size = AppTheme.dimensions.spacing300),
      contentAlignment = Alignment.Center,
    ) {
      Icon(
        data = IconData.Standard(
          iconResId = R.drawable.e003_badge,
          iconSize = IconSize.SIZE6,
          iconColorProvider = { Color(0xFF4A4A4A) },
          contentDescription = Label.EMPTY,
        ),
      )
    }
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing100),
    )
    CustomText(
      modifier = Modifier.fillMaxWidth(),
      label = text,
      color = AppTheme.colors.neutral200,
      style = AppTheme.typography.bodyLargeRegular,
    )
  }
}
