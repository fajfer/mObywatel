package pl.gov.coi.common.ui.ds.menus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.menus.provider.MenuPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.get

private val MENU_MIN_WIDTH = 112.dp
private val MENU_MAX_WIDTH = 280.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Menu(
  data: MenuData,
) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }

  DropdownMenu(
    modifier = Modifier
      .background(Color.White)
      .widthIn(
        min = MENU_MIN_WIDTH,
        max = MENU_MAX_WIDTH,
      ),
    expanded = data.isMenuVisible,
    onDismissRequest = data.onMenuClose,
  ) {
    data.items.forEachIndexed { index, item ->
      DropdownMenuItem(
        contentPadding = PaddingValues(horizontal = AppTheme.dimensions.spacing200),
        interactionSource = NoRippleInteractionSource(),
        modifier = Modifier
          .semantics { testTagsAsResourceId = true }
          .semantics { testTag = item.testTag ?: "menuItem_${item.label.tag}" },
        onClick = {
          multipleEventsCutter.processEvent {
            data.onMenuClose()
            item.onItemClick()
          }
        },
        leadingIcon = item.leftIconData?.let { { Icon(data = it) } },
        text = {
          CustomText(
            testTag = item.testTag?.let { tag -> tag + "Text" },
            label = item.label,
            color = AppTheme.colors.neutral500,
            style = AppTheme.typography.bodyMediumRegular,
          )
        },
        trailingIcon = item.rightIconData?.let { { Icon(data = it) } },
      )
      if (index != data.items.lastIndex) {
        HorizontalDivider(
          thickness = AppTheme.dimensions.strokeWidth,
          color = AppTheme.colors.neutral30,
        )
      }
    }
  }
}

@Preview
@Composable
fun MenuPreview(
  @PreviewParameter(MenuPreviewParameterProvider::class) data: MenuData,
) {
  Box(
    modifier = Modifier
      .wrapContentHeight()
      .background(color = AppTheme.colors.white),
  ) {
    Menu(
      data = data,
    )
  }
}
