package pl.gov.coi.common.ui.ds.controllers

import pl.gov.coi.common.domain.label.Label

sealed class ControllersData {
  data class Switch(
    val leftItem: TabItem,
    val rightItem: TabItem,
    val selectedItemType: Type,
    val onClick: (Type) -> Unit,
  ) : ControllersData() {

    data class TabItem(
      val label: Label,
      val type: Type,
    )

    enum class Type(val tabIndex: Int) {
      LEFT(tabIndex = 0),
      RIGHT(tabIndex = 1),
    }
  }

  data class Filter(
    val items: List<Label>,
    val selectedItemIndex: Int,
    val onClick: (Int) -> Unit,
  ) : ControllersData()
}
