package pl.gov.coi.common.ui.ds.searchbar

import pl.gov.coi.common.domain.label.Label

data class SearchBarData(
  val query: String,
  val onQueryChange: (String) -> Unit,
  val isActive: Boolean,
  val onActiveChange: (Boolean) -> Unit,
  val onClearClicked: () -> Unit,
  val placeholder: Label,
)
