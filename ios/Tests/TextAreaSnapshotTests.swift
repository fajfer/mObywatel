import Foundation
import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct TextAreaSnapshotTests {
  @MainActor @Test
  func testTextAreas() {
    assertSnapshots(matching: TextAreaTestView())
  }

  @MainActor @Test
  func testTextAreasWithCounter() {
    assertSnapshots(matching: TextAreaWithCounterTestView())
  }
}

private struct TextAreaTestView: View {
  var validationMessage: String? = "Przekroczono liczbę znaków." 
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing400) {
      TextArea(
        "Some placeholder", 
        text: .constant(""), 
        label: "Label", 
        mode: .flexible()
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label"
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label"
      )
      .apply(if: validationMessage == nil) {
        $0.tooltipText("Helper")
      }
      .validation(validationMessage)

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label"
      )
      .tooltipText("Helper")
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

private struct TextAreaWithCounterTestView: View {
  var validationMessage: String? = "Przekroczono liczbę znaków." 
  var body: some View {
    VStack(alignment: .leading, spacing: .spacing400) {
      TextArea(
        "Some placeholder", 
        text: .constant(""), 
        label: "Label", 
        maxTextLength: 150
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg"), 
        label: "Label", 
        maxTextLength: 150
      )
      .tooltipText("Helper")

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label", 
        maxTextLength: 150
      )
      .apply(if: validationMessage == nil) {
        $0.tooltipText("Helper")
      }
      .validation(validationMessage)

      TextArea(
        "", 
        text: .constant("Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Cu cum nibh brute quaestio, cu leg. Lorem ipsum dolor sit amet, ne est dolorum lucilius, ius ne labore option assueverit. Lorem ipsum dolor sit amet, ne est dolorum lucilius."), 
        label: "Label", 
        maxTextLength: 150
      )
      .tooltipText("Helper")
      .disabled(true)
    }
    .padding()
    .frame(maxWidth: .infinity, maxHeight: .infinity)
    .background(Color.background.ignoresSafeArea())
  } 
} 

