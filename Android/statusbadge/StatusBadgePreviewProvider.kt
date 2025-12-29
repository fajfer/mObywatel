package pl.gov.coi.common.ui.ds.statusbadge

import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class StatusBadgePreviewProvider : CustomPreviewParameterProvider<StatusBadgeData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<StatusBadgeData>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDotPositive",
        value = StatusBadgeData.WithDot(
          label = "Roboto, Medium, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithDotStatus.POSITIVE,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDotInformative",
        value = StatusBadgeData.WithDot(
          label = "Roboto, Medium, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithDotStatus.INFORMATIVE,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDotNegative",
        value = StatusBadgeData.WithDot(
          label = "Roboto, Medium, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithDotStatus.NEGATIVE,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDotWarning",
        value = StatusBadgeData.WithDot(
          label = "Roboto, Medium, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithDotStatus.WARNING,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataPositive",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 12, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.POSITIVE,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataNegative",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 12, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.NEGATIVE,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataNotice",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 12, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.NOTICE,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataInformative",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 12, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.INFORMATIVE,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataNeutral",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 12, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.MINUS,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithoutBorderPositive",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.POSITIVE,
          withBorder = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithoutBorderNegative",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.NEGATIVE,
          withBorder = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithoutBorderNotice",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.NOTICE,
          withBorder = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithoutBorderInformative",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.INFORMATIVE,
          withBorder = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithoutBorderNeutral",
        value = StatusBadgeData.WithIcon(
          label = "Roboto, Regular, 16, Neutral-500".toLabel(),
          status = StatusBadgeWithIconStatus.MINUS,
          withBorder = false,
        ),
      ),
    )
}
