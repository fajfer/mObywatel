import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct DropdownButtonSnapshotTests {
  @MainActor @Test
  func testDropdownButtons() {
    assertSnapshots(matching: DropdownButtonTestView())
  }
}

private struct DropdownButtonTestView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      Button(
        action: {}, 
        label: { Text("Opcja 1") }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(nil)
      .tooltipText("Tekst pomocniczy (helper text).", isHidden: false)

      Button(
        action: {}, 
        label: {
          Text("Placeholder")
            .foregroundStyle(Color.neutral100)
        }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(nil)

      let validationMessage: String? = "Tekst błedu (error text)."
      Button(
        action: {}, 
        label: { Text("Opcja 1") }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(validationMessage)
      .tooltipText("Tekst pomocniczy (helper text).", isHidden: validationMessage != nil)

      Button(
        action: {}, 
        label: {
          Text("Placeholder")
            .foregroundStyle(Color.neutral60)
        }
      )
      .buttonStyle(.dropdown("Etykieta"))
      .validation(nil)
      .disabled(true)
    }
    .contentBox()
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 
