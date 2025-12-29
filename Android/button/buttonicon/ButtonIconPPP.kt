package pl.gov.coi.common.ui.ds.button.buttonicon

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class ButtonIconPPP : CustomPreviewParameterProvider<ButtonIconData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ButtonIconData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "IconButton",
      value = ButtonIconData(
        iconResId = R.drawable.aa002_delete,
        onClick = {},
      ),
    ),
  )
}
