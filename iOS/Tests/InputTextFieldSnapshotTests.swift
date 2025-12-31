import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct InputTextFieldSnapshotTests {
  @MainActor @Test
  func testInvalidTextField() {
    let text: Binding<String> = .constant("Lorem ipsum dolor sit amet")
    let validationMessage: String = "Excepteur sint occaecat cupidatat non proident"
    assertSnapshots(
      matching: TestView { _ in
        InputTextField(text: .empty)
          .environment(\.isValid, false)
          .validation(validationMessage)

        InputTextField(
          label: "Ut enim ad minim veniam",
          placeholder: "Excepteur",
          text: .empty
        )
        .environment(\.isValid, false)
        .validation(validationMessage)

        InputTextField(text: text)
          .environment(\.isValid, false)
          .validation(validationMessage)








        InputTextField(type: .secure(true), text: text)
          .environment(\.isValid, false)
          .validation(validationMessage)

        InputTextField(type: .secure(false), text: text)
          .environment(\.isValid, false)
          .validation(validationMessage)
      }
    )
  }

  @MainActor @Test
  func testValidTextField() {
    let text: Binding<String> = .constant("Lorem ipsum dolor sit amet")
    assertSnapshots(
      matching: TestView { _ in
        InputTextField(text: .empty)

        InputTextField(
          label: "Ut enim ad minim veniam",
          placeholder: "Excepteur",
          text: .empty
        )

        InputTextField(text: text)






        InputTextField(type: .secure(true), text: text)

        InputTextField(type: .secure(false), text: text)
      }
    )
  }

  @MainActor @Test
  func testDisabledTextField() {
    assertSnapshots(
      matching: TestView { _ in
        InputTextField(text: .empty)
          .environment(\.isEnabled, false)

        InputTextField(
          label: "Ut enim ad minim veniam",
          placeholder: "Excepteur",
          text: .empty
        )
        .environment(\.isEnabled, false)

        InputTextField(type: .secure(true), text: .empty)
          .environment(\.isEnabled, false)
      }
    )
  }
}

private struct TestView<Content: View>: View {
  @FocusState private var isFocused: Bool
  private let content: (FocusState<Bool>.Binding) -> Content

  init(@ViewBuilder content: @escaping (FocusState<Bool>.Binding) -> Content) {
    self.content = content
  }

  var body: some View {
    VStack(spacing: .spacing200) {
      content($isFocused)
      Spacer()
    }
    .padding(.spacing200)
    .onAppear { isFocused = true }
    .background(Color.background.ignoresSafeArea())
  }
}
