package pl.gov.coi.common.ui.ds.singlecard

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.ds.singlecard.provider.SingleCardPreviewParameterProvider

val SINGLE_CARD_MINIMUM_HEIGHT: Dp = 80.dp

@Deprecated(
  message = "Deprecated",
  replaceWith = ReplaceWith(
    expression = "SingleCard()",
    imports = arrayOf("pl.gov.coi.common.ui.unmapped.singlecard"),
  ),
)
@Composable
fun SingleCard(
  data: SingleCardData,
) {
  when (data) {
    is SingleCardData.Info -> SingleCardInfo(data = data)
    is SingleCardData.Clickable -> SingleCardClickable(data = data)
    is SingleCardData.SelectableRadioButton -> SingleCardSelectableRadioButton(data = data)
    is SingleCardData.SelectableCheckbox -> SingleCardSelectableCheckbox(data = data)
  }
}

@Preview
@Composable
fun SingleCardPreview(
  @PreviewParameter(SingleCardPreviewParameterProvider::class) singleCardData: SingleCardData,
) {
  SingleCard(
    data = singleCardData,
  )
}
