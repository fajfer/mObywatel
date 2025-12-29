package pl.gov.coi.common.ui.ds.button.buttonicon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.menus.Menu
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.get
import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon

@Composable
fun ButtonIcon(
  data: ButtonIconData,
) {
  val localContext = LocalContext.current
  val focusManager = LocalFocusManager.current
  val rippleInteractionSource = remember { NoRippleInteractionSource() }
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }

  val iconData = IconData.Standard(
    iconResId = data.iconResId,
    iconSize = IconSize.SIZE24,
    iconColorProvider = data.iconColorProvider,
    contentDescription = data.contentDescription,
  )

  Box(
    modifier = Modifier.wrapContentSize(),
  ) {
    Button(
      modifier = Modifier
        .size(size = AppTheme.dimensions.spacing300)
        .semantics {
          role = Role.Button
          testTag = data.testTag ?: getResourceEntryNameIcon(iconData.iconResId, localContext)
        },
      contentPadding = PaddingValues(all = AppTheme.dimensions.zero),
      interactionSource = rippleInteractionSource,
      elevation = ButtonDefaults.elevation(AppTheme.elevations.level0),
      colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
      onClick = {
        multipleEventsCutter.processEvent {
          data.onClick()
          focusManager.clearFocus(force = true)
        }
      },
    ) {
      Icon(
        data = iconData,
        focusable = false,
      )
    }
    data.menuData?.let { menuData ->
      Menu(
        data = menuData,
      )
    }
  }
}

@Preview
@Composable
fun ButtonPreview(@PreviewParameter(ButtonIconPPP::class) buttonData: ButtonIconData) {
  ButtonIcon(data = buttonData)
}
