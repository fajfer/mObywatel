package pl.gov.coi.common.ui.ds.smallcard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.smallcard.provider.SmallCardPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.dpToPx
import pl.gov.coi.common.ui.utils.get

private val SMALL_CARD_WIDTH: Dp = 92.dp
private val SMALL_CARD_SQUIRCLE_SIZE: Dp = 80.dp

@Composable
fun SmallCard(
  data: SmallCardData,
) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }
  val interactionSource = remember { MutableInteractionSource() }
  val isFocused = interactionSource.collectIsFocusedAsState()

  Column(
    modifier = Modifier
      .width(width = SMALL_CARD_WIDTH)
      .semantics {
        testTag = "card_${data.title.tag}_indexTag_${data.indexTag ?: "noTag"}"
      }
      .clickable(
        interactionSource = interactionSource,
        indication = null,
        role = Role.Button,
        onClick = { multipleEventsCutter.processEvent { data.onClick() } },
      ),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Box(
      contentAlignment = Alignment.Center,
    ) {
      SmallCardSquircle(
        modifier = Modifier
          .clip(shape = AppTheme.shapes.radius200)
          .indication(
            interactionSource = interactionSource,
            indication = rememberRipple(color = AppTheme.colors.neutral500.copy(alpha = 0.1f)),
          ),
        color = if (isFocused.value) AppTheme.colors.neutral500.copy(alpha = 0.1f) else Color.White,
      )
      SmallCardSquircle(
        color = if (isFocused.value) AppTheme.colors.white else Color.Transparent,
        style = Stroke(width = AppTheme.dimensions.spacing50.dpToPx()),
      )
      SmallCardSquircle(
        color = if (isFocused.value) AppTheme.colors.neutral500 else Color.Transparent,
        style = Stroke(width = AppTheme.dimensions.spacing25.dpToPx()),
      )
      Icon(data = data.iconData)
    }
    Spacer(
      modifier = Modifier.height(AppTheme.dimensions.spacing100),
    )
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodySmallRegular,
      color = AppTheme.colors.neutral200,
      textAlign = TextAlign.Center,
      overflow = TextOverflow.Ellipsis,
      maxLines = 2,
    )
  }
}

@Composable
internal fun SmallCardSquircle(
  modifier: Modifier = Modifier,
  style: DrawStyle = Fill,
  color: Color = AppTheme.colors.white,
) {
  Canvas(
    modifier = modifier
      .size(size = SMALL_CARD_SQUIRCLE_SIZE),
  ) {
    val width = size.width
    val height = size.height
    val path = Path().apply {
      moveTo(width.times(0.4f), 0f)
      lineTo(width.times(0.6f), 0f)
      cubicTo(
        x1 = width.times(0.98f),
        y1 = 0f,
        x2 = width.times(1f),
        y2 = height.times(0.02f),
        x3 = width.times(1f),
        y3 = height.times(0.4f),
      )
      lineTo(
        x = width.times(1f),
        y = height.times(0.6f),
      )
      cubicTo(
        x1 = width.times(1f),
        y1 = height.times(0.98f),
        x2 = width.times(0.98f),
        y2 = height.times(1f),
        x3 = width.times(0.6f),
        y3 = height.times(1f),
      )
      lineTo(
        x = width.times(0.4f),
        y = height.times(1f),
      )
      cubicTo(
        x1 = width.times(0.02f),
        y1 = height.times(1f),
        x2 = 0f,
        y2 = height.times(0.98f),
        x3 = 0f,
        y3 = height.times(0.6f),
      )
      lineTo(
        x = 0f,
        y = height.times(0.4f),
      )
      cubicTo(
        x1 = 0f,
        y1 = height.times(0.02f),
        x2 = width.times(0.02f),
        y2 = 0f,
        x3 = width.times(0.4f),
        y3 = 0f,
      )
      close()
    }
    drawPath(
      path = path,
      color = color,
      style = style,
    )
  }
}

@Preview
@Composable
fun SmallCardPreview(
  @PreviewParameter(SmallCardPreviewParameterProvider::class) smallCardData: SmallCardData,
) {
  SmallCard(
    data = smallCardData,
  )
}
