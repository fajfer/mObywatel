package pl.gov.coi.common.ui.ds.checkbox.group

import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
import pl.gov.coi.common.ui.ds.checkbox.common.model.ClickableTextData
import pl.gov.coi.common.ui.ds.checkbox.group.model.CheckBoxGroupData
import pl.gov.coi.common.ui.ds.checkbox.group.model.CheckBoxHeaderData
import pl.gov.coi.common.ui.ds.link.LinkData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class GroupCheckBoxPPP : CustomPreviewParameterProvider<CheckBoxGroupData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<CheckBoxGroupData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "CheckboxGroup",
      value = CheckBoxGroupData(
        checkboxes = listOf(
          getCheckBoxData(isChecked = true),
          getCheckBoxData(),
        ),
        getCheckBoxHeader(),
        type = CheckBoxType.Default,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckboxesWithErrorText",
      value = CheckBoxGroupData(
        checkboxes = listOf(
          getCheckBoxData(),
          getCheckBoxData(),
        ),
        getCheckBoxHeader(),
        type = CheckBoxType.Error(errorText = "errorText".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckboxesWithHelperText",
      value = CheckBoxGroupData(
        checkboxes = listOf(
          getCheckBoxData(),
          getCheckBoxData(),
        ),
        getCheckBoxHeader(),
        type = CheckBoxType.Helper(helperText = "Helper text".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckboxesUrl",
      value = CheckBoxGroupData(
        checkboxes = listOf(
          getCheckBoxData(isChecked = true),
          getCheckBoxData(
            clickableTextData = ClickableTextData.Link(
              linkData = LinkData(
                label = "urlText".toLabel(),
                url = "url",
                onClick = { url -> println("Checkbox $url clicked") },
                linkType = LinkData.LinkType.WEBSITE,
              ),
            ),
          ),
        ),
        type = CheckBoxType.Default,
        header = getCheckBoxHeader(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckboxesTextButton",
      value = CheckBoxGroupData(
        checkboxes = listOf(
          getCheckBoxData(isChecked = true),
          getCheckBoxData(
            clickableTextData = ClickableTextData.Button(
              buttonData = ButtonTextData(
                label = "text button".toLabel(),
                onClick = {},
              ),
            ),
          ),
        ),
        type = CheckBoxType.Default,
        header = getCheckBoxHeader(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckboxesContentWithError",
      value = CheckBoxGroupData(
        header = getCheckBoxHeader(),
        checkboxes = listOf(
          getCheckBoxData(isChecked = true),
          getCheckBoxData(),
        ),
        type = CheckBoxType.Error(
          errorText = ("Lorem ipsum dolor sit amet, consectetur " +
            "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore " +
            "magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ").toLabel(),
        ),
        contentType = CheckboxContentType.CONTENT_BOX,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckboxesDisabled",
      value = CheckBoxGroupData(
        checkboxes = listOf(
          getCheckBoxData(isChecked = true),
          getCheckBoxData(isChecked = true),
          getCheckBoxData(),
        ),
        header = getCheckBoxHeader(),
        type = CheckBoxType.Error(errorText = "Error text".toLabel()),
        isEnabled = false,
      ),
    ),
  )

  private fun getCheckBoxData(
    isChecked: Boolean = false,
    clickableTextData: ClickableTextData? = null,
  ) = CheckBoxRowData(
    isChecked = isChecked,
    onCheckedChange = {},
    label = "Checkbox label".toLabel(),
    clickableTextData = clickableTextData,
  )

  private fun getCheckBoxHeader() = CheckBoxHeaderData(
    label = "Checkbox group Label".toLabel(),
    onClick = {},
  )
}
