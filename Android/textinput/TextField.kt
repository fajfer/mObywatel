package pl.gov.coi.common.ui.ds.textinput

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.editableText
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
import pl.gov.coi.common.ui.ds.textinput.visualtransformation.MaskVisualTransformation
import pl.gov.coi.common.ui.focus.FocusHost
import pl.gov.coi.common.ui.focus.FocusHost.Companion.focusHost
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon
import pl.gov.coi.common.ui.utils.textWithDotAndSpaceOrEmpty

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun TextField(
  data: TextInputData,
  focusHost: FocusHost,
  focusManager: FocusManager,
) {
  var isPasswordVisible by remember { mutableStateOf(false) }
  val inputInteractionSource = remember { MutableInteractionSource() }

  if (focusHost.isFocused) {
    LaunchedEffect(inputInteractionSource) {
      inputInteractionSource.interactions.collect {
        if (it is PressInteraction.Release) {
          focusHost.bringIntoView(withKeyboardAnimationDelay = true)
        }
      }
    }
  }

  Card(
    border = BorderStroke(
      width = when {
        focusHost.isFocused -> AppTheme.dimensions.spacing25
        else -> AppTheme.dimensions.strokeWidth
      },
      color = when {
        data.validationState is ValidationState.Invalid -> AppTheme.colors.supportRed100
        focusHost.isFocused -> AppTheme.colors.primary900
        !data.enabled -> AppTheme.colors.neutral30
        else -> AppTheme.colors.neutral80
      },
    ),
    backgroundColor = Color.White,
    elevation = AppTheme.elevations.level0,
  ) {
    BasicTextField(
      modifier = Modifier
        .focusHost(focusHost = focusHost)
        .semantics { testTagsAsResourceId = true }
        .semantics {
          contentDescription = data.contentDescription()
          editableText = AnnotatedString(data.value.text)
          testTag = data.testTag ?: data.label?.tag
            .let { tag -> "${tag}EditText" }
            .let { tag -> "$tag${data.indexTag?.let { "_${data.indexTag}" } ?: ""}" }
        }
        .fillMaxWidth()
        .heightIn(min = AppTheme.dimensions.spacing700),
      keyboardOptions = KeyboardOptions(
        keyboardType = data.keyboardType,
        imeAction = data.imeAction,
      ),
      keyboardActions = data.keyboardAction(focusManager),
      value = data.value.text,
      onValueChange = { value ->
        if (data is TextInputData.Masked) {
          data.maskType.run {
            if (filter(value)) data.onValueChanged(value)
          }
        } else {
          data.onValueChanged(value)
        }
      },
      interactionSource = inputInteractionSource,
      visualTransformation = when (data) {
        is TextInputData.Masked -> MaskVisualTransformation(data.maskType)
        is TextInputData.Password -> if (isPasswordVisible) {
          VisualTransformation.None
        } else {
          PasswordVisualTransformation()
        }

        else -> VisualTransformation.None
      },
      enabled = data.enabled,
      textStyle = AppTheme.typography.bodyLargeRegular.copy(
        color = if (data.enabled) {
          AppTheme.colors.neutral500
        } else {
          AppTheme.colors.neutral60
        },
        textAlign = data.textAlign ?: TextAlign.Start,
      ),
      singleLine = data.singleLine,
      cursorBrush = SolidColor(AppTheme.colors.primary900),
      decorationBox = { innerTextField ->
        Row(
          modifier = Modifier
            .padding(all = AppTheme.dimensions.spacing200)
            .fillMaxWidth(),
          verticalAlignment = if (!data.singleLine) Alignment.Top else Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Start,
        ) {
          LeftIcon(data = data)
          when (data) {
            is TextInputData.Masked ->
              Box(modifier = Modifier.weight(1F)) {
                Placeholder(data = data)
                innerTextField()
              }
            else ->
              Box(modifier = Modifier.weight(1F)) {
                Hint(data = data)
                innerTextField()
              }
          }
          RightIcon(
            data = data,
            isFocused = focusHost.isFocused,
            isPasswordVisible = isPasswordVisible,
          ) { passwordVisible ->
            isPasswordVisible = passwordVisible
          }
        }
      },
    )
  }
}

private fun TextInputData.contentDescription() =
  (
    label.textWithDotAndSpaceOrEmpty() +
      when (validationState) {
        is ValidationState.Invalid -> (validationState as ValidationState.Invalid).message.textWithDotAndSpaceOrEmpty()
        else -> helperText.textWithDotAndSpaceOrEmpty()
      }
    ).trim()

@Composable
private fun LeftIcon(data: TextInputData) {
  when (data) {
    is TextInputData.Search -> SearchIcon(
      iconTestTag = data.testTag?.let { tag -> tag + "SearchIcon" },
      enabled = data.enabled,
    )
    else -> Unit
  }
}

