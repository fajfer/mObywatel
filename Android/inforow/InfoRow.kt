package pl.gov.coi.common.ui.ds.inforow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
internal fun DefaultInfoRow(
  data: InfoRowData.Default,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth(),
  ) {
    Icon(data = data.icon)
    Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
    Column {
      CustomText(
        label = data.title,
        style = AppTheme.typography.bodyLargeMedium,
        color = AppTheme.colors.neutral500,
      )
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
      CustomText(
        label = data.description,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
      )
    }
  }
}

@Composable
internal fun BulletInfoRow(
  data: InfoRowData.Bullet,
) {
  Row(modifier = Modifier.fillMaxWidth()) {
    Icon(data = data.icon)
    Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
    CustomText(
      label = data.description,
      style = AppTheme.typography.bodyLargeRegular,
      color = AppTheme.colors.neutral200,
    )
  }
}
