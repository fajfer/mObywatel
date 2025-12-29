package pl.gov.coi.common.ui.ds.bottomnavigation

data class BottomNavigationData(
  val items: List<BottomNavigationItem>,
  val selectedItemIndex: Int = 0,
)
