package pl.gov.coi.common.ui.ds.progressbar

import androidx.compose.runtime.Stable
import pl.gov.coi.common.domain.label.Label

sealed interface ProgressBarData {
  val testTag: String?
  val value: Int

  @Stable
  data class Bar(
    override val testTag: String? = null,
    override val value: Int,
  ) : ProgressBarData

  @Stable
  data class IndicatorBar(
    override val testTag: String? = null,
    override val value: Int,
    val label: Label,
  ) : ProgressBarData
}
