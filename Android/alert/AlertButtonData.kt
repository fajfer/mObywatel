package pl.gov.coi.common.ui.ds.alert

import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.link.LinkData

sealed interface AlertButtonData {
  data class ButtonText(val data: ButtonTextData) : AlertButtonData
  data class Link(val data: LinkData) : AlertButtonData
}
