package pl.gov.coi.common.ui.ds.button

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonState
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.defaultBorderFocus
import pl.gov.coi.common.ui.utils.get
import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon


@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun Button(data: ButtonData) {
  val focusManager = LocalFocusManager.current
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }
  val interactionSource = remember { MutableInteractionSource() }
  val isFocused = interactionSource.collectIsFocusedAsState()

  val contentColor = getContentColor(
    buttonState = data.buttonState,
    buttonSize = data.buttonSize,
    buttonVariant = data.buttonVariant,
  )

  LayoutWithoutMinimumInteractiveComponentPadding {
    Button(
      modifier = getButtonTypeModifier(data)
        .defaultBorderFocus(
          isFocused = isFocused,
          shape = getButtonShape(
            buttonType = data.buttonType,
            buttonSize = data.buttonSize,
          ),
        ),
      shape = getButtonShape(
        buttonType = data.buttonType,
        buttonSize = data.buttonSize,
      ),
      interactionSource = interactionSource,
      contentPadding = getPaddingValues(data),
      colors = getButtonColors(data),
      onClick = {
        multipleEventsCutter.processEvent {
          data.onClick()
          focusManager.clearFocus(force = true)
        }
      },
      border = getBorderStroke(data),
      enabled = data.buttonState == ButtonState.Enabled || data.buttonState == ButtonState.Destructive,
      elevation = ButtonDefaults.buttonElevation(
        AppTheme.elevations.level0,
        AppTheme.elevations.level0,
        AppTheme.elevations.level0,
        AppTheme.elevations.level0,
        AppTheme.elevations.level0,
      ),
    ) {
      when (data.buttonType) {
        is ButtonType.WithIcon -> ButtonIcon(
          testTag = data.testTag,
          buttonType = data.buttonType,
          color = contentColor,
        )

        is ButtonType.WithText -> ButtonText(
          testTag = data.testTag,
          buttonSize = data.buttonSize,
          buttonType = data.buttonType,
          color = contentColor,
        )
      }
    }
  }
}

@Composable
private fun getButtonColors(data: ButtonData) =
  ButtonDefaults.buttonColors(
    containerColor = getContainerColor(
      buttonState = data.buttonState,
      buttonSize = data.buttonSize,
      buttonVariant = data.buttonVariant,
    ),
    contentColor = getContentColor(
      buttonState = data.buttonState,
      buttonSize = data.buttonSize,
      buttonVariant = data.buttonVariant,
    ),
    disabledContainerColor = getContainerColor(
      buttonState = data.buttonState,
      buttonSize = data.buttonSize,
      buttonVariant = data.buttonVariant,
    ),
    disabledContentColor = getContentColor(
      buttonState = data.buttonState,
      buttonSize = data.buttonSize,
      buttonVariant = data.buttonVariant,
    ),
  )

@Composable
private fun ButtonIcon(
  testTag: String?,
  buttonType: ButtonType.WithIcon,
  color: Color,
) {
  val iconData = IconData.Standard(
    testTag = testTag?.let { tag -> tag + "Icon" },
    iconResId = buttonType.iconResId,
    iconSize = IconSize.SIZE24,
    iconColorProvider = { color },
    contentDescription = buttonType.contentDescription,
  )
  Icon(data = iconData)
}

@Composable
private fun ButtonText(
  testTag: String?,
  buttonSize: ButtonSize,
  buttonType: ButtonType.WithText,
  color: Color,
) {
  CustomText(
    testTag = testTag?.let { tag -> tag + "Text" },
    modifier = Modifier.clearAndSetSemantics {},
    label = buttonType.label,
    color = color,
    textAlign = TextAlign.Center,
    style = when (buttonSize) {
      is ButtonSize.Large -> AppTheme.typography.bodyLargeMedium
      ButtonSize.Small -> AppTheme.typography.bodyMediumMedium
    },
  )
}

@Composable
private fun getButtonTypeModifier(data: ButtonData) = when (data.buttonType) {
  is ButtonType.WithIcon -> getButtonWithIconModifier(buttonType = data.buttonType, buttonSize = data.buttonSize)
  is ButtonType.WithText -> getButtonWithTextModifier(buttonType = data.buttonType, buttonSize = data.buttonSize)
}

@Composable
private fun getPaddingValues(data: ButtonData) = when (data.buttonType) {
  is ButtonType.WithIcon -> PaddingValues(all = AppTheme.dimensions.zero)
  is ButtonType.WithText -> when (data.buttonSize) {
    is ButtonSize.Large -> PaddingValues(
      vertical = AppTheme.dimensions.spacing100,
      horizontal = AppTheme.dimensions.spacing200,
    )
    ButtonSize.Small -> PaddingValues(
      vertical = AppTheme.dimensions.spacing50,
      horizontal = AppTheme.dimensions.spacing200,
    )
  }
}

@Composable
private fun getBorderStroke(data: ButtonData) = when (data.buttonVariant) {
  is ButtonVariant.Secondary -> BorderStroke(
    width = AppTheme.dimensions.strokeWidth,
    color = when (data.buttonState) {
      ButtonState.Enabled -> getSecondaryEnabledButtonColor(data.buttonVariant)
      ButtonState.Destructive -> AppTheme.colors.supportRed100
      ButtonState.Disabled -> AppTheme.colors.neutral30
    },
  )
  else -> null
}

