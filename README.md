# Navigation3 - Android Navigation Sample

A comprehensive Android application demonstrating modern navigation patterns using Jetpack Compose and type-safe navigation with Kotlin Serialization.

Note : Perpose of this project is to get understanding on Navingation3 logics, i have kept ui for this project is incomplete.

## 📱 Project Demo

https://github.com/user-attachments/assets/665a1709-a96a-4634-a441-656865a13408

## 🚀 Features

- **Type-Safe Navigation** - Using Kotlin Serialization for compile-time safety
- **Modern Architecture** - Clean architecture with MVVM pattern
- **Jetpack Compose UI** - Fully declarative UI with Material 3 design
- **Navigation Patterns** - Multiple navigation scenarios including:
  - Simple navigation between screens
  - Parameter passing between destinations
  - Bottom sheet navigation
  - Back stack management
  - Navigation with clear stack
- **Bottom Sheet Integration** - Modal bottom sheets as navigation destinations
- **State Management** - Proper state handling across navigation

## 🏗️ Architecture

The project follows Clean Architecture principles with the following structure:

```
com.example.navigation3/
├── domain/
│   └── navigation/
│       ├── NavDestination.kt      # Serializable navigation destinations
│       └── NavEvents.kt           # Navigation events
├── presentation/
│   ├── navigation/
│   │   ├── AppNavigation.kt       # Main navigation setup
│   │   └── NavigationViewModel.kt # Navigation state management
│   └── view/
│       ├── HomeScreen.kt          # Home screen composable
│       ├── ProfileScreen.kt       # Profile screen composable
│       ├── SettingsScreen.kt      # Settings screen composable
│       ├── UserDetailScreen.kt    # User detail with parameters
│       ├── ProductDetailScreen.kt # Product detail with parameters
│       ├── LoginScreen.kt         # Login screen composable
│       ├── RegisterScreen.kt      # Registration screen composable
│       ├── DashboardScreen.kt     # Dashboard screen composable
│       └── SettingsBottomSheetContent.kt # Bottom sheet content
└── utils/
    └── NavigationExtensions.kt    # Navigation helper functions
```

## 🛠️ Technical Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Navigation**: Navigation Compose with Type Safety
- **Serialization**: Kotlin Serialization
- **Architecture**: MVVM + Clean Architecture
- **Material Design**: Material 3
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 35

## 📋 Prerequisites

- Android Studio Hedgehog | 2023.1.1 or newer
- Kotlin 1.9.10 or newer
- Minimum SDK 24
- Compile SDK 35

## 🔧 Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/sushantAndroid/navigation3.git
   cd navigation3
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned repository and select it

3. **Sync the project**
   - Let Android Studio sync the project and download dependencies
   - Make sure all Gradle builds complete successfully

4. **Run the application**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`

## 📱 Navigation Destinations

The app includes the following navigation destinations:

| Destination | Type | Parameters | Description |
|-------------|------|------------|-------------|
| `Home` | Object | None | Main landing screen |
| `Profile` | Object | None | User profile screen |
| `Settings` | Object | None | App settings screen |
| `UserDetail` | Data Class | `userId: String`, `userName: String` | User detail with parameters |
| `ProductDetail` | Data Class | `productId: String`, `categoryId: Int` | Product detail with parameters |
| `Login` | Object | None | User authentication screen |
| `Register` | Object | None | User registration screen |
| `Dashboard` | Object | None | Main dashboard screen |

## 🎯 Key Implementation Details

### Type-Safe Navigation

All navigation destinations are defined as `@Serializable` classes:

```kotlin
@Serializable
sealed class NavDestination {
    @Serializable
    data object Home : NavDestination()
    
    @Serializable
    data class UserDetail(
        val userId: String,
        val userName: String
    ) : NavDestination()
    // ... other destinations
}
```

### Navigation Events

Navigation is handled through a centralized event system:

```kotlin
sealed class NavEvents {
    data class NavigateTo(val destination: NavDestination, val clearBackStack: Boolean = false) : NavEvents()
    data object NavigateBack : NavEvents()
    data class NavigateBackTo(val destination: NavDestination, val inclusive: Boolean = false) : NavEvents()
    // ... other events
}
```

### Bottom Sheet Integration

The app demonstrates how to integrate modal bottom sheets as navigation destinations, providing a seamless user experience for contextual content.

## 🧪 Testing

The project includes unit tests and UI tests. Run tests using:

```bash
./gradlew test                    # Unit tests
./gradlew connectedAndroidTest    # Instrumented tests
```

## 📦 Dependencies

Key dependencies used in this project:

```kotlin
// Navigation
implementation("androidx.navigation:navigation-compose:2.7.6")

// Serialization
implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

// Compose BOM
implementation(platform("androidx.compose:compose-bom:2024.02.00"))

// Material 3
implementation("androidx.compose.material3:material3")
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request


## 👨‍💻 Author

**Sushant Saurav**
- GitHub: [@yourusername](https://github.com/sushantAndroid)
- LinkedIn: [Your LinkedIn]()
- Email: sauravsushant07@gmail.com

## 🙏 Acknowledgments

- Android Developers Documentation
- Jetpack Compose Navigation Documentation
- Kotlin Serialization Documentation
- Material Design Guidelines

---

⭐ **Star this repository if you found it helpful!**
