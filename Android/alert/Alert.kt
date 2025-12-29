package pl.gov.coi.common.ui.ds.alert

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.alert.provider.AlertPreviewParameterProvider
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonText
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.link.Link
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun Alert(
  modifier: Modifier = Modifier,
  data: AlertData,
) {
  val lightAlertSuccessColor = Color(0xFFEEFAE1)
  Box(
    modifier = modifier
      .wrapContentHeight()
      .fillMaxWidth()
      .clip(shape = AppTheme.shapes.radius200)
      .background(
        color = when (data) {
          is AlertData.Info -> AppTheme.colors.supportBlue20
          is AlertData.Warning -> AppTheme.colors.supportOrange20
          is AlertData.Error -> AppTheme.colors.supportRed20
          is AlertData.Success -> lightAlertSuccessColor
        },
      )
      .semantics(mergeDescendants = true) {
        contentDescription = data.alertContentDescription.text
      },
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(
          all = AppTheme.dimensions.spacing200,
        ),
    ) {
      Icon(data = data.iconData)
      Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing200))
      Column(
        modifier = Modifier.weight(weight = 1f),
      ) {
        data.title?.let { title ->
          CustomText(
            testTag = data.testTag?.let { tag -> tag + "TitleText" },
            label = title,
            style = AppTheme.typography.bodyLargeMedium,
            overflow = TextOverflow.Ellipsis,
            color = AppTheme.colors.neutral500,
          )
          Spacer(
            modifier = Modifier
              .fillMaxWidth()
              .height(AppTheme.dimensions.spacing50),
          )
        }
        CustomText(
          testTag = data.testTag?.let { tag -> tag + "BodyText" },
          label = data.bodyText,
          style = AppTheme.typography.bodyMediumRegular,
          color = AppTheme.colors.neutral500,
        )
        data.alertButtonData?.let { alertActionButtonData ->
          Spacer(
            modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
          )
          when (alertActionButtonData) {
            is AlertButtonData.Link -> Link(data = alertActionButtonData.data)
            is AlertButtonData.ButtonText -> ButtonText(data = alertActionButtonData.data)
          }
        }
      }
      data.closeButtonData?.let { buttonData ->
        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
        ButtonIcon(
          data = buttonData,
        )
      }
    }
  }
}

@Preview
@Composable
fun AlertFullPreview(
  @PreviewParameter(AlertPreviewParameterProvider::class) data: AlertData,
) {
  Alert(
    data = data,
  )
}
