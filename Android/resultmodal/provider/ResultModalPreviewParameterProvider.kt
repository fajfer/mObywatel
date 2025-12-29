package pl.gov.coi.common.ui.ds.resultmodal.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.resultmodal.ResultModalData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class ResultModalPreviewParameterProvider : CustomPreviewParameterProvider<ResultModalData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ResultModalData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "ResultModalData",
      value = provideResultModalData(),
    ),
  )

  private fun provideResultModalData() = ResultModalData(
    iconRes = R.drawable.f4_success,
    iconColorProvider = { AppTheme.colors.supportGreen100 },
    iconContentDescription = Label.EMPTY,
    title = "Title Roboto Medium 20".toLabel(),
    dataTitle1 = "Data title 2 Roboto Regular 16".toLabel(),
    data1 = "Data 1 Roboto Medium 18\nData 1 Roboto Medium 18".toLabel(),
    dataTitle2 = "Data title 2 Roboto Regular 16".toLabel(),
    data2 = "Data 2 Roboto Medium 18".toLabel(),
    primaryButton = ButtonData(
      buttonSize = ButtonSize.Large(),
      buttonVariant = ButtonVariant.Primary,
      buttonType = ButtonType.WithText(
        label = "Primary button".toLabel(),
      ),
      onClick = {},
    ),
    secondaryButton = ButtonData(
      buttonSize = ButtonSize.Large(),
      buttonVariant = ButtonVariant.Secondary(),
      buttonType = ButtonType.WithText(
        label = "Secondary button".toLabel(),
      ),
      onClick = {},
    ),
    tertiaryButton = ButtonData(
      buttonSize = ButtonSize.Large(),
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Tertiary button".toLabel(),
      ),
      onClick = {},
    ),
    closeIconContentDescription = Label.EMPTY,
    closeAction = {},
  )
}
