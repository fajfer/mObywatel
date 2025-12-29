package pl.gov.coi.common.ui.ds.custom.singlecard.barcode

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection

data class BarCodeSingleCardData(
  val label: Label,
  val barCodeImage: MediaSection.Image,
)
