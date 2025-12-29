package pl.gov.coi.common.ui.ds.chatbubble.provider

import pl.gov.coi.common.ui.ds.chatbubble.ChatBubbleData
import pl.gov.coi.common.ui.ds.chatbubble.ClickableContent
import pl.gov.coi.common.ui.ds.chatbubble.Content
import pl.gov.coi.common.ui.ds.chatbubble.ContentType
import pl.gov.coi.common.ui.ds.chatbubble.FooterData
import pl.gov.coi.common.ui.ds.chatbubble.FooterActionData
import pl.gov.coi.common.ui.ds.chatbubble.SourcesData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class ChatBubblePreviewParameterProvider : CustomPreviewParameterProvider<ChatBubbleData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<ChatBubbleData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "ChatBubbleBotLoading",
      value = provideChatBubbleBotLoadingPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ChatBubbleBot",
      value = provideChatBubbleBotPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ChatBubbleUser",
      value = provideChatBubbleUserPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ChatBubbleBotWithOptionsWithSources",
      value = provideChatBubbleBotWithOptionsPreviewData(
        sourcesData = SourcesData(
          title = "Źródło".toLabel(),
          showMoreButtonLabel = "+ X więcej".toLabel(),
          showLessButtonLabel = "Pokaż mniej".toLabel(),
          items = listOf(
            ClickableContent(
              value = "1. Gov.pl",
              onClick = {},
            ),
            ClickableContent(
              value = "2. Gov.pl",
              onClick = {},
            ),
            ClickableContent(
              value = "3. Gov.pl",
              onClick = {},
            ),
          ),
        ),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "ChatBubbleBotWithOptionsWithoutSources",
      value = provideChatBubbleBotWithOptionsPreviewData(
        sourcesData = null,
      ),
    ),
  )

  private fun provideChatBubbleBotLoadingPreviewData() =
    ChatBubbleData.IncomingMessage(
      label = "Wirtualny asystent".toLabel(),
    )

  private fun provideChatBubbleBotPreviewData() =
    ChatBubbleData.IncomingMessage(
      label = "Wirtualny asystent".toLabel(),
      isLoading = false,
      content = listOf(
        Content(
          type = ContentType.TEXT,
          value = "Treść odpowiedzi bota - jakaś dłuższa, żeby było widać jak wygląda wielolinijkowo. " +
            "Dalsza część odpowiedzi, jeszcze trochę znaków.",
        ),
      ),
    )

  private fun provideChatBubbleUserPreviewData() =
    ChatBubbleData.OutgoingMessage(
      content = listOf(
        Content(
          type = ContentType.TEXT,
          value = "Treść pytania użytkownika",
        ),
      ),
    )

  private fun provideChatBubbleBotWithOptionsPreviewData(sourcesData: SourcesData?) =
    ChatBubbleData.IncomingMessage(
      label = "Wirtualny asystent".toLabel(),
      isLoading = false,
      content = listOf(
        Content(
          type = ContentType.TEXT,
          value = "To jest jakiś tekst, a tutaj jest ",
        ),
        Content(
          type = ContentType.LINK,
          value = "link",
          url = "www.gov.pl",
        ),
        Content(
          type = ContentType.TEXT,
          value = ". To wszystko jest z naszego źródła ",
        ),
        Content(
          type = ContentType.SOURCE,
          value = "(1)",
          url = "www.gov.pl",
        ),
        Content(
          type = ContentType.TEXT,
          value = ". Dalszy tekst.",
        ),
      ),
      additionalInfo = "Odpowiedź 2 z 10".toLabel(),
      footerData = FooterData(
        sourcesData = sourcesData,
        actionsData = listOf(
          FooterActionData.Toggleable.PositiveRate(isSelected = true, onToggle = {}),
          FooterActionData.Toggleable.NegativeRate(isSelected = false, onToggle = {}),
          FooterActionData.Share(onClick = {}),
        ),
      ),
      actions = listOf(
        ClickableContent(
          value = "Zgłoś naruszenie",
          onClick = {},
        ),
        ClickableContent(
          value = "Akcja",
          onClick = {},
        ),
      ),
      suggestions = listOf(
        ClickableContent(
          value = "Jak założyć profil zaufany?",
          onClick = {},
        ),
        ClickableContent(
          value = "Jak złożyć wniosek o dodatek elektryczny?",
          onClick = {},
        ),
      ),
      onUrlClick = {},
    )
}
