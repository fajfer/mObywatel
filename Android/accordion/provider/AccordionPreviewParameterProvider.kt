package pl.gov.coi.common.ui.ds.accordion.provider

import androidx.compose.runtime.Composable
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.accordion.AccordionData
import pl.gov.coi.common.ui.ds.accordion.AccordionElement
import pl.gov.coi.common.ui.ds.accordion.CustomAccordionContent
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.timeline.Timeline
import pl.gov.coi.common.ui.timeline.TimelineData
import pl.gov.coi.common.ui.timeline.TimelineItemData
import pl.gov.coi.common.ui.unmapped.cardlist.ColumnCardList
import pl.gov.coi.common.ui.unmapped.cardlist.model.CardListData
import pl.gov.coi.common.ui.unmapped.singlecard.BodySection
import pl.gov.coi.common.ui.unmapped.singlecard.BodyTitleSection
import pl.gov.coi.common.ui.unmapped.singlecard.DefaultSingleCardData
import pl.gov.coi.common.ui.unmapped.singlecard.SingleCardLabel

class AccordionPreviewParameterProvider : CustomPreviewParameterProvider<AccordionData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<AccordionData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "AccordionSingle",
      value = provideAccordionSinglePreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AccordionSingleExpanded",
      value = provideAccordionSingleExpandedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AccordionSingleHistoryExpanded",
      value = provideAccordionSingleHistoryExpandedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AccordionList",
      value = provideAccordionListPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AccordionListOneExpanded",
      value = provideAccordionListOneExpandedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "AccordionSingleCardContent",
      value = provideAccordionSingleCardPreviewData(),
    ),
  )

  private fun provideAccordionSingleCardPreviewData() = AccordionData(
    elements = listOf(
      AccordionElement(
        header = "Accordion single header".toLabel(),
        addContentPadding = false,
        content = object : CustomAccordionContent {
          @Composable
          override fun Content() {
            ColumnCardList(
              data = CardListData(
                singleCardList = listOf(
                  DefaultSingleCardData(
                    bodySection = BodySection(
                      title = BodyTitleSection.Title(
                        singleCardLabel = SingleCardLabel(
                          label = "SingleCard 1".toLabel(),
                        ),
                      ),
                    ),
                  ),
                  DefaultSingleCardData(
                    bodySection = BodySection(
                      title = BodyTitleSection.Title(
                        singleCardLabel = SingleCardLabel(
                          label = "SingleCard 2".toLabel(),
                        ),
                      ),
                    ),
                  ),
                  DefaultSingleCardData(
                    bodySection = BodySection(
                      title = BodyTitleSection.Title(
                        singleCardLabel = SingleCardLabel(
                          label = "SingleCard 3".toLabel(),
                        ),
                      ),
                    ),
                  ),
                ),
              ),
            )
          }
        },
        initialExpanded = true,
        onListExpanded = {},
      ),
    ),
  )

  private fun provideAccordionSinglePreviewData() =
    AccordionData(
      elements = listOf(
        AccordionElement(
          header = "Accordion single header".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = false,
          onListExpanded = {},
        ),
      ),
    )

  private fun provideAccordionSingleExpandedPreviewData() =
    AccordionData(
      elements = listOf(
        AccordionElement(
          header = "Accordion expanded header".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = true,
          onListExpanded = {},
        ),
      ),
    )

  private fun provideAccordionSingleHistoryExpandedPreviewData() =
    AccordionData(
      elements = listOf(
        AccordionElement(
          header = "Accordion history expanded header".toLabel(),
          content = CustomTimelineAccordionContent(),
          initialExpanded = true,
          onListExpanded = {},
        ),
      ),
    )

  private fun provideAccordionListPreviewData() =
    AccordionData(
      elements = listOf(
        AccordionElement(
          header = "Accordion header 1".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = false,
          onListExpanded = {},
        ),
        AccordionElement(
          header = "Accordion header 2".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = false,
          onListExpanded = {},
        ),
        AccordionElement(
          header = "Accordion header 3".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = false,
          onListExpanded = {},
        ),
      ),
    )

  private fun provideAccordionListOneExpandedPreviewData() =
    AccordionData(
      elements = listOf(
        AccordionElement(
          header = "Accordion header 1 expanded".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = true,
          onListExpanded = {},
        ),
        AccordionElement(
          header = "Accordion header 2".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = false,
          onListExpanded = {},
        ),
        AccordionElement(
          header = "Accordion header 3".toLabel(),
          content = CustomTextAccordionContent(),
          initialExpanded = false,
          onListExpanded = {},
        ),
      ),
    )

  private class CustomTextAccordionContent : CustomAccordionContent {
    @Composable
    override fun Content() {
      CustomText(label = "Provide content here".toLabel(""))
    }
  }

  private class CustomTimelineAccordionContent : CustomAccordionContent {
    @Composable
    override fun Content() {
      Timeline(
        data = TimelineData(
          items = listOf(
            TimelineItemData(
              label = "02.08.2023 12:00".toLabel(""),
              title = "Primary Bold".toLabel(""),
              description = "Urząd Stanu Cywilnego w Bolesławcu".toLabel(""),
            ),
            TimelineItemData(
              label = "01.08.2023 12:00".toLabel(""),
              title = "Primary Bold".toLabel(""),
            ),
          ),
        ),
      )
    }
  }
}
