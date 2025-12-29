package pl.gov.coi.common.ui.ds.checkbox.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckBoxType
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.helpertext.HelperText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun CheckBoxBottomText(type: CheckBoxType) {
  when (type) {
    is CheckBoxType.Error -> type.errorText?.let { errorText ->
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
      ErrorText(testTag = type.testTag?.let { tag -> tag + "ErrorText" }, errorText = errorText)
    }
    is CheckBoxType.Helper -> if (type.helperText.isNotBlank()) {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
      HelperText(testTag = type.testTag?.let { tag -> tag + "HelperText" }, type.helperText)
    }
    is CheckBoxType.Default -> Unit
  }
}
