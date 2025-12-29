import SnapshotTesting
import SwiftUI
import Testing

@testable import DesignSystem

@Suite(.snapshots(record: .missing))
struct TimelineSnapshotTests {
  @MainActor @Test
  func testTimeline() {
    assertSnapshots(matching: TestView())
  }
}

private struct TestView: View {
  let items: [Timeline.Item] = [ 
    .init( 
      header: "Lorem ipsum", 
      title: "Ut enim ad minim veniam", 
      descriptions: [
        "Duis aute irure dolor", 
        "Excepteur sint occaecat cupidatat non proident" 
      ] 
    ), 
    .init( 
      header: "Lorem ipsum", 
      title: "Ut enim ad minim veniam", 
      descriptions: [
        "Excepteur sint occaecat cupidatat non proident" 
      ] 
    ), 
    .init( 
      header: "Lorem ipsum", 
      title: "Ut enim ad minim veniam"
    ), 
    .init( 
      header: "Lorem ipsum", 
      title: "Ut enim ad minim veniam", 
      descriptions: [
        "Duis aute irure dolor", 
        "Excepteur sint occaecat cupidatat non proident", 
        "Nullam condimentum purus at tortor tincidunt egestas. Etiam vitae ultrices justo." 
      ] 
    ) 
 ] 

  var body: some View {
    VStack(spacing: .spacing200) {
      Timeline(items: items)
        .contentBox()

      Spacer()
    }
    .padding(.spacing200)
    .background(Color.background.ignoresSafeArea())
  } 
} 

