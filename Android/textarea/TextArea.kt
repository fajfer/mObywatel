package pl.gov.coi.common.ui.ds.textarea

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.editableText
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.IntOffset
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.helpertext.HelperText
import pl.gov.coi.common.ui.ds.textarea.provider.TextAreaPPP
import pl.gov.coi.common.ui.focus.FocusHost
import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHostBringIntoView
import pl.gov.coi.common.ui.focus.createFocusHost
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextArea(
  data: TextAreaData,
  focusHost: FocusHost = createFocusHost(),
) {
  var inputFieldCoordinates by remember { mutableStateOf(IntOffset(0, 0)) }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .onGloballyPositioned { coordinates ->
        inputFieldCoordinates = IntOffset(
          x = coordinates.positionInWindow().x.toInt(),
          y = coordinates.positionInWindow().y.toInt(),
        )
      },
  ) {
    data.label?.let { label ->
      CustomText(
        testTag = data.testTag?.let { tag -> tag + "Text" },
        label = label,
        style = AppTheme.typography.bodyMediumRegular,
        color = if (data.enabled) AppTheme.colors.neutral200 else AppTheme.colors.neutral60,
        indexTag = data.indexTag,
        ignoreForAccessibility = true,
      )
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
    }
    Card(
      border = BorderStroke(
        width = getBorderWidth(focusHost),
        color = getCardBorderColor(
          enabled = data.enabled,
          state = data.state,
          isFocused = focusHost.isFocused,
        ),
      ),
      backgroundColor = Color.White,
      elevation = AppTheme.elevations.level0,
    ) {
      BasicTextField(
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Text,
          imeAction = data.imeAction,
        ),
        enabled = data.enabled,
        cursorBrush = getCursorBrushColor(
          state = data.state,
          isFocused = focusHost.isFocused,
        ),
        modifier = Modifier
          .fillMaxWidth()
          .focusHostBringIntoView(focusHost = focusHost)
          .focusHost(focusHost = focusHost)
          .semantics { testTagsAsResourceId = true }
          .semantics {
            contentDescription = data.contentDescription()
            editableText = AnnotatedString(data.content)
            testTag = data.testTag?.let { tag -> tag + "EditText" } ?: data.label?.tag ?: "Undefined"
              .let { tag -> "EditText $tag${data.indexTag?.let { "_${data.indexTag}" } ?: ""}" }
          }
          .semantics {
            if (data.state is TextAreaDataState.Error) {
              liveRegion = LiveRegionMode.Assertive
              stateDescription = data.state.errorLabel.text
            }
          },
        value = data.content,
        onValueChange = { text ->
          data.onValueChanged(text)
          if (data.counterState is CounterState.Visible) {
            data.counterState.onCharsLimitReached(text.length > data.counterState.maxLength)
          }
        },
        minLines = getMinLines(textAreaType = data.type),
        maxLines = getMaxLines(textAreaType = data.type),
        visualTransformation = VisualTransformation.None,
        textStyle = AppTheme.typography.bodyLargeRegular.copy(
          color = if (data.enabled) AppTheme.colors.neutral500 else AppTheme.colors.neutral60,
        ),
        decorationBox = { innerTextField ->
          Column(
            modifier = Modifier.padding(
              all = AppTheme.dimensions.spacing100,
            ),
          ) {
            Box(
              modifier = Modifier.padding(
                all = AppTheme.dimensions.spacing100,
              ),
            ) {
              if (data.content.isEmpty()) {
                CustomText(
                  testTag = data.testTag?.let { tag -> tag + "HintText" },
                  label = data.hint,
                  overflow = TextOverflow.Ellipsis,
                  style = AppTheme.typography.bodyLargeRegular,
                  color = if (data.enabled) AppTheme.colors.neutral100 else AppTheme.colors.neutral60,
                  focusable = false,
                )
              }
              innerTextField()
            }
            if (data.counterState is CounterState.Visible) {
              buildCounter(
                state = data.state,
                enabled = data.enabled,
                contentLength = data.content.length,
                maxLength = data.counterState.maxLength,
              )
            }
          }
        },
      )
    }
    when (data.state) {
      is TextAreaDataState.Default ->
        if (data.state.helperLabel.isNotBlank()) {
          Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
          HelperText(
            testTag = data.testTag?.let { tag -> tag + "HelperText" },
            helperLabel = data.state.helperLabel,
            ignoreForAccessibility = true,
          )
        }

      is TextAreaDataState.Error -> {
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
        ErrorText(
          testTag = data.testTag?.let { tag -> tag + "ErrorText" },
          errorText = data.state.errorLabel,
          ignoreForAccessibility = true,
        )
      }
    }
  }
}

