package pl.gov.coi.common.ui.ds.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.selectableGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.defaultRippleEffect

@Composable
fun BottomNavigation(
  data: BottomNavigationData,
) {
  val bottomNavigationHeight = 80.dp
  Surface(
    color = AppTheme.colors.background,
    contentColor = AppTheme.colors.background,
    modifier = Modifier,
  ) {
    Row(
      Modifier
        .height(bottomNavigationHeight)
        .fillMaxWidth()
        .semantics {
          isTraversalGroup = true
          selectableGroup()
        },
      content = {
        data.items.forEachIndexed { index, item ->
          this.BottomNavigationItem(
            testTag = item.testTag,
            selected = data.selectedItemIndex == index,
            unselectedIconResId = item.unselectedIconResId,
            selectedIconResId = item.selectedIconResId,
            label = item.label,
            onClick = { item.onClickAction.invoke() },
          )
        }
      },
      horizontalArrangement = Arrangement.SpaceEvenly,
      verticalAlignment = Alignment.CenterVertically,
    )
  }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun RowScope.BottomNavigationItem(
  testTag: String?,
  selected: Boolean,
  onClick: () -> Unit,
  @DrawableRes unselectedIconResId: Int,
  @DrawableRes selectedIconResId: Int,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  label: Label? = null,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  selectedContentColor: Color = AppTheme.colors.primary900,
  unselectedContentColor: Color = AppTheme.colors.neutral200,
  selectedIconBackground: Color = AppTheme.colors.secondary900,
  unselectedIconBackground: Color = Color(0x00000000),
) {
  val isFocused = interactionSource.collectIsFocusedAsState()

  Box(
    modifier
      .selectable(
        selected = selected,
        onClick = onClick,
        enabled = enabled,
        role = Role.Tab,
        interactionSource = interactionSource,
        indication = null,
      )
      .weight(1f)
      .semantics { testTagsAsResourceId = true }
      .semantics { this.testTag = testTag ?: "navigationItem${label?.tag ?: "Undefined"}" },
    contentAlignment = Alignment.Center,
  ) {
    Column {
      Box(
        Modifier
          .align(Alignment.CenterHorizontally)
          .clip(RoundedCornerShape(40.dp))
          .border(
            width = AppTheme.dimensions.spacing25,
            color = if (isFocused.value) AppTheme.colors.neutral500 else Color.Transparent,
            shape = AppTheme.shapes.radius500,
          )
          .border(
            width = AppTheme.dimensions.spacing50,
            color = if (isFocused.value) AppTheme.colors.white else Color.Transparent,
            shape = AppTheme.shapes.radius500,
          )
          .background(
            when {
              selected -> selectedIconBackground
              isFocused.value -> AppTheme.colors.neutral500.copy(alpha = 0.1f)
              else -> unselectedIconBackground
            },
          )
          .defaultRippleEffect(interactionSource = interactionSource)
          .padding(12.dp, 6.dp)
          .width(42.dp),
      ) {
        Icon(
          modifier = Modifier.align(Alignment.Center),
          data = IconData.Standard(
            testTag = testTag?.let { tag -> tag + "Icon" },
            iconResId = if (selected) selectedIconResId else unselectedIconResId,
            iconSize = IconSize.SIZE24,
            iconColorProvider = { if (selected) selectedContentColor else unselectedContentColor },
            contentDescription = Label.EMPTY,
          ),
        )
      }
      if (label != null) {
        val fontSize = AppTheme.typography.bodySmallMedium.fontSize.value / LocalDensity.current.fontScale
        CustomText(
          testTag = testTag?.let { tag -> tag + "Text" },
          label = label,
          fontSize = fontSize.sp,
          style = AppTheme.typography.bodySmallMedium,
          fontWeight = FontWeight(500),
          color = if (selected) selectedContentColor else unselectedContentColor,
          modifier = Modifier.fillMaxWidth(),
          overflow = TextOverflow.Visible,
          softWrap = false,
          textAlign = TextAlign.Center,
        )
      }
    }
  }
}
