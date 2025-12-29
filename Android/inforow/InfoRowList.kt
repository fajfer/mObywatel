package pl.gov.coi.common.ui.ds.inforow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowData
import pl.gov.coi.common.ui.ds.inforow.model.InfoRowListData
import pl.gov.coi.common.ui.ds.inforow.provider.InfoRowPPP
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun InfoRowList(
  data: InfoRowListData,
  spaceBetween: Dp = AppTheme.dimensions.spacing200,
) {
  Column(
    modifier = Modifier
      .wrapContentHeight(),
  ) {
    data.items.forEachIndexed { index, stepData ->
      when (stepData) {
        is InfoRowData.Default -> DefaultInfoRow(data = stepData)
        is InfoRowData.Bullet -> BulletInfoRow(data = stepData)
      }
      if (index != data.items.lastIndex) {
        Spacer(
          modifier = Modifier.height(
            height = spaceBetween,
          ),
        )
      }
    }
  }
}

@Composable
@Preview
fun InfoRowListPreview(@PreviewParameter(InfoRowPPP::class) data: InfoRowListData) {
  Box(
    modifier = Modifier
      .background(AppTheme.colors.background)
      .padding(horizontal = AppTheme.dimensions.spacing200),
  ) {
    InfoRowList(data)
  }
}
