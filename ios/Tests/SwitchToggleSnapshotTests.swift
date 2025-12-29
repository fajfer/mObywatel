import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct SwitchToggleSnapshotTests {
  @MainActor @Test
  func testSwitchToggles() {
    assertSnapshots(matching: SwitchToggleTestView())
  }
}

private struct SwitchToggleTestView: View {
  @Environment(\.appTheme) private var appTheme 

  var body: some View {
    VStack(alignment: .leading, spacing: .spacing300) {
      Toggle(isOn: .constant(true)) {
        Text("Lorem ipsum dolor sit amet ebel it, consectetur adipiscing elit")
          .font(.footnote)
          .foregroundStyle(Color.neutral200)
      }

      Toggle(isOn: .constant(false)) {
        Text("Lorem ipsum dolor sit amet ebel it, consectetur adipiscing elit")
          .font(.footnote)
          .foregroundStyle(Color.neutral200)
      }

      Toggle(isOn: .constant(true)) {
        Text("Lorem ipsum dolor sit amet ebel it, consectetur adipiscing elit")
          .font(.footnote)
          .foregroundStyle(Color.neutral200)
      }
      .disabled(true)

      Toggle(isOn: .constant(false)) {
        Text("Lorem ipsum dolor sit amet ebel it, consectetur adipiscing elit")
          .font(.footnote)
          .foregroundStyle(Color.neutral200)
      }
      .disabled(true)
    }
    .primaryStyle(appTheme: appTheme)
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

