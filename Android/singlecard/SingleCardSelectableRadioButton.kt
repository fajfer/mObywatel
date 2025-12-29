@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package pl.gov.coi.common.ui.ds.singlecard

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.singlecard.radiobutton.OldRadioButton
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

@Composable
internal fun SingleCardSelectableRadioButton(
  data: SingleCardData.SelectableRadioButton,
) {
  Card(
    modifier = Modifier.semantics { testTag = data.testTag ?: data.title.tag },
    colors = CardDefaults.cardColors(
      containerColor = AppTheme.colors.white,
    ),
    border = if (data.state == SingleCardClickableRadioButtonState.FOCUS) {
      BorderStroke(
        width = AppTheme.dimensions.spacing25,
        color = AppTheme.colors.primary900,
      )
    } else {
      when {
        data.radioButtonData.isSelected && data.drawBorder -> BorderStroke(
          width = AppTheme.dimensions.strokeWidth,
          color = AppTheme.colors.primary900,
        )
        else -> null
      }
    },
    interactionSource = NoRippleInteractionSource(),
    onClick = data.onClick,
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
        is SingleCardData.SelectableRadioButton.Title -> SingleCardSelectableRadioButtonTitleContent(data = data)
        is SingleCardData.SelectableRadioButton.IconTitle ->
          SingleCardSelectableRadioButtonIconTitleContent(data = data)
        is SingleCardData.SelectableRadioButton.TitleDescription ->
          SingleCardSelectableRadioButtonTitleDescriptionContent(data = data)
      }
      Spacer(
        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
      )
      OldRadioButton(
        data = data.radioButtonData,
      )
    }
  }
}

@Composable
internal fun RowScope.SingleCardSelectableRadioButtonTitleContent(
  data: SingleCardData.SelectableRadioButton.Title,
) {
  CustomText(
    testTag = data.testTag?.let { tag -> tag + "TitleText" },
    label = data.title,
    style = AppTheme.typography.bodyLargeMedium,
    modifier = Modifier.weight(1f),
  )
}

@Composable
internal fun RowScope.SingleCardSelectableRadioButtonTitleDescriptionContent(
  data: SingleCardData.SelectableRadioButton.TitleDescription,
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    CustomText(
      testTag = data.testTag?.let { tag -> tag + "TitleText" },
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
    )
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
    CustomText(
      testTag = data.testTag?.let { tag -> tag + "DescriptionText" },
      label = data.description,
      style = AppTheme.typography.bodyMediumRegular,
      color = AppTheme.colors.neutral200,
      modifier = Modifier.fillMaxWidth(),
    )
    data.descriptionSecond?.let { descriptionSecond ->
      Spacer(
        modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
      )
      CustomText(
        testTag = data.testTag?.let { tag -> tag + "DescriptionSecondText" },
        label = descriptionSecond,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
        modifier = Modifier.fillMaxWidth(),
      )
    }
    data.descriptionThird?.let { descriptionThird ->
      Spacer(
        modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
      )
      CustomText(
        testTag = data.testTag?.let { tag -> tag + "DescriptionThirdText" },
        label = descriptionThird,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
        modifier = Modifier.fillMaxWidth(),
      )
    }
  }
}

@Composable
internal fun RowScope.SingleCardSelectableRadioButtonIconTitleContent(
  data: SingleCardData.SelectableRadioButton.IconTitle,
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
      testTag = data.testTag?.let { tag -> tag + "TitleText" },
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
    )
  }
}
