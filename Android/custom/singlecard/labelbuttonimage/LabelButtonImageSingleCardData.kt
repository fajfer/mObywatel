package pl.gov.coi.common.ui.ds.custom.singlecard.labelbuttonimage

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection

data class LabelButtonImageSingleCardData(
  val label: Label? = null,
  val buttonData: ButtonData,
  val qrCodeImage: MediaSection.Image,
)
