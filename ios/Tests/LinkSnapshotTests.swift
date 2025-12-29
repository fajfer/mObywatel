import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct LinkSnapshotTests {
  @MainActor @Test
  func testEnabled() {
    assertSnapshots(matching: LinkTestView(isEnabled: true))
  }

  @MainActor @Test
  func testDisabled() {
    assertSnapshots(matching: LinkTestView(isEnabled: false))
  }
}

private struct LinkTestView: View {
  let isEnabled: Bool

  var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      Link(
        destination: URL(string: "https://www.apple.com")!, 
        label: { Text("Link") }
      )

      Link(
        destination: URL(string: "https://www.apple.com")!, 
        label: { Text("Przejdź na stronę internetową i zmień adres zameldowania") }
      )
    }
    .disabled(!isEnabled)
    .buttonStyle(.linkStyle)
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

