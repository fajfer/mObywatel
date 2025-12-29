package pl.gov.coi.common.ui.ds.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.header.provider.HeaderPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun Header(
  data: HeaderData,
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(color = AppTheme.colors.background),
    horizontalAlignment = Alignment.Start,
  ) {
    Icon(data = data.iconData)
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
    CustomText(
      label = data.title,
      modifier = Modifier.fillMaxWidth(),
      style = AppTheme.typography.headlineLargeMedium,
    )
    data.message?.let { label ->
      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
      CustomText(
        label = label,
        style = AppTheme.typography.bodyLargeRegular,
        color = AppTheme.colors.neutral200,
      )
    }
  }
}

@Preview
@Composable
fun HeaderPreview(
  @PreviewParameter(HeaderPreviewParameterProvider::class) data: HeaderData,
) {
  Header(data = data)
}
