package pl.gov.coi.common.ui.ds.topappbar.small

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.progressbar.ProgressBar
import pl.gov.coi.common.ui.ds.topappbar.CreateMenuButtons
import pl.gov.coi.common.ui.ds.topappbar.CreateNavigationButton
import pl.gov.coi.common.ui.ds.topappbar.TEXT_MAX_ONE_LINE
import pl.gov.coi.common.ui.ds.topappbar.TitleAlignment
import pl.gov.coi.common.ui.ds.topappbar.TopAppBarData
import pl.gov.coi.common.ui.ds.topappbar.forceFocusOnStart
import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
import pl.gov.coi.common.ui.icon.CustomIcon
import pl.gov.coi.common.ui.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SmallTopAppBar(
  data: TopAppBarData.Small,
  scrollBehavior: TopAppBarScrollBehavior,
) {
  when (data is TopAppBarData.Small.Default && data.alignment == TitleAlignment.Left) {
    true -> TopAppBar(
      colors = TopAppBarDefaults.topAppBarColors(
        containerColor = data.containerColor(),
        scrolledContainerColor = data.containerColor(),
      ),
      title = {
        CustomText(
          modifier = Modifier
            .semantics {
              heading()
            }
            .focusHost(forceFocusOnStart(data.forceTitleFocusTrigger)),
          label = data.title,
          color = AppTheme.colors.neutral500,
          style = AppTheme.typography.subtitleMedium,
          overflow = TextOverflow.Ellipsis,
          maxLines = TEXT_MAX_ONE_LINE,
          focusIndex = -1f,
        )
      },
      navigationIcon = { data.navigationButtonData.CreateNavigationButton() },
      actions = { data.menuType.CreateMenuButtons() },
      scrollBehavior = scrollBehavior,
    )

    false -> CenterAlignedTopAppBar(
      colors = TopAppBarDefaults.topAppBarColors(
        containerColor = data.containerColor(),
        scrolledContainerColor = data.containerColor(),
      ),
      title = {
        when (data) {
          is TopAppBarData.Small.Default -> CustomText(
            modifier = Modifier
              .semantics {
                heading()
              }
              .focusHost(forceFocusOnStart(data.forceTitleFocusTrigger)),
            label = data.title,
            color = AppTheme.colors.neutral500,
            style = AppTheme.typography.subtitleMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = TEXT_MAX_ONE_LINE,
            labelContentDescription = data.title,
            focusIndex = -1f,
          )

          is TopAppBarData.Small.Logo -> Image(
            modifier = Modifier.height(AppTheme.dimensions.spacing400),
            painter = painterResource(id = R.drawable.coi_common_ui_ic_mobywatel_horizontal_logo),
            contentDescription = null,
          )

          is TopAppBarData.Small.Sygnet -> Unit
        }
      },
      navigationIcon = {
        when (data) {
          is TopAppBarData.Small.Default -> data.navigationButtonData.CreateNavigationButton()
          is TopAppBarData.Small.Logo -> data.navigationButtonData.CreateNavigationButton()
          is TopAppBarData.Small.Sygnet -> CustomIcon(
            modifier = Modifier.padding(start = AppTheme.dimensions.spacing150),
            iconResId = R.drawable.coi_common_ui_ic_mobywatel_logo,
            iconSize = IconSize.SBig,
            contentDescription = null, 
          )
        }
      },
      actions = {
        data.menuType.CreateMenuButtons()
      },
      scrollBehavior = scrollBehavior,
    )
  }
  when (data) {
    is TopAppBarData.Small.Default -> if (data.progressBarData != null) {
      ProgressBar(data = data.progressBarData)
    }

    else -> Unit
  }
}