package pl.gov.coi.common.ui.ds.singlecard.radiobutton

import androidx.compose.foundation.layout.size
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.theme.AppTheme

@Deprecated(
  message = "Do not use.",
  replaceWith = ReplaceWith("pl.gov.coi.common.ui.ds.radiobutton.RadioButton"),
)
@Composable
fun OldRadioButton(
  data: OldRadioButtonData,
) {
  RadioButton(
    modifier = Modifier.size(size = AppTheme.dimensions.spacing300),
    selected = data.isSelected,
    onClick = null,
    enabled = data.enabled,
    colors = RadioButtonDefaults.colors(
      selectedColor = AppTheme.colors.primary900,
      unselectedColor = AppTheme.colors.neutral80.orRedIfInvalid(
        validationState = data.validationState,
      ),
      disabledColor = AppTheme.colors.neutral30,
    ),
  )
}

@Composable
fun Color.orRedIfInvalid(validationState: ValidationState) =
  if (validationState is ValidationState.Invalid) {
    AppTheme.colors.supportRed100
  } else {
    this
  }
