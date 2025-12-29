package pl.gov.coi.common.ui.ds.topappbar.medium

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import pl.gov.coi.common.ui.ds.topappbar.CreateMenuButtons
import pl.gov.coi.common.ui.ds.topappbar.CreateNavigationButton
import pl.gov.coi.common.ui.ds.topappbar.TEXT_MAX_ONE_LINE
import pl.gov.coi.common.ui.ds.topappbar.TopAppBarData
import pl.gov.coi.common.ui.ds.topappbar.forceFocusOnStart
import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MediumTopAppBar(
  data: TopAppBarData.Medium,
  scrollBehavior: TopAppBarScrollBehavior,
) {
  MediumTopAppBar(
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = data.containerColor(),
      scrolledContainerColor = data.containerColor(),
    ),
    title = {
      if (scrollBehavior.state.collapsedFraction < 0.35) {
        CustomText(
          modifier = Modifier
            .semantics {
              heading()
            }
            .focusHost(forceFocusOnStart(data.forceTitleFocusTrigger)),
          label = data.title,
          color = AppTheme.colors.neutral500,
          style = AppTheme.typography.headlineLargeMedium,
          overflow = TextOverflow.Ellipsis,
          maxLines = TEXT_MAX_ONE_LINE,
        )
      }
      if (scrollBehavior.state.collapsedFraction > 0.75) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.Center,
        ) {
          CustomText(
            modifier = Modifier.semantics {
              heading()
            },
            label = data.title,
            color = AppTheme.colors.neutral500,
            style = AppTheme.typography.subtitleMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = TEXT_MAX_ONE_LINE,
          )
        }
      }
    },
    navigationIcon = { data.navigationButtonData.CreateNavigationButton() },
    actions = {
      data.menuType.CreateMenuButtons()
    },
    scrollBehavior = scrollBehavior,
  )
}
