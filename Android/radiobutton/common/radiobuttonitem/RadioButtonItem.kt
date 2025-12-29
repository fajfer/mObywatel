package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

@Composable
fun RadioButtonItem(
  data: RadioButtonItemData,
) {
  RadioButton(
    selected = data.isSelected,
    enabled = data.enabled,
    interactionSource = NoRippleInteractionSource(),
    colors = RadioButtonDefaults.colors(
      selectedColor = AppTheme.colors.primary900.orRedIfError(
        isError = data.isError,
      ),
      unselectedColor = AppTheme.colors.neutral80.orRedIfError(
        isError = data.isError,
      ),
      disabledSelectedColor = AppTheme.colors.neutral30,
      disabledUnselectedColor = AppTheme.colors.neutral30,
    ),
    onClick = null,
  )
}

@Composable
private fun Color.orRedIfError(isError: Boolean) =
  if (isError) {
    AppTheme.colors.supportRed100
  } else {
    this
  }

@Preview
@Composable
fun RadioButtonItemPreview(
  @PreviewParameter(RadioButtonItemPPP::class)
  wrappedValue: WrappedValue<RadioButtonItemData>,
) {
  Column(
    modifier = Modifier
      .background(color = AppTheme.colors.background)
      .fillMaxSize()
      .padding(all = AppTheme.dimensions.spacing200),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    RadioButtonItem(data = wrappedValue.value())
  }
}
