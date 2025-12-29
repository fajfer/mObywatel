import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct SnackBarSnapshotTests {
  @MainActor @Test
  func testSnackBar() {
    assertSnapshots(matching: SnackBarTestView())
  }
}

private struct SnackBarTestView: View {
  var body: some View {
    VStack(spacing: .spacing250) {
      SnackBarView(
        item: .constant(
          .init(
            title: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore.", 
            duration: nil
          )
        )
      )

      SnackBarView(
        item: .constant(
          .init(
            title: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum.", 
            duration: 5.0
          )
        )
      )
    }
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

