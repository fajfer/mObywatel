package pl.gov.coi.common.ui.ds.statusbadge

import pl.gov.coi.common.domain.label.Label

sealed class StatusBadgeData(
  open val testTag: String?,
  open val label: Label,
  open val withBorder: Boolean = false,
  open val contentDescription: Label = Label.EMPTY,
  open val maxLines: Int,
) {
  data class WithDot(
    override val testTag: String? = null,
    override val label: Label,
    override val contentDescription: Label = Label.EMPTY,
    override val maxLines: Int = Int.MAX_VALUE,
    val status: StatusBadgeWithDotStatus,
  ) : StatusBadgeData(
    testTag = testTag,
    label = label,
    withBorder = false,
    maxLines = maxLines,
  )

  data class WithIcon(
    override val testTag: String? = null,
    override val label: Label,
    override val contentDescription: Label = Label.EMPTY,
    override val maxLines: Int = Int.MAX_VALUE,
    override val withBorder: Boolean = true,
    val status: StatusBadgeWithIconStatus,
  ) : StatusBadgeData(
    testTag = testTag,
    label = label,
    withBorder = withBorder,
    maxLines = maxLines,
  )
}

enum class StatusBadgeWithIconStatus {
  POSITIVE,
  INFORMATIVE,
  NEGATIVE,
  NOTICE,
  MINUS,
}

enum class StatusBadgeWithDotStatus {
  POSITIVE,
  INFORMATIVE,
  NEGATIVE,
  WARNING,
}
