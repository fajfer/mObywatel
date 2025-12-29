package pl.gov.coi.common.ui.ds.progressbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.progressbar.provider.ProgressBarPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun ProgressBar(
  data: ProgressBarData,
) {
  val progress = remember { (data.value.toDouble() / PERCENTAGE).toFloat() }
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .semantics { testTag = data.testTag ?: "Progress" },
  ) {
    if (data is ProgressBarData.IndicatorBar) {
      CustomText(
        modifier = Modifier
          .fillMaxWidth(progress),
        testTag = data.testTag?.let { tag -> tag + "Text" },
        label = data.label,
        style = AppTheme.typography.bodySmallRegular,
        color = AppTheme.colors.neutral200,
        textAlign = TextAlign.End,
      )
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
    }
    LinearProgressIndicator(
      progress = progress,
      modifier = Modifier
        .fillMaxWidth(),
      color = AppTheme.colors.primary900,
      backgroundColor = AppTheme.colors.neutral30,
      strokeCap = StrokeCap.Round,
    )
  }
}

@Composable
@Preview
fun ProgressBarPreview(
  @PreviewParameter(ProgressBarPreviewParameterProvider::class)
  progressBarData: ProgressBarData,
) {
  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
      .fillMaxSize()
      .background(AppTheme.colors.background),
  ) {
    Column(modifier = Modifier.padding(AppTheme.dimensions.spacing250)) {
      ProgressBar(data = progressBarData)
    }
  }
}

private const val PERCENTAGE = 100.00
