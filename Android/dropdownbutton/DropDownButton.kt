package pl.gov.coi.common.ui.ds.dropdownbutton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.helpertext.HelperText
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty

@Composable
fun DropDownButton(data: DropDownButtonData) {
  Column(
    modifier = Modifier
      .wrapContentHeight()
      .semantics {
        if (data.buttonType is DropDownButtonState.Error && data.buttonType.errorText != null) {
          liveRegion = LiveRegionMode.Assertive
          stateDescription = data.buttonType.errorText.text
        }
      },
  ) {
    CustomText(
      color = data.buttonType.getLabelColor(),
      label = data.label,
      style = AppTheme.typography.bodyMediumRegular,
      ignoreForAccessibility = true,
    )
    Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
    DropDownClickableRow(data = data)
    DropDownBottomText(data = data)
  }
}

@Composable
fun DropDownBottomText(data: DropDownButtonData) {
  when (data.buttonType) {
    is DropDownButtonState.Error -> data.buttonType.errorText?.let {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
      ErrorText(errorText = data.buttonType.errorText, ignoreForAccessibility = true)
    }

    is DropDownButtonState.Disabled ->
      data.buttonType.helperText?.let {
        DropDownHelperText(helperText = data.buttonType.helperText)
      }

    is DropDownButtonState.Enabled -> data.buttonType.helperText?.let {
      DropDownHelperText(helperText = data.buttonType.helperText)
    }
  }
}

@Composable
private fun DropDownHelperText(helperText: Label) {
  Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
  HelperText(helperLabel = helperText, ignoreForAccessibility = true)
}

@Composable
private fun DropDownButtonState.getLabelColor() =
  when (this) {
    is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
    else -> AppTheme.colors.neutral200
  }

@Composable
private fun DropDownButtonState.getPlaceholderColor() =
  when (this) {
    is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
    else -> AppTheme.colors.neutral100
  }

@Composable
private fun DropDownButtonState.getIconColor() =
  when (this) {
    is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
    else -> AppTheme.colors.neutral200
  }

@Composable
private fun DropDownButtonState.getFilledTextColor() =
  when (this) {
    is DropDownButtonState.Disabled -> AppTheme.colors.neutral60
    else -> AppTheme.colors.neutral500
  }

@Composable
private fun DropDownButtonState.getBorderStroke() =
  when (this) {
    is DropDownButtonState.Disabled -> AppTheme.colors.neutral30
    is DropDownButtonState.Enabled -> AppTheme.colors.neutral80
    is DropDownButtonState.Error -> AppTheme.colors.supportRed100
  }

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun DropDownClickableRow(
  data: DropDownButtonData,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .focusable()
      .semantics(mergeDescendants = true) {
        contentDescription = data.contentDescription()
      }
      .fillMaxWidth()
      .border(
        width = AppTheme.dimensions.strokeWidth,
        color = data.buttonType.getBorderStroke(),
        shape = AppTheme.shapes.radius50,
      )
      .background(color = AppTheme.colors.white, shape = AppTheme.shapes.radius50)
      .padding(all = AppTheme.dimensions.spacing200)
      .clickable(
        enabled = (data.buttonType is DropDownButtonState.Disabled).not(),
        interactionSource = NoRippleInteractionSource(),
        indication = null,
        role = Role.Button,
        onClick = {
          data.onClick(data)
        },
      ),
  ) {
    Row(
      modifier = Modifier
        .weight(1.0f, fill = false)
        .semantics { invisibleToUser() },
    ) {
      if (data.initialSelectedItem != null) {
        CustomText(
          modifier = Modifier.wrapContentWidth(),
          ignoreForAccessibility = true,
          color = data.buttonType.getFilledTextColor(),
          label = data.items[data.initialSelectedItem],
          style = AppTheme.typography.bodyLargeRegular,
        )
      } else {
        CustomText(
          modifier = Modifier.wrapContentWidth(),
          ignoreForAccessibility = true,
          label = data.placeholder,
          color = data.buttonType.getPlaceholderColor(),
          style = AppTheme.typography.bodyLargeRegular,
        )
      }
      Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
    }

    Icon(
      data = IconData.Standard(
        iconResId = R.drawable.ab008_chevron_down,
        iconSize = IconSize.SIZE24,
        iconColorProvider = { data.buttonType.getIconColor() },
        contentDescription = Label.EMPTY,
      ),
    )
  }
}

private fun DropDownButtonData.contentDescription() = label.textWithDotAndSpaceOrEmpty() +
  (initialSelectedItem?.let { items[initialSelectedItem] } ?: placeholder).textWithDotAndSpaceOrEmpty() +
  when (buttonType) {
    is DropDownButtonState.Error -> buttonType.errorText
    is DropDownButtonState.Disabled -> buttonType.helperText
    is DropDownButtonState.Enabled -> buttonType.helperText
  }
    .textWithDotAndSpaceOrEmpty()
    .trim()

@Composable
@Preview
fun DropDownButtonPreview(@PreviewParameter(DropDownButtonPPP::class) data: DropDownButtonData) {
  Box(
    modifier = Modifier
      .background(color = AppTheme.colors.background)
      .padding(all = AppTheme.dimensions.spacing200)
      .fillMaxSize(),
  ) {
    DropDownButton(data)
  }
}
