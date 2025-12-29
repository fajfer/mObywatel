package pl.gov.coi.common.ui.ds.dropdownbutton

import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class DropDownButtonPPP : CustomPreviewParameterProvider<DropDownButtonData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<DropDownButtonData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "DisabledDropDown",
      value = DropDownButtonData(
        "Dropdown Label".toLabel(),
        placeholder = "DropDown placeholder placeholder placeholder".toLabel(),
        items = emptyList(),
        initialSelectedItem = null,
        buttonType = DropDownButtonState.Disabled(
          helperText = "helper text".toLabel(),
        ),
        onClick = { },
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "HelperDropDown",
      value = DropDownButtonData(
        "Dropdown Label".toLabel(),
        placeholder = "DropDown placeholder placeholder placee".toLabel(),
        items = emptyList(),
        initialSelectedItem = null,
        buttonType = DropDownButtonState.Enabled(
          helperText = "helper text".toLabel(),
        ),
        onClick = { },
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "ErrorDropDown",
      value = DropDownButtonData(
        "Dropdown Label".toLabel(),
        placeholder = "DropDown placeholder".toLabel(),
        items = emptyList(),
        initialSelectedItem = null,
        buttonType = DropDownButtonState.Error(
          errorText = "error text".toLabel(),
        ),
        onClick = { },
      ),
    ),
  )
}
