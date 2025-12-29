package pl.gov.coi.common.ui.ds.searchbar.provider

import pl.gov.coi.common.ui.ds.searchbar.SearchBarData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SearchBarPPP : CustomPreviewParameterProvider<SearchBarData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<SearchBarData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SearchBarInactive",
      value = createInitializedState(
        isActive = false,
        query = "",
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SearchBarActive",
      value = createInitializedState(
        isActive = true,
        query = "",
      ),
    ),
  )

  private fun createInitializedState(
    isActive: Boolean,
    query: String,
  ) = SearchBarData(
    placeholder = "Wyszukaj".toLabel(),
    isActive = isActive,
    query = query,
    onQueryChange = { _ -> },
    onActiveChange = { _ -> },
    onClearClicked = {},
  )
}
