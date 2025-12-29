package pl.gov.coi.common.ui.ds.accordion

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.accordion.provider.AccordionPreviewParameterProvider
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

private val MIN_ACCORDION_ROW_HEIGHT = 48.dp

@Composable
fun Accordion(
  data: AccordionData,
) {
  Card(
    shape = AppTheme.shapes.radius200,
    elevation = AppTheme.elevations.level0,
  ) {
    Column {
      data.elements.forEachIndexed { index, element ->
        AccordionSingle(
          data = element,
        )
        if (index != data.elements.size - 1) {
          AccordionDivider()
        }
      }
    }
  }
}

@Composable
private fun AccordionSingle(
  data: AccordionElement,
) {
  var expanded by remember { mutableStateOf(data.initialExpanded) }

  val stateDesc = if (expanded) {
    CommonUILabelProvider.expandedLabel().text
  } else {
    CommonUILabelProvider.notExpandedLabel().text
  }

  Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .fillMaxWidth()
      .animateContentSize(
        animationSpec = tween(
          easing = LinearOutSlowInEasing,
        ),
      ),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .padding(
          top = AppTheme.dimensions.spacing200,
          start = AppTheme.dimensions.spacing200,
          end = AppTheme.dimensions.spacing200,
          bottom = if (!expanded) {
            AppTheme.dimensions.spacing200
          } else {
            AppTheme.dimensions.zero
          },
        )
        .heightIn(min = MIN_ACCORDION_ROW_HEIGHT)
        .semantics {
          stateDescription = stateDesc
          role = Role.Button
        }
        .clickable(
          indication = null,
          interactionSource = NoRippleInteractionSource(),
          onClick = {
            expanded = !expanded
            data.onListExpanded(expanded)
          },
        ),
    ) {
      CustomText(
        label = data.header,
        style = AppTheme.typography.bodyLargeMedium,
        color = AppTheme.colors.neutral500,
        modifier = Modifier
          .fillMaxWidth()
          .weight(weight = 1F),
      )
      Spacer(
        modifier = Modifier
          .width(AppTheme.dimensions.spacing100),
      )
      Icon(
        data = IconData.Standard(
          iconResId = when (expanded) {
            true -> R.drawable.ab007_chevron_up
            else -> R.drawable.ab008_chevron_down
          },
          iconSize = IconSize.SIZE24,
          iconColorProvider = { AppTheme.colors.neutral200 },
          contentDescription = Label.EMPTY,
        ),
      )
    }
    if (expanded) {
      Box(
        modifier = Modifier
          .padding(
            all = if (data.addContentPadding) {
              AppTheme.dimensions.spacing200
            } else {
              AppTheme.dimensions.zero
            },
          ),
      ) {
        data.content.Content()
      }
    }
  }
}

@Composable
private fun AccordionDivider() {
  Divider(
    modifier = Modifier.padding(
      horizontal = AppTheme.dimensions.spacing200,
    ),
    thickness = AppTheme.dimensions.strokeWidth,
    color = AppTheme.colors.neutral30,
  )
}

@Preview
@Composable
fun AccordionPreview(
  @PreviewParameter(provider = AccordionPreviewParameterProvider::class)
  data: AccordionData,
) {
  Accordion(data = data)
}
