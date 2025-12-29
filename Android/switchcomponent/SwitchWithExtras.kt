package pl.gov.coi.common.ui.ds.switchcomponent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.toggleableState
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.launch
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.link.Link
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwitchWithExtras(data: SwitchData.SwitchWithExtras) {
  val bringIntoViewRequester = remember { BringIntoViewRequester() }
  var inputFieldCoordinates by remember { mutableStateOf(IntOffset(0, 0)) }
  val coroutineScope = rememberCoroutineScope()
  var validationMessageShowed by remember { mutableStateOf(false) }

  fun getSwitchLabel() = "${data.label.text} ${CommonUILabelProvider.switchLabel().text} " +
    if (data.checked) {
      CommonUILabelProvider.switchOnLabel().text
    } else {
      CommonUILabelProvider.switchOffLabel().text
    }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .bringIntoViewRequester(bringIntoViewRequester = bringIntoViewRequester)
      .onGloballyPositioned { coordinates ->
        inputFieldCoordinates = IntOffset(
          x = coordinates.positionInWindow().x.toInt(),
          y = coordinates.positionInWindow().y.toInt(),
        )
        if ((data.validationState is ValidationState.Invalid) && !validationMessageShowed) {
          coroutineScope.launch {
            bringIntoViewRequester.bringIntoView()
            validationMessageShowed = true
          }
        }
      },
  ) {
    Row(
      modifier = Modifier
        .toggleable(
          role = Role.Switch,
          value = data.checked,
          enabled = true,
          onValueChange = { (data.onCheckedChange?.invoke(data.checked.not())) },
        )
        .semantics(
          mergeDescendants = true,
          properties = {},
        )
        .semantics {
          if (data.validationState is ValidationState.Invalid) {
            liveRegion = LiveRegionMode.Assertive
            stateDescription = data.validationState.message.text
          }
          role = Role.Switch
          toggleableState = ToggleableState(data.checked)
          customActions = listOf(
            CustomAccessibilityAction(
              label = data.customActionContentDescription.text,
              action = {
                when (data.type) {
                  is SwitchExtraType.Link -> data.type.data.onClick(data.type.data.url)
                  is SwitchExtraType.TextButton -> data.type.data.onClick()
                }
                true
              },
            ),
            CustomAccessibilityAction(
              label = getSwitchLabel(),
              action = {
                data.onCheckedChange?.invoke(data.checked.not())
                true
              },
            ),
          )
        },
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Column(
        modifier = Modifier
          .weight(1f),
      ) {
        CustomText(
          testTag = data.testTag?.let { tag -> tag + "Text" },
          label = data.label,
          style = AppTheme.typography.bodyMediumRegular,
          color = AppTheme.colors.neutral200,
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
        when (data.type) {
          is SwitchExtraType.Link -> Link(
            data = data.type.data,
          )

          is SwitchExtraType.TextButton -> ButtonText(
            data = data.type.data,
          )
        }
      }
      Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))

      Box(
        modifier = Modifier
          .clearAndSetSemantics {}
          .semantics(
            mergeDescendants = true,
            properties = {},
          ),
      ) {
        SwitchOnly(
          data = SwitchData.SwitchOnly(
            testTag = data.testTag?.let { tag -> tag + "Switch" },
            checked = data.checked,
            enabled = data.enabled,
            onCheckedChange = { value ->
              data.onCheckedChange?.invoke(value)
            },
            contentDescription = data.label,
            testIndexTag = data.testIndexTag,
          ),
        )
      }
    }
    if (data.validationState is ValidationState.Invalid) {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
      ErrorText(
        testTag = data.testTag?.let { tag -> tag + "ErrorText" },
        errorText = data.validationState.message,
        ignoreForAccessibility = true,
      )
    }
  }
}
