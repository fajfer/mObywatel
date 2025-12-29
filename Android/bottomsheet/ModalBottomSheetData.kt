package pl.gov.coi.common.ui.ds.bottomsheet

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.theme.AppTheme

data class ModalBottomSheetData(
  val sheetState: ModalSheetState,
  val title: Label? = null,
  val onCloseClick: (() -> Unit)? = null,
  val colorProvider: @Composable () -> Color = { AppTheme.colors.white },
)

data class ModalSheetState(
  val value: ModalSheetValue,
  val skipHalfExpanded: Boolean = true,
  val onValueChange: (ModalSheetValue) -> Unit,
)

enum class ModalSheetValue {
  EXPANDED, HIDDEN, HALF_EXPANDED
}
