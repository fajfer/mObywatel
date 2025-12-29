package pl.gov.coi.common.ui.ds.servicewelcomepage

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.alert.Alert
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.header.Header
import pl.gov.coi.common.ui.ds.inforow.InfoRowList
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.ds.servicewelcomepage.provider.ServiceWelcomePagePreviewParameterProvider
import pl.gov.coi.common.ui.pulltorefresh.PullToRefresh
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.topMenu.TopMenu

@Deprecated("Use BaseScaffold and Header")
@Composable
fun <CONTENT_DATA> ServiceWelcomePage(
  data: ServiceWelcomePageData<CONTENT_DATA>,
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
          start = AppTheme.dimensions.spacing200,
          end = AppTheme.dimensions.spacing200,
        ),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      PullToRefresh(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .background(color = AppTheme.colors.background),
        isEnabled = data.pullToRefreshEnabled,
        onRefresh = data.refreshAction,
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(color = AppTheme.colors.background)
            .verticalScroll(rememberScrollState())
            .padding(
              top = AppTheme.dimensions.spacing100,
              bottom = AppTheme.dimensions.spacing200,
            ),
        ) {
          data.alertData?.let {
            Alert(data = it)
            Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing200))
          }
          Header(data = data.headerData)
          Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing300))
          content(data.contentData)
        }
      }

      data.buttonData?.let {
        Column(
          modifier = Modifier
            .background(color = AppTheme.colors.background)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(
              top = AppTheme.dimensions.spacing200,
              bottom = AppTheme.dimensions.spacing200,
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
fun ServiceWelcomePagePreview(
  @PreviewParameter(ServiceWelcomePagePreviewParameterProvider::class) data: ServiceWelcomePageData<*>,
) {

  ServiceWelcomePage(data = data) {
    if (it is InfoRowListData) {
      InfoRowList(data = it)
    }
  }
}
