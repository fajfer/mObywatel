package pl.gov.coi.common.ui.ds.custom.singlecard.labelbuttonimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.unmapped.singlecard.CustomContent
import pl.gov.coi.common.ui.unmapped.singlecard.CustomSingleCardData
import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
import pl.gov.coi.common.ui.unmapped.singlecard.SingleCard

class LabelButtonImageSingleCard(val data: LabelButtonImageSingleCardData) : CustomContent {
  @Composable
  override fun Content() {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.fillMaxWidth(),
    ) {
      Column {
        data.label?.let { label ->
          CustomText(
            label = label,
            style = AppTheme.typography.bodyMediumRegular,
            color = AppTheme.colors.neutral200,
          )
          Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
        }
        Image(
          contentScale = ContentScale.FillBounds,
          modifier = Modifier.size(100.dp),
          bitmap = data.qrCodeImage.bitmap.asImageBitmap(),
          contentDescription = data.qrCodeImage.contentDescription?.text,
        )
      }
      Button(data = data.buttonData)
    }
  }
}

@Composable
@Preview
fun QrCodeCustomSingleCardPreview() {
  SingleCard(
    singleCardData = CustomSingleCardData(
      oldTestTag = "qrCodeCard".toLabel(tag = "qrCodeCard"),
      customContent =
      LabelButtonImageSingleCard(
        data = LabelButtonImageSingleCardData(
          label = "Kod QR".toLabel(tag = "qrCodeButton"),
          buttonData = ButtonData(
            buttonSize = ButtonSize.Small,
            buttonType = ButtonType.WithText(
              label = "Powiększ kod QR".toLabel(tag = "zoomInQrCodeButton"),
            ),
            buttonVariant = ButtonVariant.Primary,
            onClick = {},
          ),
          qrCodeImage = MediaSection.Image(
            bitmap = provideBitmap(value = qrCodeValue),
          ),
        ),
      ),
    ),
  )
}

private fun provideBitmap(value: String): Bitmap {
  val picture = Base64.decode(value, Base64.NO_WRAP)
  return BitmapFactory
    .decodeByteArray(picture, 0, picture.size)
}

private val qrCodeValue =
  "iVBORw0KGgoAAAANSUhEUgAAAH0AAAB9AQAAAACn+1GIAAAApklEQVR4Xu2UMQ4EMQgD/QP+/0vK6zjsvayUMm" +
    "avWxQpMAUBkwS12wcveAAkgNSCD3rR5Lkgoai3GUCMgWqbAEYR3HxAkZlzU/0MyBisYRs" +
    "gI1ERFfcpBpA+ze6k56Cj7KTdXNigFWZvSOpsgqLfd" +
    "18i2aAukXh9TXBNmdWt5gzA/oqzWkkN8HtA7G8CNOwYAiZt3wZixUfkA32OHNQq7Bxs9oI/gC/9fV8AVCkPjQAAAABJRU5ErkJggg=="
