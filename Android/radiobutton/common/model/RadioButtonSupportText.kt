package pl.gov.coi.common.ui.ds.radiobutton.common.model

import pl.gov.coi.common.domain.label.Label

sealed interface RadioButtonSupportText {
  data object None : RadioButtonSupportText
  data class Helper(val helperText: Label = Label.EMPTY) : RadioButtonSupportText
  data class Error(val errorText: Label = Label.EMPTY) : RadioButtonSupportText
}
