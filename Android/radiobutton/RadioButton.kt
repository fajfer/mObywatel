package pl.gov.coi.common.ui.ds.radiobutton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.contentbox.ContentBox
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.helpertext.HelperText
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonVariant
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttons.RadioButtons
import pl.gov.coi.common.ui.ds.radiobutton.provider.RadioButtonPPP

@Composable
fun RadioButton(
  data: RadioButtonData,
) {
  Column {
    RadioButtonHeader(
      label = data.label,
      onClickHelperIcon = data.onClickHelperIcon,
    )
    when (data.radioButtonVariant) {
      is RadioButtonVariant.Default -> RadioButtonDefault(data = data)
      is RadioButtonVariant.ContentBox -> RadioButtonContentBox(data = data)
    }
  }
}

@Composable
private fun RadioButtonContentBox(
  data: RadioButtonData,
) {
  ContentBox {
    Column {
      RadioButtonDefault(data = data)
    }
  }
}

@Composable
private fun RadioButtonDefault(
  data: RadioButtonData,
) {
  RadioButtons(
    items = data.items,
    state = data.supportText,
  )
  RadioButtonSupportText(supportText = data.supportText)
}

@Composable
private fun RadioButtonHeader(
  label: Label?,
  onClickHelperIcon: (() -> Unit)?,
) {
  Row {
    label?.let {
      CustomText(
        label = label,
        style = AppTheme.typography.subtitleMedium,
        color = AppTheme.colors.neutral500,
      )
    }
    Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing50))
    onClickHelperIcon?.let { onClick ->
      ButtonIcon(
        data = ButtonIconData(
          iconResId = R.drawable.ab015_help,
          onClick = onClick,
          iconColorProvider = { AppTheme.colors.primary900 },
        ),
      )
    }
  }
  if (label != null || onClickHelperIcon != null) {
    Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
  }
}

@Composable
private fun RadioButtonSupportText(supportText: RadioButtonSupportText) = when (supportText) {
  is RadioButtonSupportText.Helper -> RadioButtonHelperText(helperText = supportText.helperText)
  is RadioButtonSupportText.Error -> RadioButtonError(errorText = supportText.errorText)
  RadioButtonSupportText.None -> Unit
}

@Composable
private fun RadioButtonError(
  errorText: Label,
) {
  AnimatedVisibility(visible = true) {
    Column {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
      ErrorText(errorText = errorText)
    }
  }
}

@Composable
private fun RadioButtonHelperText(
  helperText: Label,
) {
  if (helperText.isNotBlank()) {
    Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
    HelperText(helperLabel = helperText)
  }
}

@Preview
@Composable
fun RadioButtonPreview(
  @PreviewParameter(RadioButtonPPP::class)
  wrappedValue: WrappedValue<RadioButtonData>,
) {
  Column(
    modifier = Modifier
      .background(color = AppTheme.colors.background)
      .fillMaxSize()
      .padding(all = AppTheme.dimensions.spacing200),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    RadioButton(data = wrappedValue.value())
  }
}
