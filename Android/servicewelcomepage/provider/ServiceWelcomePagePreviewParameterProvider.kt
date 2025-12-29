package pl.gov.coi.common.ui.ds.servicewelcomepage.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.alert.AlertData
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.header.HeaderData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.ds.servicewelcomepage.ServiceWelcomePageData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class ServiceWelcomePagePreviewParameterProvider : CustomPreviewParameterProvider<ServiceWelcomePageData<*>>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ServiceWelcomePageData<*>>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "ServiceWelcomePageData",
        value = ServiceWelcomePageData(
          topBarTitle = "Top bar title".toLabel(),
          topBarIconMainResId = R.drawable.ab004_arrow_left,
          onTopBarIconMainClick = {},
          topBarIconMenuResId = R.drawable.c1_info,
          onTopBarIconMenuClick = {},
          headerData = HeaderData(
            iconResId = R.drawable.da015_historia_pojazdu,
            iconColorProvider = { AppTheme.colors.headerCeladon100 },
            iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
            title = "Title Size XXL Color - black 900".toLabel(),
            message = "Description text Size - M, Color - grey 900".toLabel(),
          ),
          contentData = Unit,
          buttonData = null,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = "ServiceWelcomePageDataWithContent",
        value = ServiceWelcomePageData(
          topBarTitle = "Top bar title".toLabel(),
          topBarIconMainResId = R.drawable.ab004_arrow_left,
          onTopBarIconMainClick = {},
          topBarIconMenuResId = R.drawable.c1_info,
          onTopBarIconMenuClick = {},
          headerData = HeaderData(
            iconResId = R.drawable.da015_historia_pojazdu,
            iconColorProvider = { AppTheme.colors.headerCeladon100 },
            iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
            title = "Title Size XXL Color - black 900".toLabel(),
            message = "Description text Size - M, Color - grey 900".toLabel(),
          ),
          alertData = AlertData.Warning(
            title = "Alert title example".toLabel(),
            bodyText = "Alert body text".toLabel(),
            alertContentDescription = Label.EMPTY,
          ),
          contentData = InfoRowListData(
            items = listOf(
              InfoRowData.Bullet(
                description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
              ),
              InfoRowData.Bullet(
                description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
              ),
            ),
          ),
          buttonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(
              label = "Sprawdź".toLabel(),
            ),
            onClick = {},
          ),
        ),
      ),

      ScreenShotTestData(
        screenShotTestName = "ServiceWelcomePageDataWithStepsContent",
        value = ServiceWelcomePageData(
          topBarTitle = "Top bar title".toLabel(),
          topBarIconMainResId = R.drawable.ab004_arrow_left,
          onTopBarIconMainClick = {},
          topBarIconMenuResId = R.drawable.c1_info,
          onTopBarIconMenuClick = {},
          headerData = HeaderData(
            iconResId = R.drawable.da015_historia_pojazdu,
            iconColorProvider = { AppTheme.colors.headerCeladon100 },
            iconBackgroundColorProvider = { AppTheme.colors.headerGrass30 },
            title = "Title Size XXL Color - black 900".toLabel(),
            message = "Description text Size - M, Color - grey 900".toLabel(),
          ),
          contentData = InfoRowListData(
            items = listOf(
              InfoRowData.Bullet(
                description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
              ),
              InfoRowData.Bullet(
                description = "Support text\nSIZE M: Roboto Normal Gray 900".toLabel(),
              ),
            ),
          ),
          buttonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(
              label = "Sprawdź".toLabel(),
            ),
            onClick = {},
          ),
        ),
      ),
    )
}
