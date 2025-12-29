package pl.gov.coi.common.ui.ds.textinput.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class TextInputPreviewParameterProvider : CustomPreviewParameterProvider<TextInputData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<TextInputData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "TextInputText",
      value = provideTextInputText(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputTextWithOptionals",
      value = provideTextInputTextWithOptionals(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputTextError",
      value = provideTextInputTextError(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputTextDisabled",
      value = provideTextInputTextDisabled(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputNumber",
      value = provideTextInputNumber(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPassword",
      value = provideTextInputPassword(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputSearch",
      value = provideTextInputSearch(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPin",
      value = provideTextInputPin(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPinError",
      value = provideTextInputPinError(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPinDisabled",
      value = provideTextInputPinDisabled(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPhoneNumberFilled",
      value = provideTextInputPhoneNumberFilled(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPhoneNumberInvalidNumber",
      value = provideTextInputPhoneNumberInvalidNumber(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPhoneNumberInvalidPrefix",
      value = provideTextInputPhoneNumberInvalidCountryCode(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputPhoneNumberLong",
      value = provideTextInputPhoneNumberLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "TextInputSearchLong",
      value = provideTextInputSearchLong(),
    ),
  )

  private fun provideTextInputText() = TextInputData.Text(
    label = "Etykieta".toLabel(),
    value = Label.EMPTY,
    onValueChanged = {},
  )

  private fun provideTextInputTextWithOptionals() = TextInputData.Text(
    label = "Etykieta".toLabel(),
    hint = "Tekst zastępczy (hint)".toLabel(),
    value = Label.EMPTY,
    helperText = "Tekst pomocniczy (helper text)".toLabel(),
    infoButtonData = ButtonTextData(
      label = "Info button".toLabel(),
      onClick = {},
    ),
    onValueChanged = {},
  )

  private fun provideTextInputTextError() = TextInputData.Text(
    label = "Etykieta".toLabel(),
    hint = "Tekst zastępczy (hint)".toLabel(),
    value = Label.EMPTY,
    validationState = ValidationState.Invalid(
      message = "Tekst błędu".toLabel(),
    ),
    helperText = null,
    infoButtonData = null,
    onValueChanged = {},
  )

  private fun provideTextInputTextDisabled() = TextInputData.Text(
    label = "Etykieta".toLabel(),
    hint = "Tekst zastępczy (hint)".toLabel(),
    value = Label.EMPTY,
    helperText = "Tekst pomocniczy (helper text)".toLabel(),
    infoButtonData = null,
    enabled = false,
    onValueChanged = {},
  )

  private fun provideTextInputNumber() = TextInputData.Number(
    label = "Etykieta".toLabel(),
    hint = "Tekst zastępczy (hint)".toLabel(),
    value = "1234".toLabel(),
    onValueChanged = {},
  )

  private fun provideTextInputPassword() = TextInputData.Password(
    label = "Hasło".toLabel(),
    value = "123".toLabel(),
    onValueChanged = {},
  )

  private fun provideTextInputSearch() = TextInputData.Search(
    hint = "Wyszukaj (hint)".toLabel(),
    value = Label.EMPTY,
    onValueChanged = {},
  )

  private fun provideTextInputPin() = TextInputData.Pin(
    label = "Etykieta".toLabel(),
    value = "123".toLabel(),
    onValueChanged = {},
  )

  private fun provideTextInputPinError() = TextInputData.Pin(
    label = "Etykieta".toLabel(),
    value = "1234".toLabel(),
    validationState = ValidationState.Invalid(
      message = "Tekst błędu".toLabel(),
    ),
    onValueChanged = {},
  )

  private fun provideTextInputPinDisabled() = TextInputData.Pin(
    label = "Etykieta".toLabel(),
    value = "1234".toLabel(),
    enabled = false,
    onValueChanged = {},
  )

  private fun provideTextInputPhoneNumberFilled() = TextInputData.PhoneNumber(
    label = "Numer telefonu".toLabel(),
    countryCodeValue = "+48".toLabel(),
    phoneNumberValue = "123456789".toLabel(),
    onCountryCodeChanged = {},
    onPhoneNumberChanged = {},
    isCountryCodeCorrect = null,
    isPhoneNumberCorrect = null,
    validationState = ValidationState.Default,
  )

  private fun provideTextInputPhoneNumberInvalidNumber() = TextInputData.PhoneNumber(
    label = "Numer telefonu".toLabel(),
    countryCodeValue = "+48".toLabel(),
    phoneNumberValue = "12345".toLabel(),
    onCountryCodeChanged = {},
    onPhoneNumberChanged = {},
    isCountryCodeCorrect = null,
    isPhoneNumberCorrect = false,
    validationState = ValidationState.Invalid(message = "Niepoprawny numer".toLabel()),
  )

  private fun provideTextInputPhoneNumberInvalidCountryCode() = TextInputData.PhoneNumber(
    label = "Numer telefonu".toLabel(),
    countryCodeValue = "+48".toLabel(),
    phoneNumberValue = "12345".toLabel(),
    onCountryCodeChanged = {},
    onPhoneNumberChanged = {},
    isCountryCodeCorrect = false,
    isPhoneNumberCorrect = true,
    validationState = ValidationState.Invalid(message = "Niepoprawny prefix".toLabel()),
  )

  private fun provideTextInputPhoneNumberLong() = TextInputData.PhoneNumber(
    label = "Numer telefonu".toLabel(),
    countryCodeValue = "+48".toLabel(),
    phoneNumberValue = "123456789123456789123456789".toLabel(),
    onCountryCodeChanged = {},
    onPhoneNumberChanged = {},
    isCountryCodeCorrect = null,
    isPhoneNumberCorrect = null,
    validationState = ValidationState.Default,
  )

  private fun provideTextInputSearchLong() = TextInputData.Search(
    hint = "Wyszukaj (hint)".toLabel(),
    value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.".toLabel(),
    onValueChanged = {},
  )
}
