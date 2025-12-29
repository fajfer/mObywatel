import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct IconPageSnapshotTests {
  @MainActor @Test
  func testWithRequiredParameters() {
    assertSnapshots(
      matching:
        IconPage(
          title: "Tu pojawią sie Twoje aktualne sprawy urzedowe", 
          description: "Nie widzisz swojej sprawy? Obecnie w aplikacji możesz zobazyć tylko wybrane wnioski złożone przez internet.", 
          icon: { TestEmptyIcon() }
        )
    )
  }

  @MainActor @Test
  func testWithContent() {
    assertSnapshots(
      matching:
        IconPage(
          title: "Aktywuj skrzynkę", 
          description: "Zrobisz to na stronie mObywatel.gov.pl w zakładce Twoje skrzynki", 
          icon: { TestEmptyIcon() }, 
          content: {
            Button("Przejdz do mObywayel.gov.pl", action: {})
              .buttonStyle(.text)
          }
        )
    )
  }

  @MainActor @Test
  func testWithContentAndSubDescription() {
    assertSnapshots(
      matching:
        IconPage(
          title: "Aktywuj skrzynkę", 
          description: "Zrobisz to na stronie mObywatel.gov.pl w zakładce Twoje skrzynki", 
          subDescription: "Poniżej znajdziesz link", 
          icon: { TestEmptyIcon() }, 
          content: {
            Button("Przejdz do mObywayel.gov.pl", action: {})
              .buttonStyle(.text)
          }
        )
    )
  }
}

private struct TestEmptyIcon: View {
  @Environment(\.appTheme) private var appTheme 

  var body: some View {
    Icons.EmptyState.documentBox 
      .resizable() 
      .foregroundStyle(appTheme.colors.primary900) 
      .frame(size: 96)
      .accessibility(hidden: true)
  }
} 

