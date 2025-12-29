package pl.gov.coi.common.ui.ds.custom.documentrow.provider

import android.content.Context
import androidx.compose.ui.res.colorResource
import pl.gov.coi.common.domain.Mapper
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.documentrow.DocumentRowData
import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeData
import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeWithIconStatus
import pl.gov.coi.common.ui.preview.CustomWrappedDataPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestDataProvider
import pl.gov.coi.common.ui.preview.WrappedValue

data class ProvidedSingleCardDocumentRowData(
  val previewName: String,
  val data: DocumentRowData,
)

class SingleCardDocumentRowPPP : CustomWrappedDataPreviewParameterProvider
  <Unit, DocumentRowData, Mapper<Unit, DocumentRowData>, ProvidedSingleCardDocumentRowData>() {

  override fun mapper(context: Context): Mapper<Unit, DocumentRowData> {
    return object : Mapper<Unit, DocumentRowData> {
      override fun invoke(p1: Unit): DocumentRowData = getSingleCardDocument()
    }
  }

  private val cards = mapOf(
    "SingleCardDocumentRow" to getSingleCardDocument(),
    "SingleCardDocumentRowWithDescription" to getSingleCardDocumentWithDescription(),
    "SingleCardDocumentRowWithStatus" to getSingleCardDocumentWithStatus(),
    "SingleCardDocumentRowWithDescriptionStatus" to getSingleCardDocumentWithDescriptionStatus(),
  )

  override val screenShotTestValues: Sequence<ScreenShotTestDataProvider<ProvidedSingleCardDocumentRowData>>
    get() = cards.map { (testName, cardData) ->
      ScreenShotTestDataProvider(
        screenShotTestName = testName,
        wrappedValue = WrappedValue {
          ProvidedSingleCardDocumentRowData(
            previewName = testName,
            data = cardData,
          )
        },
      )
    }.asSequence()

  private fun getSingleCardDocument() = DocumentRowData(
    title = "Legitymacja poselska".toLabel(),
    iconColorProvider = { colorResource(id = R.color.coi_mobywatel_feature_dashboard_deputy_card_primary) },
    iconResId = R.drawable.db012_legitymacja_poselska,
    badgeData = null,
    onClick = {},
  )

  private fun getSingleCardDocumentWithDescription() = getSingleCardDocument().copy(
    description = "Opis dokumentu".toLabel(),
  )

  private fun getSingleCardDocumentWithStatus() = getSingleCardDocument().copy(
    badgeData = StatusBadgeData.WithIcon(
      label = "Błąd pobierania".toLabel(),
      withBorder = false,
      status = StatusBadgeWithIconStatus.NEGATIVE,
    ),
  )

  private fun getSingleCardDocumentWithDescriptionStatus() = getSingleCardDocumentWithDescription().copy(
    badgeData = StatusBadgeData.WithIcon(
      label = "Błąd pobierania".toLabel(),
      withBorder = false,
      status = StatusBadgeWithIconStatus.NEGATIVE,
    ),
  )
}
