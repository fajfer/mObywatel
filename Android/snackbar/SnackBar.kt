package pl.gov.coi.common.ui.ds.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.snackbar.provider.SnackBarPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun SnackBar(data: SnackBarData) {
  Card(
    modifier = Modifier.semantics { contentDescription = data.messageLabel.text },
    shape = AppTheme.shapes.radius50,
    colors = CardDefaults.cardColors(containerColor = AppTheme.colors.neutral200),
    elevation = CardDefaults.cardElevation(defaultElevation = AppTheme.elevations.level0),
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(all = AppTheme.dimensions.spacing200),
    ) {
      CustomText(
        label = data.messageLabel,
        modifier = Modifier
          .weight(weight = 1f)
          .align(Alignment.CenterVertically),
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.white,
        overflow = TextOverflow.Ellipsis,
      )

      when (data) {
        is SnackBarData.Default -> Unit
        is SnackBarData.DefaultWithIcon -> {
          Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing150))
          Box(contentAlignment = Alignment.TopCenter) {
            ButtonIcon(data = data.iconButtonData)
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun SnackBarPreview(
  @PreviewParameter(SnackBarPreviewParameterProvider::class) data: SnackBarData,
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(color = AppTheme.colors.background)
      .padding(all = AppTheme.dimensions.spacing200),
    contentAlignment = Alignment.BottomCenter,
  ) {
    SnackBar(data = data)
  }
}
