package pl.gov.coi.common.ui.ds.checkbox.group.model

import pl.gov.coi.common.domain.label.Label

data class CheckBoxHeaderData(
  val label: Label,
  val onClick: (() -> Unit)? = null,
)
