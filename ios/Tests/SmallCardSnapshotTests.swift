import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct SmallCardSnapshotTests {
  @MainActor @Test
  func testSmallCards() {
    assertSnapshots(matching: SmallCardTestView())
  }
}

private struct SmallCardTestView: View {
  var body: some View {
    HStack(spacing: .spacing250) {
      SmallCard.yourAffairs

      SmallCard.fines

      SmallCard.airQuality
    }
    .frame(maxWidth: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

private extension SmallCard {
  static var yourAffairs: Self {
    .init(
      foregroundColor: .sun80, 
      image: Icons.Brand.Services.yourAffairs, 
      title: "Twoje sprawy"
    )
  }

  static var fines: Self {
    .init(
      foregroundColor: .cornflower100, 
      image: Icons.Brand.Services.fines, 
      title: "Mandaty"
    )
  }

  static var airQuality: Self {
    .init(
      foregroundColor: .snow100, 
      image: Icons.Brand.Services.airQuality, 
      title: "Jakość powietrza"
    )
  }
}

