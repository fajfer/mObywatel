package pl.gov.coi.common.ui.ds.textinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.helpertext.HelperText
import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
import pl.gov.coi.common.ui.ds.textinput.provider.TextInputPreviewParameterProvider
import pl.gov.coi.common.ui.focus.FocusHost
import pl.gov.coi.common.ui.focus.createFocusHost
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun TextInput(
  data: TextInputData,
  focusHost: FocusHost = createFocusHost(),
) {
  val focusManager = LocalFocusManager.current
  Column(
    modifier = Modifier
      .wrapContentHeight()
      .semantics {
        if (data.validationState is ValidationState.Invalid) {
          liveRegion = LiveRegionMode.Assertive
          stateDescription = (data.validationState as ValidationState.Invalid).message.text
        }
      },
  ) {
    data.label?.let { label ->
      CustomText(
        testTag = data.testTag?.let { tag -> tag + "Text" },
        ignoreForAccessibility = true,
        label = label,
        style = AppTheme.typography.bodyMediumRegular,
        color = when (data.enabled) {
          true -> AppTheme.colors.neutral200
          else -> AppTheme.colors.neutral60
        },
      )
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
    }

    when (data) {
      is TextInputData.Pin -> TextFieldPin(
        data = data,
        focusHost = focusHost,
        focusManager = focusManager,
      )
      is TextInputData.PhoneNumber -> TextFieldPhoneNumber(
        data = data,
        focusHost = focusHost,
        focusManager = focusManager,
      )
      else -> TextField(
        data = data,
        focusHost = focusHost,
        focusManager = focusManager,
      )
    }

    when (val validationState = data.validationState) {
      is ValidationState.Invalid -> {
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
        ErrorText(
          testTag = data.testTag?.let { tag -> tag + "ErrorText" },
          errorText = validationState.message,
          ignoreForAccessibility = true,
        )
      }
      else -> data.helperText?.let { helperText ->
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
        HelperText(
          testTag = data.testTag?.let { tag -> tag + "HelperText" },
          helperLabel = helperText,
          ignoreForAccessibility = true,
        )
      }
    }

    data.infoButtonData?.let { infoButtonData ->
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
      ButtonText(data = infoButtonData)
    }
  }
}

@Preview
@Composable
fun TextInputPreview(@PreviewParameter(TextInputPreviewParameterProvider::class) data: TextInputData) {
  TextInput(data = data)
}
