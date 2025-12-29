package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttoncontent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
internal fun RadioButtonContent(
  isSelected: Boolean,
  content: @Composable (() -> Unit)?,
) {
  content?.let {
    AnimatedVisibility(
      visible = isSelected,
      enter = fadeIn() + expandVertically(),
      exit = fadeOut() + shrinkVertically(),
    ) {
      Column {
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
        content()
      }
    }
  }
}
