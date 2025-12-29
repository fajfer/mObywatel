package pl.gov.coi.common.ui.ds.filepicker.model

import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.unmapped.singlecard.BodySection
import pl.gov.coi.common.ui.unmapped.singlecard.BodyTitleSection
import pl.gov.coi.common.ui.unmapped.singlecard.DefaultSingleCardData
import pl.gov.coi.common.ui.unmapped.singlecard.LeadingSection
import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection
import pl.gov.coi.common.ui.unmapped.singlecard.MediaSection.RoundedSquareIcon
import pl.gov.coi.common.ui.unmapped.singlecard.TrailingSection
import pl.gov.coi.common.ui.unmapped.singlecard.toSingleCardLabel

sealed class PickerFile(
  open val title: Label,
  open val description: Label,
  open val onDeleteClick: () -> Unit,
) {
  internal abstract val cardData: DefaultSingleCardData

  val leadingButtonData by lazy {
    ButtonIconData(
      iconResId = R.drawable.aa002_delete,
      iconColorProvider = { AppTheme.colors.supportRed100 },
      contentDescription = CommonUILabelProvider.commonAccessibilityDeleteFile(),
      onClick = onDeleteClick,
    )
  }

  data class Image(
    override val title: Label,
    override val description: Label,
    override val onDeleteClick: () -> Unit,
    val onImageClick: (() -> Unit)? = null,
    val leadingImageData: LeadingImageData,
  ) : PickerFile(
    title = title,
    description = description,
    onDeleteClick = onDeleteClick,
  ) {

    sealed class LeadingImageData {
      data class Image(
        val bitmap: Bitmap,
      ) : LeadingImageData()

      data class Icon(
        @DrawableRes val iconResId: Int,
        val backgroundColor: @Composable () -> Color,
      ) : LeadingImageData() {

        companion object {
          val PLACEHOLDER = Icon(
            iconResId = R.drawable.ae006_document,
            backgroundColor = { AppTheme.colors.background },
          )
        }
      }
    }

    override val cardData = DefaultSingleCardData(
      leadingSection = LeadingSection(
        mediaSection = when (leadingImageData) {
          is LeadingImageData.Image -> MediaSection.Image(
            bitmap = leadingImageData.bitmap,
            onClick = onImageClick,
            contentDescription = onImageClick?.let { CommonUILabelProvider.commonAccessibilityPhotoPreview() },
          )

          is LeadingImageData.Icon -> RoundedSquareIcon(
            iconResId = leadingImageData.iconResId,
            contentDescription = onImageClick?.let { CommonUILabelProvider.commonAccessibilityFilePreview() },
            onClick = onImageClick,
            backgroundColor = leadingImageData.backgroundColor,
          )
        },
      ),
      bodySection = BodySection(
        title = BodyTitleSection.Title(
          singleCardLabel = title.toSingleCardLabel(),
        ),
        description = description.toSingleCardLabel(),
      ),
      trailingSection = TrailingSection.IconButton(
        data = leadingButtonData,
      ),
    )
  }

  data class Regular(
    override val title: Label,
    override val description: Label,
    override val onDeleteClick: () -> Unit,
  ) : PickerFile(
    title = title,
    description = description,
    onDeleteClick = onDeleteClick,
  ) {

    override val cardData = DefaultSingleCardData(
      leadingSection = LeadingSection(
        mediaSection = RoundedSquareIcon(
          iconSize = IconSize.SIZE32,
          backgroundSize = IconSize.SIZE48,
          iconResId = R.drawable.ae006_document,
          backgroundColor = { AppTheme.colors.background },
          iconColor = { AppTheme.colors.neutral200 },
        ),
      ),
      bodySection = BodySection(
        title = BodyTitleSection.Title(
          singleCardLabel = title.toSingleCardLabel(),
        ),
        description = description.toSingleCardLabel(),
      ),
      trailingSection = TrailingSection.IconButton(
        data = leadingButtonData,
      ),
    )
  }
}
