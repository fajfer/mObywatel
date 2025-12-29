import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct DocumentCardSnapshotTests {
  @MainActor @Test
  func testDocumentCard() {
    assertSnapshots(matching: DocumentCardView())
  }
}

private struct DocumentCardView: View {
  var body: some View {
    DocumentCard( 
      title: "Legitymacja osoby niepełnosprawnej", 
      backgroundImage: Image("lon_background", bundle: .module), 
      trailingItem: {
        Icons.Lift.Documents.cardLogoLON
          .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
          .overlay(alignment: .bottomTrailing) {
            Icons.Lift.StatusCard.checkMark
          }
      }
    ) 
    .padding(.spacing200)
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 
