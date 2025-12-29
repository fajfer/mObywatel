package pl.gov.coi.common.ui.ds.chatbubble

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.chatbubble.provider.ChatBubblePreviewParameterProvider
import pl.gov.coi.common.ui.ds.custom.clickabletext.CustomClickableText
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChatBubble(
  modifier: Modifier = Modifier,
  data: ChatBubbleData,
) {
  val darkestInfoStatus = Color(0xFF01498B)
  val lightGrey4 = Color(0xFF333333)

  Column(
    modifier = modifier.fillMaxWidth(),
  ) {
    Row {
      Card(
        modifier = Modifier
          .padding(
            start = when (data) {
              is ChatBubbleData.IncomingMessage -> AppTheme.dimensions.zero
              is ChatBubbleData.OutgoingMessage -> AppTheme.dimensions.spacing600
            },
            end = when (data) {
              is ChatBubbleData.IncomingMessage -> AppTheme.dimensions.spacing600
              is ChatBubbleData.OutgoingMessage -> AppTheme.dimensions.zero
            },
          )
          .weight(1f)
          .then(
            when {
              data.isLoading -> Modifier.wrapContentWidth(align = Alignment.Start)
              data is ChatBubbleData.IncomingMessage -> Modifier.fillMaxWidth()
              else -> Modifier.wrapContentWidth(align = Alignment.End)
            },
          ),
        shape = AppTheme.shapes.radius150,
        colors = CardDefaults.cardColors(
          containerColor = when (data) {
            is ChatBubbleData.IncomingMessage -> Color.White
            is ChatBubbleData.OutgoingMessage -> AppTheme.colors.primary900
          },
        ),
        elevation = CardDefaults.cardElevation(
          defaultElevation = AppTheme.elevations.level0,
        ),
      ) {
        Column(
          modifier = Modifier
            .padding(
              start = AppTheme.dimensions.spacing200,
              top = AppTheme.dimensions.spacing150,
              end = AppTheme.dimensions.spacing200,
              bottom = AppTheme.dimensions.spacing200,
            ),
        ) {
          Row(
            modifier = Modifier
              .padding(bottom = AppTheme.dimensions.spacing50),
            horizontalArrangement = Arrangement.SpaceBetween,
          ) {
            data.label?.let { label ->
              CustomText(
                modifier = Modifier
                  .weight(
                    weight = 1F,
                    fill = false,
                  )
                  .padding(
                    top = AppTheme.dimensions.spacing50,
                    bottom = AppTheme.dimensions.spacing50,
                  ),
                style = AppTheme.typography.bodyMediumRegular,
                label = label,
              )
            }
          }

          if (data.isLoading) {
            DotsTyping()
          }

          val annotatedString = buildAnnotatedString {
            data.content?.forEach { content ->
              when (content.type) {
                ContentType.TEXT,
                ContentType.SOURCE,
                ->
                  withStyle(
                    style = SpanStyle(
                      fontStyle = AppTheme.typography.bodyLargeRegular.fontStyle,
                      color = when (data) {
                        is ChatBubbleData.IncomingMessage -> lightGrey4
                        is ChatBubbleData.OutgoingMessage -> AppTheme.colors.white
                      },
                    ),
                  ) {
                    append(content.value)
                  }

                ContentType.LINK -> if (content.url == null) {
                  withStyle(
                    style = SpanStyle(
                      fontStyle = AppTheme.typography.bodyLargeRegular.fontStyle,
                      color = lightGrey4,
                    ),
                  ) {
                    append(content.value)
                  }
                } else {
                  pushStringAnnotation(
                    tag = content.url,
                    annotation = content.url,
                  )
                  withStyle(
                    style = SpanStyle(
                      color = darkestInfoStatus,
                      fontWeight = FontWeight.Bold,
                    ),
                  ) {
                    append(content.value)
                  }
                  pop()
                }

                ContentType.UNKNOWN -> Unit
              }
            }
          }

          CustomClickableText(
            annotatedText = annotatedString,
            style = AppTheme.typography.bodyLargeRegular.copy(textAlign = TextAlign.Start),
            onClick = data.onUrlClick,
          )

          data.footerData?.let { data -> MessageFooter(footerData = data) }
        }
      }
    }

    data
      .actions
      ?.takeIf { actions -> actions.isNotEmpty() }
      ?.let { actions -> CtaSection(actions = actions) }

    data.additionalInfo?.let { additionalInfo ->
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
      CustomText(
        label = additionalInfo,
        style = AppTheme.typography.bodySmallRegular,
        color = AppTheme.colors.neutral200,
      )
    }

    data.suggestions?.let { suggestions ->
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing300))
      FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
          space = AppTheme.dimensions.spacing100,
          alignment = Alignment.End,
        ),
        verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing100),
      ) {
        suggestions.forEachIndexed { index, suggestion ->
          Button(
            data = ButtonData(
              buttonSize = ButtonSize.Large(
                fillMaxWidth = false,
              ),
              buttonVariant = ButtonVariant.Secondary(),
              buttonType = ButtonType.WithText(
                label = suggestion.value.toLabel(tag = "suggestionButton_$index"),
              ),
              onClick = suggestion.onClick,
            ),
          )
        }
      }
    }
    Spacer(
      modifier = Modifier
        .height(height = AppTheme.dimensions.spacing300)
        .fillMaxWidth(),
    )
  }
}

