package pl.gov.coi.common.ui.ds.controllers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.ds.controllers.provider.ControllerSwitchPreviewParameterProvider
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

private const val MAX_LINES = 3
private const val ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE = 100

@Composable
fun ControllerSwitch(
  data: ControllersData.Switch,
) {
  TabRow(
    selectedTabIndex = data.selectedItemType.tabIndex,
    modifier = Modifier
      .background(
        color = AppTheme.colors.neutral30,
        shape = RoundedCornerShape(percent = ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE),
      ),
    indicator = {},
    divider = {},
    containerColor = Color.Transparent,
  ) {
    listOf(
      data.leftItem,
      data.rightItem,
    ).forEach { tabItem ->
      val isSelected = data.selectedItemType.tabIndex == tabItem.type.tabIndex
      Tab(
        modifier = Modifier
          .fillMaxSize()
          .padding(
            bottom = AppTheme.dimensions.spacing50,
            top = AppTheme.dimensions.spacing50,
            start = when (tabItem.type) {
              ControllersData.Switch.Type.LEFT -> AppTheme.dimensions.spacing50
              ControllersData.Switch.Type.RIGHT -> AppTheme.dimensions.spacing25
            },
            end = when (tabItem.type) {
              ControllersData.Switch.Type.LEFT -> AppTheme.dimensions.spacing25
              ControllersData.Switch.Type.RIGHT -> AppTheme.dimensions.spacing50
            },
          )
          .shadow(
            shape = RoundedCornerShape(percent = ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE),
            elevation = when (isSelected) {
              true -> AppTheme.elevations.level1
              false -> AppTheme.elevations.level0
            },
          )
          .background(
            color = when (isSelected) {
              true -> Color.White
              false -> Color.Transparent
            },
            shape = RoundedCornerShape(percent = ROUNDED_CORNER_SHAPE_PERCENTAGE_VALUE),
          ),
        selected = isSelected,
        onClick = { data.onClick(tabItem.type) },
        selectedContentColor = Color.Blue,
        interactionSource = NoRippleInteractionSource(),
        text = {
          CustomText(
            label = tabItem.label,
            textAlign = TextAlign.Center,
            style = when (isSelected) {
              true -> AppTheme.typography.bodyMediumMedium
              false -> AppTheme.typography.bodyMediumRegular
            },
            color = when (isSelected) {
              true -> AppTheme.colors.primary900
              false -> AppTheme.colors.neutral200
            },
            maxLines = MAX_LINES,
          )
        },
      )
    }
  }
}

@Preview
@Composable
fun ControllerSwitchPreview(
  @PreviewParameter(ControllerSwitchPreviewParameterProvider::class)
  data: ControllersData.Switch,
) {
  Box(
    modifier = Modifier
      .background(AppTheme.colors.background)
      .padding(all = AppTheme.dimensions.spacing200),
  ) {
    ControllerSwitch(data = data)
  }
}
