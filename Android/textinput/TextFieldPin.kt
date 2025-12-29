package pl.gov.coi.common.ui.ds.textinput

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.core.text.isDigitsOnly
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
import pl.gov.coi.common.ui.focus.FocusHost
import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

private const val DOT_CHAR = '\u2022'
private const val EMPTY_STRING = ""

@Composable
internal fun TextFieldPin(
  data: TextInputData.Pin,
  focusHost: FocusHost,
  focusManager: FocusManager,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
  ) {
    BasicTextField(
      modifier = Modifier
        .focusHost(focusHost = focusHost),
      value = TextFieldValue(
        text = data.value.text,
        selection = TextRange(data.value.text.length),
      ),
      onValueChange = {
        if (it.text.length <= data.length && it.text.isDigitsOnly()) {
          data.onValueChanged(it.text)
        }
      },
      enabled = data.enabled,
      keyboardOptions = KeyboardOptions(
        keyboardType = data.keyboardType,
        imeAction = data.imeAction,
      ),
      keyboardActions = data.keyboardAction(focusManager),
      decorationBox = {
        Column {
          Row {
            repeat(times = data.length) { index ->
              PinCharField(
                characterIndex = index,
                pinValue = data.value.text,
                isError = data.validationState is ValidationState.Invalid,
                enabled = data.enabled,
              )
              if (index == data.length - 1) return@repeat
              Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing150))
            }
          }
        }
      },
    )
  }
}

@Composable
private fun PinCharField(
  characterIndex: Int,
  pinValue: String,
  isError: Boolean,
  enabled: Boolean,
) {
  val isCharFieldFocused = characterIndex == pinValue.length

  val fieldValue = when {
    characterIndex >= pinValue.length -> EMPTY_STRING
    else -> DOT_CHAR
  }.toString()

  Box(
    modifier = Modifier
      .size(
        width = AppTheme.dimensions.spacing500,
        height = AppTheme.dimensions.spacing600,
      )
      .clip(AppTheme.shapes.radius50)
      .border(
        width = when (isCharFieldFocused) {
          true -> AppTheme.dimensions.spacing25
          else -> AppTheme.dimensions.strokeWidth
        },
        color = when {
          isError -> AppTheme.colors.supportRed100
          isCharFieldFocused -> AppTheme.colors.primary900
          !enabled -> AppTheme.colors.neutral30
          else -> AppTheme.colors.neutral80
        },
        shape = AppTheme.shapes.radius50,
      )
      .background(AppTheme.colors.white),
    contentAlignment = Alignment.Center,
  ) {
    CustomText(
      modifier = Modifier.align(alignment = Alignment.Center),
      label = fieldValue.toLabel(tag = "fieldValue"),
      style = AppTheme.typography.headlineMedium
        .copy(
          color = when (enabled) {
            true -> AppTheme.colors.neutral500
            else -> AppTheme.colors.neutral60
          },
        ),
      textAlign = TextAlign.Center,
    )
  }
}
