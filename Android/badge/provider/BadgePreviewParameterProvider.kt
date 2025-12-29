package pl.gov.coi.common.ui.ds.badge.provider

import pl.gov.coi.common.ui.ds.badge.BadgeData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class BadgePreviewParameterProvider : CustomPreviewParameterProvider<BadgeData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<BadgeData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "BadgeDataDefault",
      value = BadgeData.BadgeDefault,
    ),
  )
}
