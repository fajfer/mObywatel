package pl.gov.coi.common.ui.ds.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.window.DialogProperties
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.dialog.provider.DialogPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun Dialog(
  data: DialogData,
) {
  androidx.compose.ui.window.Dialog(
    properties = DialogProperties(usePlatformDefaultWidth = false),
    onDismissRequest = data.onDismiss,
  ) {
    Column(
      modifier = Modifier
        .padding(AppTheme.dimensions.spacing300)
        .background(color = AppTheme.colors.white, AppTheme.shapes.radius200)
        .padding(
          vertical = AppTheme.dimensions.spacing300,
          horizontal = AppTheme.dimensions.spacing250,
        )
        .semantics { testTag = data.testTag ?: data.title.tag },
      horizontalAlignment = data.horizontalAlignment,
    ) {
      if (data is DialogData.WithIcon) {
        Icon(
          data = IconData.Standard(
            testTag = data.testTag?.let { tag -> tag + "Icon" },
            iconResId = data.icon.iconResId,
            iconColorProvider = data.icon.iconColorProvider,
            iconSize = IconSize.SIZE24,
            contentDescription = Label.EMPTY,
          ),
        )
        Spacer(Modifier.height(AppTheme.dimensions.spacing200))
      }

      CustomText(
        testTag = data.testTag?.let { tag -> tag + "Title" },
        label = data.title,
        style = AppTheme.typography.titleMedium,
        textAlign = data.textAlign,
        color = AppTheme.colors.neutral500,
      )
      data.annotatedBody?.let { annotatedBody ->
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
        CustomText(
          testTag = data.testTag?.let { tag -> tag + "AnnotatedBody" },
          annotatedContent = annotatedBody.invoke(),
          style = AppTheme.typography.bodyMediumRegular,
          textAlign = data.textAlign,
          color = AppTheme.colors.neutral200,
        )
      } ?: data.body?.let {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
        CustomText(
          testTag = data.testTag?.let { tag -> tag + "Body" },
          label = data.body,
          style = AppTheme.typography.bodyMediumRegular,
          textAlign = TextAlign.Start,
          color = AppTheme.colors.neutral200,
        )
      }
      if (data is DialogData.WithThreeButtons) {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
        Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.End,
          verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.spacing150),
        ) {
          Button(data.primaryButtonData)
          Button(data.secondaryButtonData)
          Button(data.tertiaryButtonData)
        }
      } else {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing400))
        Row(
          Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.End,
        ) {
          data.secondaryButtonData?.let { secondaryButtonData ->
            Button(data = secondaryButtonData)
            Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
          }
          Button(data = data.primaryButtonData)
        }
      }
    }
  }
}

@Preview
@Composable
fun DialogPreview(
  @PreviewParameter(DialogPreviewParameterProvider::class) dialogData: DialogData,
) {
  Dialog(data = dialogData)
}
