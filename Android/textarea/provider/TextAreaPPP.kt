package pl.gov.coi.common.ui.ds.textarea.provider

import pl.gov.coi.common.ui.ds.textarea.CounterState
import pl.gov.coi.common.ui.ds.textarea.TextAreaData
import pl.gov.coi.common.ui.ds.textarea.TextAreaDataState
import pl.gov.coi.common.ui.ds.textarea.TextAreaType
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class TextAreaPPP : CustomPreviewParameterProvider<TextAreaData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<TextAreaData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "FlexibleEmpty",
      value = TextAreaData(
        type = TextAreaType.Flexible(),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
        state = TextAreaDataState.Default(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterAndLabel",
      value = TextAreaData(
        label = "Flexible - WithCounterAndLabel".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 400,
          onCharsLimitReached = {},
        ),
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithLabel",
      value = TextAreaData(
        label = "Flexible - WithLabel".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterLabelAndHelper",
      value = TextAreaData(
        label = "Flexible - WithCounterLabelAndHelper".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterLabelAndHelperDisabled",
      value = TextAreaData(
        label = "Flexible - FlexibleWithCounterLabelAndHelperDisabled".toLabel(),
        type = TextAreaType.Flexible(),
        enabled = false,
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 200,
        ),
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterAndContentDisabled",
      value = TextAreaData(
        label = "Flexible - FlexibleWithCounterAndContentDisabled".toLabel(),
        type = TextAreaType.Flexible(maxLines = 6),
        enabled = false,
        state = TextAreaDataState.Default(),
        counterState = CounterState.Visible(
          maxLength = 255,
        ),
        onValueChanged = {},
        content = "TextArea content",
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterLabelAndInvalid",
      value = TextAreaData(
        label = "Flexible - WithCounterLabelAndInvalid".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 400,
          onCharsLimitReached = {},
        ),
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FixWithCounterLabelAndHelper",
      value = TextAreaData(
        label = "Fix - WithCounterLabelAndHelper".toLabel(),
        type = TextAreaType.Fix(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Fix text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FixEmpty",
      value = TextAreaData(
        label = "Fix - FixEmpty".toLabel(),
        type = TextAreaType.Fix(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Fix text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FixWithCounterLabelAndInvalid",
      value = TextAreaData(
        label = "Fix - WithCounterLabelAndInvalid".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Error(errorLabel = "Invalid Fix".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 400,
          onCharsLimitReached = {},
        ),
        onValueChanged = {},
      ),
    ),
  )
}
