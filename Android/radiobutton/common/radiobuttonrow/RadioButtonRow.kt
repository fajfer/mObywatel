package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonrow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttoncontent.RadioButtonContent
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttondescription.RadioButtonDescription
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem.RadioButtonItem
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.get

@Composable
internal fun RadioButtonRow(
  data: RadioButtonRow,
) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }
  Row(
    modifier = Modifier
      .wrapContentHeight()
      .semantics {
        testTag = "radiobutton ${data.label.tag}"
      }
      .selectable(
        selected = data.item.isSelected,
        role = Role.RadioButton,
        enabled = data.item.enabled,
        interactionSource = NoRippleInteractionSource(),
        indication = null,
        onClick = {
          if (data.item.enabled && data.item.isSelected.not()) {
            multipleEventsCutter.processEvent {
              data.onClick()
            }
          }
        },
      ),
  ) {
    RadioButtonItem(data = data.item)
    Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing200))
    Column(modifier = Modifier.fillMaxWidth()) {
      CustomText(
        label = data.label,
        style = AppTheme.typography.bodyLargeRegular,
        color = AppTheme.colors.neutral500,
      )
      RadioButtonDescription(
        description = data.description,
      )
      RadioButtonContent(
        content = data.content?.content(),
        isSelected = data.item.isSelected,
      )
    }
  }
}
