package pl.gov.coi.common.ui.ds.pagecontroller

import pl.gov.coi.common.domain.label.Label

data class PageControllerData<CONTENT_DATA>(
  val contentsData: List<PageData<CONTENT_DATA>>,
) {

  data class PageData<CONTENT_DATA>(
    val content: CONTENT_DATA,
    val isButtonVisible: Boolean,
    val buttonTitle: Label,
    val buttonAction: ButtonAction = ButtonAction.GoToNextPage,
  ) {
    sealed interface ButtonAction {
      data object GoToNextPage : ButtonAction
      fun interface Custom : ButtonAction {
        operator fun invoke()
      }
    }
  }
}
