package pl.gov.coi.common.ui.ds.bottomnavigation

import androidx.annotation.DrawableRes
import pl.gov.coi.common.domain.label.Label

data class BottomNavigationItem(
  val testTag: String? = null,
  val label: Label,
  @DrawableRes val unselectedIconResId: Int,
  @DrawableRes val selectedIconResId: Int,
  val onClickAction: () -> Unit,
)
