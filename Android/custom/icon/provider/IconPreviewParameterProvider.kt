package pl.gov.coi.common.ui.ds.custom.icon.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class IconPreviewParameterProvider : CustomPreviewParameterProvider<IconData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<IconData>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "IconDataStandard",
        value = providerIconDataStandard(),
      ),
      ScreenShotTestData(
        screenShotTestName = "IconBackgroundRounded",
        value = providerIconDataBackgroundRounded(),
      ),
      ScreenShotTestData(
        screenShotTestName = "IconBackgroundSquare",
        value = providerIconDataBackgroundSquare(),
      ),
      ScreenShotTestData(
        screenShotTestName = "IconBackgroundRoundedSquare",
        value = providerIconDataBackgroundRoundedSquare(),
      ),
      ScreenShotTestData(
        screenShotTestName = "IconBackgroundRoundedExample",
        value = providerIconDataBackgroundRoundedExample(),
      ),
    )

  companion object {
    fun providerIconDataStandard() = IconData.Standard(
      iconResId = R.drawable.aa008_change_password,
      iconSize = IconSize.SIZE48,
      iconColorProvider = { AppTheme.colors.supportRed100 },
      contentDescription = Label.EMPTY,
    )

    fun providerIconDataBackgroundRounded() = IconData.Background(
      iconResId = R.drawable.c2_warning_mark,
      backgroundSize = IconSize.SIZE48,
      iconSize = IconSize.SIZE32,
      iconColorProvider = { AppTheme.colors.primary900 },
      backgroundColorProvider = { AppTheme.colors.secondary900 },
      backgroundShape = BackgroundShape.Rounded,
      contentDescription = Label.EMPTY,
    )

    fun providerIconDataBackgroundSquare() = IconData.Background(
      iconResId = R.drawable.c4_success,
      backgroundSize = IconSize.SIZE48,
      iconSize = IconSize.SIZE32,
      iconColorProvider = { AppTheme.colors.primary900 },
      backgroundColorProvider = { AppTheme.colors.secondary900 },
      backgroundShape = BackgroundShape.Square,
      contentDescription = Label.EMPTY,
    )

    fun providerIconDataBackgroundRoundedSquare() = IconData.Background(
      iconResId = R.drawable.c3_error_mark,
      backgroundSize = IconSize.SIZE48,
      iconSize = IconSize.SIZE32,
      iconColorProvider = { AppTheme.colors.primary900 },
      backgroundColorProvider = { AppTheme.colors.secondary900 },
      backgroundShape = BackgroundShape.RoundedSquare({ AppTheme.shapes.radius150 }),
      contentDescription = Label.EMPTY,
    )

    fun providerIconDataBackgroundRoundedExample() = IconData.Background(
      iconResId = R.drawable.ag005_globe,
      backgroundSize = IconSize.SIZE96,
      iconSize = IconSize.SIZE64,
      iconColorProvider = { AppTheme.colors.primary900 },
      backgroundColorProvider = { AppTheme.colors.secondary900 },
      backgroundShape = BackgroundShape.Rounded,
      contentDescription = Label.EMPTY,
    )
  }
}
