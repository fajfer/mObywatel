package pl.gov.coi.common.ui.ds.controllers.provider

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.ds.controllers.ControllersData

class ControllerFilterPreviewParameterProvider : CustomPreviewParameterProvider<ControllersData.Filter>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ControllersData.Filter>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "ControllerFilterFirstSelected",
      value = provideControllerFilterFirstSelectedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ControllerFilterThirdSelected",
      value = provideControllerFilterThirdSelectedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ControllerFilterShortLabel",
      value = provideControllerFilterShortLabelPreviewData(),
    ),
  )
}

private fun provideControllerFilterFirstSelectedPreviewData() =
  ControllersData.Filter(
    items = listOf(
      "Główne",
      "Tymczasowe",
      "Niezdeklarowane",
      "Nieważne",
    ).map { it.toLabel(tag = it) },
    selectedItemIndex = 0,
    onClick = {},
  )

private fun provideControllerFilterThirdSelectedPreviewData() =
  ControllersData.Filter(
    items = listOf(
      "Główne",
      "Tymczasowe",
      "Niezdeklarowane",
      "Nieważne",
    ).map { it.toLabel(tag = it) },
    selectedItemIndex = 2,
    onClick = {},
  )

private fun provideControllerFilterShortLabelPreviewData() =
  ControllersData.Filter(
    items = listOf(
      "a",
      "b",
      "c",
      "d",
      "e",
      "f",
      "g",
      "h",
      "i",
      "j",
      "k",
    ).map { it.toLabel(tag = it) },
    selectedItemIndex = 1,
    onClick = {},
  )
