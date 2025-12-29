import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct SectionHeaderSnapshotTests {
  @MainActor @Test
  func testSectionHeader() {
    assertSnapshots(matching: SectionHeaderTestView())
  }
}

private struct SectionHeaderTestView: View {
  var body: some View {
    GroupBox("Section Header") {
      VStack(alignment: .leading, spacing: .spacing200) {
        Label(title: "Przeczytaj i zaakceptuj regulamin oraz politykę prywatności.")

        Label(title: "Ustaw hasło.")

        Label(title: "Jeśli chcesz, włącz logowanie biometryczne. Ustaw PIN i biometrię.")

        Label(title: "Dodaj pierwszy dokument.")
      }
      .labelStyle(.bullet)
      .contentBox()
    }
    .groupBoxStyle(.sectionHeader)
    .frame(maxHeight: .infinity)
    .padding()
    .background(Color.background.ignoresSafeArea())
  } 
} 

