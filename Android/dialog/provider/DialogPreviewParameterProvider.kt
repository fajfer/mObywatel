package pl.gov.coi.common.ui.ds.dialog.provider

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonState
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.dialog.DialogData
import pl.gov.coi.common.ui.ds.dialog.DialogIconData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.theme.withStyle

class DialogPreviewParameterProvider() : CustomPreviewParameterProvider<DialogData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<DialogData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "DialogLongTextOneButton",
      value = provideDialogLongTextOneButton(),
    ),
    ScreenShotTestData(
      screenShotTestName = "DialogLongTextTwoButtons",
      value = provideDialogLongTextTwoButtons(),
    ),
    ScreenShotTestData(
      screenShotTestName = "DialogLongTextThreeButtons",
      value = provideDialogLongTextThreeButtons(),
    ),
    ScreenShotTestData(
      screenShotTestName = "DialogOnlyTitleOneButton",
      value = provideDialogOnlyTitleOneButton(),
    ),
    ScreenShotTestData(
      screenShotTestName = "DialogShortTextColoredButton",
      value = provideDialogShortTextColoredButton(),
    ),
    ScreenShotTestData(
      screenShotTestName = "DialogShortTextWithIcon",
      value = provideDialogShortTextWithIcon(),
    ),
    ScreenShotTestData(
      screenShotTestName = "DialogHighlightedTextTwoButtons",
      value = provideDialogHighlightedTextTwoButtons(),
    ),
  )

  private fun provideLongText() =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. " +
      "Proin gravida dolor sit amet lacus accumsan et viverra justo commodo. Proin sodales pulvinar tempor. " +
      "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."

  private fun provideDialogLongTextOneButton() =
    DialogData.WithText(
      title = "Dialog Title".toLabel(),
      body = provideLongText().toLabel(),
      primaryButtonData =
      ButtonData(
        buttonVariant = ButtonVariant.Tertiary,
        buttonType = ButtonType.WithText(
          label = "Primary button".toLabel(),
        ),
        buttonSize = ButtonSize.Small,
        onClick = {},
      ),
    ) {}

  private fun provideDialogLongTextTwoButtons() = provideDialogLongTextOneButton().copy(
    secondaryButtonData = ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Secondary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
  )

  private fun provideDialogLongTextThreeButtons() = DialogData.WithThreeButtons(
    title = "Dialog Title".toLabel(),
    body = provideLongText().toLabel(),
    primaryButtonData = ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Primary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
    secondaryButtonData = ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Secondary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
    tertiaryButtonData =
    ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Tertiary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
  ) {}

  private fun provideDialogOnlyTitleOneButton() = DialogData.WithText(
    title = "Dialog Title".toLabel(),
    primaryButtonData = ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Primary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
  ) {}

  private fun provideDialogShortTextColoredButton() = DialogData.WithText(
    title = "Dialog Title".toLabel(),
    body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet.".toLabel(),
    primaryButtonData = ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Primary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
    secondaryButtonData = ButtonData(
      buttonState = ButtonState.Destructive,
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Secondary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
  ) {}

  private fun provideDialogShortTextWithIcon() = DialogData.WithIcon(
    icon = DialogIconData(
      iconResId = R.drawable.aa025_star,
      iconColorProvider = { AppTheme.colors.supportRed100 },
    ),
    title = "Dialog Title".toLabel(),
    body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet.".toLabel(),
    primaryButtonData = ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Primary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
    secondaryButtonData = ButtonData(
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Secondary button".toLabel(),
      ),
      buttonSize = ButtonSize.Small,
      onClick = {},
    ),
  ) {}

  private fun provideDialogHighlightedTextTwoButtons() = provideDialogLongTextTwoButtons().copy(
    annotatedBody = { getAnnotatedString() },
  )

  @Composable
  private fun getAnnotatedString() =
    buildAnnotatedString {
      val spanStyle = AppTheme.typography.bodyLargeRegular
      withStyle(spanStyle) {
        append("Normal text")
      }
      withStyle(
        spanStyle.copy(
          fontWeight = FontWeight.Bold,
          color = AppTheme.colors.primary900,
        ),
      ) {
        append(" Highlighted text")
      }
      withStyle(spanStyle) {
        append(" Normal text")
      }
    }

}
