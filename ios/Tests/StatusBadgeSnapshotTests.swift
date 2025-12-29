import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct StatusBadgeSnapshotTests {
  @MainActor @Test
  func testStatusBadge() {
    assertSnapshots(matching: TestView())
  }
}

private struct TestView: View {
  let title = "Lorem ipsum" 

  var body: some View {
    VStack(alignment: .leading) {
      VStack {
        Label(title: title)
          .labelStyle(.status(.informativeIcon))

        Label(title: title)
          .labelStyle(.status(.positiveIcon))

        Label(title: title)
          .labelStyle(.status(.negativeIcon))

        Label(title: title)
          .labelStyle(.status(.noticeIcon))

        Label(title: title)
          .labelStyle(.status(.minusIcon))
      }
      .contentBox()

      VStack(alignment: .leading) {
        Label(title: title)
          .labelStyle(.status(.informativeDot))

        Label(title: title)
          .labelStyle(.status(.positiveDot))

        Label(title: title)
          .labelStyle(.status(.negativeDot))

        Label(title: title)
          .labelStyle(.status(.warningDot))
      }
      .contentBox()

      VStack(alignment: .leading) {
        Label(title: title)
          .labelStyle(.status(.borderedInformativeIcon))

        Label(title: title)
          .labelStyle(.status(.borderedPositiveIcon))

        Label(title: title)
          .labelStyle(.status(.borderedNegativeIcon))

        Label(title: title)
          .labelStyle(.status(.borderedNoticeIcon))

        Label(title: title)
          .labelStyle(.status(.borderedMinusIcon))
      }
      .contentBox()

      Spacer()
    }
    .padding(.spacing200)
    .background(Color.background.ignoresSafeArea())
  } 
} 

