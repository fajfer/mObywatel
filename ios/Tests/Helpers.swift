import DesignSystem
import SnapshotTesting
import SwiftUI

public enum SnapshotDevice {
  public enum Mode {
    case `default`
    case scaled(CGFloat)
    case estimatedHeight(CGFloat)
  }

  case iPhone13Mini(Mode = .default)
  case iPhone13ProMax(Mode = .default)

  var sizeName: String {
    switch self {
    case .iPhone13Mini:
      "small"

    case .iPhone13ProMax:
      "large"
    }
  }
}

public func assertSnapshots<Value: View>(
  matching value: @autoclosure () throws -> Value, 
  as devices: [SnapshotDevice] = [.iPhone13Mini(), .iPhone13ProMax()],
  named name: String? = nil, 
  appTheme: AppTheme = AppTheme(), 
  record recording: Bool? = nil, 
  timeout: TimeInterval = 5, 
  precision: Float = 1.0, 
  perceptualPrecision: Float = 0.98, 
  file: StaticString = #file, 
  testName: String = #function, 
  line: UInt = #line
) {
  setupAppearance(appTheme: appTheme)
  for device in devices {
    assertSnapshot(
      of: try value().environment(\.appTheme, appTheme), 
      as: .image(
        precision: precision, 
        perceptualPrecision: perceptualPrecision, 
        layout: .device(config: device.config)
      ), 
      named: ".\(device.sizeName)", 
      record: recording, 
      timeout: timeout, 
      file: file, 
      testName: testName, 
      line: line 
    )
  }
}

public extension SnapshotDevice {
  var config: ViewImageConfig {
    switch self {
    case let .iPhone13Mini(mode):
        .iPhone13Mini.transform(with: mode)

    case let .iPhone13ProMax(mode):
        .iPhone13ProMax.transform(with: mode)
    }
  }
}

private extension ViewImageConfig {
  func transform(with mode: SnapshotDevice.Mode) -> ViewImageConfig {
    switch mode {
    case .default:
      self

    case let .scaled(heightScale):
      self.scaled(height: heightScale)

    case let .estimatedHeight(height):
      self.estimatedHeight(height)
    }
  }

  func estimatedHeight(_ height: CGFloat) -> ViewImageConfig {
    var scaledConfig = self
    scaledConfig.size?.height = height 
    return scaledConfig 
  }

  func scaled(height heightScale: CGFloat) -> ViewImageConfig {
    var scaledConfig = self
    scaledConfig.size?.height *= heightScale 
    return scaledConfig 
  }
}

