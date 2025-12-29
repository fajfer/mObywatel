import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct HeaderViewSnapshotTests {
  @MainActor @Test
  func testWithAllElements() {
    let view = HeaderView(
      icon: Icons.Brand.Services.peselRestriction, 
      iconColor: .purple100, 
      iconBackgroundColor: .purple30, 
      title: "Twój PESEL jest niezastrzeżony", 
      description: "Znajdziesz tu najważniejsze informacje o pojeździe, na przykład czy ma ważne badanie techniczne i polisę OC.", 
      content: {
        VStack {
          Spacer()

          Text("Some additional content")

          Spacer()
        }
        .frame(maxWidth: .infinity)
        .contentBox()
      }
    )
    .padding(.spacing200)
    .background(Color.background.ignoresSafeArea())

    assertSnapshots(matching: view)
  }

  @MainActor @Test
  func testWithoutDescription() {
    let view = HeaderView(
      icon: Icons.Lift.Brand.peselRestriction, 
      iconBackgroundColor: Colors.Services.Background.peselRestriction, 
      title: "Twój PESEL jest niezastrzeżony", 
      content: {
        VStack {
          Spacer()

          Text("Some additional content")

          Spacer()
        }
        .frame(maxWidth: .infinity)
        .contentBox()
      }
    )
    .padding(.spacing200)
    .background(Color.background.ignoresSafeArea())

    assertSnapshots(matching: view)
  }
}
