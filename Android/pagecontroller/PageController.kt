package pl.gov.coi.common.ui.ds.pagecontroller

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import kotlinx.coroutines.launch
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.pagecontroller.provider.PageControllerPreviewParameterProvider
import pl.gov.coi.common.ui.ds.pageindicator.PageIndicator
import pl.gov.coi.common.ui.ds.smallcard.SmallCard
import pl.gov.coi.common.ui.ds.smallcard.SmallCardData
import pl.gov.coi.common.ui.onboarding.OnboardingPage
import pl.gov.coi.common.ui.onboarding.model.OnboardingPageData
import pl.gov.coi.common.ui.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <CONTENT_DATA> PageController(
  data: PageControllerData<CONTENT_DATA>,
  contents: @Composable (CONTENT_DATA) -> Unit = { },
) {
  val coroutineScope = rememberCoroutineScope()

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(color = AppTheme.colors.background)
      .padding(
        vertical = AppTheme.dimensions.spacing500,
      ),
  ) {
    val pageCount = data.contentsData.size
    val pagerState = rememberPagerState(
      pageCount = { pageCount },
    )
    HorizontalPager(
      state = pagerState,
      modifier = Modifier
        .fillMaxSize()
        .weight(10f),
    ) { page ->
      Box(
        modifier = Modifier
          .fillMaxSize(),
        contentAlignment = Alignment.Center,
      ) {
        contents(data.contentsData[page].content)
      }
    }
    PageIndicator(pagerState = pagerState)
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))
    Column(
      modifier = Modifier.weight(1f),
    ) {
      data.contentsData[pagerState.currentPage].let { pageData ->
        if (pageData.isButtonVisible) {
          Row(
            Modifier
              .padding(
                horizontal = AppTheme.dimensions.spacing200,
              )
              .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
          ) {
            Button(
              data = ButtonData(
                buttonSize = ButtonSize.Large(),
                buttonVariant = ButtonVariant.Primary,
                buttonType = ButtonType.WithText(
                  label = pageData.buttonTitle,
                ),
                onClick = {
                  when (pageData.buttonAction) {
                    PageControllerData.PageData.ButtonAction.GoToNextPage -> coroutineScope.launch {
                      pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                    is PageControllerData.PageData.ButtonAction.Custom -> pageData.buttonAction.invoke()
                  }
                },
              ),
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun PageControllerPreview(
  @PreviewParameter(PageControllerPreviewParameterProvider::class) data: PageControllerData<*>,
) {
  PageController(
    data = data,
    contents = { contentData ->
      when (contentData) {
        is SmallCardData -> SmallCard(data = contentData)
        is OnboardingPageData -> OnboardingPage(page = contentData)
      }
    },
  )
}
