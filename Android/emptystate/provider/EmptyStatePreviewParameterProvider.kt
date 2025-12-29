package pl.gov.coi.common.ui.ds.emptystate.provider

import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.emptystate.EmptyStateData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class EmptyStatePreviewParameterProvider : CustomPreviewParameterProvider<EmptyStateData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<EmptyStateData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "EmptyStateDataNoTitle",
      value = provideEmptyStateDataNoTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "EmptyStateStateDataWithTitle",
      value = provideEmptyStateDataWithTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "EmptyStateDataStandardWithButton",
      value = provideEmptyStateDataWithButton(),
    ),
    ScreenShotTestData(
      screenShotTestName = "EmptyStateDataNoTitleWithButton",
      value = provideEmptyStateDataNoTitleWithButton(),
    ),
  )

  private fun provideEmptyStateDataWithTitle() = EmptyStateData(
    title = "Title section (optional)".toLabel(),
    body = "Body section".toLabel(),
  )

  private fun provideEmptyStateDataNoTitle() = EmptyStateData(
    body = "Body section".toLabel(),
  )

  private fun provideEmptyStateDataWithButton() = EmptyStateData(
    title = "Title section (optional)".toLabel(),
    body = "Body section".toLabel(),
    buttonData = ButtonData(
      buttonSize = ButtonSize.Small,
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Tertiary small button (optional)".toLabel(),
      ),
      onClick = {},
    ),
  )

  private fun provideEmptyStateDataNoTitleWithButton() = EmptyStateData(
    body = "Body section".toLabel(),
    buttonData = ButtonData(
      buttonSize = ButtonSize.Small,
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Tertiary small button (optional)".toLabel(),
      ),
      onClick = {},
    ),
  )
}
