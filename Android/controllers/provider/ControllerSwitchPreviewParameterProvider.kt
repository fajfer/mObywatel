package pl.gov.coi.common.ui.ds.controllers.provider

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.ds.controllers.ControllersData

class ControllerSwitchPreviewParameterProvider : CustomPreviewParameterProvider<ControllersData.Switch>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ControllersData.Switch>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "ControllerSwitchTabLeftSelected",
      value = provideControllerSwitchTabLeftSelectedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ControllerSwitchTabRightSelected",
      value = provideControllerSwitchTabRightSelectedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ControllerSwitchTab",
      value = provideControllerSwitchTabLongLabelsPreviewData(),
    ),
  )

  private fun provideControllerSwitchTabLeftSelectedPreviewData() =
    ControllersData.Switch(
      leftItem = ControllersData.Switch.TabItem(
        label = "Left".toLabel(),
        type = ControllersData.Switch.Type.LEFT,
      ),
      rightItem = ControllersData.Switch.TabItem(
        label = "Right".toLabel(),
        type = ControllersData.Switch.Type.RIGHT,
      ),
      selectedItemType = ControllersData.Switch.Type.LEFT,
      onClick = {},
    )

  private fun provideControllerSwitchTabRightSelectedPreviewData() =
    ControllersData.Switch(
      leftItem = ControllersData.Switch.TabItem(
        label = "Left".toLabel(),
        type = ControllersData.Switch.Type.LEFT,
      ),
      rightItem = ControllersData.Switch.TabItem(
        label = "Right".toLabel(),
        type = ControllersData.Switch.Type.RIGHT,
      ),
      selectedItemType = ControllersData.Switch.Type.RIGHT,
      onClick = {},
    )

  private fun provideControllerSwitchTabLongLabelsPreviewData() =
    ControllersData.Switch(
      leftItem = ControllersData.Switch.TabItem(
        label = "Zaległe i nieopłacone mandaty".toLabel(),
        type = ControllersData.Switch.Type.LEFT,
      ),
      rightItem = ControllersData.Switch.TabItem(
        label = "Opłacone mandaty".toLabel(),
        type = ControllersData.Switch.Type.RIGHT,
      ),
      selectedItemType = ControllersData.Switch.Type.LEFT,
      onClick = {},
    )
}
