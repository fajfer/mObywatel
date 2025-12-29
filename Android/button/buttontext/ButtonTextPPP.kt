package pl.gov.coi.common.ui.ds.button.buttontext

import pl.gov.coi.common.ui.ds.button.common.ButtonState
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class ButtonTextPPP : CustomPreviewParameterProvider<ButtonTextData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ButtonTextData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "TextEnabledButton",
      value = ButtonTextData(
        label = "Test".toLabel(),
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextDestructiveButton",
      value = ButtonTextData(
        label = "Test".toLabel(),
        buttonState = ButtonState.Destructive,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextDisabledButton",
      value = ButtonTextData(
        label = "Test".toLabel(),
        buttonState = ButtonState.Disabled,
        onClick = {},
      ),
    ),
  )
}
