import SwiftUI

public extension View {
  func shadow(_ shadow: Shadow) -> some View {
    self
      .shadow(
        color: shadow.firstLayer.color,
        radius: shadow.firstLayer.radius,
        y: shadow.firstLayer.radius
      )
      .shadow(
        color: shadow.secondLayer.color,
        radius: shadow.secondLayer.radius,
        y: shadow.secondLayer.radius
      )
  }
}

public struct Shadow {
  struct Layer {
    let color: Color
    let radius: CGFloat
    let y: CGFloat
  }

  let firstLayer: Layer
  let secondLayer: Layer
}

extension Shadow {
  public static let light200: Self = .init(
    firstLayer: .init(color: .neutral500.opacity(0.02), radius: 2, y: 0),
    secondLayer: .init(color: .neutral500.opacity(0.04), radius: 8, y: 8)
  )

  public static let light400: Self = .init(
    firstLayer: .init(color: .neutral500.opacity(0.02), radius: 4, y: 0),
    secondLayer: .init(color: .neutral500.opacity(0.04), radius: 12, y: 16)
  )

  public static let light600: Self = .init(
    firstLayer: .init(color: .neutral500.opacity(0.02), radius: 4, y: 0),
    secondLayer: .init(color: .neutral500.opacity(0.04), radius: 16, y: 24)
  )
}
