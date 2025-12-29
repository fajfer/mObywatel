package pl.gov.coi.common.ui.ds.singlecard.provider

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButtonData
import pl.gov.coi.common.ui.ds.singlecard.radiobutton.RadioButtonId
import pl.gov.coi.common.ui.ds.singlecard.SingleCardClickableRadioButtonState
import pl.gov.coi.common.ui.ds.singlecard.SingleCardData
import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoExtras
import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoState
import pl.gov.coi.common.ui.ds.singlecard.SingleCardStatusBadgeData
import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SingleCardPreviewParameterProvider : CustomPreviewParameterProvider<SingleCardData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<SingleCardData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitle",
      value = provideSingleCardInfoTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleLong",
      value = provideSingleCardInfoTitleLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleDescription",
      value = provideSingleCardInfoTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleDescriptionLong",
      value = provideSingleCardInfoTitleDescriptionLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleInfo",
      value = provideSingleCardInfoTitleInfo(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleInfoLong",
      value = provideSingleCardInfoTitleInfoLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleIcon",
      value = provideSingleCardInfoTitleIcon(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleInfoLong",
      value = provideSingleCardInfoTitleIconBigger(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleDescriptionIcon",
      value = provideSingleCardInfoTitleDescriptionIcon(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleDescriptionIconDisabledState",
      value = provideSingleCardInfoTitleDescriptionIconDisabledState(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleWithButton",
      value = provideSingleCardInfoTitleWithButton(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleWithSwitch",
      value = provideSingleCardInfoTitleWithSwitch(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoDraggableTitle",
      value = provideSingleCardInfoDraggableTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoDraggableTitleDescription",
      value = provideSingleCardInfoDraggableTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableTitle",
      value = provideSingleCardClickableTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableTitleWithoutTrailingIcon",
      value = provideSingleCardClickableTitleWithoutTrailingIcon(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableTitleLong",
      value = provideSingleCardClickableTitleLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableTitleDescription",
      value = provideSingleCardClickableTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableTitleDescriptionLong",
      value = provideSingleCardClickableTitleDescriptionLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableInfoTitle",
      value = provideSingleCardClickableInfoTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableInfoTitleLong",
      value = provideSingleCardClickableInfoTitleLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitle",
      value = provideSingleCardClickableIconTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitleLong",
      value = provideSingleCardClickableIconTitleLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitleDescription",
      value = provideSingleCardClickableIconTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitleDescriptionLong",
      value = provideSingleCardClickableIconTitleDescriptionLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableButtonIconTitle",
      value = provideSingleCardButtonIconTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableButtonIconTitleDescription",
      value = provideSingleCardButtonIconTitleDescription(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableDeleteButtonIconTitle",
      value = provideSingleCardDeleteButtonIconTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitleDescriptionLongEnabledState",
      value = provideSingleCardClickableIconTitleDescriptionLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitleDescriptionLongFocusState",
      value = provideSingleCardClickableIconTitleDescriptionLongFocusState(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitleDescriptionLongDisabledState",
      value = provideSingleCardClickableIconTitleDescriptionLongDisabledState(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableIconTitleDescriptionLongIconOnOneLineWithTitle",
      value = provideSingleCardClickableIconTitleDescriptionLongIconOnOneLineWithTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardClickableTitleDescriptionStatusBadge",
      value = provideSingleCardClickableTitleDescriptionStatusBadge(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselected",
      value = provideSingleCardSelectableRadioButtonTitleUnselected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedLong",
      value = provideSingleCardSelectableRadioButtonTitleUnselectedLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleSelected",
      value = provideSingleCardSelectableRadioButtonTitleSelected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonIconTitleUnselected",
      value = provideSingleCardSelectableRadioButtonIconTitleUnselected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonIconTitleUnselectedLong",
      value = provideSingleCardSelectableRadioButtonIconTitleUnselectedLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonIconTitleSelected",
      value = provideSingleCardSelectableRadioButtonIconTitleSelected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleDescriptionUnselected",
      value = provideSingleCardSelectableRadioButtonTitleDescriptionUnselected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleDescriptionUnselectedLong",
      value = provideSingleCardSelectableRadioButtonTitleDescriptionUnselectedLong(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleDescriptionSelected",
      value = provideSingleCardSelectableRadioButtonTitleDescriptionSelected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedEnabledState",
      value = provideSingleCardSelectableRadioButtonTitleUnselected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedFocusState",
      value = provideSingleCardSelectableRadioButtonTitleUnselectedFocusState(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonTitleUnselectedDisabledState",
      value = provideSingleCardSelectableRadioButtonTitleUnselectedDisabledState(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardSelectableRadioButtonBiggerIconTitleSelected",
      value = provideSingleCardSelectableRadioButtonBiggerIconTitleSelected(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SingleCardInfoTitleDescriptionStatusBadge",
      value = provideSingleCardInfoTitleDescriptionStatusBadge(),
    ),
  )

  private fun provideSingleCardInfoTitle() = SingleCardData.Info.Title(
    title = "Card title".toLabel(),
  )

  private fun provideSingleCardInfoTitleLong() = SingleCardData.Info.Title(
    title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
  )

  private fun provideSingleCardInfoTitleDescription() = SingleCardData.Info.TitleDescription(
    title = "Card title".toLabel(),
    description = "Card description".toLabel(),
  )

  private fun provideSingleCardInfoTitleDescriptionLong() = SingleCardData.Info.TitleDescription(
    title = "Card title".toLabel(),
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt"
      .toLabel(),
  )

  private fun provideSingleCardInfoTitleInfo() = SingleCardData.Info.InfoTitle(
    title = "Card title".toLabel(),
    info = "Card info".toLabel(),
  )

  private fun provideSingleCardInfoTitleInfoLong() = SingleCardData.Info.InfoTitle(
    title = "Card title".toLabel(),
    info = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
  )

  private fun provideSingleCardInfoTitleIcon() = SingleCardData.Info.IconTitle(
    title = "Card title".toLabel(),
    iconResId = R.drawable.ab001_home,
  )

  private fun provideSingleCardInfoTitleIconBigger() = SingleCardData.Info.IconTitle(
    title = "Card title".toLabel(),
    iconResId = R.drawable.ab001_home,
    iconSize = IconSize.SIZE32,
  )

  private fun provideSingleCardInfoTitleDescriptionIcon() = SingleCardData.Info.IconTitleDescription(
    title = "Card title".toLabel(),
    description = "Card description".toLabel(),
    iconResId = R.drawable.ab001_home,
  )

  private fun provideSingleCardInfoTitleDescriptionIconDisabledState() = SingleCardData.Info.IconTitleDescription(
    title = "Card title".toLabel(),
    description = "Card description".toLabel(),
    iconResId = R.drawable.ab001_home,
    state = SingleCardInfoState.DISABLE,
  )

  private fun provideSingleCardInfoTitleWithButton() = SingleCardData.Info.Title(
    title = "Card title".toLabel(),
    extras = SingleCardInfoExtras.ButtonMore(
      buttonData = ButtonData(
        buttonSize = ButtonSize.Small,
        buttonVariant = ButtonVariant.Primary,
        buttonType = ButtonType.WithText(
          label = "Więcej".toLabel(),
        ),
        onClick = {},
      ),
    ),
  )

  private fun provideSingleCardInfoTitleWithSwitch() = SingleCardData.Info.Title(
    title = "Card title".toLabel(),
    extras = SingleCardInfoExtras.Switch(
      switchData = SwitchData.SwitchOnly(
        contentDescription = "Card title".toLabel(),
        checked = false,
        onCheckedChange = {},
      ),
    ),
  )

  private fun provideSingleCardInfoDraggableTitle() = SingleCardData.Info.Title(
    title = "Card title".toLabel(),
    draggable = true,
  )

  private fun provideSingleCardInfoDraggableTitleDescription() = SingleCardData.Info.TitleDescription(
    title = "Card title".toLabel(),
    description = "Card description".toLabel(),
    draggable = true,
  )

  private fun provideSingleCardClickableTitle() = SingleCardData.Clickable.Title(
    title = "Card title".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableTitleWithoutTrailingIcon() = SingleCardData.Clickable.Title(
    title = "Card title".toLabel(),
    onClick = {},
    trailingIonResId = null,
  )

  private fun provideSingleCardClickableTitleLong() = SingleCardData.Clickable.Title(
    title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableTitleDescription() = SingleCardData.Clickable.TitleDescription(
    title = "Card title".toLabel(),
    description = "Card description".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableTitleDescriptionLong() = SingleCardData.Clickable.TitleDescription(
    title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableInfoTitle() = SingleCardData.Clickable.InfoTitle(
    title = "Card title".toLabel(),
    info = "Card info".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableInfoTitleLong() = SingleCardData.Clickable.InfoTitle(
    title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
    info = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableIconTitle() = SingleCardData.Clickable.IconTitle(
    iconResId = R.drawable.ab001_home,
    title = "Card title".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableIconTitleLong() = SingleCardData.Clickable.IconTitle(
    iconResId = R.drawable.ab001_home,
    title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableIconTitleDescription() = SingleCardData.Clickable.IconTitleDescription(
    iconResId = R.drawable.ab001_home,
    title = "Card title".toLabel(),
    description = "Card description".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableIconTitleDescriptionLong() = SingleCardData.Clickable.IconTitleDescription(
    iconResId = R.drawable.ab001_home,
    title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardClickableIconTitleDescriptionLongIconOnOneLineWithTitle() =
    SingleCardData.Clickable.IconTitleDescription(
      iconResId = R.drawable.ab001_home,
      iconOnOneLineWithTitle = true,
      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
      onClick = {},
    )

  private fun provideSingleCardClickableIconTitleDescriptionLongFocusState() =
    SingleCardData.Clickable.IconTitleDescription(
      iconResId = R.drawable.ab001_home,
      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
      state = SingleCardClickableRadioButtonState.FOCUS,
      onClick = {},
    )

  private fun provideSingleCardClickableIconTitleDescriptionLongDisabledState() =
    SingleCardData.Clickable.IconTitleDescription(
      iconResId = R.drawable.ab001_home,
      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
      state = SingleCardClickableRadioButtonState.DISABLED,
      onClick = {},
    )

  private fun provideSingleCardClickableTitleDescriptionStatusBadge() =
    SingleCardData.Clickable.TitleDescriptionStatusBadge(
      title = "Card title with status badge".toLabel(),
      description = "Card description".toLabel(),
      badgeData = SingleCardStatusBadgeData.WithIcon.Info(
        text = "Badge status info".toLabel(),
        iconContentDescription = "content desc".toLabel(),
      ),
      onClick = {},
    )

  private fun provideSingleCardButtonIconTitle() = SingleCardData.Clickable.ButtonIconTitle(
    iconResId = R.drawable.ab001_home,
    title = "Card title".toLabel(),
    onIconClick = {},
  )

  private fun provideSingleCardButtonIconTitleDescription() = SingleCardData.Clickable.ButtonIconTitleDescription(
    iconResId = R.drawable.ab001_home,
    title = "Card title".toLabel(),
    description = "Card description".toLabel(),
    onIconClick = {},
  )

  private fun provideSingleCardDeleteButtonIconTitle() = SingleCardData.Clickable.DeleteButtonIconTitle(
    title = "Card title".toLabel(),
    onClick = {},
  )

  private fun provideSingleCardSelectableRadioButtonTitleUnselected() = SingleCardData.SelectableRadioButton.Title(
    title = "Card title".toLabel(),
    radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
    onClick = {},
  )

  private fun provideSingleCardSelectableRadioButtonTitleUnselectedFocusState() =
    SingleCardData.SelectableRadioButton.Title(
      title = "Card title".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
      state = SingleCardClickableRadioButtonState.FOCUS,
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonTitleUnselectedDisabledState() =
    SingleCardData.SelectableRadioButton.Title(
      title = "Card title".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
      state = SingleCardClickableRadioButtonState.DISABLED,
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonTitleUnselectedLong() =
    SingleCardData.SelectableRadioButton.Title(
      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonTitleSelected() =
    SingleCardData.SelectableRadioButton.Title(
      title = "Card title".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonIconTitleUnselected() =
    SingleCardData.SelectableRadioButton.IconTitle(
      iconResId = R.drawable.ab001_home,
      title = "Card title".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonIconTitleUnselectedLong() =
    SingleCardData.SelectableRadioButton.IconTitle(
      iconResId = R.drawable.ab001_home,
      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonIconTitleSelected() =
    SingleCardData.SelectableRadioButton.IconTitle(
      iconResId = R.drawable.ab001_home,
      title = "Card title".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonBiggerIconTitleSelected() =
    SingleCardData.SelectableRadioButton.IconTitle(
      iconResId = R.drawable.ab001_home,
      iconSize = IconSize.SIZE32,
      title = "Card title".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonTitleDescriptionUnselected() =
    SingleCardData.SelectableRadioButton.TitleDescription(
      title = "Card title".toLabel(),
      description = "Card description no 1".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonTitleDescriptionUnselectedLong() =
    SingleCardData.SelectableRadioButton.TitleDescription(
      title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt".toLabel(),
      description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
      onClick = {},
    )

  private fun provideSingleCardSelectableRadioButtonTitleDescriptionSelected() =
    SingleCardData.SelectableRadioButton.TitleDescription(
      title = "Card title".toLabel(),
      description = "Card description no 1".toLabel(),
      descriptionSecond = "Card description no 2".toLabel(),
      radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
      onClick = {},
    )

  private fun provideSingleCardInfoTitleDescriptionStatusBadge() =
    SingleCardData.Info.TitleStatusBadge(
      title = "Status".toLabel(),
      state = SingleCardInfoState.ENABLED,
      badgeData = SingleCardStatusBadgeData.Default.Green(
        text = "Opłacona".toLabel(),
      ),
    )
}
