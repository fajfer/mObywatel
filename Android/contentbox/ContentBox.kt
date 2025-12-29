package pl.gov.coi.common.ui.ds.contentbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun ContentBox(
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit,
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .clip(shape = AppTheme.shapes.radius200)
      .background(color = AppTheme.colors.white)
      .padding(all = AppTheme.dimensions.spacing200),
  ) {
    content()
  }
}

@Composable
@Preview
fun ContentBoxPreview() {
  Box(
    Modifier
      .background(color = AppTheme.colors.background)
      .padding(AppTheme.dimensions.spacing200),
  ) {
    ContentBox {
      Column {
        CustomText(label = "Text 1".toLabel(tag = "text1Label"))
        CustomText(label = "Text 2".toLabel(tag = "text2Label"))
        CustomText(label = "Text 3".toLabel(tag = "text3Label"))
      }
    }
  }
}
