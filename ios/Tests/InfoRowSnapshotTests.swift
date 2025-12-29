import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct InfoRowSnapshotTests {
  @MainActor @Test
  func testInfoRows() {
    assertSnapshots(matching: InfoRowTestView())
  }

  @MainActor @Test
  func testBullets() {
    assertSnapshots(matching: BulletTestView())
  }
}

private struct BulletTestView: View {
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      Label(title: "Przeczytaj i zaakceptuj regulamin oraz politykę prywatności.")

      Label(title: "Ustaw hasło.")

      Label(title: "Jeśli chcesz, włącz logowanie biometryczne. Ustaw PIN i biometrię.")

      Label(title: "Dodaj pierwszy dokument.")
    }
    .labelStyle(.bullet)
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

private struct InfoRowTestView: View {
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing200) {
      Label(
        title: "E-wizyta w ZUS", 
        description: "Umów się na wideorozmowę z pracownikiem ZUS w dogodnym terminie. Załatwisz swoje sprawy z dowolnego miejsca."
      ) {
        Icons.Brand.Services.zusVisit
          .resizable()
          .foregroundStyle(Color.grass80)
      }

      Label(
        title: "Jakość powietrza", 
        description: "Dowiedz się, jakim powietrzem oddychasz. Możesz znajdować i zapisywać punkty pomiarowe z całego kraju. Szybko sprawdzisz aktualną jakość powietrza."
      ) {
        Icons.Brand.Services.airQuality
          .resizable()
          .foregroundStyle(Color.snow100)
      }

      Label(
        title: "Historia pojazdu", 
        description: "Kupujesz używany samochód lub motocykl? Sprawdź najważniejsze informacje o pojeździe. Wystarczy, że wpiszesz numer VIN i numer rejestracyjny."
      ) {
        Icons.Brand.Services.vehicleHistory
          .resizable()
          .foregroundStyle(Color.celadon100)
      }
    }
    .labelStyle(.infoRow)
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

