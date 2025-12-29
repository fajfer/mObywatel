import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct AccordionSnapshotTests {
  @MainActor @Test
  func testAccordionSingleLineView() {
    assertSnapshots(matching: AccordionSingleLineView())
  }

  @MainActor @Test
  func testAccordionMultiLineView() {
    assertSnapshots(matching: AccordionMultiLineView())
  }
}

private struct AccordionSingleLineView: View {
  var body: some View {
    VStack(spacing: .spacing100) {
      Accordion("Uczniowie/studenci", isExpanded: .constant(true)) {
        VStack(alignment: .leading, spacing: .spacing50) {
          Text("Uczeń szkoły podstawowej:")
            .font(.headline)

          Group {
            Text("Zniżka 50% na bilety komunikacji miejskiej.")
            Text("Darmowy przejazd w godzinach szczytu od poniedziałku do piątku.")
          }
          .font(.subheadline)
          .frame(maxWidth: .infinity, alignment: .leading)
        }
      }
      .contentBox()

      Accordion("Seniorzy", isExpanded: .constant(false)) { }
        .contentBox()

      Spacer()

    }
    .padding()
    .background(Color.background.ignoresSafeArea())
  } 
} 

private struct AccordionMultiLineView: View {
  var body: some View {
    VStack(spacing: .spacing200) {
      VStack(spacing: .zero) {
        Accordion("Uczniowie/studenci", isExpanded: .constant(true)) {
          VStack(alignment: .leading, spacing: .spacing50) {
            Text("Uczeń szkoły podstawowej:")
              .font(.headline)

            Group {
              Text("Zniżka 50% na bilety komunikacji miejskiej.")
              Text("Darmowy przejazd w godzinach szczytu od poniedziałku do piątku.")
            }
            .font(.subheadline)
            .frame(maxWidth: .infinity, alignment: .leading)
          }

          VStack(alignment: .leading, spacing: .spacing50) {
            Text("Student uczelni wyższej:")
              .font(.headline)

            Group {
              Text("Zniżka 30% na bilety komunikacji miejskiej.")
              Text("Możliwość skorzystania z karty miejskiej umożliwiającej dodatkowe ulgi.")
            }
            .font(.subheadline)
            .frame(maxWidth: .infinity, alignment: .leading)
          }
        }

        Divider()
          .padding(.vertical, .spacing200)

        Accordion("Seniorzy", isExpanded: .constant(false)) { }
      }
      .contentBox()

      Spacer()
    }
    .padding()
    .background(Color.background.ignoresSafeArea())
  } 
} 


