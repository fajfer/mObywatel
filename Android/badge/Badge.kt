package pl.gov.coi.common.ui.ds.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.badge.provider.BadgePreviewParameterProvider
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun Badge(
  data: BadgeData = BadgeData.BadgeDefault,
) {
  val lightBadgeColor = Color(0xFF900E1D)
  when (data) {
    is BadgeData.BadgeDefault -> Box(
      modifier = Modifier
        .size(AppTheme.dimensions.spacing100)
        .clip(CircleShape)
        .background(lightBadgeColor),
    )
  }
}

@Preview
@Composable
fun BadgePreview(
  @PreviewParameter(BadgePreviewParameterProvider::class) data: BadgeData,
) {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxSize()
      .background(AppTheme.colors.background),
  ) {
    Text("Badge Dot")
    Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
    Badge(data = data)
  }
}
