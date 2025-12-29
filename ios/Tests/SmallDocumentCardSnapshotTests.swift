import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct SmallDocumentCardSnapshotTests {
  @MainActor @Test
  func testSmallDocumentCards() {
    assertSnapshots(matching: SmallDocumentCardsView())
  }
}

private struct SmallDocumentCardsView: View {
  var body: some View {
    HStack(spacing: .spacing100) {
      SmallDocumentCard(
        title: "Legitymacja osoby niepełnosprawnej", 
        backgroundImage: Image("lon_small_background", bundle: .module), 
        leadingItem: {
          Icons.Lift.Documents.cardLogoLON
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
            .overlay(alignment: .bottomTrailing) {
              Icons.Lift.StatusCard.checkMark
            }
        }
      )
      SmallDocumentCard(
        title: "Karta dużej rodziny", 
        backgroundImage: Image("kdr_small_background", bundle: .module), 
        leadingItem: {
          Icons.Lift.Documents.cardLogoKDR
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
            .overlay(alignment: .bottomTrailing) {
              Icons.Lift.StatusCard.noticeMark
            }
        }
      )
    }
    .padding(.spacing200)
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

