package pl.gov.coi.common.ui.ds.searchbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.searchbar.provider.SearchBarPPP
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
  modifier: Modifier = Modifier,
  data: SearchBarData,
  innerContent: @Composable () -> Unit,
) {
  androidx.compose.material3.SearchBar(
    modifier = Modifier
      .fillMaxWidth()
      .semantics {
        testTagsAsResourceId = true
        testTag = "SearchBarComponent"
      }
      .then(other = modifier),
    query = data.query,
    colors = SearchBarDefaults.colors(
      containerColor = if (data.isActive) AppTheme.colors.background else AppTheme.colors.white,
      dividerColor = AppTheme.colors.neutral30,
      inputFieldColors = SearchBarDefaults.inputFieldColors(
        focusedTextColor = AppTheme.colors.neutral500,
        unfocusedTextColor = AppTheme.colors.neutral500,
        cursorColor = AppTheme.colors.primary900,
      ),
    ),
    onSearch = {},
    onQueryChange = { data.onQueryChange(it) },
    active = data.isActive,
    onActiveChange = { data.onActiveChange(true) },
    placeholder = {
      Row {
        Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing50))
        CustomText(
          label = data.placeholder,
          overflow = TextOverflow.Ellipsis,
          style = AppTheme.typography.bodyLargeRegular,
          color = AppTheme.colors.neutral100,
        )
      }
    },
    leadingIcon = {
      SearchBarLeadingIcon(
        isActive = data.isActive,
        onActiveChanged = data.onActiveChange,
      )
    },
    trailingIcon = {
      if (data.isActive && data.query.isNotEmpty()) {
        SearchBarTrailingIcon(
          onClearClicked = data.onClearClicked,
        )
      }
    },
  ) {
    innerContent()
  }
}

@Composable
private fun SearchBarLeadingIcon(
  isActive: Boolean,
  onActiveChanged: (Boolean) -> Unit,
) {
  ButtonIcon(
    data = ButtonIconData(
      iconResId = if (isActive) R.drawable.ab004_arrow_left else R.drawable.ab002_search,
      iconColorProvider = { AppTheme.colors.neutral200 },
      onClick = { onActiveChanged(!isActive) },
    ),
  )
}

@Composable
private fun SearchBarTrailingIcon(
  onClearClicked: () -> Unit,
) {
  ButtonIcon(
    data = ButtonIconData(
      iconResId = R.drawable.ab009_x_mark,
      iconColorProvider = { AppTheme.colors.neutral200 },
      onClick = { onClearClicked() },
    ),
  )
}

@Preview
@Composable
fun SearchBarPreview(
  @PreviewParameter(SearchBarPPP::class)
  data: SearchBarData,
) {
  SearchBar(data = data) {
    CustomText(
      label = ("Inner content - results of the search should be placed in InnerContent")
        .toLabel(tag = "searchBarText"),
    )
  }
}
