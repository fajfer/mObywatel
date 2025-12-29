package pl.gov.coi.common.ui.ds.textarea

import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.ImeAction
import pl.gov.coi.common.domain.label.Label

private const val DEFAULT_MIN_LINES = 4

data class TextAreaData(
  val testTag: String? = null,
  val label: Label? = null,
  val type: TextAreaType,
  val indexTag: Int? = null,
  val state: TextAreaDataState,
  val content: String = "",
  val enabled: Boolean = true,
  val counterState: CounterState,
  val hint: Label = Label.EMPTY,
  val imeAction: ImeAction = ImeAction.Done,
  val focusRequester: FocusRequester? = null,
  val onValueChanged: (String) -> Unit,
)

sealed interface CounterState {
  data object Hidden : CounterState
  data class Visible(
    val maxLength: Int,
    val onCharsLimitReached: (Boolean) -> Unit = {},
  ) : CounterState
}

sealed interface TextAreaType {
  data class Fix(
    val lines: Int = DEFAULT_MIN_LINES,
  ) : TextAreaType

  data class Flexible(
    val maxLines: Int = Integer.MAX_VALUE,
  ) : TextAreaType
}

sealed interface TextAreaDataState {
  data class Error(val errorLabel: Label) : TextAreaDataState
  data class Default(val helperLabel: Label = Label.EMPTY) : TextAreaDataState
}
