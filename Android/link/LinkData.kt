package pl.gov.coi.common.ui.ds.link

import pl.gov.coi.common.domain.label.Label

data class LinkData(
  val testTag: String? = null,
  val label: Label,
  val url: String,
  val linkType: LinkType,
  val enabled: Boolean = true,
  val onClick: (String) -> Unit,
) {
  enum class LinkType {
    WEBSITE, E_MAIL, EXTERNAL_APP
  }
}
