@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package pl.gov.coi.common.ui.ds.singlecard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SingleCardClickable(data: SingleCardData.Clickable) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }

  Card(
    modifier = Modifier.semantics { testTag = data.title.tag },
    colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
    border = if (data.state == SingleCardClickableRadioButtonState.FOCUS) {
      BorderStroke(
        width = AppTheme.dimensions.spacing25,
        color = AppTheme.colors.primary900,
      )
    } else {
      null
    },
    interactionSource = NoRippleInteractionSource(),
    onClick = {
      if (data.state != SingleCardClickableRadioButtonState.DISABLED) {
        multipleEventsCutter.processEvent { data.onClick() }
      }
    },
    shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
        .fillMaxWidth()
        .padding(all = AppTheme.dimensions.spacing250),
    ) {
      when (data) {
        is SingleCardData.Clickable.Title -> SingleCardClickableTitleContent(data = data)
        is SingleCardData.Clickable.TitleDescription -> SingleCardClickableTitleDescriptionContent(data = data)
        is SingleCardData.Clickable.InfoTitle -> SingleCardClickableInfoTitleContent(data = data)
        is SingleCardData.Clickable.IconTitle -> SingleCardClickableIconTitleContent(data = data)
        is SingleCardData.Clickable.IconTitleColored -> SingleCardClickableIconTitleColoredContent(data = data)
        is SingleCardData.Clickable.IconTitleDescription -> SingleCardClickableIconTitleDescriptionContent(data = data)
        is SingleCardData.Clickable.ButtonIconTitle ->
          SingleCardClickableButtonIconTitleContent(data = data)

        is SingleCardData.Clickable.ButtonIconTitleDescription ->
          SingleCardClickableButtonIconTitleDescriptionContent(data = data)

        is SingleCardData.Clickable.DeleteButtonIconTitle ->
          SingleCardClickableDeleteButtonIconTitleContent(data = data)

        is SingleCardData.Clickable.TitleDescriptionStatusBadge ->
          SingleCardClickableTitleDescriptionStatusBadgeContent(data = data)
      }

      data.trailingIcon?.let { iconData ->
        Icon(
          modifier = Modifier.padding(start = AppTheme.dimensions.spacing200),
          data = iconData,
        )
      }
    }
  }
}

@Composable
internal fun RowScope.SingleCardClickableTitleContent(
  data: SingleCardData.Clickable.Title,
) {
  CustomText(
    label = data.title,
    style = AppTheme.typography.bodyLargeMedium,
    modifier = Modifier.weight(1f),
    color = when (data.state) {
      SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
      else -> Color.Unspecified
    },
  )
}

@Composable
internal fun RowScope.SingleCardClickableTitleDescriptionContent(
  data: SingleCardData.Clickable.TitleDescription,
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
      color = when (data.state) {
        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
        else -> Color.Unspecified
      },
    )
    CustomText(
      label = data.description,
      style = AppTheme.typography.bodyMediumRegular,
      modifier = Modifier.fillMaxWidth(),
      color = when (data.state) {
        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
        else -> Color.Unspecified
      },
    )
  }
}

@Composable
internal fun RowScope.SingleCardClickableInfoTitleContent(
  data: SingleCardData.Clickable.InfoTitle,
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    CustomText(
      label = data.info,
      style = AppTheme.typography.bodyMediumRegular,
      modifier = Modifier.fillMaxWidth(),
      color = when (data.state) {
        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
        else -> Color.Unspecified
      },
    )
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
      color = when (data.state) {
        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
        else -> Color.Unspecified
      },
    )
  }
}

@Composable
internal fun RowScope.SingleCardClickableIconTitleContent(
  data: SingleCardData.Clickable.IconTitle,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    Icon(
      data = data.iconData,
    )
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
    )
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
      color = when (data.state) {
        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
        else -> Color.Unspecified
      },
    )
  }
}

@Composable
internal fun RowScope.SingleCardClickableIconTitleColoredContent(
  data: SingleCardData.Clickable.IconTitleColored,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .weight(weight = 1f),
  ) {
    Icon(
      data = data.iconData,
    )
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
    )
    CustomText(
      label = data.title,
      style = data.titleStyleProvider(),
      modifier = Modifier.fillMaxWidth(),
      color = data.textColorProvider(),
    )
  }
}

@Composable
internal fun RowScope.SingleCardClickableIconTitleDescriptionContent(
  data: SingleCardData.Clickable.IconTitleDescription,
) {
  Row(
    verticalAlignment = when (data.iconOnOneLineWithTitle) {
      true -> Alignment.Top
      false -> Alignment.CenterVertically
    },
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    Icon(
      data = data.iconData,
    )
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
    )
    Column(
      verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.spacing50),
      modifier = Modifier.fillMaxWidth(),
    ) {
      CustomText(
        label = data.title,
        style = AppTheme.typography.bodyLargeMedium,
        color = when (data.state) {
          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
          else -> Color.Unspecified
        },
      )
      CustomText(
        label = data.description,
        style = AppTheme.typography.bodyMediumRegular,
        color = when (data.state) {
          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
          else -> Color.Unspecified
        },
      )
    }
  }
}

@Composable
internal fun RowScope.SingleCardClickableButtonIconTitleContent(
  data: SingleCardData.Clickable.ButtonIconTitle,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    ButtonIcon(
      data = data.buttonIconData,
    )
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
    )
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
    )
  }
}

@Composable
internal fun RowScope.SingleCardClickableButtonIconTitleDescriptionContent(
  data: SingleCardData.Clickable.ButtonIconTitleDescription,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    ButtonIcon(
      data = data.buttonIconData,
    )
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
    )
    Column(
      verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.spacing50),
      modifier = Modifier.fillMaxWidth(),
    ) {
      CustomText(
        label = data.title,
        style = AppTheme.typography.bodyLargeMedium,
        color = when (data.state) {
          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
          else -> Color.Unspecified
        },
      )
      CustomText(
        label = data.description,
        style = AppTheme.typography.bodyMediumRegular,
        color = when (data.state) {
          SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
          else -> Color.Unspecified
        },
      )
    }
  }
}

@Composable
internal fun RowScope.SingleCardClickableDeleteButtonIconTitleContent(
  data: SingleCardData.Clickable.DeleteButtonIconTitle,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    Icon(
      data = data.iconData,
    )
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
    )
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
      color = data.textColorProvider(),
    )
  }
}

@Composable
internal fun RowScope.SingleCardClickableTitleDescriptionStatusBadgeContent(
  data: SingleCardData.Clickable.TitleDescriptionStatusBadge,
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
      color = when (data.state) {
        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
        else -> Color.Unspecified
      },
    )
    CustomText(
      label = data.description,
      style = AppTheme.typography.bodyMediumRegular,
      modifier = Modifier.fillMaxWidth(),
      color = when (data.state) {
        SingleCardClickableRadioButtonState.DISABLED -> AppTheme.colors.neutral60
        else -> Color.Unspecified
      },
    )
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
    SingleCardStatusBadge(data = data.badgeData)
  }
}
