import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct RadioButtonSnapshotTests {
  @MainActor @Test
  func testRadioButton() {
    assertSnapshots(
      matching: RadioButtonTestView(), 
      as: [ 
        .iPhone13Mini(.scaled(1.6)), 
        .iPhone13ProMax(.scaled(1.5))
      ] 
    )
  }
}

private struct RadioButtonTestView: View {
  var body: some View {
    ScrollView {
      Group {
        VStack(spacing: .spacing200) {
          RadioButton(label: "Opcja 1", isOn: .constant(false))

          Divider()

          RadioButton(label: "Opcja 2", isOn: .constant(false))

          Divider()

          RadioButton(label: "Opcja 3", isOn: .constant(true))
        }
        .toggleStyle(.radio)
        .contentBox()

        VStack(spacing: .spacing200) {
          RadioButton(
            label: {
              VStack(alignment: .leading, spacing: .spacing100) {
                Text("Opcja 1")

                Text("Opis")
                  .foregroundStyle(Color.neutral200)
              }
            }, 
            content: {
              VStack(spacing: .spacing200) {
                Button(
                  action: {}, 
                  label: { Text("Opcja 1") }
                )
                .buttonStyle(.dropdown("Etykieta"))
                .validation(nil)
                .tooltipText("Tekst pomocniczy (helper text).", isHidden: false)
              }
            }, 
            isOn: .constant(true)
          )

          Divider()

          RadioButton(
            label: {
              VStack(alignment: .leading, spacing: .spacing100) {
                Text("Opcja 2")

                Text("Opis")
                  .foregroundStyle(Color.neutral200)
              }
            }, 
            isOn: .constant(false)
          )
        }
        .contentBox()

        VStack(spacing: .spacing200) {
          RadioButton(label: "Opcja 1", isOn: .constant(false))
            .disabled(true)

          Divider()

          RadioButton(label: "Opcja 2", isOn: .constant(true))
            .disabled(true)
        }
        .toggleStyle(.radio)
        .contentBox()

        VStack(spacing: .spacing200) {
          RadioButton(label: "Opcja 1", isOn: .constant(false))

          Divider()

          RadioButton(label: "Opcja 2", isOn: .constant(true))
        }
        .toggleStyle(.radio)
        .validation("Tekst błędu", padding: .spacing200)
        .contentBox()
      }
      .padding(.spacing200)
    }
    .background(Color.background.ignoresSafeArea())
  } 
} 

