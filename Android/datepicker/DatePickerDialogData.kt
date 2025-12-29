package pl.gov.coi.common.ui.ds.datepicker

import java.time.LocalDate

data class DatePickerDialogData(
  val initialDate: LocalDate? = null,
  val onDateChange: (LocalDate) -> Unit,
  val close: () -> Unit,
  val datePickerDataVMS: DatePickerDataVMS,
)
