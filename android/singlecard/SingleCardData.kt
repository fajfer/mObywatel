package pl.gov.coi.common.ui.ds.singlecard

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.checkbox.single.model.CheckBoxSingleData
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.custom.icon.IconState
import pl.gov.coi.common.ui.ds.image.ImageData
import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButtonData
import pl.gov.coi.common.ui.ds.switchcomponent.SwitchData
import pl.gov.coi.common.ui.theme.AppTheme

enum class SingleCardInfoState { ENABLED, DISABLE }

enum class SingleCardClickableRadioButtonState { ENABLED, DISABLED, FOCUS }

sealed interface SingleCardInfoExtras {
  class ButtonMore(
    val buttonData: ButtonData,
  ) : SingleCardInfoExtras

  class Switch(
    val switchData: SwitchData.SwitchOnly,
  ) : SingleCardInfoExtras
}

sealed class SingleCardData(
  val testTag: String?,
  val title: Label,
) {

  sealed class Info(
    testTag: String?,
    title: Label,
    val modifier: Modifier = Modifier,
    val draggable: Boolean,
    val cardState: SingleCardInfoState,
  ) : SingleCardData(testTag = testTag, title = title) {

    class Title(
      testTag: String? = null,
      title: Label,
      draggable: Boolean = false,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      val extras: SingleCardInfoExtras? = null,
    ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)

    class TitleDescription(
      testTag: String? = null,
      title: Label,
      val description: Label,
      draggable: Boolean = false,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      val extras: SingleCardInfoExtras? = null,
    ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)

    class InfoTitle(
      testTag: String? = null,
      val info: Label,
      title: Label,
      draggable: Boolean = false,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      val extras: SingleCardInfoExtras? = null,
      val titleMaxLines: Int = Int.MAX_VALUE,
      val titleTextOverflow: TextOverflow = TextOverflow.Clip,
    ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)

    class IconTitle(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      modifier: Modifier = Modifier,
      title: Label,
      draggable: Boolean = false,
      val iconSize: IconSize = IconSize.SIZE24,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      val cardContentDescription: Label = Label.EMPTY,
      iconContentDescription: Label = Label.EMPTY,
      val onIconClick: (() -> Unit)? = null,
    ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state) {

      internal val iconData: IconData = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = iconSize,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
        iconState = state.toIconState(),
      )

      internal val buttonIconData: ButtonIconData? = when (onIconClick) {
        null -> null
        else -> ButtonIconData(
          testTag = testTag?.let { tag -> tag + "ButtonIcon" },
          iconResId = iconResId,
          iconColorProvider = iconColorProvider,
          contentDescription = iconContentDescription,
          onClick = onIconClick,
        )
      }
    }

    class IconTitleDescription(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      modifier: Modifier = Modifier,
      title: Label,
      val description: Label,
      draggable: Boolean = false,
      val iconOnOneLineWithTitle: Boolean = false,
      val iconSize: IconSize = IconSize.SIZE24,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      val cardContentDescription: Label = Label.EMPTY,
      iconContentDescription: Label = Label.EMPTY,
      val onIconClick: (() -> Unit)? = null,
    ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state) {
      internal val iconData: IconData = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = iconSize,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
        iconState = state.toIconState(),
      )

      internal val buttonIconData: ButtonIconData? = when (onIconClick) {
        null -> null
        else -> ButtonIconData(
          testTag = testTag?.let { tag -> tag + "ButtonIcon" },
          iconResId = iconResId,
          iconColorProvider = iconColorProvider,
          contentDescription = iconContentDescription,
          onClick = onIconClick,
        )
      }
    }

    class TitleStatusBadge(
      testTag: String? = null,
      title: Label,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      draggable: Boolean = false,
      val badgeData: SingleCardStatusBadgeData,
    ) : Info(testTag = testTag, title = title, draggable = draggable, cardState = state)

    class IconTitleDescriptionLeadingButton(
      testTag: String? = null,
      modifier: Modifier = Modifier,
      title: Label,
      val iconData: IconData,
      val description: Label,
      val leadingButtonData: ButtonIconData? = null,
      val titleMaxLines: Int = 2,
      val titleOverflow: TextOverflow = TextOverflow.Ellipsis,
      draggable: Boolean = false,
      val iconOnOneLineWithTitle: Boolean = false,
      val iconSize: IconSize = IconSize.SIZE48,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      val cardContentDescription: Label = Label.EMPTY,
    ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state)

    class ImageTitleDescriptionLeadingButton(
      testTag: String? = null,
      modifier: Modifier = Modifier,
      val imageData: ImageData,
      title: Label,
      val description: Label,
      val leadingButtonData: ButtonIconData? = null,
      val titleMaxLines: Int = 2,
      val titleOverflow: TextOverflow = TextOverflow.Ellipsis,
      draggable: Boolean = false,
      val iconOnOneLineWithTitle: Boolean = false,
      val iconSize: IconSize = IconSize.SIZE24,
      state: SingleCardInfoState = SingleCardInfoState.ENABLED,
      val cardContentDescription: Label = Label.EMPTY,
    ) : Info(testTag = testTag, title = title, modifier = modifier, draggable = draggable, cardState = state)
  }

  sealed class Clickable(
    testTag: String?,
    title: Label,
    val modifier: Modifier = Modifier,
    val state: SingleCardClickableRadioButtonState,
    @DrawableRes val trailingIconResId: Int?,
    val trailingIconColorProvider: @Composable () -> Color,
    val trailingIconContentDescription: Label,
    val onClick: () -> Unit,
  ) : SingleCardData(testTag = testTag, title = title) {

    internal val trailingIcon = trailingIconResId?.let { iconResId ->
      IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = IconSize.SIZE24,
        iconColorProvider = trailingIconColorProvider,
        iconState = state.toIconState(),
        contentDescription = trailingIconContentDescription,
      )
    }

    class Title(
      testTag: String? = null,
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    )

    class TitleDescription(
      testTag: String? = null,
      val description: Label,
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    )

    class InfoTitle(
      testTag: String? = null,
      val info: Label,
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = null,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    )

    class IconTitle(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      title: Label,
      modifier: Modifier = Modifier,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      val iconSize: IconSize = IconSize.SIZE24,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      modifier = modifier,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    ) {

      internal val iconData: IconData = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = iconSize,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
        iconState = state.toIconState(),
      )
    }

    class IconTitleColored(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      title: Label,
      titleColorProvider: @Composable () -> Color = { Color.Unspecified },
      val titleStyleProvider: @Composable () -> TextStyle = { AppTheme.typography.bodyLargeMedium },
      modifier: Modifier = Modifier,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      val iconSize: IconSize = IconSize.SIZE24,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      modifier = modifier,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    ) {

      internal val iconData: IconData = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = iconSize,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
        iconState = state.toIconState(),
      )

      internal val textColorProvider: @Composable () -> Color = {
        when (state) {
          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
          else -> titleColorProvider()
        }
      }
    }

    class ButtonIconTitle(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = null,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      onIconClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = {},
    ) {

      internal val buttonIconData: ButtonIconData = ButtonIconData(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
        onClick = onIconClick,
      )
    }

    class ButtonIconTitleDescription(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      title: Label,
      val description: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      onIconClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = {},
    ) {

      internal val buttonIconData: ButtonIconData = ButtonIconData(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
        onClick = onIconClick,
      )
    }

    class DeleteButtonIconTitle(
      testTag: String? = null,
      title: Label,
      val iconSize: IconSize = IconSize.SIZE24,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = null,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    ) {

      internal val iconData: IconData.Standard = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = R.drawable.aa002_delete,
        iconSize = iconSize,
        iconColorProvider = { AppTheme.colors.supportRed100 },
        contentDescription = Label.EMPTY,
      )

      internal val textColorProvider: @Composable () -> Color = { AppTheme.colors.supportRed100 }
    }

    class IconTitleDescription(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      val description: Label,
      val iconOnOneLineWithTitle: Boolean = false,
      title: Label,
      val iconSize: IconSize = IconSize.SIZE24,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    ) {

      internal val iconData: IconData = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = iconSize,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
        iconState = state.toIconState(),
      )
    }

    class TitleDescriptionStatusBadge(
      testTag: String? = null,
      val description: Label,
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      @DrawableRes trailingIonResId: Int? = DEFAULT_TRAILING_ICON_RES_ID,
      trailingIconColorProvider: @Composable () -> Color = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
      trailingIconContentDescription: Label = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
      val badgeData: SingleCardStatusBadgeData,
      onClick: () -> Unit,
    ) : Clickable(
      testTag = testTag,
      title = title,
      state = state,
      trailingIconResId = trailingIonResId,
      trailingIconColorProvider = trailingIconColorProvider,
      trailingIconContentDescription = trailingIconContentDescription,
      onClick = onClick,
    )

    private companion object {
      val DEFAULT_TRAILING_ICON_RES_ID = R.drawable.ab006_chevron_right
      val DEFAULT_TRAILING_ICON_COLOR_PROVIDER: @Composable () -> Color = { Color.Unspecified }
      val DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION = Label.EMPTY
    }
  }

  sealed class SelectableRadioButton(
    testTag: String?,
    val radioButtonData: OldRadioButtonData,
    val onClick: () -> Unit,
    val state: SingleCardClickableRadioButtonState,
    val drawBorder: Boolean = true,
    title: Label,
  ) : SingleCardData(testTag = testTag, title = title) {
    class Title(
      testTag: String? = null,
      radioButtonData: OldRadioButtonData,
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      drawBorder: Boolean = true, 
      onClick: () -> Unit,
    ) : SelectableRadioButton(
      testTag = testTag,
      title = title,
      radioButtonData = radioButtonData,
      state = state,
      drawBorder = drawBorder,
      onClick = onClick,
    )

    class IconTitle(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      radioButtonData: OldRadioButtonData,
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      val iconSize: IconSize = IconSize.SIZE24,
      drawBorder: Boolean = true, 
      onClick: () -> Unit,
    ) : SelectableRadioButton(
      testTag = testTag,
      title = title,
      radioButtonData = radioButtonData,
      state = state,
      drawBorder = drawBorder,
      onClick = onClick,
    ) {

      internal val iconData: IconData = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = iconSize,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
      )
    }

    class TitleDescription(
      testTag: String? = null,
      val description: Label,
      val descriptionSecond: Label? = null,
      val descriptionThird: Label? = null,
      radioButtonData: OldRadioButtonData,
      title: Label,
      state: SingleCardClickableRadioButtonState = SingleCardClickableRadioButtonState.ENABLED,
      drawBorder: Boolean = true, 
      onClick: () -> Unit,
    ) : SelectableRadioButton(
      testTag = testTag,
      title = title,
      radioButtonData = radioButtonData,
      state = state,
      drawBorder = drawBorder,
      onClick = onClick,
    )
  }

  sealed class SelectableCheckbox(
    testTag: String?,
    val checkboxData: CheckBoxSingleData,
    title: Label,
  ) : SingleCardData(testTag = testTag, title = title) {
    class Title(
      testTag: String? = null,
      checkboxData: CheckBoxSingleData,
      title: Label,
    ) : SelectableCheckbox(testTag = testTag, title = title, checkboxData = checkboxData)

    class IconTitle(
      testTag: String? = null,
      @DrawableRes val iconResId: Int,
      iconColorProvider: @Composable () -> Color = { Color.Unspecified },
      checkboxData: CheckBoxSingleData,
      title: Label,
    ) : SelectableCheckbox(testTag = testTag, title = title, checkboxData = checkboxData) {

      internal val iconData: IconData = IconData.Standard(
        testTag = testTag?.let { tag -> tag + "Icon" },
        iconResId = iconResId,
        iconSize = IconSize.SIZE24,
        iconColorProvider = iconColorProvider,
        contentDescription = Label.EMPTY,
      )
    }

    class TitleDescription(
      testTag: String? = null,
      val description: Label,
      val descriptionSecond: Label? = null,
      val descriptionThird: Label? = null,
      checkboxData: CheckBoxSingleData,
      title: Label,
    ) : SelectableCheckbox(testTag = testTag, title = title, checkboxData = checkboxData)
  }
}

fun SingleCardInfoState.toIconState() = when (this) {
  SingleCardInfoState.ENABLED -> IconState.ENABLED
  SingleCardInfoState.DISABLE -> IconState.DISABLED
}

fun SingleCardClickableRadioButtonState.toIconState() = when (this) {
  SingleCardClickableRadioButtonState.ENABLED,
  SingleCardClickableRadioButtonState.FOCUS,
  -> IconState.ENABLED

  SingleCardClickableRadioButtonState.DISABLED -> IconState.DISABLED
}