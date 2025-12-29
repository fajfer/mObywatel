import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct ListHeaderSnapshotTests {
  func testListHeader() {
    assertSnapshots(matching: ListHeaderTestView())
  }
}

private struct ListHeaderTestView: View {
  var body: some View {
    List {
      Section {
        Label {
          GroupBox("Seria i numer dowodu osobistego") {
            Text("ABC123456")
          }
          .groupBoxStyle(.singleCard)
        } item: {
          Icons.Outline.Symbols.phone
        }
        .labelStyle(.leading(.icon))
      } header: {
        GroupBox("Potwierdź zastrzeżenie dowodu") {
          Text("Zastrzeżenie dowodu jest bezpłatne. W każdej chwili możesz je cofnąć.")
        }
        .groupBoxStyle(.listHeader)
        .listRowInsets(.vertical200)
      }
    }
  } 
} 

