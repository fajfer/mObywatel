package pl.gov.coi.common.ui.ds.checkbox.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextAlign
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxRowData
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
import pl.gov.coi.common.ui.ds.checkbox.common.model.ClickableTextData
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.link.Link
import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
import pl.gov.coi.common.ui.focus.createFocusHost
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun CheckboxRow(
  data: CheckBoxRowData,
  type: CheckBoxType,
  isEnabled: Boolean,
) {
  Column {
    Row(
      modifier = Modifier
        .toggleable(
          enabled = isEnabled,
          value = data.isChecked,
          role = Role.Checkbox,
          onValueChange = { checked ->
            data.onCheckedChange(checked)
          },
        )
        .semantics {
          testTagsAsResourceId = true
          testTag = data.testTag ?: "checkbox${data.label}"
        },
      verticalAlignment = Alignment.Top,
    ) {
      Box(
        modifier = Modifier.size(IconSize.SIZE24.dimension),
        contentAlignment = Alignment.Center,
      ) {
        Box(
          modifier = Modifier
            .background(
              color = type.getBackgroundColor(isChecked = data.isChecked, isEnabled = isEnabled),
              shape = RoundedCornerShape(AppTheme.dimensions.spacing50),
            )
            .border(
              width = AppTheme.dimensions.spacing25,
              color = type.getBorderStrokeColor(isChecked = data.isChecked, isEnabled = isEnabled),
              shape = RoundedCornerShape(AppTheme.dimensions.spacing50),
            )
            .size(IconSize.SIZE20.dimension)
            .focusHost(createFocusHost()),

          contentAlignment = Alignment.Center,
        ) {
          if (data.isChecked) {
            Icon(
              data = IconData.Standard(
                testTag = data.testTag?.let { tag -> tag + "Icon" },
                iconResId = R.drawable.e006_checkbox_mark,
                iconSize = IconSize.SIZE16,
                iconColorProvider = { AppTheme.colors.white },
                contentDescription = Label.EMPTY,
              ),
            )
          }
        }
      }

      if (data.label.isNotBlank()) {
        Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing200))
        CustomText(
          testTag = data.testTag?.let { tag -> tag + "Text" },
          textAlign = TextAlign.Start,
          label = data.label,
          style = AppTheme.typography.bodyLargeRegular,
          color = getLabelColor(isEnabled = isEnabled),
        )
      }
    }
    data.clickableTextData?.let { clickableText ->
      CheckBoxClickableText(data = clickableText)
    }
  }
}

@Composable
private fun CheckBoxClickableText(data: ClickableTextData) {
  Box(
    modifier = Modifier.padding(
      top = AppTheme.dimensions.spacing100,
      start = AppTheme.dimensions.spacing500,
      end = AppTheme.dimensions.spacing500,
    ),
  ) {
    when (data) {
      is ClickableTextData.Button -> ButtonText(data = data.buttonData)
      is ClickableTextData.Link -> Link(data = data.linkData)
    }
  }
}

@Composable
private fun getLabelColor(isEnabled: Boolean) =
  if (isEnabled) {
    AppTheme.colors.neutral500
  } else {
    AppTheme.colors.neutral30
  }

@Composable
private fun CheckBoxType.getBackgroundColor(isChecked: Boolean, isEnabled: Boolean) =
  when {
    isChecked.not() -> Color.Transparent
    isEnabled.not() -> AppTheme.colors.neutral30
    this is CheckBoxType.Error -> AppTheme.colors.supportRed100
    else -> AppTheme.colors.primary900
  }

@Composable
private fun CheckBoxType.getBorderStrokeColor(isEnabled: Boolean, isChecked: Boolean) =
  when {
    isEnabled.not() -> AppTheme.colors.neutral30
    this is CheckBoxType.Error -> AppTheme.colors.supportRed100
    else -> if (isChecked) AppTheme.colors.primary900 else AppTheme.colors.neutral80
  }
