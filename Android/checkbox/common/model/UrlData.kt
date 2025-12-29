package pl.gov.coi.common.ui.ds.checkbox.common.model

import pl.gov.coi.common.domain.label.Label

data class UrlData(
  val urlText: Label,
  val onClick: (url: String) -> Unit,
)
