package pl.gov.coi.common.ui.ds.accordion

import androidx.compose.runtime.Composable
import pl.gov.coi.common.domain.label.Label

interface CustomAccordionContent {
  @Composable
  fun Content()
}

data class AccordionData(
  val elements: List<AccordionElement>,
)

data class AccordionElement(
  val header: Label,
  val initialExpanded: Boolean = false,
  val onListExpanded: (Boolean) -> Unit = {},
  val addContentPadding: Boolean = true,
  val content: CustomAccordionContent,
)
