import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct ButtonSnapshotTests {
  @MainActor @Test
  func testPrimaryButtons() {
    assertSnapshots(matching: PrimaryButtonTestView())
  }

  @MainActor @Test
  func testSecondaryButtons() {
    assertSnapshots(matching: SecondaryButtonTestView())
  }

  @MainActor @Test
  func testTertiaryButtons() {
    assertSnapshots(matching: TertiaryButtonTestView())
  }

  @MainActor @Test
  func testTextButtons() {
    assertSnapshots(matching: TextButtonTestView())
  }

  @MainActor @Test
  func testIconButtons() {
    assertSnapshots(matching: IconButtonTestView())
  }
}



private struct PrimaryButtonTestView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      
      Button("Button label") {}
        .buttonStyle(.primary(.large))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.primary(.iconLarge))

      Button("Button label") {}
        .buttonStyle(.primary(.small))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.primary(.iconSmall))

      
      Button("Button label") {}
        .buttonStyle(.primary(.largeDestructive))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.primary(.iconLargeDestructive))

      Button("Button label") {}
        .buttonStyle(.primary(.smallDestructive))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.primary(.iconSmallDestructive))

      
      Button("Button label") {}
        .buttonStyle(.primary(.large))
        .disabled(true)

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.primary(.iconLarge))
      .disabled(true)

      Button("Button label") {}
        .buttonStyle(.primary(.small))
        .disabled(true)

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.primary(.iconSmall))
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct SecondaryButtonTestView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      
      Button("Button label") {}
        .buttonStyle(.secondary(.large))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.secondary(.iconLarge))

      Button("Button label") {}
        .buttonStyle(.secondary(.small))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.secondary(.iconSmall))

      
      Button("Button label") {}
        .buttonStyle(.secondary(.largeDestructive))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.secondary(.iconLargeDestructive))

      Button("Button label") {}
        .buttonStyle(.secondary(.smallDestructive))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.secondary(.iconSmallDestructive))

      
      Button("Button label") {}
        .buttonStyle(.secondary(.large))
        .disabled(true)

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.secondary(.iconLarge))
      .disabled(true)

      Button("Button label") {}
        .buttonStyle(.secondary(.small))
        .disabled(true)

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.secondary(.iconSmall))
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct TertiaryButtonTestView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      
      Button("Button label") {}
        .buttonStyle(.tertiary(.large))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.tertiary(.iconLarge))

      Button("Button label") {}
        .buttonStyle(.tertiary(.small))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.tertiary(.iconSmall))

      
      Button("Button label") {}
        .buttonStyle(.tertiary(.largeDestructive))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.tertiary(.iconLargeDestructive))

      Button("Button label") {}
        .buttonStyle(.tertiary(.smallDestructive))

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.tertiary(.iconSmallDestructive))

      
      Button("Button label") {}
        .buttonStyle(.tertiary(.large))
        .disabled(true)

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.tertiary(.iconLarge))
      .disabled(true)

      Button("Button label") {}
        .buttonStyle(.tertiary(.small))
        .disabled(true)

      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.tertiary(.iconSmall))
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct TextButtonTestView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      
      Button("Button label") {}
        .buttonStyle(.text)

      
      Button("Button label") {}
        .buttonStyle(.destructiveText)

      
      Button("Button label") {}
        .buttonStyle(.text)
        .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 



private struct IconButtonTestView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      
      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.icon)

      
      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.destructiveIcon)

      
      Button(
        action: {}, 
        label: { Icons.Outline.Symbols.star }
      )
      .buttonStyle(.icon)
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 
