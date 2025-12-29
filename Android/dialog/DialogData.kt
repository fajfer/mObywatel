package pl.gov.coi.common.ui.ds.dialog

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.ButtonData

sealed class DialogData(
  open val testTag: String?,
  open val title: Label,
  open val body: Label? = null,
  open val annotatedBody: (@Composable () -> AnnotatedString)? = null,
  open val primaryButtonData: ButtonData,
  open val secondaryButtonData: ButtonData? = null,
  internal val horizontalAlignment: Alignment.Horizontal = Alignment.Start,
  internal val textAlign: TextAlign = TextAlign.Start,
  open val onDismiss: () -> Unit,
) {
  data class WithThreeButtons(
    override val testTag: String? = null,
    override val title: Label,
    override val body: Label? = null,
    override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
    override val primaryButtonData: ButtonData,
    override val secondaryButtonData: ButtonData,
    val tertiaryButtonData: ButtonData,
    override val onDismiss: () -> Unit,
  ) : DialogData(
    testTag = testTag,
    title = title,
    body = body,
    annotatedBody = annotatedBody,
    primaryButtonData = primaryButtonData,
    secondaryButtonData = secondaryButtonData,
    onDismiss = onDismiss,
    horizontalAlignment = Alignment.Start,
    textAlign = TextAlign.Start,
  )

  data class WithText(
    override val testTag: String? = null,
    override val title: Label,
    override val body: Label? = null,
    override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
    override val primaryButtonData: ButtonData,
    override val secondaryButtonData: ButtonData? = null,
    override val onDismiss: () -> Unit,
  ) : DialogData(
    testTag = testTag,
    title = title,
    body = body,
    annotatedBody = annotatedBody,
    primaryButtonData = primaryButtonData,
    secondaryButtonData = secondaryButtonData,
    onDismiss = onDismiss,
    horizontalAlignment = Alignment.Start,
    textAlign = TextAlign.Start,
  )

  data class WithIcon(
    override val testTag: String? = null,
    override val title: Label,
    override val body: Label? = null,
    override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
    override val primaryButtonData: ButtonData,
    override val secondaryButtonData: ButtonData? = null,
    val icon: DialogIconData,
    override val onDismiss: () -> Unit,
  ) : DialogData(
    testTag = testTag,
    title = title,
    body = body,
    annotatedBody = annotatedBody,
    primaryButtonData = primaryButtonData,
    secondaryButtonData = secondaryButtonData,
    onDismiss = onDismiss,
    horizontalAlignment = Alignment.CenterHorizontally,
    textAlign = TextAlign.Center,
  )
}

data class DialogIconData(
  @DrawableRes val iconResId: Int,
  val iconColorProvider: @Composable () -> Color,
)
