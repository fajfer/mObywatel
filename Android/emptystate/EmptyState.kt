package pl.gov.coi.common.ui.ds.emptystate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.emptystate.provider.EmptyStatePreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun EmptyState(
  modifier: Modifier = Modifier,
  data: EmptyStateData,
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .semantics { isTraversalGroup = true },
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    data.title?.let { title ->
      CustomText(
        label = title,
        color = AppTheme.colors.neutral500,
        style = AppTheme.typography.bodyLargeMedium,
        textAlign = TextAlign.Center,
      )
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
    }
    CustomText(
      label = data.body,
      color = AppTheme.colors.neutral200,
      style = AppTheme.typography.bodyMediumRegular,
      textAlign = TextAlign.Center,
    )
    data.buttonData?.let {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
      Button(data = it)
    }
  }
}

@Preview
@Composable
fun EmptyStatePreview(@PreviewParameter(EmptyStatePreviewParameterProvider::class) data: EmptyStateData) {
  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize().background(AppTheme.colors.background),
  ) {
    EmptyState(data = data)
  }
}
