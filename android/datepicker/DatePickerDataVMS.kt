package pl.gov.coi.common.ui.ds.datepicker

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

interface DatePickerDataVMS {
  fun isDateSelectable(currentCalendarDate: Long): Boolean
  fun getInitialSelectedDate(initialDate: LocalDate?): Long?
}

class DatePickerDataVMSImpl(
  val minDate: LocalDate?,
  val maxDate: LocalDate?,
) : DatePickerDataVMS {
  override fun isDateSelectable(currentCalendarDate: Long): Boolean {
    /* 
18       Probably ZoneOffset.systemDefault should be used, but it returns wrong values. 
19       Will be checked in MOB-60795 
20        */
    val currentLocalDate = LocalDate.ofInstant(Instant.ofEpochMilli(currentCalendarDate), ZoneOffset.UTC)
    return (minDate?.isBefore(currentLocalDate) ?: true || minDate?.isEqual(currentLocalDate) ?: true) &&
      (maxDate?.isAfter(currentLocalDate) ?: true || maxDate?.isEqual(currentLocalDate) ?: true)
  }

  override fun getInitialSelectedDate(initialDate: LocalDate?): Long? {
    /* 
28       Probably ZoneOffset.systemDefault should be used, but it returns wrong values. 
29       Will be checked in MOB-60795 
30        */
    return initialDate?.atStartOfDay()?.atZone(ZoneOffset.UTC)?.toInstant()?.toEpochMilli()
  }
}