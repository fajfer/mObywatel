package pl.gov.coi.common.ui.ds.smallcard.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.smallcard.SmallCardData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class SmallCardPreviewParameterProvider : CustomPreviewParameterProvider<SmallCardData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<SmallCardData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SmallCard",
      value = SmallCardData(
        title = "Naruszenie środowiskowe".toLabel(),
        iconResId = R.drawable.da002_naruszenie_srodowiskowe,
        iconColorProvider = { AppTheme.colors.serviceLeafy100 },
        onClick = {},
      ),
    ),
  )
}
