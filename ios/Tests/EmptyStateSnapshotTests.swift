import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct EmptyStateSnapshotTests {
  @MainActor @Test
  func testEmptyState() {
    assertSnapshots(matching: EmptyStateTestView())
  }
}

private struct EmptyStateTestView: View {
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      Spacer()

      GroupBox("Title") {
        Text("Body")
      }

      Spacer()

      GroupBox("Title") {
        Text("Body")

        Button("Tertiary small button (optional)") {}
      }

      Spacer()
    }
    .groupBoxStyle(.emptyState)
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 
