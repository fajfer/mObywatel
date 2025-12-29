import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct IllustrationPageSnapshotTests {
  @MainActor @Test
  func testWithRequiredParameters() {
    let view = GeometryReader { geometry in
      IllustrationPage(
        title: "Załatwiaj wygodnie sprawy urzędowe", 
        illustration: {
          TestIllustration()
            .frame(height: geometry.size.height * 0.3)
        }
      )
    }

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithDescription() {
    let view = GeometryReader { geometry in
      IllustrationPage(
        title: "Załatwiaj wygodnie sprawy urzędowe", 
        description: "Wystarczy, że zeskanujesz kod QR ze strony e‑Urzędu Skarbowego lub mObywatela w przeglądarce. Nie potrzebujesz loginu i hasła.", 
        illustration: {
          TestIllustration()
            .frame(height: geometry.size.height * 0.3)
        }
      )
    }

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithContentAndDescription() {
    let view = GeometryReader { geometry in
      IllustrationPage(
        title: "Załatwiaj wygodnie sprawy urzędowe", 
        description: "Wystarczy, że zeskanujesz kod QR ze strony e‑Urzędu Skarbowego lub mObywatela w przeglądarce. Nie potrzebujesz loginu i hasła.", 
        illustration: {
          TestIllustration()
            .frame(height: geometry.size.height * 0.3)
        }, 
        content: {
          Button("Przejdz do najczęściej zadawanych pytań", action: {})
            .buttonStyle(.text)
        }
      )
    }

    assertSnapshots(matching: view)
  }
}

private struct TestIllustration: View {
  var body: some View {
    Image("illustration_page", bundle: .module)
      .resizable() 
      .scaledToFit() 
  }
} 

