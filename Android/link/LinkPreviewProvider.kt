package pl.gov.coi.common.ui.ds.link

import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class LinkPreviewProvider : CustomPreviewParameterProvider<LinkData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<LinkData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "LinkEnabled",
      value = LinkData(
        label = "Link".toLabel(),
        linkType = LinkData.LinkType.WEBSITE,
        url = "",
        onClick = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "LinkDisabled",
      value = LinkData(
        label = "Link".toLabel(),
        linkType = LinkData.LinkType.WEBSITE,
        url = "",
        enabled = false,
        onClick = {},
      ),
    ),
  )
}
