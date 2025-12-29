package pl.gov.coi.common.ui.ds.singlecard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.singlecard.provider.SingleCardStatusBadgePreviewProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

private val STATUS_BADGE_SIZE: Dp = 10.dp
/* 
34    TODO REMOVE MOB-49304 
35    */
@Composable
fun SingleCardStatusBadge(data: SingleCardStatusBadgeData) {
  when (data) {
    is SingleCardStatusBadgeData.Default -> StatusBadge(data = data)
    is SingleCardStatusBadgeData.WithNoIcon -> StatusBadge(data = data)
    is SingleCardStatusBadgeData.WithIcon -> StatusBadge(data = data)
    is SingleCardStatusBadgeData.WithIconAndBorder -> StatusBadge(data = data)
    is SingleCardStatusBadgeData.WithDotAndBorder -> StatusBadge(data = data)
    is SingleCardStatusBadgeData.Elevated -> StatusBadge(data = data)
  }
}

@Composable
internal fun StatusBadge(data: SingleCardStatusBadgeData.Default) {
  Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Box(
      modifier = Modifier
        .size(size = STATUS_BADGE_SIZE)
        .background(
          color = data.dotColorProvider(),
          shape = CircleShape,
        ),
    )
    Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
    CustomText(
      label = data.text,
      maxLines = 1,
      color = AppTheme.colors.neutral500,
      style = AppTheme.typography.bodyLargeMedium,
    )
  }
}

@Composable
internal fun StatusBadge(data: SingleCardStatusBadgeData.WithNoIcon) {
  CustomText(
    modifier = Modifier
      .wrapContentHeight()
      .wrapContentWidth(),
    label = data.text,
    maxLines = 1,
    color = when (data) {
      is SingleCardStatusBadgeData.WithNoIcon.Error -> AppTheme.colors.supportRed100
      is SingleCardStatusBadgeData.WithNoIcon.Normal -> AppTheme.colors.neutral200
    },
    style = when (data) {
      is SingleCardStatusBadgeData.WithNoIcon.Error -> AppTheme.typography.bodyMediumMedium
      is SingleCardStatusBadgeData.WithNoIcon.Normal -> AppTheme.typography.bodyMediumRegular
    },
  )
}

@Composable
private fun StatusBadge(data: SingleCardStatusBadgeData.WithIcon) {
  Row {
    Icon(data = data.iconData)
    Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
    CustomText(
      label = data.text,
      maxLines = 1,
      color = AppTheme.colors.neutral200,
      style = AppTheme.typography.bodySmallRegular,
    )
  }
}

@Composable
private fun StatusBadge(data: SingleCardStatusBadgeData.WithIconAndBorder) {
  Surface(
    modifier = Modifier
      .height(height = AppTheme.dimensions.spacing400),
    shape = RoundedCornerShape(percent = 50),
    color = AppTheme.colors.white,
    border = BorderStroke(
      width = ButtonDefaults.outlinedBorder.width,
      color = AppTheme.colors.neutral80,
    ),
    elevation = AppTheme.elevations.level0,
  ) {
    Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
      Icon(data = data.iconData)
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
      CustomText(
        label = data.text,
        maxLines = 1,
        color = AppTheme.colors.neutral200,
        style = AppTheme.typography.bodySmallRegular,
      )
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
    }
  }
}

@Composable
internal fun StatusBadge(data: SingleCardStatusBadgeData.WithDotAndBorder) {
  Surface(
    modifier = Modifier
      .height(height = AppTheme.dimensions.spacing400),
    shape = RoundedCornerShape(percent = 50),
    color = data.backgroundColorProvider(),
    border = BorderStroke(
      width = ButtonDefaults.outlinedBorder.width,
      color = data.strokeColorProvider(),
    ),
    elevation = AppTheme.elevations.level0,
  ) {
    Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
      Box(
        modifier = Modifier
          .size(size = STATUS_BADGE_SIZE)
          .background(
            color = data.dotColorProvider(),
            shape = CircleShape,
          ),
      )
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
      CustomText(
        label = data.text,
        maxLines = 1,
        color = AppTheme.colors.neutral200,
        style = AppTheme.typography.bodySmallRegular,
      )
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
    }
  }
}

@Composable
internal fun StatusBadge(data: SingleCardStatusBadgeData.Elevated) {
  Surface(
    modifier = Modifier
      .height(height = AppTheme.dimensions.spacing300),
    shape = RoundedCornerShape(percent = 50),
    color = AppTheme.colors.white,
    border = BorderStroke(
      width = ButtonDefaults.outlinedBorder.width,
      color = AppTheme.colors.neutral80,
    ),
    elevation = AppTheme.elevations.level0,
  ) {
    Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
      Box(
        modifier = Modifier
          .size(size = AppTheme.dimensions.spacing100)
          .background(
            color = data.dotColorProvider(),
            shape = CircleShape,
          ),
      )
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
      CustomText(
        label = data.text,
        maxLines = 1,
        color = AppTheme.colors.neutral200,
        style = AppTheme.typography.bodySmallRegular,
      )
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
    }
  }
}

@Preview
@Composable
fun StatusBadgePreview(@PreviewParameter(SingleCardStatusBadgePreviewProvider::class) data: SingleCardStatusBadgeData) {

  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(all = AppTheme.dimensions.spacing200)
      .background(color = AppTheme.colors.white),
    contentAlignment = Alignment.Center,
  ) {
    SingleCardStatusBadge(data = data)
  }
}