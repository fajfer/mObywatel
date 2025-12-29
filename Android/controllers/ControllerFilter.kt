package pl.gov.coi.common.ui.ds.controllers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.ds.controllers.provider.ControllerFilterPreviewParameterProvider

private const val MAX_LINES = 1

@Composable
fun ControllerFilter(
  data: ControllersData.Filter,
  state: LazyListState = rememberLazyListState(),
) {
  LazyRow(
    state = state,
    horizontalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
    content = {
      itemsIndexed(data.items) { index, _ ->
        Box(
          modifier = Modifier
            .background(
              color = when (data.selectedItemIndex == index) {
                true -> AppTheme.colors.secondary900
                false -> Color.Transparent
              },
              shape = AppTheme.shapes.radius200,
            )
            .clickable(
              interactionSource = remember { MutableInteractionSource() },
              indication = null,
              onClick = { data.onClick(index) },
            )
            .padding(
              horizontal = AppTheme.dimensions.spacing200,
              vertical = AppTheme.dimensions.spacing50,
            )
            .wrapContentWidth(align = Alignment.CenterHorizontally),
          contentAlignment = Alignment.Center,
        ) {
          CustomText(
            label = data.items[index],
            textAlign = TextAlign.Center,
            style = when (data.selectedItemIndex == index) {
              true -> AppTheme.typography.bodyMediumMedium
              false -> AppTheme.typography.bodyMediumRegular
            },
            color = when (data.selectedItemIndex == index) {
              true -> AppTheme.colors.primary900
              false -> AppTheme.colors.neutral200
            },
            maxLines = MAX_LINES,
          )
        }
      }
    },
  )
}

@Preview
@Composable
fun ControllerFilterPreview(
  @PreviewParameter(ControllerFilterPreviewParameterProvider::class)
  data: ControllersData.Filter,
) {
  Box(
    modifier = Modifier
      .background(AppTheme.colors.background)
      .padding(all = AppTheme.dimensions.spacing200),
  ) {
    ControllerFilter(data = data)
  }
}
