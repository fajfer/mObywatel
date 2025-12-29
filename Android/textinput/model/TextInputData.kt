package pl.gov.coi.common.ui.ds.textinput.model

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.textinput.visualtransformation.MaskType

sealed class TextInputData(
  open val testTag: String?,
  open val label: Label?,
  open val value: Label = Label.EMPTY,
  open val hint: Label?,
  open val validationState: ValidationState,
  open val helperText: Label?,
  open val infoButtonData: ButtonTextData?,
  open val onValueChanged: (String) -> Unit,
  open val enabled: Boolean,
  open val imeAction: ImeAction,
  open val keyboardAction: (FocusManager) -> KeyboardActions,
  open val singleLine: Boolean,
  open val textAlign: TextAlign? = null,
  open val removableIconVisible: Boolean,
  open val indexTag: Int? = null,
) {

  abstract val keyboardType: KeyboardType

  data class Text(
    override val testTag: String? = null,
    override val label: Label? = null,
    override val hint: Label? = null,
    override val value: Label,
    override val validationState: ValidationState = ValidationState.Default,
    override val helperText: Label? = null,
    override val infoButtonData: ButtonTextData? = null,
    override val onValueChanged: (String) -> Unit,
    override val enabled: Boolean = true,
    override val imeAction: ImeAction = ImeAction.Done,
    override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
    override val singleLine: Boolean = true,
    override val textAlign: TextAlign? = null,
    override val removableIconVisible: Boolean = true,
    override val indexTag: Int? = null,
  ) : TextInputData(
    testTag = testTag,
    label = label,
    value = value,
    hint = hint,
    validationState = validationState,
    helperText = helperText,
    infoButtonData = infoButtonData,
    onValueChanged = onValueChanged,
    enabled = enabled,
    imeAction = imeAction,
    singleLine = singleLine,
    textAlign = textAlign,
    removableIconVisible = removableIconVisible,
    indexTag = indexTag,
    keyboardAction = keyboardAction,
  ) {
    override val keyboardType: KeyboardType = KeyboardType.Text
  }

  data class Number(
    override val testTag: String? = null,
    override val label: Label? = null,
    override val hint: Label? = null,
    override val value: Label,
    override val validationState: ValidationState = ValidationState.Default,
    override val helperText: Label? = null,
    override val infoButtonData: ButtonTextData? = null,
    override val onValueChanged: (String) -> Unit,
    override val enabled: Boolean = true,
    override val imeAction: ImeAction = ImeAction.Done,
    override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
    override val singleLine: Boolean = true,
    override val textAlign: TextAlign? = null,
    override val removableIconVisible: Boolean = true,
    override val indexTag: Int? = null,
    val isPhoneNumberPrefix: Boolean = false,
  ) : TextInputData(
    testTag = testTag,
    label = label,
    value = value,
    hint = hint,
    validationState = validationState,
    helperText = helperText,
    infoButtonData = infoButtonData,
    onValueChanged = onValueChanged,
    enabled = enabled,
    imeAction = imeAction,
    singleLine = singleLine,
    textAlign = textAlign,
    removableIconVisible = removableIconVisible,
    indexTag = indexTag,
    keyboardAction = keyboardAction,
  ) {
    override val keyboardType: KeyboardType = when (isPhoneNumberPrefix) {
      true -> KeyboardType.Phone
      false -> KeyboardType.Number
    }
  }

  data class Password(
    override val testTag: String? = null,
    override val label: Label? = null,
    override val hint: Label? = null,
    override val value: Label,
    override val validationState: ValidationState = ValidationState.Default,
    override val helperText: Label? = null,
    override val infoButtonData: ButtonTextData? = null,
    override val onValueChanged: (String) -> Unit,
    override val enabled: Boolean = true,
    override val imeAction: ImeAction = ImeAction.Done,
    override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
    override val singleLine: Boolean = true,
    override val textAlign: TextAlign? = null,
    override val removableIconVisible: Boolean = false,
    override val keyboardType: KeyboardType = KeyboardType.Password,
    val iconContentDescription: IconContentDescription = IconContentDescription(),
    val onPasswordVisibilityChanged: (Boolean) -> Unit = {},
  ) : TextInputData(
    testTag = testTag,
    label = label,
    value = value,
    hint = hint,
    validationState = validationState,
    helperText = helperText,
    infoButtonData = infoButtonData,
    onValueChanged = onValueChanged,
    enabled = enabled,
    imeAction = imeAction,
    singleLine = singleLine,
    textAlign = textAlign,
    removableIconVisible = removableIconVisible,
    keyboardAction = keyboardAction,
  ) {
    data class IconContentDescription(
      val whenPasswordVisible: Label = CommonUILabelProvider.inputIconHidePasswordLabel(),
      val whenPasswordHidden: Label = CommonUILabelProvider.inputIconShowPasswordLabel(),
    )
  }

  data class Search(
    override val testTag: String? = null,
    override val label: Label? = null,
    override val hint: Label? = null,
    override val value: Label,
    override val validationState: ValidationState = ValidationState.Default,
    override val helperText: Label? = null,
    override val infoButtonData: ButtonTextData? = null,
    override val onValueChanged: (String) -> Unit,
    override val enabled: Boolean = true,
    override val imeAction: ImeAction = ImeAction.Done,
    override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
    override val singleLine: Boolean = true,
    override val textAlign: TextAlign? = null,
    override val removableIconVisible: Boolean = false,
    override val indexTag: Int? = null,
  ) : TextInputData(
    testTag = testTag,
    label = label,
    value = value,
    hint = hint,
    validationState = validationState,
    helperText = helperText,
    infoButtonData = infoButtonData,
    onValueChanged = onValueChanged,
    enabled = enabled,
    imeAction = imeAction,
    singleLine = singleLine,
    textAlign = textAlign,
    removableIconVisible = removableIconVisible,
    indexTag = indexTag,
    keyboardAction = keyboardAction,
  ) {
    override val keyboardType: KeyboardType = KeyboardType.Text
  }

  data class Pin(
    override val testTag: String? = null,
    override val label: Label? = null,
    override val value: Label,
    override val validationState: ValidationState = ValidationState.Default,
    override val helperText: Label? = null,
    override val infoButtonData: ButtonTextData? = null,
    override val onValueChanged: (String) -> Unit,
    override val enabled: Boolean = true,
    override val imeAction: ImeAction = ImeAction.Done,
    override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
    override val singleLine: Boolean = true,
    override val textAlign: TextAlign? = null,
    override val removableIconVisible: Boolean = false,
    val length: Int = PIN_LENGTH_DEFAULT_VALUE,
  ) : TextInputData(
    testTag = testTag,
    label = label,
    value = value,
    hint = null,
    validationState = validationState,
    helperText = helperText,
    infoButtonData = infoButtonData,
    onValueChanged = onValueChanged,
    enabled = enabled,
    imeAction = imeAction,
    singleLine = singleLine,
    textAlign = textAlign,
    removableIconVisible = removableIconVisible,
    keyboardAction = keyboardAction,
  ) {
    override val keyboardType: KeyboardType = KeyboardType.NumberPassword
  }

  data class Masked(
    override val testTag: String? = null,
    override val label: Label? = null,
    override val value: Label,
    override val hint: Label? = null,
    override val validationState: ValidationState = ValidationState.Default,
    override val helperText: Label? = null,
    override val infoButtonData: ButtonTextData? = null,
    override val onValueChanged: (String) -> Unit,
    override val enabled: Boolean = true,
    override val imeAction: ImeAction = ImeAction.Done,
    override val keyboardAction: (FocusManager) -> KeyboardActions = { KeyboardActions.Default },
    override val singleLine: Boolean = true,
    override val textAlign: TextAlign? = null,
    override val removableIconVisible: Boolean = true,
    override val indexTag: Int? = null,
    val maskType: MaskType,
    override val keyboardType: KeyboardType = KeyboardType.Text,
  ) : TextInputData(
    testTag = testTag,
    label = label,
    value = value,
    hint = null,
    validationState = validationState,
    helperText = helperText,
    infoButtonData = infoButtonData,
    onValueChanged = onValueChanged,
    enabled = enabled,
    imeAction = imeAction,
    singleLine = singleLine,
    textAlign = textAlign,
    removableIconVisible = removableIconVisible,
    indexTag = indexTag,
    keyboardAction = keyboardAction,
  )

  data class PhoneNumber(
    override val testTag: String? = null,
    override val label: Label?,
    override val validationState: ValidationState = ValidationState.Default,
    val countryCodeValue: Label?,
    val phoneNumberValue: Label?,
    val onCountryCodeChanged: (String) -> Unit,
    val onPhoneNumberChanged: (String) -> Unit,
    val isCountryCodeCorrect: Boolean? = null,
    val isPhoneNumberCorrect: Boolean? = null,
    val countryCodeTextAlign: TextAlign = TextAlign.Center,
    val phoneNumberTextAlign: TextAlign? = null,
    override val imeAction: ImeAction = ImeAction.Done,
    override val indexTag: Int? = null,
  ) : TextInputData(
    testTag = testTag,
    label = label,
    value = Label.EMPTY,
    hint = null,
    validationState = validationState,
    helperText = null,
    infoButtonData = null,
    onValueChanged = {},
    enabled = true,
    imeAction = imeAction,
    singleLine = true,
    textAlign = null,
    removableIconVisible = false,
    keyboardAction = { KeyboardActions.Default },
  ) {
    override val keyboardType: KeyboardType = KeyboardType.Phone

    val countryCodeNumber = Number(
      testTag = testTag?.let { tag -> tag + "CountryCodeText" },
      label = label?.addToTag(addStringToTag = COUNTRY_CODE_SUFFIX),
      indexTag = indexTag,
      hint = null,
      value = countryCodeValue ?: Label.EMPTY,
      onValueChanged = onCountryCodeChanged,
      validationState = when (isCountryCodeCorrect) {
        true -> ValidationState.Valid
        false -> ValidationState.Invalid(message = Label.EMPTY)
        null -> ValidationState.Default
      },
      isPhoneNumberPrefix = true,
      removableIconVisible = false,
      textAlign = countryCodeTextAlign,
      imeAction = ImeAction.Next,
    )

    val phoneNumber = Number(
      testTag = testTag?.let { tag -> tag + "PhoneNumberText" },
      label = label?.addToTag(addStringToTag = PHONE_NUMBER_SUFFIX),
      indexTag = indexTag,
      value = phoneNumberValue ?: Label.EMPTY,
      onValueChanged = onPhoneNumberChanged,
      validationState = when (isPhoneNumberCorrect) {
        true -> ValidationState.Valid
        false -> ValidationState.Invalid(message = Label.EMPTY)
        null -> ValidationState.Default
      },
      textAlign = phoneNumberTextAlign,
      imeAction = imeAction,
    )
  }
}

private const val PIN_LENGTH_DEFAULT_VALUE = 4
private const val COUNTRY_CODE_SUFFIX = "_CountryCode"
private const val PHONE_NUMBER_SUFFIX = "_PhoneNumber"
