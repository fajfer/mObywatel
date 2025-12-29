package pl.gov.coi.common.ui.ds.menus.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.menus.MenuData
import pl.gov.coi.common.ui.ds.menus.MenuItem
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class MenuPreviewParameterProvider : CustomPreviewParameterProvider<MenuData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<MenuData>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "Menu",
        value = provideMenuData(),
      ),
    )

  private fun provideMenuData() = MenuData(
    isMenuVisible = true,
    onMenuClose = {},
    items = listOf(
      MenuItem(
        label = "Opcja 1".toLabel(),
        leftIconResId = R.drawable.ah001_like,
        rightIconResId = R.drawable.ah001_like,
        onItemClick = {},
      ),
      MenuItem(
        label = "Opcja 2".toLabel(),
        leftIconResId = R.drawable.aa002_delete,
        rightIconResId = R.drawable.aa002_delete,
        onItemClick = {},
      ),
      MenuItem(
        label = "Opcja 3".toLabel(),
        leftIconResId = R.drawable.ah002_dislike,
        rightIconResId = R.drawable.ah002_dislike,
        onItemClick = {},
      ),
    ),
  )
}
