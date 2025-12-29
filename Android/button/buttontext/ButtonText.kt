package pl.gov.coi.common.ui.ds.button.buttontext

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.button.common.ButtonState
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.get

@Composable
fun ButtonText(
  modifier: Modifier = Modifier,
  data: ButtonTextData,
) {
  val focusManager = LocalFocusManager.current
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }
  val textColor = when (data.buttonState) {
    ButtonState.Enabled -> AppTheme.colors.primary900
    ButtonState.Destructive -> AppTheme.colors.supportRed100
    ButtonState.Disabled -> AppTheme.colors.neutral60
  }
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
      .heightIn(min = AppTheme.dimensions.spacing250)
      .semantics {
        testTag = data.testTag ?: "button${data.label.tag}"
        role = Role.Button
      }
      .clickable(
        interactionSource = NoRippleInteractionSource(),
        indication = null,
        onClick = {
          multipleEventsCutter.processEvent {
            data.onClick()
            focusManager.clearFocus(force = true)
          }
        },
        enabled = data.buttonState == ButtonState.Enabled || data.buttonState == ButtonState.Destructive,
      ),
  ) {
    CustomText(
      label = data.label,
      style = AppTheme.typography.bodyMediumMedium,
      color = textColor,
    )
  }
}

@Preview
@Composable
fun ButtonPreview(@PreviewParameter(ButtonTextPPP::class) buttonData: ButtonTextData) {
  ButtonText(data = buttonData)
}
