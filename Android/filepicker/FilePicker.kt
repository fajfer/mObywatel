package pl.gov.coi.common.ui.ds.filepicker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.filepicker.model.FilePickerData
import pl.gov.coi.common.ui.ds.filepicker.model.showAddButton
import pl.gov.coi.common.ui.ds.filepicker.model.showError
import pl.gov.coi.common.ui.ds.filepicker.provider.FilePickerPreviewParameterProvider
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.unmapped.cardlist.ColumnCardList
import pl.gov.coi.common.ui.unmapped.cardlist.model.CardListData
import pl.gov.coi.common.ui.unmapped.singlecard.SingleCard

@Composable
fun FilePicker(
  modifier: Modifier = Modifier,
  data: FilePickerData,
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight(),
  ) {
    if (data.files.isNotEmpty()) {
      ColumnCardList(data = CardListData(singleCardList = data.cardsData))
    }

    if (data.showAddButton) {
      if (data.files.isNotEmpty()) {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
      }

      SingleCard(singleCardData = data.addFileCardData)

      AnimatedVisibility(visible = data.showError) {
        data.errorLabel?.let { errorText ->
          Column {
            Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
            ErrorText(errorText = errorText, ignoreForAccessibility = true)
          }
        }
      }

      Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))

      CustomText(
        label = data.combinedRequirements,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
        ignoreForAccessibility = true,
      )
    }
  }
}

@Preview
@Composable
internal fun FilePickerPreview(
  @PreviewParameter(FilePickerPreviewParameterProvider::class)
  wrappedValue: WrappedValue<FilePickerData>,
) {
  FilePicker(
    modifier = Modifier.background(AppTheme.colors.background),
    data = wrappedValue.value(),
  )
}
