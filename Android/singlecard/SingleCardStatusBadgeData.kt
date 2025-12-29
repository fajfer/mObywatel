package pl.gov.coi.common.ui.ds.singlecard

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

/*
 TODO REMOVE MOB-49304
 */
sealed class SingleCardStatusBadgeData(
  internal open val testTag: String?,
  internal open val text: Label,
) {
  sealed class Default(
    testTag: String?,
    text: Label,
    internal open val dotColorProvider: @Composable () -> Color,
  ) : SingleCardStatusBadgeData(
    testTag = testTag,
    text = text,
  ) {
    data class Green(
      override val testTag: String? = null,
      override val text: Label,
    ) : Default(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportGreen100 },
    )

    data class Yellow(
      override val testTag: String? = null,
      override val text: Label,
    ) : Default(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportOrange100 },
    )

    data class Red(
      override val testTag: String? = null,
      override val text: Label,
    ) : Default(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportRed100 },
    )

    data class Blue(
      override val testTag: String? = null,
      override val text: Label,
    ) : Default(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportBlue100 },
    )
  }

  sealed class WithNoIcon(
    testTag: String?,
    text: Label,
  ) : SingleCardStatusBadgeData(
    testTag = testTag,
    text = text,
  ) {
    data class Normal(
      override val testTag: String? = null,
      override val text: Label,
    ) : WithNoIcon(
      testTag = testTag,
      text = text,
    )

    data class Error(
      override val testTag: String? = null,
      override val text: Label,
    ) : WithNoIcon(
      testTag = testTag,
      text = text,
    )
  }

  sealed class WithIcon(
    testTag: String?,
    text: Label,
    @DrawableRes iconResId: Int,
    iconColorProvider: @Composable () -> Color,
    iconContentDescription: Label,
  ) : SingleCardStatusBadgeData(
    testTag = testTag,
    text = text,
  ) {

    internal val iconData: IconData = IconData.Standard(
      testTag = testTag?.let { tag -> tag + "Icon" },
      iconResId = iconResId,
      iconSize = IconSize.SIZE16,
      iconColorProvider = iconColorProvider,
      contentDescription = iconContentDescription,
    )

    class Success(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIcon(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.c4_success,
      iconColorProvider = { AppTheme.colors.supportGreen100 },
      iconContentDescription = iconContentDescription,
    )

    class Error(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIcon(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.c3_error_mark,
      iconColorProvider = { AppTheme.colors.supportRed100 },
      iconContentDescription = iconContentDescription,
    )

    class Warning(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIcon(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.c2_warning_mark,
      iconColorProvider = { AppTheme.colors.supportOrange100 },
      iconContentDescription = iconContentDescription,
    )

    class Info(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIcon(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.c1_info,
      iconColorProvider = { AppTheme.colors.supportBlue100 },
      iconContentDescription = iconContentDescription,
    )
  }

  sealed class WithIconAndBorder(
    testTag: String?,
    text: Label,
    @DrawableRes iconResId: Int,
    iconColorProvider: @Composable () -> Color,
    iconContentDescription: Label,
  ) : SingleCardStatusBadgeData(
    testTag = testTag,
    text = text,
  ) {

    internal val iconData: IconData = IconData.Standard(
      testTag = testTag?.let { tag -> tag + "Icon" },
      iconResId = iconResId,
      iconSize = IconSize.SIZE14,
      iconColorProvider = iconColorProvider,
      contentDescription = iconContentDescription,
    )

    class Active(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIconAndBorder(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.b009_check_mark,
      iconColorProvider = { AppTheme.colors.supportGreen100 },
      iconContentDescription = iconContentDescription,
    )

    class Failure(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIconAndBorder(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.b010_x_mark,
      iconColorProvider = { AppTheme.colors.supportRed100 },
      iconContentDescription = iconContentDescription,
    )

    class ActionNeeded(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIconAndBorder(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.b011_exclamation_mark,
      iconColorProvider = { AppTheme.colors.supportOrange100 },
      iconContentDescription = iconContentDescription,
    )

    class Canceled(
      testTag: String? = null,
      text: Label,
      iconContentDescription: Label,
    ) : WithIconAndBorder(
      testTag = testTag,
      text = text,
      iconResId = R.drawable.b010_x_mark,
      iconColorProvider = { AppTheme.colors.neutral100 },
      iconContentDescription = iconContentDescription,
    )
  }

  sealed class WithDotAndBorder(
    testTag: String?,
    text: Label,
    private val variant: WithDotAndBorderVariant,
    internal val dotColorProvider: @Composable () -> Color,
  ) : SingleCardStatusBadgeData(
    testTag = testTag,
    text = text,
  ) {
    internal val strokeColorProvider: @Composable () -> Color = {
      when (variant) {
        WithDotAndBorderVariant.Default -> AppTheme.colors.neutral80
        is WithDotAndBorderVariant.Colored -> dotColorProvider()
      }
    }
    internal val backgroundColorProvider: @Composable () -> Color = {
      when (variant) {
        WithDotAndBorderVariant.Default -> AppTheme.colors.white
        is WithDotAndBorderVariant.Colored -> variant.backgroundColorProvider()
      }
    }

    class Green(
      testTag: String? = null,
      text: Label,
      isColored: Boolean,
    ) : WithDotAndBorder(
      testTag = testTag,
      text = text,
      variant = if (isColored) {
        val lightGreen20 = Color(0xFFEEFAE1)
        WithDotAndBorderVariant.Colored { lightGreen20 }
      } else {
        WithDotAndBorderVariant.Default
      },
      dotColorProvider = { AppTheme.colors.supportGreen100 },
    )

    class Red(
      testTag: String? = null,
      text: Label,
      isColored: Boolean,
    ) : WithDotAndBorder(
      testTag = testTag,
      text = text,
      variant = if (isColored) {
        WithDotAndBorderVariant.Colored { AppTheme.colors.supportRed20 }
      } else {
        WithDotAndBorderVariant.Default
      },
      dotColorProvider = { AppTheme.colors.supportRed100 },
    )

    class Yellow(
      testTag: String? = null,
      text: Label,
      isColored: Boolean,
    ) : WithDotAndBorder(
      testTag = testTag,
      text = text,
      variant = if (isColored) {
        WithDotAndBorderVariant.Colored { AppTheme.colors.supportOrange20 }
      } else {
        WithDotAndBorderVariant.Default
      },
      dotColorProvider = { AppTheme.colors.supportOrange100 },
    )

    class Blue(
      testTag: String? = null,
      text: Label,
      isColored: Boolean,
    ) : WithDotAndBorder(
      testTag = testTag,
      text = text,
      variant = if (isColored) {
        WithDotAndBorderVariant.Colored { AppTheme.colors.supportBlue20 }
      } else {
        WithDotAndBorderVariant.Default
      },
      dotColorProvider = { AppTheme.colors.supportBlue100 },
    )
  }

  sealed class Elevated(
    testTag: String?,
    text: Label,
    internal val dotColorProvider: @Composable () -> Color,
  ) : SingleCardStatusBadgeData(
    testTag = testTag,
    text = text,
  ) {
    class Green(
      testTag: String? = null,
      text: Label,
    ) : Elevated(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportGreen100 },
    )

    class Yellow(
      testTag: String? = null,
      text: Label,
    ) : Elevated(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportOrange100 },
    )

    class Red(
      testTag: String? = null,
      text: Label,
    ) : Elevated(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportRed100 },
    )

    class Blue(
      testTag: String? = null,
      text: Label,
    ) : Elevated(
      testTag = testTag,
      text = text,
      dotColorProvider = { AppTheme.colors.supportBlue100 },
    )
  }
}

internal sealed interface WithDotAndBorderVariant {
  object Default : WithDotAndBorderVariant
  data class Colored(val backgroundColorProvider: @Composable () -> Color) : WithDotAndBorderVariant
}
