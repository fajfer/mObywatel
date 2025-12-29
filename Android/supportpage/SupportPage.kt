package pl.gov.coi.common.ui.ds.supportpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.contentbox.ContentBox
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.supportpage.provider.SupportPagePreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.topMenu.TopMenu
import pl.gov.coi.common.ui.ds.inforow.InfoRowList
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData

@Deprecated("Use BaseScaffold with Header")
@Composable
fun <CONTENT_DATA> SupportPage(
  data: SupportPageData<CONTENT_DATA>,
  content: @Composable (CONTENT_DATA) -> Unit = {},
) {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
      TopMenu(
        label = data.topBarTitle,
        menuButtonData = data.menuButtonData,
        mainButtonData = data.mainButtonData,
      )
    },
  ) { contentPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(color = AppTheme.colors.background)
        .padding(
          top = contentPadding.calculateTopPadding(),
          start = AppTheme.dimensions.spacing250,
          end = AppTheme.dimensions.spacing250,
        ),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .background(color = AppTheme.colors.background)
          .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
        Icon(data = data.iconData)
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
        CustomText(
          label = data.title,
          modifier = Modifier
            .padding(horizontal = AppTheme.dimensions.spacing250)
            .align(alignment = Alignment.CenterHorizontally),
          style = AppTheme.typography.headlineMedium,
          textAlign = TextAlign.Center,
        )
        data.message?.let {
          Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
          CustomText(
            label = it,
            modifier = Modifier
              .padding(horizontal = AppTheme.dimensions.spacing250)
              .align(alignment = Alignment.CenterHorizontally),
            style = AppTheme.typography.bodyLargeRegular,
            color = AppTheme.colors.neutral200,
            textAlign = TextAlign.Center,
          )
        }
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing600))
        content(data.contentData)
      }

      data.buttonData?.let {
        Column(
          modifier = Modifier
            .background(color = AppTheme.colors.background)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(
              top = AppTheme.dimensions.spacing300,
              bottom = AppTheme.dimensions.spacing300,
            ),
          verticalArrangement = Arrangement.Bottom,
        ) {
          Button(data = it)
        }
      }
    }
  }
}

@Preview
@Composable
fun SupportPagePreview(@PreviewParameter(SupportPagePreviewParameterProvider::class) data: SupportPageData<*>) {
  SupportPage(data = data) {
    if (it is InfoRowListData) {
      ContentBox {
        InfoRowList(data = it)
      }
    }
  }
}
