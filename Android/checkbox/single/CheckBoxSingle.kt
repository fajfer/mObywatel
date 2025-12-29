package pl.gov.coi.common.ui.ds.checkbox.single

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.checkbox.common.CheckBoxBottomText
import pl.gov.coi.common.ui.ds.checkbox.common.CheckboxRow
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
import pl.gov.coi.common.ui.ds.checkbox.single.model.CheckBoxSingleData
import pl.gov.coi.common.ui.ds.contentbox.ContentBox
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun CheckBoxSingle(data: CheckBoxSingleData) {
  Column {
    when (data.contentType) {
      CheckboxContentType.CONTENT_BOX -> ContentBox {
        Column {
          CheckboxRow(data = data.checkbox, type = data.type, isEnabled = data.isEnabled)
          CheckBoxBottomText(data.type)
        }
      }

      CheckboxContentType.DEFAULT -> Column {
        CheckboxRow(data = data.checkbox, type = data.type, isEnabled = data.isEnabled)
        CheckBoxBottomText(data.type)
      }
    }
  }
}

@Composable
@Preview
fun CheckBoxSinglePreview(@PreviewParameter(CheckBoxSinglePPP::class) data: CheckBoxSingleData) {
  Box(
    modifier = Modifier
      .background(AppTheme.colors.background)
      .padding(AppTheme.dimensions.spacing200)
      .fillMaxSize(),
  ) {
    CheckBoxSingle(data)
  }
}
