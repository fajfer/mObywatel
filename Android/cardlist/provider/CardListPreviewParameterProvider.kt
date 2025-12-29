package pl.gov.coi.common.ui.ds.cardlist.provider

import android.content.Context
import pl.gov.coi.common.domain.Mapper
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.cardlist.CardListData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButtonData
import pl.gov.coi.common.ui.ds.singlecard.radiobutton.RadioButtonId
import pl.gov.coi.common.ui.ds.singlecard.SingleCardClickableRadioButtonState
import pl.gov.coi.common.ui.ds.singlecard.SingleCardData
import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoExtras
import pl.gov.coi.common.ui.ds.singlecard.SingleCardInfoState
import pl.gov.coi.common.ui.ds.singlecard.SingleCardStatusBadgeData
import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
import pl.gov.coi.common.ui.preview.WrappedValue

data class ProvidedCardListData(
  val previewName: String,
  val data: CardListData,
)

class CardListPreviewProvider : CustomWrappedDataPreviewParameterProvider<
  Unit,
  CardListData,
  Mapper<Unit, CardListData>,
  ProvidedCardListData,
  >() {

  private val cards = mapOf(
    "InfoTitle" to getCardListInfoTitle(),
    "InfoTitleLong" to getCardListInfoTitleLong(),
    "InfoTitleDescriptionLong" to getCardListInfoTitleDescriptionLong(),
    "InfoTitleInfo" to getCardListInfoTitleInfo(),
    "InfoTitleDescription" to getCardListInfoTitleDescription(),
    "InfoTitleInfoLong" to getCardListInfoTitleInfoLong(),
    "InfoTitleIcon" to getCardListInfoTitleIcon(),
    "InfoTitleIconBigger" to getCardListInfoTitleIconBigger(),
    "InfoTitleDescriptionIcon" to getCardListInfoTitleDescriptionIcon(),
    "InfoTitleDescriptionIconDisabledState" to getCardListInfoTitleDescriptionIconDisabledState(),
    "InfoTitleWithButton" to getCardListInfoTitleWithButton(),
    "InfoTitleWithSwitch" to getCardListInfoTitleWithSwitch(),
    "ClickableTitle" to getCardListClickableTitle(),
    "ClickableTitleLong" to getCardListClickableTitleLong(),
    "ClickableTitleDescription" to getCardListClickableTitleDescription(),
    "ClickableTitleDescriptionLong" to getCardListClickableTitleDescriptionLong(),
    "ClickableInfoTitle" to getCardListClickableInfoTitle(),
    "ClickableInfoTitleLong" to getCardListClickableInfoTitleLong(),
    "ClickableIconTitle" to getCardListClickableIconTitle(),
    "ClickableIconTitleLong" to getCardListClickableIconTitleLong(),
    "ClickableIconTitleDescription" to getCardListClickableIconTitleDescription(),
    "ClickableIconTitleDescriptionLong" to getCardListClickableIconTitleDescriptionLong(),
    "ClickableIconTitleDescriptionLongIconOnOneLineWithTitle" to
      getCardListClickableIconTitleDescriptionLongIconOnOneLineWithTitle(),
    "ClickableIconTitleDescriptionLongFocusState" to getCardListClickableIconTitleDescriptionLongFocusState(),
    "ClickableIconTitleDescriptionLongDisabledState" to getCardListClickableIconTitleDescriptionLongDisabledState(),
    "ClickableTitleDescriptionStatusBadge" to getCardListClickableTitleDescriptionStatusBadge(),
    "ClickableButtonIconTitle" to getCardListClickableButtonIconTitle(),
    "ClickableDeleteButtonIconTitle" to getCardListClickableDeleteButtonIconTitle(),
    "SelectableRadioButtonTitleUnselected" to getCardListSelectableRadioButtonTitleUnselected(),
    "SelectableRadioButtonTitleUnselectedFocusState" to getCardListSelectableRadioButtonTitleUnselectedFocusState(),
    "SelectableRadioButtonTitleUnselectedDisabledState" to
      getCardListSelectableRadioButtonTitleUnselectedDisabledState(),
    "SelectableRadioButtonTitleUnselectedLong" to getCardListSelectableRadioButtonTitleUnselectedLong(),
    "SelectableRadioButtonTitleSelected" to getCardListSelectableRadioButtonTitleSelected(),
    "SelectableRadioButtonIconTitleUnselected" to getCardListSelectableRadioButtonIconTitleUnselected(),
    "SelectableRadioButtonIconTitleUnselectedLong" to getCardListSelectableRadioButtonIconTitleUnselectedLong(),
    "SelectableRadioButtonIconTitleSelected" to getCardListSelectableRadioButtonIconTitleSelected(),
    "SelectableRadioButtonBiggerIconTitleSelected" to getCardListSelectableRadioButtonBiggerIconTitleSelected(),
    "SelectableRadioButtonTitleDescriptionUnselected" to getCardListSelectableRadioButtonTitleDescriptionUnselected(),
    "SelectableRadioButtonTitleDescriptionUnselectedLong" to
      getCardListSelectableRadioButtonTitleDescriptionUnselectedLong(),
    "SelectableRadioButtonTitleDescriptionSelected" to getCardListSelectableRadioButtonTitleDescriptionSelected(),
  )

  override fun mapper(context: Context): Mapper<Unit, CardListData> {
    return object : Mapper<Unit, CardListData> {
      override fun invoke(p1: Unit): CardListData = CardListData(cards = emptyList())
    }
  }

  override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<ProvidedCardListData>>
    get() = cards.map { (testName, cardData) ->
      ScreenShotTestDataProvider(
        screenShotTestName = testName,
        wrappedValue = WrappedValue {
          ProvidedCardListData(
            previewName = testName,
            data = cardData,
          )
        },
      )
    }.asSequence()

  private fun getCardListInfoTitle() = CardListData(
    cards = listOf(
      SingleCardData.Info.Title(
        title = "Card title".toLabel(),
      ),
      SingleCardData.Info.Title(
        title = "Card title 2".toLabel(),
      ),
    ),
  )

  private fun getCardListInfoTitleLong() = CardListData(
    cards = listOf(
      SingleCardData.Info.Title(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit, sed do eiusmod tempor incididunt"
          ).toLabel(),
      ),
      SingleCardData.Info.Title(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit, sed do eiusmod tempor incididunt 2"
          ).toLabel(),
      ),
    ),
  )

  private fun getCardListInfoTitleDescription() = CardListData(
    cards = listOf(
      SingleCardData.Info.TitleDescription(
        title = "Card title".toLabel(),
        description = "Card description".toLabel(),
      ),
      SingleCardData.Info.TitleDescription(
        title = "Card title 2".toLabel(),
        description = "Card description 2".toLabel(),
      ),
    ),
  )

  private fun getCardListInfoTitleDescriptionLong() = CardListData(
    cards = listOf(
      SingleCardData.Info.TitleDescription(
        title = "Card title".toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit, sed do eiusmod tempor incididunt"
          )
          .toLabel(),
      ),
      SingleCardData.Info.TitleDescription(
        title = "Card title 2".toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit, sed do eiusmod tempor incididunt 2"
          )
          .toLabel(),
      ),
    ),
  )

  private fun getCardListInfoTitleInfo() = CardListData(
    cards = listOf(
      SingleCardData.Info.InfoTitle(
        title = "Card title".toLabel(),
        info = "Card info".toLabel(),
      ),
      SingleCardData.Info.InfoTitle(
        title = "Card title 2".toLabel(),
        info = "Card info 2".toLabel(),
      ),
    ),
  )

  private fun getCardListInfoTitleInfoLong() = CardListData(
    cards = listOf(
      SingleCardData.Info.InfoTitle(
        title = "Card title".toLabel(),
        info = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt"
          ).toLabel(),
      ),
      SingleCardData.Info.InfoTitle(
        title = "Card title 2".toLabel(),
        info = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt 2"
          ).toLabel(),
      ),
    ),
  )

  private fun getCardListInfoTitleIcon() = CardListData(
    cards = listOf(
      SingleCardData.Info.IconTitle(
        title = "Card title".toLabel(),
        iconResId = R.drawable.ab001_home,
      ),
      SingleCardData.Info.IconTitle(
        title = "Card title 2".toLabel(),
        iconResId = R.drawable.ab001_home,
      ),
    ),
  )

  private fun getCardListInfoTitleIconBigger() = CardListData(
    cards = listOf(
      SingleCardData.Info.IconTitle(
        title = "Card title".toLabel(),
        iconResId = R.drawable.ab001_home,
        iconSize = IconSize.SIZE32,
      ),
      SingleCardData.Info.IconTitle(
        title = "Card title 2".toLabel(),
        iconResId = R.drawable.ab001_home,
        iconSize = IconSize.SIZE32,
      ),
    ),
  )

  private fun getCardListInfoTitleDescriptionIcon() = CardListData(
    cards = listOf(
      SingleCardData.Info.IconTitleDescription(
        title = "Card title".toLabel(),
        description = "Card description".toLabel(),
        iconResId = R.drawable.ab001_home,
      ),
      SingleCardData.Info.IconTitleDescription(
        title = "Card title 2".toLabel(),
        description = "Card description 2".toLabel(),
        iconResId = R.drawable.ab001_home,
      ),
    ),
  )

  private fun getCardListInfoTitleDescriptionIconDisabledState() = CardListData(
    cards = listOf(
      SingleCardData.Info.IconTitleDescription(
        title = "Card title".toLabel(),
        description = "Card description".toLabel(),
        iconResId = R.drawable.ab001_home,
        state = SingleCardInfoState.DISABLE,
      ),
      SingleCardData.Info.IconTitleDescription(
        title = "Card title 2".toLabel(),
        description = "Card description 2".toLabel(),
        iconResId = R.drawable.ab001_home,
        state = SingleCardInfoState.DISABLE,
      ),
    ),
  )

  private fun getCardListInfoTitleWithButton() = CardListData(
    cards = listOf(
      SingleCardData.Info.Title(
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
      ),
      SingleCardData.Info.Title(
        title = "Card title 2".toLabel(),
        extras = SingleCardInfoExtras.ButtonMore(
          buttonData = ButtonData(
            buttonSize = ButtonSize.Small,
            buttonVariant = ButtonVariant.Primary,
            buttonType = ButtonType.WithText(
              label = "Więcej 2".toLabel(),
            ),
            onClick = {},
          ),
        ),
      ),
    ),
  )

  private fun getCardListInfoTitleWithSwitch() = CardListData(
    cards = listOf(
      SingleCardData.Info.Title(
        title = "Card title".toLabel(),
        extras = SingleCardInfoExtras.Switch(
          switchData = SwitchData.SwitchOnly(
            contentDescription = "Card title".toLabel(),
            checked = false,
            onCheckedChange = {},
          ),
        ),
      ),
      SingleCardData.Info.Title(
        title = "Card title 2".toLabel(),
        extras = SingleCardInfoExtras.Switch(
          switchData = SwitchData.SwitchOnly(
            checked = false,
            contentDescription = "Card title 2".toLabel(),
            onCheckedChange = {},
          ),
        ),
      ),
    ),
  )

  private fun getCardListClickableTitle() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.Title(
        title = "Card title".toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.Title(
        title = "Card title 2".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableTitleLong() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.Title(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.Title(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableTitleDescription() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.TitleDescription(
        title = "Card title".toLabel(),
        description = "Card description".toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.TitleDescription(
        title = "Card title 2".toLabel(),
        description = "Card description 2".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableTitleDescriptionLong() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.TitleDescription(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor"
          ).toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.TitleDescription(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor 2"
          ).toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableInfoTitle() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.InfoTitle(
        title = "Card title".toLabel(),
        info = "Card info".toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.InfoTitle(
        title = "Card title 2".toLabel(),
        info = "Card info 2".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableInfoTitleLong() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.InfoTitle(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        info = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.InfoTitle(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        info = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableIconTitle() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title".toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title 2".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableIconTitleLong() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableIconTitleDescription() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = "Card title".toLabel(),
        description = "Card description".toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = "Card title 2".toLabel(),
        description = "Card description 2".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableIconTitleDescriptionLong() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor"
          ).toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor 2"
          ).toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableIconTitleDescriptionLongIconOnOneLineWithTitle() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        iconOnOneLineWithTitle = true,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor"
          ).toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        iconOnOneLineWithTitle = true,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor 2"
          ).toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableIconTitleDescriptionLongFocusState() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor"
          ).toLabel(),
        state = SingleCardClickableRadioButtonState.FOCUS,
        onClick = {},
      ),
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor 2"
          ).toLabel(),
        state = SingleCardClickableRadioButtonState.ENABLED,
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableIconTitleDescriptionLongDisabledState() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor"
          ).toLabel(),
        state = SingleCardClickableRadioButtonState.DISABLED,
        onClick = {},
      ),
      SingleCardData.Clickable.IconTitleDescription(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor 2"
          ).toLabel(),
        state = SingleCardClickableRadioButtonState.DISABLED,
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableTitleDescriptionStatusBadge() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.TitleDescriptionStatusBadge(
        title = "Card title with status badge".toLabel(),
        description = "Card description".toLabel(),
        badgeData = SingleCardStatusBadgeData.WithIcon.Info(
          text = "Badge status info".toLabel(),
          iconContentDescription = "content desc".toLabel(),
        ),
        onClick = {},
      ),
      SingleCardData.Clickable.TitleDescriptionStatusBadge(
        title = "Card title with status badge 2".toLabel(),
        description = "Card description 2".toLabel(),
        badgeData = SingleCardStatusBadgeData.WithIcon.Info(
          text = "Badge status info 2".toLabel(),
          iconContentDescription = "content desc 2".toLabel(),
        ),
        onClick = {},
      ),
    ),
  )

  private fun getCardListClickableButtonIconTitle() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.ButtonIconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title".toLabel(),
        onIconClick = {},
      ),
      SingleCardData.Clickable.ButtonIconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title 2".toLabel(),
        onIconClick = {},
      ),
    ),
  )

  private fun getCardListClickableDeleteButtonIconTitle() = CardListData(
    cards = listOf(
      SingleCardData.Clickable.DeleteButtonIconTitle(
        title = "Card title".toLabel(),
        onClick = {},
      ),
      SingleCardData.Clickable.DeleteButtonIconTitle(
        title = "Card title 2".toLabel(),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleUnselected() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleUnselectedFocusState() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title".toLabel(),
        radioButtonData = OldRadioButtonData(
          id = RadioButtonId.Default,
          isSelected = false,
        ),
        state = SingleCardClickableRadioButtonState.FOCUS,
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        state = SingleCardClickableRadioButtonState.FOCUS,
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleUnselectedDisabledState() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title".toLabel(),
        radioButtonData = OldRadioButtonData(
          id = RadioButtonId.Default,
          isSelected = false,
        ),
        state = SingleCardClickableRadioButtonState.DISABLED,
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title 2".toLabel(),
        radioButtonData = OldRadioButtonData(
          id = RadioButtonId.Default,
          isSelected = false,
        ),
        state = SingleCardClickableRadioButtonState.DISABLED,
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleUnselectedLong() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.Title(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        radioButtonData = OldRadioButtonData(
          id = RadioButtonId.Default,
          isSelected = false,
        ),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.Title(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        radioButtonData = OldRadioButtonData(
          id = RadioButtonId.Default,
          isSelected = false,
        ),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleSelected() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title".toLabel(),
        radioButtonData = OldRadioButtonData(
          id = RadioButtonId.Default,
          isSelected = true,
        ),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.Title(
        title = "Card title 2".toLabel(),
        radioButtonData = OldRadioButtonData(
          id = RadioButtonId.Default,
          isSelected = false,
        ),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonIconTitleUnselected() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonIconTitleUnselectedLong() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonIconTitleSelected() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        title = "Card title 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonBiggerIconTitleSelected() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        iconSize = IconSize.SIZE32,
        title = "Card title".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.IconTitle(
        iconResId = R.drawable.ab001_home,
        iconSize = IconSize.SIZE32,
        title = "Card title 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleDescriptionUnselected() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.TitleDescription(
        title = "Card title".toLabel(),
        description = "Card description no 1".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.TitleDescription(
        title = "Card title 2".toLabel(),
        description = "Card description no 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleDescriptionUnselectedLong() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.TitleDescription(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor"
          ).toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.TitleDescription(
        title = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt 2"
          ).toLabel(),
        description = (
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor 2"
          ).toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )

  private fun getCardListSelectableRadioButtonTitleDescriptionSelected() = CardListData(
    cards = listOf(
      SingleCardData.SelectableRadioButton.TitleDescription(
        title = "Card title".toLabel(),
        description = "Card description no 1".toLabel(),
        descriptionSecond = "Card description no 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = true),
        onClick = {},
      ),
      SingleCardData.SelectableRadioButton.TitleDescription(
        title = "Card title 2".toLabel(),
        description = "Card description no 2".toLabel(),
        descriptionSecond = "Card description no 2".toLabel(),
        radioButtonData = OldRadioButtonData(id = RadioButtonId.Default, isSelected = false),
        onClick = {},
      ),
    ),
  )
}
