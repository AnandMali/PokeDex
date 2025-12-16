# Pokedex

This is a Pokedex app that demonstrates modern Android development with a clean architecture.

## Clean Architecture

The project follows the principles of Clean Architecture, separating the codebase into distinct layers with specific responsibilities. This separation of concerns makes the app more scalable, maintainable, and testable.

*   **App:** The entry point of the application, responsible for UI and user interaction.
*   **Domain:** Contains the core business logic of the application, independent of any framework or UI.
*   **Data:** Responsible for providing data to the domain layer, abstracting away the data sources (network, database, etc.).
*   **Core Modules:**
    *   `core-common`: Contains common data models and utility classes used across multiple modules.
    *   `core-network`: Handles all network-related operations.
    *   `core-database`: Manages the local database.

## Tech Stack

*   **Kotlin:** The primary programming language.
*   **Jetpack Compose:** For building the UI.
*   **Coroutines:** For asynchronous programming.
*   **Hilt:** For dependency injection.
*   **Retrofit:** For networking.
*   **Room:** For local database storage.
*   **Coil:** For image loading.
*   **Paging 3:** For paginating data from the network.

## Structural Benefits

*   **Modularity:** The multi-module architecture allows for better code organization and faster build times.
*   **Scalability:** The clean architecture makes it easy to add new features and scale the application.
*   **Testability:** The separation of concerns makes it easy to write unit tests for each layer of the application.
