package pl.gov.coi.common.ui.ds.topappbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.topappbar.large.LargeTopAppBar
import pl.gov.coi.common.ui.ds.topappbar.medium.MediumTopAppBar
import pl.gov.coi.common.ui.ds.topappbar.small.SmallTopAppBar

internal const val TEXT_MAX_ONE_LINE = 1
internal const val TEXT_MAX_TWO_LINES = 2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
  data: TopAppBarData,
  scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
) = when (data) {
  is TopAppBarData.Medium -> MediumTopAppBar(data, scrollBehavior)
  is TopAppBarData.Large -> LargeTopAppBar(data, scrollBehavior)
  is TopAppBarData.Small -> SmallTopAppBar(data, scrollBehavior)
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopAppBarPreview(
  @PreviewParameter(TopAppBarPPP::class) data: TopAppBarData,
) {
  TopAppBar(data = data)
}
