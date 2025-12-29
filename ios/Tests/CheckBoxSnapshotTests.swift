import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct CheckBoxSnapshotTests {
  @MainActor @Test
  func testCheckBoxes() {
    assertSnapshots(matching: CheckBoxTestView())
  }
}

private struct CheckBoxTestView: View {
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      VStack(alignment: .leading, spacing: .spacing200) {
        Toggle("Etykieta", isOn: .constant(false))

        Toggle("Etykieta", isOn: .constant(true))
      }
      .contentBox()

      VStack(alignment: .leading, spacing: .spacing200) {
        Toggle("Etykieta", isOn: .constant(false))

        Toggle("Etykieta", isOn: .constant(true))
      }
      .disabled(true)
      .contentBox()

      VStack(spacing: .zero) {
        VStack(alignment: .leading, spacing: .spacing200) {
          Toggle("Etykieta", isOn: .constant(false))

          Toggle("Etykieta", isOn: .constant(true))
        }
        .validation("Tekst błędu (error text)", padding: .spacing200)
      }
      .contentBox()
    }
    .toggleStyle(.checkBox())
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 