package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonrow.RadioButtonRow

@Composable
internal fun RadioButtons(
  items: List<RadioButtonRow>,
  state: RadioButtonSupportText,
) {
  items.forEachIndexed { index, radioButtonItem ->
    RadioButtonRow(
      data = radioButtonItem
        .setValidationState(state = state),
    )
    if (items.lastIndex != index) {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing250))
    }
  }
}

private fun RadioButtonRow.setValidationState(
  state: RadioButtonSupportText,
) = this.copy(item = item.copy(isError = state is RadioButtonSupportText.Error))
