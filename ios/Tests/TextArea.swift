import SwiftUI

public struct TextArea: View {
  public enum Mode {
    case fixed(height: CGFloat = 128.0)
    case flexible(minimumHeight: CGFloat = 48.0, maximumHeight: CGFloat = 128.0)

    var isFlexible: Bool {
      guard case .flexible = self
      else { return false }
      return true
    }

    var minimumHeight: CGFloat {
      switch self {
      case .fixed(let height):
        return height 

      case .flexible(let minimumHeight, _):
        return minimumHeight 
      }
    }

    var maximumHeight: CGFloat {
      switch self {
      case .fixed(let height):
        return height 

      case .flexible(_, let maximumHeight):
        return maximumHeight 
      }
    }
  }

  private let placeholder: String
  private let label: String?
  private let maxTextLength: Int?
  private let mode: Mode 
  @Binding var text: String
  @Environment(\.accessibilityVoiceOverEnabled) private var isVoiceOverEnabled 
  @Environment(\.isValid) private var isValid 
  @Environment(\.isEnabled) private var isEnabled 
  @Environment(\.appTheme) private var appTheme 
  @FocusState private var isFocused: Bool

  public init(
    _ placeholder: String, 
    text: Binding<String>, 
    label: String? = nil, 
    maxTextLength: Int? = nil, 
    mode: Mode = .fixed(height: 128.0)
  ) {
    _text = text 
    self.placeholder = placeholder 
    self.label = label 
    self.maxTextLength = maxTextLength 
    self.mode = mode 
  }

  public var body: some View {
    VStack(alignment: .leading, spacing: .spacing50) {
      if let label {
        Text(label)
          .font(.footnote)
          .foregroundColor(isEnabled ? .neutral200 : .neutral60)
          .accessibilityIdentifier(.label)
          .accessibilityHidden(isVoiceOverEnabled)
      }

      ZStack(alignment: .top) {
        VStack(spacing: .zero) {
          TextEditor(text: $text)
            .focused($isFocused)
            .foregroundColor(isEnabled ? .neutral500 : .neutral60)
            .padding([.top, .horizontal], .spacing200)
            .padding(.bottom, maxTextLength == nil ? .spacing200 : .zero)
            .accessibilityIdentifier(.textEditor)
            .apply(if: isVoiceOverEnabled) {
              $0
                .accessibilityLabel(label ?? "")
                .accessibilityValue(text.isEmpty ? placeholder : text)
                .accessibilityAction { isFocused = true }
                .accessibility(removeTraits: .isButton)
            }

          if let maxTextLength {
            HStack {
              Spacer()

              Group {
                Text("\(text.count)")
                  .font(counterTextFont)
                  .foregroundColor(counterTextColor)
                + Text(Constants.charactersCounterSeparator)
                + Text("\(maxTextLength)")
              }
              .font(.caption)
              .foregroundStyle(isEnabled ? Color.neutral200 : Color.neutral60)
              .frame(height: .spacing200)
              .padding([.vertical, .trailing], .spacing100)
              .accessibilityIdentifier(.charactersCounter)
            }
          }
        }

        if text.isEmpty {
          HStack(spacing: .zero) {
            Text(placeholder)
              .foregroundStyle(isEnabled ? Color.neutral100 : Color.neutral60)
              .padding(.vertical, Constants.verticalPlaceholderPadding)
              .padding(.horizontal, Constants.horizontalPlaceholderPadding)

            Spacer()
          }
          .allowsHitTesting(false)
          .accessibilityHidden(true)
        }
      }
      .frame(minHeight: mode.minimumHeight, maxHeight: mode.maximumHeight)
      .background(backgroundView)
      .fixedSize(horizontal: false, vertical: mode.isFlexible)
    }
    .accessibilityRespondsToUserInteraction()
    .accessibilityIdentifierGroup(.textArea)
  }
} 

private extension TextArea {
  var counterTextFont: Font {
    text.count <= maxTextLength ?? 0
      ? .caption
      : .caption.weight(.semibold)
  }

  var counterTextColor: Color {
    guard isEnabled else { return .neutral60 }
    return text.count <= maxTextLength ?? 0
      ? .neutral200
      : .red100
  }
}

private extension TextArea {
  @ViewBuilder
  var backgroundView: some View {
    ZStack {
      RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
        .fill(Color.white)

      RoundedRectangle(cornerRadius: appTheme.cornerRadius.border)
        .stroke(borderColor, lineWidth: borderWidth)
    }
  }

  var borderWidth: CGFloat {
    isFocused ? Constants.selectedBorderWidth : Constants.unselectedBorderWidth
  }

  var borderColor: Color {
    guard isValid else { return .red100 }
    guard isEnabled else { return .neutral30 }
    guard isFocused else { return .neutral80 }
    guard let maxTextLength else { return appTheme.colors.primary900 }
    return text.count <= maxTextLength 
      ? appTheme.colors.primary900
      : .red100
  }
}



private enum Constants {
  static let selectedBorderWidth = 2.0
  static let unselectedBorderWidth = 1.0
  static let verticalPlaceholderPadding = 17.0
  static let horizontalPlaceholderPadding = 21.0
  static let charactersCounterSeparator = "/"
}

private extension AccessibilityIdentifier {
  static let label: Self = .init("label")
  static let charactersCounter: Self = .init("charactersCounter")
  static let textEditor: Self = .init("textEditor")
}

private extension AccessibilityIdentifierGroup {
  static let textArea: Self = .init("textArea")
}

