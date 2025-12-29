package pl.gov.coi.common.ui.ds.header.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.header.HeaderData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class HeaderPreviewParameterProvider : CustomPreviewParameterProvider<HeaderData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<HeaderData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "Header",
      value = HeaderData(
        iconResId = R.drawable.da015_historia_pojazdu,
        iconColorProvider = { AppTheme.colors.headerCeladon100 },
        iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
        title = "Title Size XXL Color - black 900".toLabel(),
        message = "Description text Size - M, Color - grey 900".toLabel(),
      ),
    ),
  )
}
