package pl.gov.coi.common.ui.ds.switchcomponent.provider

import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.link.LinkData
import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
import pl.gov.coi.common.ui.ds.switchcomponent.SwitchExtraType
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SwitchPreviewParameterProvider : CustomPreviewParameterProvider<SwitchData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<SwitchData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SwitchEnabledStateOFF",
      value = SwitchData.SwitchOnly(
        checked = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchEnabledStateON",
      value = SwitchData.SwitchOnly(
        checked = true,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchDisabledStateOFF",
      value = SwitchData.SwitchOnly(
        enabled = false,
        checked = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchDisabledStateON",
      value = SwitchData.SwitchOnly(
        checked = true,
        enabled = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithShortText",
      value = SwitchData.SwitchWithText(
        label = "Krótka  treść".toLabel(),
        checked = false,
        onCheckedChange = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithLongTextInvalid",
      value = SwitchData.SwitchWithText(
        label = "Switch component longer description, Lorem ipsum dolor sit amet, consectetur adipiscing elit"
          .toLabel(),
        onCheckedChange = {},
        checked = false,
        validationState = ValidationState.Invalid(
          message = "Komunikat walidacyjny".toLabel(),
        ),
      ),
    ),

    ScreenShotTestData(
      screenShotTestName = "SwitchWithLink",
      value = SwitchData.SwitchWithExtras(
        checked = true,
        enabled = true,
        onCheckedChange = { },
        label = "Switch with link".toLabel(),
        customActionContentDescription = "Pobierz Switch with link".toLabel(),
        type = SwitchExtraType.Link(
          data = LinkData(
            label = "Link".toLabel(),
            linkType = LinkData.LinkType.WEBSITE,
            url = "",
            onClick = {},
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithButtonText",
      value = SwitchData.SwitchWithExtras(
        checked = true,
        enabled = true,
        onCheckedChange = { },
        label = "Switch with text button".toLabel(),
        customActionContentDescription = "Zobacz".toLabel(),
        type = SwitchExtraType.TextButton(
          data = ButtonTextData(
            label = "button text label".toLabel(),
            onClick = {},
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SwitchWithLinkInvalid",
      value = SwitchData.SwitchWithExtras(
        checked = true,
        enabled = true,
        onCheckedChange = { },
        label = "Switch with link".toLabel(),
        type = SwitchExtraType.Link(
          data = LinkData(
            label = "Link".toLabel(),
            linkType = LinkData.LinkType.EXTERNAL_APP,
            url = "",
            onClick = {},
          ),
        ),
        validationState = ValidationState.Invalid(
          message = "Komunikat walidacyjny".toLabel(),
        ),
        customActionContentDescription = "Pobierz Switch with link".toLabel(),
      ),
    ),
  )
}
