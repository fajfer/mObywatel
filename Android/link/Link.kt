package pl.gov.coi.common.ui.ds.link

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.get

@Composable
fun Link(data: LinkData) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }
  CustomText(
    testTag = data.testTag,
    modifier = Modifier
      .semantics {
        if (data.enabled.not()) disabled()
      }
      .clickable(
        enabled = data.enabled,
        onClick = {
          multipleEventsCutter.processEvent {
            data.onClick(data.url)
          }
        },
      ),
    labelContentDescription = when (data.linkType) {
      LinkData.LinkType.WEBSITE -> CommonUILabelProvider.linkToWebsite()
      LinkData.LinkType.E_MAIL -> CommonUILabelProvider.linkToEMail()
      LinkData.LinkType.EXTERNAL_APP -> CommonUILabelProvider.linkToExternalApp()
    }.let { wcagLabel -> "${data.label.text}. ${wcagLabel.text}".toLabel(tag = "linkLabel") },
    textAlign = TextAlign.Start,
    label = data.label,
    style = AppTheme.typography.bodyMediumMedium,
    textDecoration = TextDecoration.Underline,
    color = when {
      data.enabled.not() -> AppTheme.colors.neutral60
      else -> AppTheme.colors.primary900
    },
  )
}

@Preview
@Composable
fun LinkPreview(
  @PreviewParameter(LinkPreviewProvider::class)
  data: LinkData,
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(AppTheme.colors.white)
      .padding(all = AppTheme.dimensions.spacing200),
  ) {
    Link(data = data)
  }
}