@Composable
private fun getContainerColor(
  buttonSize: ButtonSize,
  buttonVariant: ButtonVariant,
  buttonState: ButtonState,
): Color = when (buttonSize) {
  is ButtonSize.Large -> when (buttonVariant) {
    ButtonVariant.Primary -> when (buttonState) {
      ButtonState.Enabled -> AppTheme.colors.primary900
      ButtonState.Destructive -> AppTheme.colors.supportRed100
      ButtonState.Disabled -> AppTheme.colors.neutral30
    }
    is ButtonVariant.Secondary -> Color.Transparent
    ButtonVariant.Tertiary -> Color.Transparent
  }
  ButtonSize.Small -> when (buttonVariant) {
    ButtonVariant.Primary -> when (buttonState) {
      ButtonState.Enabled -> AppTheme.colors.secondary900
      ButtonState.Destructive -> AppTheme.colors.supportRed20
      ButtonState.Disabled -> AppTheme.colors.neutral30
    }
    is ButtonVariant.Secondary -> Color.Transparent
    ButtonVariant.Tertiary -> Color.Transparent
  }
}

@Composable
private fun getContentColor(
  buttonSize: ButtonSize,
  buttonVariant: ButtonVariant,
  buttonState: ButtonState,
): Color = when (buttonSize) {
  is ButtonSize.Large -> when (buttonVariant) {
    ButtonVariant.Primary -> when (buttonState) {
      ButtonState.Enabled -> AppTheme.colors.white
      ButtonState.Destructive -> AppTheme.colors.white
      ButtonState.Disabled -> AppTheme.colors.neutral60
    }
    is ButtonVariant.Secondary -> when (buttonState) {
      ButtonState.Enabled -> getSecondaryEnabledButtonColor(buttonVariant)
      ButtonState.Destructive -> getSecondaryDestructiveButtonColor(buttonVariant)
      ButtonState.Disabled -> AppTheme.colors.neutral60
    }
    ButtonVariant.Tertiary -> when (buttonState) {
      ButtonState.Enabled -> AppTheme.colors.primary900
      ButtonState.Destructive -> AppTheme.colors.supportRed100
      ButtonState.Disabled -> AppTheme.colors.neutral60
    }
  }
  ButtonSize.Small -> when (buttonVariant) {
    is ButtonVariant.Secondary -> when (buttonState) {
      ButtonState.Enabled -> getSecondaryEnabledButtonColor(buttonVariant)
      ButtonState.Destructive -> getSecondaryDestructiveButtonColor(buttonVariant)
      ButtonState.Disabled -> AppTheme.colors.neutral60
    }
    else -> when (buttonState) {
      ButtonState.Enabled -> AppTheme.colors.primary900
      ButtonState.Destructive -> AppTheme.colors.supportRed100
      ButtonState.Disabled -> AppTheme.colors.neutral60
    }
  }
}

@Composable
private fun getSecondaryDestructiveButtonColor(buttonVariant: ButtonVariant.Secondary) =
  if (buttonVariant.reversedColor) {
    AppTheme.colors.white
  } else {
    AppTheme.colors.supportRed100
  }

@Composable
private fun getSecondaryEnabledButtonColor(buttonVariant: ButtonVariant.Secondary) =
  if (buttonVariant.reversedColor) {
    AppTheme.colors.white
  } else {
    AppTheme.colors.primary900
  }

@Composable
private fun getButtonWithIconSize(buttonSize: ButtonSize) = when (buttonSize) {
  is ButtonSize.Large -> AppTheme.dimensions.spacing600
  ButtonSize.Small -> AppTheme.dimensions.spacing400
}

@Composable
private fun getButtonShape(buttonType: ButtonType, buttonSize: ButtonSize) = when (buttonType) {
  is ButtonType.WithIcon -> CircleShape
  is ButtonType.WithText -> when (buttonSize) {
    is ButtonSize.Large -> AppTheme.shapes.radius300
    ButtonSize.Small -> AppTheme.shapes.radius200
  }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun getButtonWithTextModifier(buttonType: ButtonType.WithText, buttonSize: ButtonSize) = when (buttonSize) {
  is ButtonSize.Large ->
    Modifier
      .heightIn(min = AppTheme.dimensions.spacing600)
      .semantics {
        testTagsAsResourceId = true
        testTag = buttonType.testTag ?: buttonType.label.tag
        contentDescription = buttonType.contentDescription.takeIf { it.isNotEmpty() }?.text ?: buttonType.label.text
      }
      .then(
        if (buttonSize.fillMaxWidth) {
          Modifier.fillMaxWidth()
        } else {
          Modifier
        },
      )

  ButtonSize.Small ->
    Modifier
      .heightIn(min = AppTheme.dimensions.spacing400)
      .semantics {
        testTagsAsResourceId = true
        testTag = buttonType.testTag ?: buttonType.label.tag
        contentDescription = buttonType.contentDescription.takeIf { it.isNotEmpty() }?.text ?: buttonType.label.text
      }
}

@Composable
private fun getButtonWithIconModifier(buttonType: ButtonType.WithIcon, buttonSize: ButtonSize): Modifier {
  val localContext = LocalContext.current
  return Modifier
    .size(size = getButtonWithIconSize(buttonSize))
    .semantics {
      testTag = buttonType.testTag ?: getResourceEntryNameIcon(buttonType.iconResId, localContext)
      contentDescription = buttonType.contentDescription.text
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LayoutWithoutMinimumInteractiveComponentPadding(content: @Composable () -> Unit) {
  CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
    content()
  }
}

@Preview
@Composable
fun ButtonPreview(@PreviewParameter(ButtonPPP::class) buttonData: ButtonData) {
  Button(data = buttonData)
}
