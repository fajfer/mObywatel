package pl.gov.coi.common.ui.ds.checkbox.single

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
import pl.gov.coi.common.ui.ds.checkbox.common.model.ClickableTextData
import pl.gov.coi.common.ui.ds.checkbox.single.model.CheckBoxSingleData
import pl.gov.coi.common.ui.ds.link.LinkData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class CheckBoxSinglePPP : CustomPreviewParameterProvider<CheckBoxSingleData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<CheckBoxSingleData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "Default",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(),
        type = CheckBoxType.Default,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "HelperText",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(isChecked = true),
        type = CheckBoxType.Helper(helperText = "helper text".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "ErrorText",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(isChecked = true),
        type = CheckBoxType.Error(errorText = "error text".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "Disabled",
      value = CheckBoxSingleData(
        isEnabled = false,
        checkbox = getCheckBoxData(isChecked = true),
        type = CheckBoxType.Error(errorText = "error text".toLabel()),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "ContentBox",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(),
        type = CheckBoxType.Helper(helperText = "helper text".toLabel()),
        contentType = CheckboxContentType.CONTENT_BOX,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "Url",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(
          clickableTextData = ClickableTextData.Link(
            linkData = LinkData(
              label = "urlText".toLabel(),
              url = "url",
              linkType = LinkData.LinkType.WEBSITE,
              onClick = { url -> println("Checkbox $url clicked") },
            ),
          ),
        ),
        contentType = CheckboxContentType.CONTENT_BOX,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "CheckBoxTextButton",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(
          clickableTextData = ClickableTextData.Button(
            buttonData = ButtonTextData(
              label = "textButton".toLabel(),
              onClick = { println("buttonText clicked") },
            ),
          ),
        ),
        contentType = CheckboxContentType.CONTENT_BOX,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "UrlWithError",
      value = CheckBoxSingleData(
        checkbox = getCheckBoxData(
          clickableTextData = ClickableTextData.Link(
            linkData = LinkData(
              label = "urlText".toLabel(),
              url = "url",
              linkType = LinkData.LinkType.WEBSITE,
              onClick = { url -> println("Checkbox $url clicked") },
            ),
          ),
        ),
        type = CheckBoxType.Error(errorText = "error text".toLabel()),
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
}
