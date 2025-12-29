package pl.gov.coi.common.ui.ds.snackbar

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.theme.AppTheme

sealed class SnackBarData(
  open val messageLabel: Label,
  descriptionLabel: Label? = null,
  override val duration: SnackbarDuration = SnackbarDuration.Short,
) : SnackbarVisuals {
  override val actionLabel: String? = descriptionLabel?.text

  data class Default(
    override val messageLabel: Label,
    override val withDismissAction: Boolean = false,
    override val message: String = messageLabel.text,
  ) : SnackBarData(messageLabel = messageLabel)

  data class DefaultWithIcon(
    override val messageLabel: Label,
    override val withDismissAction: Boolean = true,
    override val message: String = messageLabel.text,
    val onAction: () -> Unit = {},
  ) : SnackBarData(messageLabel = messageLabel) {
    internal val iconButtonData = ButtonIconData(
      iconResId = R.drawable.ab009_x_mark,
      iconColorProvider = { AppTheme.colors.white },
      contentDescription = CommonUILabelProvider.closeLabel(),
      onClick = onAction,
    )
  }
}
