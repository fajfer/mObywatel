package pl.gov.coi.common.ui.ds.pageindicator

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.theme.AppTheme

private val DOT_SIZE = 8.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicator(pagerState: PagerState) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.Bottom,
  ) {
    repeat(times = pagerState.pageCount) { iteration ->
      val modifier = if (pagerState.currentPage == iteration) {
        Modifier.background(color = AppTheme.colors.primary900)
      } else {
        Modifier.border(
          width = AppTheme.dimensions.strokeWidth,
          color = AppTheme.colors.neutral80,
          shape = CircleShape,
        )
      }
      Box(
        modifier = Modifier
          .clip(shape = CircleShape)
          .size(size = DOT_SIZE)
          .then(other = modifier),
      )
      if (iteration < pagerState.pageCount - 1) {
        Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing150))
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun PageIndicatorPreview() {
  val pagerState = rememberPagerState(
    pageCount = { 4 },
  )
  PageIndicator(pagerState = pagerState)
}
