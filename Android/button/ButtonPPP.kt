package pl.gov.coi.common.ui.ds.button

import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonState
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class ButtonPPP : CustomPreviewParameterProvider<ButtonData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ButtonData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SmallTextPrimaryEnabled",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallTextPrimaryEnabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Primary,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallTextPrimaryDestructive",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallTextPrimaryDestructive".toLabel(),
        ),
        buttonVariant = ButtonVariant.Primary,
        buttonState = ButtonState.Destructive,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallPrimaryDisabled",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallPrimaryDisabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Primary,
        buttonState = ButtonState.Disabled,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallSecondaryEnabled",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallSecondaryEnabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Secondary(),
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallSecondaryDestructive",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallSecondaryDestructive".toLabel(),
        ),
        buttonVariant = ButtonVariant.Secondary(),
        buttonState = ButtonState.Destructive,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallSecondaryDisabled",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallSecondaryDisabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Secondary(),
        buttonState = ButtonState.Disabled,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallTertiaryEnabled",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallTertiaryEnabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Tertiary,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallTertiaryDestructive",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallTertiaryDestructive".toLabel(),
        ),
        buttonVariant = ButtonVariant.Tertiary,
        buttonState = ButtonState.Destructive,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallTertiaryDisabled",
      value = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonType = ButtonType.WithText(
          label = "SmallTertiaryDisabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Tertiary,
        buttonState = ButtonState.Disabled,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargePrimaryEnabled",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargePrimaryEnabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Primary,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargePrimaryDestructive",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargePrimaryDestructive".toLabel(),
        ),
        buttonVariant = ButtonVariant.Primary,
        buttonState = ButtonState.Destructive,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargePrimaryDisabled",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargePrimaryDisabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Primary,
        buttonState = ButtonState.Disabled,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargeSecondaryEnabled",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargeSecondaryEnabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Secondary(),
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargeSecondaryDestructive",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargeSecondaryDestructive".toLabel(),
        ),
        buttonVariant = ButtonVariant.Secondary(),
        buttonState = ButtonState.Destructive,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargeSecondaryDisabled",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargeSecondaryDisabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Secondary(),
        buttonState = ButtonState.Disabled,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargeTertiaryEnabled",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargeTertiaryEnabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Tertiary,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargeTertiaryDestructive",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargeTertiaryDestructive".toLabel(),
        ),
        buttonVariant = ButtonVariant.Tertiary,
        buttonState = ButtonState.Destructive,
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargeTertiaryDisabled",
      value = ButtonData(
        buttonSize = ButtonSize.Large(),
        buttonType = ButtonType.WithText(
          label = "LargeTertiaryDisabled".toLabel(),
        ),
        buttonVariant = ButtonVariant.Tertiary,
        buttonState = ButtonState.Disabled,
        onClick = {},
      ),
    ),
  )
}
