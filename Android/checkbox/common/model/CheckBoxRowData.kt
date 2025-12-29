package pl.gov.coi.common.ui.ds.checkbox.common.model

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.link.LinkData

data class CheckBoxRowData(
  val testTag: String? = null,
  val isChecked: Boolean,
  val onCheckedChange: (Boolean) -> Unit,
  val label: Label = Label.EMPTY,
  val clickableTextData: ClickableTextData? = null,
)

sealed interface ClickableTextData {
  data class Link(
    val linkData: LinkData,
  ) : ClickableTextData

  data class Button(
    val buttonData: ButtonTextData,
  ) : ClickableTextData
}
