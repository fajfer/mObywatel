import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct DropdownListSnapshotTests {
  @MainActor @Test
  func testDropdownListSelected() {
    assertSnapshots(matching: DropdownList(.testItems, selectedItem: .constant(.selectedItem)))
  }

  @MainActor @Test
  func testDropdownListUnselected() {
    assertSnapshots(matching: DropdownList(.testItems, selectedItem: .constant(nil)))
  }

  @MainActor @Test
  func testDropdownListRowContent() {
    assertSnapshots(
      matching: DropdownList(
        .testItems, 
        selectedItem: .constant(.selectedItem), 
        rowContent: { item in
          GroupBox(item.text) {
            Text(item.reversed)
          }
          .groupBoxStyle(.singleCard.reversed)
        }
      )
    )
  }
}

private struct Item: Selectable {
  var text: String

  var reversed: String {
    String(self.text.reversed()).capitalized 
  }
} 

private extension Item {
  static let selectedItem = Item(text: "Środa")
}

private extension Array where Element == Item {
  static let testItems = [ 
    "Poniedziałek", 
    "Wtorek", 
    "Środa", 
    "Czwartek", 
    "Piątek", 
    "Sobota", 
    "Niedziela"
  ] 
  .map(Item.init(text:))
}
