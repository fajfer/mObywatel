package pl.gov.coi.common.ui.ds.custom.icon

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.custom.icon.provider.IconPreviewParameterProvider
import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon
import pl.gov.coi.common.ui.utils.semanticsContentDescription

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Icon(
  modifier: Modifier = Modifier,
  data: IconData,
  focusable: Boolean? = null,
) {
  val localContext = LocalContext.current
  Box(
    modifier = modifier
      .alpha(data.iconState.alphaValue)
      .semantics { testTagsAsResourceId = true }
      .semantics { testTag = data.testTag ?: "icon${getResourceEntryNameIcon(data.iconResId, localContext)}" }
      .semanticsContentDescription(data.contentDescription?.text, focusable),
    contentAlignment = Alignment.Center,
  ) {
    if (data is IconData.Background) {
      val backgroundColor = data.backgroundColorProvider()
      Canvas(
        modifier = Modifier
          .size(data.backgroundSize.dimension)
          .then(
            if (data.backgroundShape is BackgroundShape.RoundedSquare) {
              Modifier.clip(data.backgroundShape.shape())
            } else {
              Modifier
            },
          ),
        onDraw = {
          when (data.backgroundShape) {
            BackgroundShape.Rounded ->
              drawCircle(color = backgroundColor)

            BackgroundShape.Square,
            is BackgroundShape.RoundedSquare,
            ->
              drawRoundRect(
                color = backgroundColor,
              )
          }
        },
      )
    }

    androidx.compose.material.Icon(
      modifier = Modifier
        .size(data.iconSize.dimension),
      painter = painterResource(id = data.iconResId),
      contentDescription = null,
      tint = data.iconColorProvider(),
    )
  }
}

@Preview
@Composable
fun IconPreview(@PreviewParameter(IconPreviewParameterProvider::class) data: IconData) {
  Icon(data = data)
}
