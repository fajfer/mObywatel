package pl.gov.coi.common.ui.ds.smallcards.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.smallcards.SmallCardSData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class SmallCardSPPP : CustomPreviewParameterProvider<SmallCardSData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<SmallCardSData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SmallCard Confirm identity",
      value = SmallCardSData(
        title = "Potwierdź dane".toLabel(),
        iconResId = R.drawable.ai002_confirm_identity,
        iconColorProvider = { AppTheme.colors.primary900 },
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallCard Delete",
      value = SmallCardSData(
        title = "Usuń".toLabel(),
        iconResId = R.drawable.aa002_delete,
        iconColorProvider = { AppTheme.colors.supportRed100 },
        onClick = {},
      ),
    ),
  )
}
