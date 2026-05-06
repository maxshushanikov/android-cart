# Android Shop App

This is a high-performance, scalable, and modular Android Shop application built with modern technologies.

## Technology Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design System**: Material 3
- **Architecture**: MVVM + Clean Architecture (Modularized)
- **Dependency Injection**: Hilt
- **Network**: Retrofit + OkHttp
- **Database**: Room
- **Image Loading**: Coil
- **Asynchronous**: Coroutines + Flow

## Architecture
The app follows **Clean Architecture** principles to ensure separation of concerns and testability.

### Modules
- `:app`: Main entry point, Navigation, Hilt setup.
- `:core`: Common UI components, Theme, and Utilities.
- `:domain`: Business logic, Entities, and Repository interfaces.
- `:data`: Implementation of repositories, Database, and Network services.
- `:feature:*`: Independent feature modules (Catalog, Cart, Auth, Profile).

## Features
- [x] **Product Catalog**: List and Grid views with shimmer loading.
- [x] **Shopping Cart**: Real-time updates with Room persistence.
- [x] **Modern UI**: Full Material 3 support with Light/Dark mode.
- [x] **Clean Code**: SOLID principles and production-ready structure.

## Setup & Run
1. Clone the repository.
2. Open in Android Studio (Iguana or newer).
3. Sync Gradle and build the project.
4. Run on an emulator or physical device.
