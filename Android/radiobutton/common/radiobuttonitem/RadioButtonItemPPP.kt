package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem

import android.content.Context
import pl.gov.coi.common.domain.Mapper
import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData

class RadioButtonItemPPP : CustomWrappedDataPreviewParameterProvider<
  Unit,
  RadioButtonItemData?,
  Mapper<Unit, RadioButtonItemData?>,
  RadioButtonItemData,
  >() {

  override fun mapper(context: Context) = object : Mapper<Unit, RadioButtonItemData?> {
    override fun invoke(p1: Unit): RadioButtonItemData? = null
  }

  override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<RadioButtonItemData>> = sequenceOf(
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemUnselected",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = false,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemUnselectedDisabled",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = false,
          isSelected = false,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemSelected",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = true,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemSelectedDisabled",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = false,
          isSelected = true,
          isError = false,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemUnselectedError",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = false,
          isError = true,
        )
      },
    ),
    ScreenShotTestDataProvider(
      screenShotTestName = "RadioButtonItemSelectedError",
      wrappedValue = WrappedValue {
        provideRadioButtonItemData(
          enabled = true,
          isSelected = true,
          isError = true,
        )
      },
    ),
  )

  private fun provideRadioButtonItemData(
    enabled: Boolean,
    isSelected: Boolean,
    isError: Boolean,
  ) = RadioButtonItemData(
    enabled = enabled,
    isSelected = isSelected,
    isError = isError,
  )
}
