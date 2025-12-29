package pl.gov.coi.common.ui.ds.switchcomponent

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.link.LinkData

sealed class SwitchData(
  val testTag: String?,
  val checked: Boolean,
  val enabled: Boolean,
  val onCheckedChange: ((Boolean) -> Unit)?,
  val contentDescription: Label?,
  val testIndexTag: Int? = null,
) {
  class SwitchOnly(
    testTag: String? = null,
    checked: Boolean,
    enabled: Boolean = true,
    onCheckedChange: ((Boolean) -> Unit)?,
    contentDescription: Label? = null,
    testIndexTag: Int? = null,
  ) : SwitchData(
    testTag = testTag,
    checked = checked,
    enabled = enabled,
    onCheckedChange = onCheckedChange,
    contentDescription = contentDescription,
    testIndexTag = testIndexTag,
  )

  class SwitchWithText(
    testTag: String? = null,
    checked: Boolean,
    val label: Label,
    val validationState: ValidationState = ValidationState.Default,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
    testIndexTag: Int? = null,
  ) : SwitchData(
    testTag = testTag,
    checked = checked,
    enabled = enabled,
    onCheckedChange = onCheckedChange,
    contentDescription = null,
    testIndexTag = testIndexTag,
  )

  
  
  class SwitchWithExtras(
    testTag: String? = null,
    checked: Boolean,
    val label: Label,
    val validationState: ValidationState = ValidationState.Default,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
    testIndexTag: Int? = null,
    val type: SwitchExtraType,
    val customActionContentDescription: Label,
  ) : SwitchData(
    testTag = testTag,
    checked = checked,
    enabled = enabled,
    onCheckedChange = onCheckedChange,
    contentDescription = null,
    testIndexTag = testIndexTag,
  )
}

sealed interface SwitchExtraType {
  data class Link(val data: LinkData) : SwitchExtraType
  data class TextButton(val data: ButtonTextData) : SwitchExtraType
}