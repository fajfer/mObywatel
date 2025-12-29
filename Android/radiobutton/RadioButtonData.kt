package pl.gov.coi.common.ui.ds.radiobutton

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonSupportText
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonVariant

data class RadioButtonData(
  val items: List<RadioButtonRow>,
  val radioButtonVariant: RadioButtonVariant,
  val supportText: RadioButtonSupportText = RadioButtonSupportText.None,
  val label: Label? = null,
  val onClickHelperIcon: (() -> Unit)? = null,
)
