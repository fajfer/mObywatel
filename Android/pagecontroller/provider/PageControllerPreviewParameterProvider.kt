package pl.gov.coi.common.ui.ds.pagecontroller.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.pagecontroller.PageControllerData
import pl.gov.coi.common.ui.ds.smallcard.SmallCardData
import pl.gov.coi.common.ui.onboarding.model.OnboardingPageData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class PageControllerPreviewParameterProvider :
  CustomPreviewParameterProvider<PageControllerData<*>>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<PageControllerData<*>>> =
    sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "PageControllerSmallCardData",
        value = providePageControllerSmallCardData(),
      ),
      ScreenShotTestData(
        screenShotTestName = "PageControllerOnboardingPageData",
        value = providePageControllerOnboardingPageData(),
      ),
      ScreenShotTestData(
        screenShotTestName = "PageControllerSmallCardDataNoButton",
        value = providePageControllerSmallCardDataNoButton(),
      ),
      ScreenShotTestData(
        screenShotTestName = "PageControllerOnboardingPageDataNoButton",
        value = providePageControllerOnboardingPageDataNoButton(),
      ),
    )

  private fun providePageControllerOnboardingPageDataNoButton() =
    PageControllerData(
      contentsData = listOf(
        PageControllerData.PageData(
          OnboardingPageData.Regular(
            title = "Dokumenty zawsze pod ręką".toLabel(),
            message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
              " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
            imageResId = R.drawable.coi_common_ui_ic_document_diia,
          ),
          isButtonVisible = false,
          buttonTitle = "Dalej".toLabel(),
        ),
        PageControllerData.PageData(
          OnboardingPageData.Regular(
            title = "Dokumenty zawsze pod ręką".toLabel(),
            message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
              " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
            imageResId = R.drawable.coi_common_ui_ic_document_doctor,
          ),
          isButtonVisible = false,
          buttonTitle = "Dalej".toLabel(),
        ),
      ),
    )

  private fun providePageControllerSmallCardDataNoButton() =
    PageControllerData(
      contentsData = listOf(
        PageControllerData.PageData(
          SmallCardData(
            title = "Naruszenie środowiskowe".toLabel(),
            iconResId = R.drawable.da002_naruszenie_srodowiskowe,
            iconColorProvider = { AppTheme.colors.serviceLeafy100 },
            onClick = {},
          ),
          isButtonVisible = false,
          buttonTitle = "Dalej".toLabel(),
        ),

        PageControllerData.PageData(
          SmallCardData(
            title = "PWZ Pielęgniarka".toLabel(),
            iconResId = R.drawable.db017_pwz_pielegniarka,
            iconColorProvider = { AppTheme.colors.documentOcean400 },
            onClick = {},
          ),
          isButtonVisible = false,
          buttonTitle = "Dalej".toLabel(),
        ),
      ),
    )

  private fun providePageControllerSmallCardData() = PageControllerData(
    contentsData = listOf(
      PageControllerData.PageData(
        SmallCardData(
          title = "Naruszenie środowiskowe".toLabel(),
          iconResId = R.drawable.da002_naruszenie_srodowiskowe,
          iconColorProvider = { AppTheme.colors.serviceLeafy100 },
          onClick = {},
        ),
        isButtonVisible = true,
        buttonTitle = "Rozpocznij".toLabel(),
      ),

      PageControllerData.PageData(
        SmallCardData(
          title = "PWZ Pielęgniarka".toLabel(),
          iconResId = R.drawable.db017_pwz_pielegniarka,
          iconColorProvider = { AppTheme.colors.documentOcean400 },
          onClick = {},
        ),
        isButtonVisible = false,
        buttonTitle = "Dalej".toLabel(),
      ),

      PageControllerData.PageData(
        SmallCardData(
          title = "Legitymacja szkolna".toLabel(),
          iconResId = R.drawable.db008_legitymacja_szkolna,
          iconColorProvider = { AppTheme.colors.documentPink200 },
          onClick = {},
        ),
        isButtonVisible = true,
        buttonTitle = "Zakończ".toLabel(),
      ),
    ),
  )

  private fun providePageControllerOnboardingPageData() = PageControllerData(
    contentsData = listOf(
      PageControllerData.PageData(
        OnboardingPageData.Regular(
          title = "Dokumenty zawsze pod ręką".toLabel(),
          message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
            " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
          imageResId = R.drawable.coi_common_ui_ic_document_diia,
        ),
        isButtonVisible = true,
        buttonTitle = "Rozpocznij".toLabel(),
      ),
      PageControllerData.PageData(
        OnboardingPageData.Regular(
          title = "Dokumenty zawsze pod ręką".toLabel(),
          message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
            " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
          imageResId = R.drawable.coi_common_ui_ic_document_doctor,
        ),
        isButtonVisible = false,
        buttonTitle = "Dalej".toLabel(),
      ),
      PageControllerData.PageData(
        OnboardingPageData.Regular(
          title = "Dokumenty zawsze pod ręką".toLabel(),
          message = "Potwierdzaj tożsamość telefonem, na przykład w przychodni, pociągu, na poczcie.".toLabel() +
            " Nie musisz pamiętać, aby nosić ze sobą dokumenty.".toLabel(),
          imageResId = R.drawable.coi_common_ui_ic_document_id,
        ),
        isButtonVisible = true,
        buttonTitle = "Zakończ".toLabel(),
      ),
    ),
  )
}
