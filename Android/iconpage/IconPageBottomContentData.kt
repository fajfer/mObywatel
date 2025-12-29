package pl.gov.coi.common.ui.ds.iconpage

import pl.gov.coi.common.ui.ds.button.ButtonData

data class IconPageBottomContentData(
  val primaryButtonData: ButtonData,
  val secondaryButtonData: ButtonData? = null,
  val tertiaryButtonData: ButtonData? = null,
)
