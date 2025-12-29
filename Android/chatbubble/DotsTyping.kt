package pl.gov.coi.common.ui.ds.chatbubble

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.theme.AppTheme

const val DELAY_UNIT = 300

@Composable
internal fun DotsTyping() {
  val maxOffset = 10f

  @Composable
  fun Dot(
    offset: Float,
    color: Color,
  ) = Spacer(
    modifier = Modifier
      .size(AppTheme.dimensions.spacing100)
      .offset(y = -offset.dp)
      .background(
        color = color,
        shape = CircleShape,
      ),
  )

  val infiniteTransition = rememberInfiniteTransition()

  @Composable
  fun animateOffsetWithDelay(delay: Int) = infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = 0f,
    animationSpec = infiniteRepeatable(
      animation = keyframes {
        durationMillis = DELAY_UNIT * 4
        0f at delay with LinearEasing
        maxOffset at delay + DELAY_UNIT with LinearEasing
        0f at delay + DELAY_UNIT * 2
      },
    ),
  )

  val firstDotAnimationOffset by animateOffsetWithDelay(0)
  val secondDotAnimationOffset by animateOffsetWithDelay(DELAY_UNIT)
  val thirdDotAnimationOffset by animateOffsetWithDelay(DELAY_UNIT * 2)

  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center,
    modifier = Modifier.padding(top = maxOffset.dp),
  ) {
    Dot(offset = firstDotAnimationOffset, color = AppTheme.colors.neutral200.copy(alpha = 0.25F))
    Spacer(Modifier.width(AppTheme.dimensions.spacing50))
    Dot(offset = secondDotAnimationOffset, color = AppTheme.colors.neutral200.copy(alpha = 0.5F))
    Spacer(Modifier.width(AppTheme.dimensions.spacing50))
    Dot(offset = thirdDotAnimationOffset, color = AppTheme.colors.neutral200)
  }
}
