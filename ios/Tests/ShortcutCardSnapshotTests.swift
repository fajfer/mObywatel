import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct ShortcutCardSnapshotTests {
  @MainActor @Test
  func testShortcutCards() {
    assertSnapshots(matching: ShortcutCardTestView())
  }
}

private struct ShortcutCardTestView: View {
  @Environment(\.appTheme) private var appTheme 
  var body: some View {
    HStack(spacing: .spacing300) {
      ShortcutCard("Zastrzeż PESEL", image: Icons.Outline.Services.peselRestriction, foregroundColor: appTheme.colors.primary900)

      ShortcutCard("Usuń dokument", image: Icons.Outline.Symbols.delete, foregroundColor: .red100)
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

