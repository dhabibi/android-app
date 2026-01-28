# Cookie Clicker

A simple and fun cookie clicker game for Android. Tap the cookie to earn cookies, then spend them on upgrades to earn even more!

## Features

- Tap the cookie to earn cookies
- Buy Auto Clickers to earn cookies automatically (1 per second each)
- Buy Double Click Power to multiply your cookies per tap
- Smooth animations and satisfying feedback
- Warm, cookie-themed color palette

## Requirements

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17 or newer
- Android SDK 34
- Minimum Android version: 7.0 (API 24)

## Building the App

### Using Android Studio

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd android-app
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it
   - Wait for Gradle sync to complete

3. **Build the app**
   - Click `Build > Make Project` or press `Ctrl+F9` (Windows/Linux) or `Cmd+F9` (Mac)
   - For a release build: `Build > Build Bundle(s) / APK(s) > Build APK(s)`

### Using Command Line

1. **Clone and navigate to the project**
   ```bash
   git clone <repository-url>
   cd android-app
   ```

2. **Build debug APK**
   ```bash
   ./gradlew assembleDebug
   ```
   The APK will be at `app/build/outputs/apk/debug/app-debug.apk`

3. **Build release APK** (unsigned)
   ```bash
   ./gradlew assembleRelease
   ```
   The APK will be at `app/build/outputs/apk/release/app-release-unsigned.apk`

## Installing the App

### From Android Studio

1. Connect your Android device via USB (enable USB debugging in Developer Options)
2. Or start an Android emulator
3. Click the green "Run" button or press `Shift+F10`
4. Select your target device
5. The app will be installed and launched automatically

### Using ADB (Command Line)

1. **Enable USB debugging** on your Android device:
   - Go to Settings > About phone
   - Tap "Build number" 7 times to enable Developer Options
   - Go to Settings > Developer Options
   - Enable "USB debugging"

2. **Connect your device** via USB and verify connection:
   ```bash
   adb devices
   ```

3. **Install the APK**:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

### Manual Installation

1. Build the APK using one of the methods above
2. Transfer the APK file to your Android device
3. On your device, enable "Install from unknown sources" in Settings
4. Open a file manager and navigate to the APK
5. Tap the APK file to install

## How to Play

1. **Tap the cookie** - Each tap gives you cookies (starts at 1 per tap)
2. **Buy Auto Clickers** - Spend 10 cookies to get an auto clicker that generates 1 cookie per second. Cost increases with each purchase.
3. **Buy Double Click Power** - Spend 50 cookies to double your cookies per tap. Cost increases with each purchase.
4. **Keep clicking and upgrading** - Watch your cookie empire grow!

## Project Structure

```
app/
├── src/main/
│   ├── java/com/example/cookieclicker/
│   │   └── MainActivity.kt       # Main game logic
│   ├── res/
│   │   ├── layout/
│   │   │   └── activity_main.xml # UI layout
│   │   ├── drawable/
│   │   │   └── ic_cookie.xml     # Cookie vector graphic
│   │   └── values/
│   │       ├── colors.xml        # Color definitions
│   │       ├── strings.xml       # String resources
│   │       └── themes.xml        # App theme
│   └── AndroidManifest.xml       # App manifest
├── build.gradle.kts              # App-level build config
└── proguard-rules.pro            # ProGuard rules
```

## License

This project is open source and available for educational purposes.
