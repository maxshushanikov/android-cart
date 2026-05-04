# Android Shop App

Dies ist eine leistungsstarke, skalierbare und modulare Android Shop-Anwendung, die mit modernsten Technologien entwickelt wurde.

## 🚀 Technologie-Stack
- **Sprache**: Kotlin
- **UI-Framework**: Jetpack Compose
- **Design-System**: Material 3
- **Architektur**: MVVM + Clean Architecture (Modularisiert)
- **Dependency Injection**: Hilt
- **Netzwerk**: Retrofit + OkHttp
- **Datenbank**: Room
- **Bildladen**: Coil
- **Asynchron**: Coroutines + Flow

## 🏗 Architektur
Die App folgt den Prinzipien der **Clean Architecture**, um eine klare Trennung der Verantwortlichkeiten und Testbarkeit zu gewährleisten.

### Module
- `:app`: Haupteinstiegspunkt, Navigation, Hilt-Setup.
- `:core`: Gemeinsame UI-Komponenten, Theme und Hilfsprogramme.
- `:domain`: Geschäftslogik, Entitäten und Repository-Schnittstellen.
- `:data`: Implementierung von Repositories, Datenbank- und Netzwerkdiensten.
- `:feature:*`: Unabhängige Feature-Module (Katalog, Warenkorb, Auth, Profil).

## 📦 Funktionen
- [x] **Produktkatalog**: Listen- und Grid-Ansichten mit Shimmer-Ladeeffekt.
- [x] **Warenkorb**: Echtzeit-Updates mit Room-Persistenz.
- [x] **Modernes UI**: Volle Material 3 Unterstützung mit Light/Dark Mode.
- [x] **Sauberer Code**: SOLID-Prinzipien und produktionsreife Struktur.

## 🛠 Einrichtung & Ausführung
1. Klonen Sie das Repository.
2. Öffnen Sie es in Android Studio (Iguana oder neuer).
3. Synchronisieren Sie Gradle und bauen Sie das Projekt.
4. Führen Sie es auf einem Emulator oder einem physischen Gerät aus.
