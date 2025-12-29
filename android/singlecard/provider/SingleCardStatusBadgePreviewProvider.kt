package pl.gov.coi.common.ui.ds.singlecard.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.singlecard.SingleCardStatusBadgeData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

/* 
9     TODO REMOVE MOB-49304 
10    */
class SingleCardStatusBadgePreviewProvider : CustomPreviewParameterProvider<SingleCardStatusBadgeData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<SingleCardStatusBadgeData>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDefaultGreen",
        value = SingleCardStatusBadgeData.Default.Green(
          text = "Roboto, Medium, 16, Neutral-500".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDefaultYellow",
        value = SingleCardStatusBadgeData.Default.Yellow(
          text = "Roboto, Medium, 16, Neutral-500".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDefaultRed",
        value = SingleCardStatusBadgeData.Default.Red(
          text = "Roboto, Medium, 16, Neutral-500".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataDefaultBlue",
        value = SingleCardStatusBadgeData.Default.Blue(
          text = "Roboto, Medium, 16, Neutral-500".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithNoIconNormal",
        value = SingleCardStatusBadgeData.WithNoIcon.Normal(
          text = "Roboto, Regular, 14, Neutral-200".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithNoIconError",
        value = SingleCardStatusBadgeData.WithNoIcon.Error(
          text = "Roboto, Medium, 14, Red-100".toLabel(),
        ),
      ),

      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconSuccess",
        value = SingleCardStatusBadgeData.WithIcon.Success(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconError",
        value = SingleCardStatusBadgeData.WithIcon.Error(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconWarning",
        value = SingleCardStatusBadgeData.WithIcon.Warning(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconInfo",
        value = SingleCardStatusBadgeData.WithIcon.Info(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconAndBorderActive",
        value = SingleCardStatusBadgeData.WithIconAndBorder.Active(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconAndBorderActive",
        value = SingleCardStatusBadgeData.WithIconAndBorder.ActionNeeded(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconAndBorderFailure",
        value = SingleCardStatusBadgeData.WithIconAndBorder.Failure(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithIconAndBorderCanceled",
        value = SingleCardStatusBadgeData.WithIconAndBorder.Canceled(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          iconContentDescription = Label.EMPTY,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithDotAndBorderGreen",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Green(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDatWithDotAndBorderYellow",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Yellow(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithDotAndBorderRed",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Red(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithDotAndBorderBlue",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Blue(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = false,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithDotAndBorderGreenColored",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Green(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = true,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithDotAndBorderYellowColored",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Yellow(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = true,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDatWithDotAndBorderRedColored",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Red(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = true,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataWithDotAndBorderBlueColored",
        value = SingleCardStatusBadgeData.WithDotAndBorder.Blue(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
          isColored = true,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataElevatedGreen",
        value = SingleCardStatusBadgeData.Elevated.Green(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataElevatedYellow",
        value = SingleCardStatusBadgeData.Elevated.Yellow(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataElevatedRed",
        value = SingleCardStatusBadgeData.Elevated.Red(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = " StatusBadgeDataElevatedBlue",
        value = SingleCardStatusBadgeData.Elevated.Blue(
          text = "Roboto, Regular, 12, Neutral-200".toLabel(),
        ),
      ),
    )
}