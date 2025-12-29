package pl.gov.coi.common.ui.ds.alert.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.alert.AlertButtonData
import pl.gov.coi.common.ui.ds.alert.AlertData
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.link.LinkData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class AlertPreviewParameterProvider : CustomPreviewParameterProvider<AlertData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<AlertData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "AlertInfoDescr",
      value = provideAlertInfoOnlyDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertInfoTitleDescr",
      value = provideAlertInfoTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertInfoDescrTextBtn",
      value = provideAlertInfoDescriptionTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertInfoDescrLink",
      value = provideAlertInfoDescriptionLink(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertInfoTitleDescrTextBtn",
      value = provideAlertInfoTitleDescrTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertInfoDescrTextBtnCloseBtn",
      value = provideAlertInfoDescrTextBtnCloseBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertInfoFull",
      value = provideAlertInfoFull(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertErrorDescr",
      value = provideAlertErrorOnlyDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertErrorTitleDescr",
      value = provideAlertErrorTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertErrorDescrTextBtn",
      value = provideAlertErrorDescriptionTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertErrorDescrLink",
      value = provideAlertErrorDescriptionLink(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertErrorTitleDescrTextBtn",
      value = provideAlertErrorTitleDescrTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertErrorDescrTextBtnCloseBtn",
      value = provideAlertErrorDescrTextBtnCloseBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertErrorFull",
      value = provideAlertErrorFull(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertWarningDescr",
      value = provideAlertWarningOnlyDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertWarningTitleDescr",
      value = provideAlertWarningTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertWarningDescrTextBtn",
      value = provideAlertWarningDescriptionTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertWarningDescrLink",
      value = provideAlertWarningDescriptionLink(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertWarningTitleDescrTextBtn",
      value = provideAlertWarningTitleDescrTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertWarningDescrTextBtnCloseBtn",
      value = provideAlertWarningDescrTextBtnCloseBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertWarningFull",
      value = provideAlertWarningFull(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertSuccessDescr",
      value = provideAlertSuccessOnlyDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertSuccessTitleDescr",
      value = provideAlertSuccessTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertSuccessDescrTextBtn",
      value = provideAlertSuccessDescriptionTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertSuccessDescrLink",
      value = provideAlertSuccessDescriptionLink(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertSuccessTitleDescrTextBtn",
      value = provideAlertSuccessTitleDescrTextBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertSuccessDescrTextBtnCloseBtn",
      value = provideAlertSuccessDescrTextBtnCloseBtn(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AlertSuccessFull",
      value = provideAlertSuccessFull(),
    ),
  )

  private fun provideAlertInfoOnlyDescription() = AlertData.Info(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertInfoTitleDescription() = AlertData.Info(
    title = "Info alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertInfoDescriptionTextBtn() = AlertData.Info(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
      ) {},
    ),
  )

  private fun provideAlertInfoDescriptionLink() = AlertData.Info(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.Link(
      data = LinkData(
        label = "Link".toLabel(),
        url = "",
        linkType = LinkData.LinkType.WEBSITE,
        onClick = {},
      ),
    ),
  )

  private fun provideAlertInfoTitleDescrTextBtn() = AlertData.Info(
    title = "Info alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
      ) {},
    ),
  )

  private fun provideAlertInfoDescrTextBtnCloseBtn() = AlertData.Info(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertInfoFull() = AlertData.Info(
    title = "Info alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertErrorOnlyDescription() = AlertData.Error(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertErrorTitleDescription() = AlertData.Error(
    title = "Error alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertErrorDescriptionTextBtn() = AlertData.Error(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertErrorDescriptionLink() = AlertData.Error(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.Link(
      data = LinkData(
        label = "Link".toLabel(),
        url = "",
        linkType = LinkData.LinkType.WEBSITE,
        onClick = {},
      ),
    ),
  )

  private fun provideAlertErrorTitleDescrTextBtn() = AlertData.Error(
    title = "Error alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertErrorDescrTextBtnCloseBtn() = AlertData.Error(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertErrorFull() = AlertData.Error(
    title = "Error alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertWarningOnlyDescription() = AlertData.Warning(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertWarningTitleDescription() = AlertData.Warning(
    title = "Warning alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertWarningDescriptionTextBtn() = AlertData.Warning(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertWarningDescriptionLink() = AlertData.Warning(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.Link(
      data = LinkData(
        label = "Link".toLabel(),
        url = "",
        linkType = LinkData.LinkType.WEBSITE,
        onClick = {},
      ),
    ),
  )

  private fun provideAlertWarningTitleDescrTextBtn() = AlertData.Warning(
    title = "Warning alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertWarningDescrTextBtnCloseBtn() = AlertData.Warning(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertWarningFull() = AlertData.Warning(
    title = "Warning alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertSuccessOnlyDescription() = AlertData.Success(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertSuccessTitleDescription() = AlertData.Success(
    title = "Success alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
  )

  private fun provideAlertSuccessDescriptionTextBtn() = AlertData.Success(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertSuccessDescriptionLink() = AlertData.Success(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.Link(
      data = LinkData(
        label = "Link".toLabel(),
        url = "",
        linkType = LinkData.LinkType.WEBSITE,
        onClick = {},
      ),
    ),
  )

  private fun provideAlertSuccessTitleDescrTextBtn() = AlertData.Success(
    title = "Success alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertSuccessDescrTextBtnCloseBtn() = AlertData.Success(
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun provideAlertSuccessFull() = AlertData.Success(
    title = "Success alert".toLabel(),
    bodyText = (
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
        "incididunt ut labore."
      ).toLabel(),
    alertContentDescription = Label.EMPTY,
    onCloseButtonClick = {},
    alertButtonData = AlertButtonData.ButtonText(
      data = ButtonTextData(
        label = "Text button".toLabel(),
        onClick = {},
      ),
    ),
  )
}
