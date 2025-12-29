package pl.gov.coi.common.ui.ds.inputdatetime.provider

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.inputdatetime.InputDateTimeData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class InputDateTimePreviewParameterProvider : CustomPreviewParameterProvider<InputDateTimeData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<InputDateTimeData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "InputDateEnabledPlaceholder",
      value = provideInputDateEnabledPlaceholderPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateEnabledSelectedDate",
      value = provideInputDateEnabledSelectedDatePreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateErrorPlaceholder",
      value = provideInputDateErrorPlaceholderPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateErrorSelectedDate",
      value = provideInputDateErrorSelectedDatePreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateErrorLongMessage",
      value = provideInputDateErrorLongMessagePreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateDisabledPlaceholder",
      value = provideInputDateDisabledPlaceholderPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateDisabledSelectedDate",
      value = provideInputDateDisabledSelectedDatePreviewData(),
    ),
  )
}

fun provideInputDateEnabledPlaceholderPreviewData() =
  InputDateTimeData(
    label = "Label".toLabel(""),
    helperText = "Helper text.".toLabel(""),
    type = InputDateTimeData.Type.Date,
    onClick = {},
  )

fun provideInputDateEnabledSelectedDatePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    onClick = {},
  )

fun provideInputDateErrorPlaceholderPreviewData() =
  InputDateTimeData(
    label = "Label".toLabel(""),
    helperText = "Helper text.".toLabel(""),
    type = InputDateTimeData.Type.Date,
    validationState = ValidationState.Invalid(
      message = "Error text.".toLabel(""),
    ),
    onClick = {},
  )

fun provideInputDateErrorSelectedDatePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    validationState = ValidationState.Invalid(
      message = "Error text.".toLabel(""),
    ),
    onClick = {},
  )

fun provideInputDateErrorLongMessagePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    validationState = ValidationState.Invalid(
      message = ("Podczas walidacji tekst pomocniczy zostaje zastąpiony tekstem błędu (komponent validation error). " +
        "Validation error dla komunikatu o długości powyżej jednej linii.").toLabel(""),
    ),
    onClick = {},
  )

fun provideInputDateDisabledPlaceholderPreviewData() =
  InputDateTimeData(
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    enabled = false,
    onClick = {},
  )

fun provideInputDateDisabledSelectedDatePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    enabled = false,
    onClick = {},
  )
