package pl.gov.coi.common.ui.ds.resultmodal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.resultmodal.provider.ResultModalPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.get

@Composable
fun ResultModal(data: ResultModalData) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(AppTheme.colors.background)
      .padding(horizontal = AppTheme.dimensions.spacing200),
    horizontalAlignment = Alignment.End,
  ) {
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))
    ButtonIcon(data = data.closeIconButtonData)
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))

    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Column(
        modifier = Modifier
          .verticalScroll(rememberScrollState())
          .weight(1F, fill = true)
          .padding(horizontal = AppTheme.dimensions.spacing250),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Icon(data = data.iconData)
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing300))
        CustomText(
          label = data.title,
          style = AppTheme.typography.titleMedium,
          textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing400))
        CustomText(
          label = data.dataTitle1,
          style = AppTheme.typography.bodyLargeRegular,
          color = AppTheme.colors.neutral200,
          textAlign = TextAlign.Center,
        )
        CustomText(
          label = data.data1,
          style = AppTheme.typography.subtitleMedium,
          textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing400))
        CustomText(
          label = data.dataTitle2,
          style = AppTheme.typography.bodyLargeRegular,
          color = AppTheme.colors.neutral200,
        )
        CustomText(
          label = data.data2,
          style = AppTheme.typography.subtitleMedium,
        )
      }

      Column(
        modifier = Modifier.wrapContentWidth(),
        verticalArrangement = Arrangement.Bottom,
      ) {
        data.primaryButton?.let {
          Button(data = it)
        }
        data.secondaryButton?.let {
          Spacer(
            modifier = Modifier.height(AppTheme.dimensions.spacing100),
          )
          Button(
            data = it,
          )
        }
        data.tertiaryButton?.let {
          Spacer(
            modifier = Modifier.height(AppTheme.dimensions.spacing100),
          )
          Button(
            data = it,
          )
        }
        Spacer(
          modifier = Modifier.height(AppTheme.dimensions.spacing300),
        )
      }
    }
  }
}

@Preview
@Composable
fun ResultModalPreview(@PreviewParameter(ResultModalPreviewParameterProvider::class) data: ResultModalData) {
  ResultModal(data = data)
}
