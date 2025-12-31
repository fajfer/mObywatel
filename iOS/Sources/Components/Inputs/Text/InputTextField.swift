import A11y
import SwiftUI

public struct InputTextField: View {
  private let label: String?
  private let prompt: Text
  @State private var type: FieldType
  @Binding private var text: String
  @Environment(\.accessibilityVoiceOverEnabled) private var isVoiceOverEnabled
  @Environment(\.isEnabled) private var isEnabled
  @Environment(\.isValid) private var isValid
  @FocusState private var isFocused: Bool

  public init(
    type: FieldType = .text,
    label: String? = nil,
    placeholder: String = "",
    text: Binding<String>
  ) {
    self.type = type
    self.label = label
    self.prompt = .init(placeholder)
    _text = text
  }

  public var body: some View {
    HStack(alignment: .top) {
      VStack(alignment: .leading, spacing: .spacing50) {
        if let label {
          Text(label)
            .frame(alignment: .leading)
            .font(.footnote)
            .accessibilityIdentifier(.inputTitle)
            .accessibilityHidden(isVoiceOverEnabled)
        }

        HStack(spacing: .zero) {
          textField
            .foregroundStyle(self.isEnabled ? Color.neutral500 : Color.neutral60)
            .focused($isFocused)
            .autocapitalization(.none)
            .autocorrectionDisabled()
            .apply(if: isVoiceOverEnabled) {
              $0.accessibilityLabel(label ?? "")
            }

          rightTooltipButton
            .frame(size: Constants.iconSize)
            .padding(.leading, .spacing100)
        }
        .padding(.spacing200)
        .frame(height: Constants.textFieldHeight)
        .inputTextFieldBackground(isFocused: isFocused)
      }
      .foregroundStyle(self.isEnabled ? Color.neutral200 : Color.neutral60)
    }
  }
}

private extension InputTextField {



  @ViewBuilder
  private var textField: some View {
    switch type {
    case .secure(true):
      SecureField(
        "",
        text: $text,
        prompt: prompt
          .foregroundColor(self.isEnabled ? Color.neutral100 : Color.neutral60)
      )
      .accessibilityIdentifier(.securedTextField)

    case .secure(false), .text:
      TextField(
        "",
        text: $text,
        prompt: prompt
          .foregroundColor(self.isEnabled ? Color.neutral100 : Color.neutral60)
      )
      .accessibilityIdentifier(.textField)
    }
  }



  @ViewBuilder
  private var rightTooltipButton: some View {
    switch self.type {
    case .secure:
      securedTooltipButton

    case .text:
      clearTooltipButton
    }
  }

  @ViewBuilder
  private var clearTooltipButton: some View {
    if !text.isEmpty && isFocused {
      Button(
        action: { text.removeAll() },
        label: { Icons.Outline.Symbols.fail }
      )
      .accessibilityLabel(A11y.commonAccessibilityClearField)
    }
  }

  private var securedTooltipButton: some View {
    Button(
      action: { type.toogleSecureValue() },
      label: {
        type.isSecure
          ? Icons.Outline.Symbols.showPassword
          : Icons.Outline.Symbols.hidePassword
      }
    )
    .accessibilityIdentifier(.securedTooltipButton)
    .accessibilityLabel(
      type.isSecure
        ? A11y.commonAccessibilityShowPassword
        : A11y.commonAccessibilityHidePassword
    )
  }


}

private extension AccessibilityIdentifier {
  static let securedTextField: Self = .init("securedTextField")
  static let textField: Self = .init("textField")
  static let securedTooltipButton: Self = .init("securedTooltipButton")
  static let inputTitle: Self = .init("inputTitle")
}

private enum Constants {
  static let textFieldHeight = 56.0
  static let componentHeight = 100.0
  static let selectedLineWidth = 2.0
  static let unselectedLineWidth = 1.0
  static let iconSize = 24.0
  static let defaultAnimation = Animation.linear(duration: 0.2)
}
