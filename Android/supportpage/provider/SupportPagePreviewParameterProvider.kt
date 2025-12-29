package pl.gov.coi.common.ui.ds.supportpage.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.ds.supportpage.SupportPageData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SupportPagePreviewParameterProvider : CustomPreviewParameterProvider<SupportPageData<*>>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<SupportPageData<*>>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "SupportPageData",
        value = SupportPageData(
          topBarTitle = "Top bar title".toLabel(),
          topBarIconMainResId = null,
          onTopBarIconMainClick = null,
          topBarIconMenuResId = null,
          onTopBarIconMenuClick = null,
          iconResId = R.drawable.ag005_globe,
          iconContentDescription = Label.EMPTY,
          title = "Title Size XXL medium 24 Color - black 900".toLabel(),
          message = "Description text Size - M, Color - grey 900".toLabel(),
          contentData = Unit,
          buttonData = null,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = "SupportPageDataExample",
        value = SupportPageData(
          topBarTitle = "Wybierz język".toLabel(),
          topBarIconMainResId = R.drawable.ab004_arrow_left,
          onTopBarIconMainClick = {},
          topBarIconMenuResId = null,
          onTopBarIconMenuClick = null,
          iconResId = R.drawable.ag005_globe,
          iconContentDescription = Label.EMPTY,
          title = "Top bar title".toLabel(),
          message = "Nie można zmienić języka w Ustawieniach.".toLabel(),
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
              label = "Dalej".toLabel(),
            ),
            onClick = {},
          ),
        ),
      ),
    )
}
