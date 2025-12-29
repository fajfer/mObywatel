package pl.gov.coi.common.ui.ds.cardlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.cardlist.provider.CardListPreviewProvider
import pl.gov.coi.common.ui.ds.cardlist.provider.ProvidedCardListData
import pl.gov.coi.common.ui.ds.singlecard.SingleCard
import pl.gov.coi.common.ui.ds.singlecard.SingleCardData
import pl.gov.coi.common.ui.model.ListType
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.theme.AppTheme

data class CardListData(
  val cards: List<SingleCardData>,
  val type: ListType = ListType.COLUMN,
)

@Composable
fun CardList(
  data: CardListData,
) {
  Card(
    shape = AppTheme.shapes.radius200,
    elevation = AppTheme.elevations.level0,
  ) {
    when (data.type) {
      ListType.COLUMN ->
        Column {
          data.cards.forEachIndexed { index, singleCardData ->
            ItemContent(
              card = singleCardData,
              isLastItem = data.cards.lastIndex == index,
            )
          }
        }

      ListType.LAZY ->
        LazyColumn {
          itemsIndexed(data.cards) { index, singleCardData ->
            ItemContent(
              card = singleCardData,
              isLastItem = data.cards.lastIndex == index,
            )
          }
        }
    }
  }
}

@Composable
private fun ItemContent(
  card: SingleCardData,
  isLastItem: Boolean,
) {
  SingleCard(data = card)
  if (!isLastItem) {
    ListDivider()
  }
}

@Composable
private fun ListDivider() {
  Row {
    Divider(
      modifier = Modifier.padding(
        start = AppTheme.dimensions.spacing250,
        end = AppTheme.dimensions.spacing250,
      ),
      thickness = AppTheme.dimensions.strokeWidth,
      color = AppTheme.colors.neutral30,
    )
  }
}

@Preview
@Composable
fun CardListPreview(
  @PreviewParameter(CardListPreviewProvider::class)
  wrappedValue: WrappedValue<ProvidedCardListData>,
) = with(wrappedValue.value()) {
  Column {
    Text(
      modifier = Modifier.padding(AppTheme.dimensions.spacing250),
      text = previewName,
    )
    CardList(
      data = data,
    )
  }
}
