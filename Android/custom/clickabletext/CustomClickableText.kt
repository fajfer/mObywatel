package pl.gov.coi.common.ui.ds.custom.clickabletext

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.get
import pl.gov.coi.common.ui.utils.semanticsContentDescription


@Composable
@Deprecated(message = "For external redirections use Link. For internal redirections use ButtonText")
fun CustomClickableText(
  annotatedText: AnnotatedString,
  style: TextStyle = TextStyle.Default,
  softWrap: Boolean = true,
  overflow: TextOverflow = TextOverflow.Clip,
  maxLines: Int = Int.MAX_VALUE,
  onTextLayout: (TextLayoutResult) -> Unit = {},
  semanticsData: SemanticsData = SemanticsData(),
  onClick: (String) -> Unit,
) {
  val focusManager = LocalFocusManager.current
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }

  ClickableText(
    modifier = Modifier
      .semantics {
        role = Role.Button
        onClick { false }
      }
      .semantics(
        mergeDescendants = semanticsData.mergeDescendants,
        properties = semanticsData.semanticsProperties,
      )
      .semanticsContentDescription(
        semanticsData.semanticsContentDescription ?: annotatedText.text,
      ),
    text = annotatedText,
    style = style,
    softWrap = softWrap,
    overflow = overflow,
    maxLines = maxLines,
    onTextLayout = onTextLayout,
    onClick = { offset ->
      multipleEventsCutter.processEvent {
        annotatedText.getStringAnnotations(
          start = offset,
          end = offset,
        )
          .firstOrNull()
          ?.let { annotation ->
            onClick(annotation.item)
          }
        focusManager.clearFocus(force = true)
      }
    },
  )
}
