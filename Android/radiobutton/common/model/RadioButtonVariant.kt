package pl.gov.coi.common.ui.ds.radiobutton.common.model

sealed interface RadioButtonVariant {
  data object Default : RadioButtonVariant
  data object ContentBox : RadioButtonVariant
}
