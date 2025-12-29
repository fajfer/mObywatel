package pl.gov.coi.common.ui.ds.progressbar.provider

import pl.gov.coi.common.ui.ds.progressbar.ProgressBarData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class ProgressBarPreviewParameterProvider : CustomPreviewParameterProvider<ProgressBarData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<ProgressBarData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "ProgressBar",
      value = ProgressBarData.Bar(value = 50),
    ),
    ScreenShotTestData(
      screenShotTestName = "ProgressBarWithOptionalLabel",
      value = ProgressBarData.IndicatorBar(value = 75, label = "75%".toLabel()),
    ),
  )
}
