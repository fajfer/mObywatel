package pl.gov.coi.common.ui.ds.snackbar.provider

import pl.gov.coi.common.ui.ds.snackbar.SnackBarData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SnackBarPreviewParameterProvider : CustomPreviewParameterProvider<SnackBarData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<SnackBarData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataSimple",
      value = SnackBarData.Default(
        messageLabel = "Single-line snackbar".toLabel(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataSimple",
      value = SnackBarData.Default(
        ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore").toLabel(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataClosable",
      value = SnackBarData.DefaultWithIcon(
        messageLabel = "Single-line snackbar with close affordance".toLabel(),
      ) {},
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataClosable",
      value = SnackBarData.DefaultWithIcon(
        ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore").toLabel(),
      ) {},
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataDefaultWithIcon",
      value = SnackBarData.DefaultWithIcon(
        ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore." +
          " Lorem ipsum dolor sit amet.").toLabel(),
      ),
    ),
  )
}
