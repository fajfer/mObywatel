import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct PhoneNumberInputTextFieldSnapshotTests {
  @MainActor @Test
  func testPhoneNumberInputField() {
    assertSnapshots(matching: TestView())
  }
}

private struct TestView: View {
  let countryCode: Binding<String> = .constant("+48") 
  let phoneNumber: Binding<String> = .constant("998877665") 
  let validationMessage: String = "Excepteur sint occaecat cupidatat non proident"
  @AccessibilityFocusState var accessibilityFocused: Field?
  @FocusState var focusedField: Field?

  enum Field {
    case countryCode 
    case phoneNumber 
    case focusedOne 
  }

  var body: some View {
    VStack(spacing: .spacing200) {
      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )
      .environment(\.isEnabled, false)

      PhoneNumberInputTextField(
        label: "Ut enim ad minim veniam", 
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: nil, 
            prompt: "Excepteur"
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: nil, 
            prompt: "Duis aute irure dolor"
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: countryCode, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: phoneNumber, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: countryCode, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.focusedOne, 
            text: phoneNumber, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: .empty, 
            validationMessage: validationMessage 
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: phoneNumber, 
            validationMessage: nil
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      PhoneNumberInputTextField(
        fieldsConfiguration: .init(
          countryCode: .init(
            id: Field.countryCode, 
            text: countryCode, 
            validationMessage: nil
          ), 
          localNumber: .init(
            id: Field.phoneNumber, 
            text: .empty, 
            validationMessage: validationMessage 
          )
        ), 
        accessibilityFocusState: self.$accessibilityFocused, 
        focusState: self.$focusedField 
      )

      Spacer()
    }
    .padding(.spacing200)
    .onAppear { focusedField = .focusedOne }
    .background(Color.background.ignoresSafeArea())
  }
} 

