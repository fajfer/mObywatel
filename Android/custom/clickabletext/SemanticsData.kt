package pl.gov.coi.common.ui.ds.custom.clickabletext

import androidx.compose.ui.semantics.SemanticsPropertyReceiver

data class SemanticsData(
  val mergeDescendants: Boolean = false,
  val semanticsContentDescription: String? = null,
  val semanticsProperties: (SemanticsPropertyReceiver.() -> Unit) = {},
)
