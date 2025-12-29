import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct PinInputTextFieldSnapshotTests {
  @MainActor @Test
  func testPinInputField() {
    assertSnapshots(matching: TestView())
  }
}

private struct TestView: View {
  let text: Binding<String> = .constant("123456") 
  let validationMessage: String = "Excepteur sint occaecat cupidatat non proident"

  var body: some View {
    VStack(alignment: .center, spacing: .spacing200) {
      PinInputTextField(value: .empty)

      PinInputTextField(value: text)

      PinInputTextField(value: text)
        .environment(\.isValid, false)
        .validation(validationMessage, alignment: .center)

      PinInputTextField(value: .empty, numberOfCells: 6)

      PinInputTextField(value: text, numberOfCells: 6)

      PinInputTextField(value: text, numberOfCells: 6)
        .environment(\.isValid, false)
        .validation(validationMessage, alignment: .center)

      Spacer()
    }
    .padding(.spacing200)
    .background(Color.background.ignoresSafeArea())
  } 
} 

