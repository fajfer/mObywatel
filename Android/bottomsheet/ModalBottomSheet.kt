package pl.gov.coi.common.ui.ds.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.icon.CustomIcon
import pl.gov.coi.common.ui.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

private const val MAX_HEIGHT_PERCENT = 0.9f

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet(
  data: ModalBottomSheetData,
  horizontalPadding: Dp = AppTheme.dimensions.spacing200,
  bottomSheetContent: @Composable () -> Unit,
  innerContent: @Composable () -> Unit,
) = with(data) {
  val configuration = LocalConfiguration.current
  val screenHeight = configuration.screenHeightDp.dp
  val maxHeight = screenHeight * MAX_HEIGHT_PERCENT

  val sheetState = rememberModalBottomSheetState(
    initialValue = when (sheetState.value) {
      ModalSheetValue.EXPANDED -> ModalBottomSheetValue.Expanded
      ModalSheetValue.HIDDEN -> ModalBottomSheetValue.Hidden
      ModalSheetValue.HALF_EXPANDED -> ModalBottomSheetValue.HalfExpanded
    },
    confirmValueChange = { value ->
      when (value) {
        ModalBottomSheetValue.Hidden -> sheetState.onValueChange(ModalSheetValue.HIDDEN)
        ModalBottomSheetValue.Expanded -> sheetState.onValueChange(ModalSheetValue.EXPANDED)
        ModalBottomSheetValue.HalfExpanded -> sheetState.onValueChange(ModalSheetValue.HALF_EXPANDED)
      }
      true
    },
    skipHalfExpanded = sheetState.skipHalfExpanded,
  )

  val focusRequester = remember { FocusRequester() }
  LaunchedEffect(sheetState.isVisible) {
    if (sheetState.isVisible) {
      focusRequester.requestFocus()
    }
  }

  ModalBottomSheetLayout(
    modifier = Modifier.focusRequester(focusRequester),
    sheetState = sheetState,
    sheetElevation = AppTheme.elevations.level0,
    sheetShape = RoundedCornerShape(
      topStart = AppTheme.dimensions.spacing200,
      topEnd = AppTheme.dimensions.spacing200,
    ),
    sheetContent = {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .heightIn(max = maxHeight)
          .background(data.colorProvider())
          .clip(
            RoundedCornerShape(
              topStart = AppTheme.dimensions.spacing50,
              topEnd = AppTheme.dimensions.spacing50,
            ),
          ),
      ) {
        Column(
          modifier = Modifier
            .padding(horizontal = AppTheme.dimensions.spacing200),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Divider(
            modifier = Modifier
              .padding(
                top = AppTheme.dimensions.spacing100,
                bottom = AppTheme.dimensions.spacing100,
              )
              .clip(RoundedCornerShape(AppTheme.dimensions.spacing300))
              .background(AppTheme.colors.neutral30)
              .width(AppTheme.dimensions.spacing400)
              .height(AppTheme.dimensions.spacing50),

          )
          Box(modifier = Modifier.fillMaxWidth()) {
            title?.let { title ->
              CustomText(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(
                    start = AppTheme.dimensions.spacing400,
                    end = AppTheme.dimensions.spacing400,
                  ),
                textAlign = TextAlign.Center,
                label = title,
                color = AppTheme.colors.neutral500,
                style = AppTheme.typography.subtitleMedium,
              )
            }
            onCloseClick?.let { onCloseClick ->
              IconButton(
                modifier = Modifier
                  .align(Alignment.TopEnd)
                  .size(IconSize.Medium.dimension),
                onClick = onCloseClick,
                interactionSource = NoRippleInteractionSource(),
              ) {
                CustomIcon(
                  iconResId = R.drawable.ab009_x_mark,
                  iconColor = AppTheme.colors.neutral200,
                  contentDescription = CommonUILabelProvider.closeLabel().text,
                )
              }
            }
          }
          if (title != null || onCloseClick != null) {
            Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
          }
        }
        Box(
          modifier = Modifier
            .padding(horizontal = horizontalPadding),
        ) {
          bottomSheetContent()
        }
      }
    },
    content = innerContent,
  )
}

@Preview
@Composable
fun ModalBottomSheetPreview() {
  val data = ModalBottomSheetData(
    title = "Bottom Sheet (1.1.0)".toLabel(tag = "modalBottomSheetPreviewTitle"),
    sheetState = ModalSheetState(
      value = ModalSheetValue.EXPANDED,
      skipHalfExpanded = true,
      onValueChange = {},
    ),
    onCloseClick = {},
  )
  ModalBottomSheet(
    data = data,
    bottomSheetContent = {
      Box(
        modifier = Modifier.height(height = AppTheme.dimensions.spacing600),
      )
    },
    innerContent = {},
  )
}