@Composable
private fun RightIcon(
  data: TextInputData,
  isFocused: Boolean,
  isPasswordVisible: Boolean,
  changePasswordVisibility: (Boolean) -> Unit,
) {
  val context = LocalContext.current

  val isValueNotEmpty = data.value.text.isNotEmpty()
  val isNotPasswordInputType = (data is TextInputData.Password).not()

  when {
    isValueNotEmpty && isFocused && isNotPasswordInputType && data.removableIconVisible ->
      RemoveIconButton(
        context = context,
        iconButtonTestTag = data.testTag?.let { tag -> tag + "RemoveIconButton" },
        enabled = data.enabled,
        onValueChanged = data.onValueChanged,
        indexTag = data.indexTag,
        contentDescription = with(CommonUILabelProvider.inputIconRemoveLabel()) {
          "$text ${data.label?.text.orEmpty()}".trim().toLabel(tag = tag)
        },
      )

    data is TextInputData.Password -> PasswordIconButton(
      iconButtonTestTag = data.testTag?.let { tag -> tag + "PasswordIconButton" },
      isPasswordVisible = isPasswordVisible,
      isFocused = isFocused,
      enabled = data.enabled,
      context = context,
      onClicked = {
        changePasswordVisibility(!isPasswordVisible)
        data.onPasswordVisibilityChanged(isPasswordVisible)
      },
      iconContentDescription = data.iconContentDescription,
      indexTag = data.indexTag,
    )
  }
}

@Composable
private fun Hint(data: TextInputData) {
  with(data) {
    if (value.text.isEmpty() && enabled && hint != null) {
      CustomText(
        testTag = testTag?.let { tag -> tag + "HintText" },
        label = hint,
        style = AppTheme.typography.bodyLargeRegular,
        color = AppTheme.colors.neutral100,
        focusable = false,
      )
    }
  }
}

@Composable
private fun Placeholder(data: TextInputData.Masked) {
  with(data) {
    if (value.text.isEmpty()) {
      CustomText(
        testTag = testTag?.let { tag -> tag + "PlaceholderText" },
        label = data.maskType.getPlaceholderValue().takeIf { placeholder -> placeholder.isNotBlank() } ?: data.hint,
        style = AppTheme.typography.bodyLargeRegular,
        color = AppTheme.colors.neutral100,
        focusable = false,
      )
    }
  }
}

@Composable
private fun SearchIcon(
  iconTestTag: String?,
  enabled: Boolean,
) {
  Row {
    Icon(
      data = IconData.Standard(
        testTag = iconTestTag,
        iconResId = R.drawable.ab002_search,
        iconSize = IconSize.SIZE24,
        iconColorProvider = {
          when (enabled) {
            true -> AppTheme.colors.neutral200
            else -> AppTheme.colors.neutral60
          }
        },
        contentDescription = Label.EMPTY,
      ),
    )
    Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
  }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun RemoveIconButton(
  iconButtonTestTag: String?,
  context: Context,
  enabled: Boolean,
  onValueChanged: (String) -> Unit,
  contentDescription: Label,
  indexTag: Int? = null,
) {
  Icon(
    modifier = Modifier
      .semantics { testTagsAsResourceId = true }
      .semantics {
        testTag = iconButtonTestTag ?: getResourceEntryNameIcon(R.drawable.aa018_fail, context)
          .let { tag -> "$tag${indexTag?.let { "_$indexTag" } ?: ""}" }
      }
      .clickable(
        enabled = enabled,
        role = Role.Button,
        indication = null,
        interactionSource = NoRippleInteractionSource(),
        onClick = { onValueChanged("") },
      ),
    data = IconData.Standard(
      testTag = iconButtonTestTag?.let { tag -> tag + "Icon" },
      iconResId = R.drawable.aa018_fail,
      iconSize = IconSize.SIZE24,
      iconColorProvider = {
        when (enabled) {
          true -> AppTheme.colors.neutral200
          else -> AppTheme.colors.neutral60
        }
      },
      contentDescription = contentDescription,
    ),
  )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun PasswordIconButton(
  iconButtonTestTag: String?,
  isPasswordVisible: Boolean,
  isFocused: Boolean,
  enabled: Boolean,
  context: Context,
  onClicked: () -> Unit,
  iconContentDescription: TextInputData.Password.IconContentDescription,
  indexTag: Int? = null,
) {
  val passwordVisibilityIcon = when (isPasswordVisible) {
    true -> R.drawable.aa023_hide_password
    else -> R.drawable.aa022_show_password
  }
  val contentDescription = when (isPasswordVisible) {
    true -> iconContentDescription.whenPasswordVisible
    false -> iconContentDescription.whenPasswordHidden
  }
  Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
  Icon(
    modifier = Modifier
      .semantics {
        when (isFocused) {
          true -> {
            testTagsAsResourceId = true
            testTag = iconButtonTestTag ?: getResourceEntryNameIcon(passwordVisibilityIcon, context)
              .let { tag -> "$tag${indexTag?.let { "_$$indexTag" } ?: ""}" }
          }

          else -> invisibleToUser()
        }
      }
      .clickable(
        enabled = enabled,
        role = Role.Button,
        indication = null,
        interactionSource = NoRippleInteractionSource(),
        onClick = onClicked,
      ),
    data = IconData.Standard(
      testTag = iconButtonTestTag?.let { tag -> tag + "Icon" },
      iconResId = passwordVisibilityIcon,
      iconSize = IconSize.SIZE24,
      iconColorProvider = {
        when (enabled) {
          true -> AppTheme.colors.neutral200
          else -> AppTheme.colors.neutral60
        }
      },
      contentDescription = contentDescription,
    ),
  )
}
