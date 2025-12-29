package pl.gov.coi.common.ui.ds.switchcomponent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.launch
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SwitchWithText(
  data: SwitchData.SwitchWithText,
) {
  val bringIntoViewRequester = remember { BringIntoViewRequester() }
  var inputFieldCoordinates by remember { mutableStateOf(IntOffset(0, 0)) }
  val coroutineScope = rememberCoroutineScope()
  var validationMessageShowed by remember { mutableStateOf(false) }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .bringIntoViewRequester(bringIntoViewRequester = bringIntoViewRequester)
      .toggleable(
        role = Role.Switch,
        value = data.checked,
        enabled = false,
        onValueChange = { value -> data.onCheckedChange?.invoke(value) },
      )
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
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      CustomText(
        testTag = data.testTag?.let { tag -> tag + "Text" },
        modifier = Modifier
          .weight(1f),
        label = data.label,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
      )
      Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
      SwitchOnly(
        data = SwitchData.SwitchOnly(
          testTag = data.testTag?.let { tag -> tag + "Switch" },
          checked = data.checked,
          enabled = data.enabled,
          onCheckedChange = data.onCheckedChange,
          contentDescription = data.label,
          testIndexTag = data.testIndexTag,
        ),
      )
    }
    if (data.validationState is ValidationState.Invalid) {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
      ErrorText(testTag = data.testTag?.let { tag -> tag + "ErrorText" }, errorText = data.validationState.message)
    }
  }
}
