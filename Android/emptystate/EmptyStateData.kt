package pl.gov.coi.common.ui.ds.emptystate

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.ButtonData

data class EmptyStateData(
  val title: Label? = null,
  val body: Label,
  val buttonData: ButtonData? = null,
)