@Composable
private fun getBorderWidth(focusHost: FocusHost) = if (focusHost.isFocused) {
  AppTheme.dimensions.spacing25
} else {
  AppTheme.dimensions.strokeWidth
}

@Composable
private fun getCursorBrushColor(
  state: TextAreaDataState,
  isFocused: Boolean,
) = when (state) {
  is TextAreaDataState.Error -> SolidColor(AppTheme.colors.supportRed100)
  else -> SolidColor(
    value = if (isFocused) {
      AppTheme.colors.primary900
    } else {
      AppTheme.colors.neutral100
    },
  )
}

@Composable
private fun getMinLines(
  textAreaType: TextAreaType,
) = if (textAreaType is TextAreaType.Fix) {
  textAreaType.lines
} else {
  1
}

@Composable
private fun getMaxLines(
  textAreaType: TextAreaType,
) = when (textAreaType) {
  is TextAreaType.Fix -> textAreaType.lines
  is TextAreaType.Flexible -> textAreaType.maxLines
}

@Composable
private fun getCardBorderColor(
  enabled: Boolean,
  state: TextAreaDataState,
  isFocused: Boolean,
) = when {
  enabled.not() -> AppTheme.colors.neutral30
  state is TextAreaDataState.Error -> AppTheme.colors.supportRed100
  isFocused -> AppTheme.colors.primary900
  else -> AppTheme.colors.neutral80
}

@Composable
private fun buildCounter(
  state: TextAreaDataState,
  enabled: Boolean,
  contentLength: Int,
  maxLength: Int,
) {
  val annotatedString = buildAnnotatedString {
    withStyle(
      style = SpanStyle(
        fontStyle = AppTheme.typography.bodySmallRegular.fontStyle,
        fontWeight = when (state) {
          is TextAreaDataState.Error -> FontWeight.Bold
          else -> FontWeight.Normal
        },
        color = when {
          enabled.not() -> AppTheme.colors.neutral60
          state is TextAreaDataState.Error -> AppTheme.colors.supportRed100
          else -> AppTheme.colors.neutral200
        },
      ),
    ) {
      append("$contentLength")
    }
    withStyle(
      style = SpanStyle(
        fontStyle = AppTheme.typography.bodySmallRegular.fontStyle,
        color = if (enabled) AppTheme.colors.neutral200 else AppTheme.colors.neutral60,
      ),
    ) {
      append("/$maxLength")
    }
  }
  Text(
    modifier = Modifier.fillMaxWidth(),
    textAlign = TextAlign.End,
    style = AppTheme.typography.bodySmallRegular,
    text = annotatedString,
  )
}

private fun TextAreaData.contentDescription() =
  (label.textWithDotAndSpaceOrEmpty() +
    (when (state) {
      is TextAreaDataState.Default -> state.helperLabel
      is TextAreaDataState.Error -> state.errorLabel
    }).textWithDotAndSpaceOrEmpty()).trim()

@Preview
@Composable
fun TextAreaPreview(
  @PreviewParameter(TextAreaPPP::class)
  data: TextAreaData,
) {
  Box(modifier = Modifier.background(AppTheme.colors.white)) {
    TextArea(
      data = data,
    )
  }
}
