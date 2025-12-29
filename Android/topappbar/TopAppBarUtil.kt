package pl.gov.coi.common.ui.ds.topappbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalFocusManager
import kotlinx.coroutines.delay
import pl.gov.coi.common.ui.focus.FocusHost
import pl.gov.coi.common.ui.focus.createFocusHost

@Deprecated(
  "This is hack for WCAG requirements to focus titles on every screen enter." +
    " Should be deleted with task MOB-72178",
)
@Composable
fun forceFocusOnStart(forceFocusTrigger: Boolean?): FocusHost {

  val focusHost = createFocusHost(false)
  val focusManager = LocalFocusManager.current
  if (forceFocusTrigger != null) {
    LaunchedEffect(forceFocusTrigger) {
      delay(1L)
      focusManager.clearFocus(true)
      delay(1L)
      focusHost.requestFocus()
    }
  }
  return focusHost
}
