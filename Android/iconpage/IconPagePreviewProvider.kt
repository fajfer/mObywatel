package pl.gov.coi.common.ui.ds.iconpage

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class IconPagePreviewProvider : CustomPreviewParameterProvider<IconPageData<*, *>>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<IconPageData<*, *>>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "IconPageResultStateFailure",
      value = IconPageData(
        iconSection = IconSection.Result.Failure,
        title = "Icon Page Result Failure".toLabel(),
        descriptionFirst = "description first".toLabel(),
        descriptionSecond = "description second".toLabel(),
        content = null,
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageResultStateInfoNoBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Result.Info,
        title = "Icon Page Result Info".toLabel(),
        descriptionFirst = "description first".toLabel(),
        content = null,
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageResultStateInfoBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Result.Info,
        title = "Icon Page Result Info".toLabel(),
        descriptionFirst = "description first".toLabel(),
        content = null,
        bottomContent = IconPageBottomContentData(
          primaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
            onClick = { },
          ),
          secondaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Secondary(),
            buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
            onClick = { },
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageResultStateSuccessNoBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Result.Success,
        title = "Icon Page Result Success".toLabel(),
        descriptionFirst = "description first".toLabel(),
        content = null,
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageResultStateSuccessBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Result.Success,
        title = "Icon Page Result Success".toLabel(),
        descriptionFirst = "description first".toLabel(),
        content = null,
        bottomContent = IconPageBottomContentData(
          primaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
            onClick = { },
          ),
          secondaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Secondary(),
            buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
            onClick = { },
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageResultStateWarning",
      value = IconPageData(
        iconSection = IconSection.Result.Warning,
        title = "Icon Page Result Success".toLabel(),
        descriptionFirst = "description first".toLabel(),
        content = null,
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageEmptyStateDescription",
      value = IconPageData(
        iconSection = IconSection.Empty(),
        title = "Icon Page Empty state".toLabel(),
        descriptionFirst = "description first".toLabel(),
        content = null,
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageEmptyStateNoBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Empty(),
        title = "Icon Page Empty State".toLabel(),
        content = null,
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageEmptyStateBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Empty(),
        title = "Icon Page Empty State".toLabel(),
        content = null,
        bottomContent = IconPageBottomContentData(
          primaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
            onClick = { },
          ),
          secondaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Secondary(),
            buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
            onClick = { },
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageEmptyIconDescription",
      value = IconPageData(
        iconSection = IconSection.Empty(
          iconRes = R.drawable.g005_mbiznes,
        ),
        title = "Icon Page Empty State".toLabel(),
        descriptionFirst = "description first".toLabel(),
        descriptionSecond = "description second".toLabel(),
        content = null,
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageEmptyWithContentNoBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Empty(
          iconRes = R.drawable.g005_mbiznes,
        ),
        title = "Icon Page Empty State".toLabel(),
        descriptionFirst = "description first".toLabel(),
        descriptionSecond = "description second".toLabel(),
        content = InfoRowListData(
          items = listOf(
            InfoRowData.Bullet(
              description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
            ),
            InfoRowData.Bullet(
              description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
            ),
            InfoRowData.Bullet(
              description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
            ),
          ),
        ),
        bottomContent = null,
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "IconPageEmptyWithContentBottomButtons",
      value = IconPageData(
        iconSection = IconSection.Empty(
          iconRes = R.drawable.g005_mbiznes,
        ),
        title = "Icon Page Empty State".toLabel(),
        descriptionFirst = "description first".toLabel(),
        descriptionSecond = "description second".toLabel(),
        content = InfoRowListData(
          items = listOf(
            InfoRowData.Bullet(
              description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
            ),
            InfoRowData.Bullet(
              description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
            ),
            InfoRowData.Bullet(
              description = "Support text font: bodyLargeRegular color: neutral200".toLabel(),
            ),
          ),
        ),
        bottomContent = IconPageBottomContentData(
          primaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(label = "Dalej".toLabel()),
            onClick = { },
          ),
          secondaryButtonData = ButtonData(
            buttonSize = ButtonSize.Large(),
            buttonVariant = ButtonVariant.Secondary(),
            buttonType = ButtonType.WithText(label = "Zamknij".toLabel()),
            onClick = { },
          ),
        ),
      ),
    ),
  )
}
