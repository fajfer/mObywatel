package pl.gov.coi.common.ui.ds.inforow.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class InfoRowPPP : CustomPreviewParameterProvider<InfoRowListData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<InfoRowListData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "InfoRowBullet",
      value = InfoRowListData(
        listOf(
          InfoRowData.Bullet(
            description = ("Bullet info row description Bullet info row description " +
              "Bullet info row description Bullet info row description Bullet info row description " +
              "Bullet info row description Bullet info row description ").toLabel(),
          ),
          InfoRowData.Bullet(
            description = "Bullet info row description".toLabel(),
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "InfoRowDefault",
      value = InfoRowListData(
        listOf(
          InfoRowData.Default(
            title = "Title label 1".toLabel(),
            description = ("Description label 1 Description label 1 Description label 1 " +
              "Description label 1 Description label 1").toLabel(),
            iconResId = R.drawable.aa037_rounded_plus,
            iconColorProvider = { AppTheme.colors.supportGreen100 },
          ),
          InfoRowData.Default(
            title = "Title label 2".toLabel(),
            description = "Description label 2".toLabel(),
            iconResId = R.drawable.aa002_delete,
            iconColorProvider = { AppTheme.colors.supportRed100 },
          ),
        ),
      ),
    ),
  )
}
