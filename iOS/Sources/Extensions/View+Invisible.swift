import SwiftUI

extension View {



  var invisible: some View {
    self
      .background(Color.clear)
      .foregroundStyle(Color.clear)
      .tint(Color.clear)
  }
}