@ExperimentalLayoutApi
@Composable
private fun MessageFooter(footerData: FooterData) {
  var sourcesExpanded by remember {
    mutableStateOf(false)
  }

  if (footerData.isVisible) {
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing250))
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      footerData.sourcesData?.let { sourcesData ->
        CustomText(
          label = sourcesData.title,
          style = AppTheme.typography.bodyMediumMedium,
          color = AppTheme.colors.neutral500,
        )
      }

      FlowRow(
        modifier = Modifier.weight(weight = 1f),
        horizontalArrangement = Arrangement.spacedBy(
          space = AppTheme.dimensions.spacing100,
          alignment = Alignment.End,
        ),
      ) {
        footerData.actionsData.forEach { actionData ->
          ButtonIcon(data = actionData.buttonData)
        }
      }
    }
  }
  footerData.sourcesData?.let { sourcesData ->
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing50))
    Column(modifier = Modifier.fillMaxWidth()) {
      val visibleSources =
        when (sourcesExpanded || sourcesData.items.size == 2) {
          true -> sourcesData.items
          false -> sourcesData.items.take(1)
        }
      visibleSources.forEachIndexed { index, source ->
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Box(
            modifier = Modifier
              .weight(weight = 1F, fill = false),
          ) {
            Button(
              data = ButtonData(
                buttonSize = ButtonSize.Small,
                buttonVariant = ButtonVariant.Primary,
                buttonType = ButtonType.WithText(
                  label = source.value.toLabel(tag = "sourceButton_$index"),
                ),
                onClick = source.onClick,
              ),
            )
          }
          if ((!sourcesExpanded && index == 0 && sourcesData.items.size > 2) ||
            (sourcesExpanded && index == sourcesData.items.size - 1)
          ) {
            Box(
              modifier = Modifier
                .padding(start = AppTheme.dimensions.spacing100),
            ) {
              Button(
                data = ButtonData(
                  buttonSize = ButtonSize.Small,
                  buttonVariant = ButtonVariant.Tertiary,
                  buttonType = ButtonType.WithText(
                    label = when (sourcesExpanded) {
                      true -> sourcesData.showLessButtonLabel
                      false -> sourcesData.showMoreButtonLabel
                    },
                  ),
                  onClick = {
                    sourcesExpanded = !sourcesExpanded
                  },
                ),
              )
            }
          }
        }
      }
    }
  }

  if (footerData.isVisible) {
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing50))
  }
}

@Composable
private fun CtaSection(actions: List<ClickableContent>) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        top = AppTheme.dimensions.spacing200,
        end = AppTheme.dimensions.spacing600,
      ),
  ) {
    actions.forEachIndexed { index, action ->
      Button(data = action.actionButtonData)
      if (index != actions.lastIndex) {
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
      }
    }
  }
}

@Preview
@Composable
fun ChatBubblePreview(
  @PreviewParameter(ChatBubblePreviewParameterProvider::class)
  data: ChatBubbleData,
) {
  Column(
    modifier = Modifier
      .wrapContentWidth()
      .background(color = AppTheme.colors.background)
      .padding(all = AppTheme.dimensions.spacing50),
  ) {
    ChatBubble(data = data)
  }
}
