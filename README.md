# NTT Data Project - Leaderboard

This project was developed as part of an assignment by **NTT Data** for the **Master's Degree in Computer Engineering (AI & ML course)**.

## Project Overview

The goal of this project is to implement a robust and efficient Leaderboard system. It follows Test-Driven Development (TDD) principles to ensure reliability and correctness.

### Key Features
- **Score Management**: Tracks player scores and only maintains the personal best (highest score).
- **Unique Players**: Efficiently manages a collection of unique players using a hash-based approach.
- **TDD Approach**: Comprehensive unit tests covering nominal and edge cases.

## Technical Stack
- **Language**: Java
- **Build System**: Maven
- **Testing Framework**: JUnit 5, Mockito

## Getting Started

### Prerequisites
- Java 11 or higher
- Apache Maven

### Installation & Running Tests
1. Clone the repository.
2. Navigate to the project directory:
   ```bash
   cd demo
   ```
3. Run the tests using Maven:
   ```bash
   mvn test
   ```

## Project Structure
- `src/main/java/com/example/Leaderboard.java`: The core logic of the leaderboard.
- `src/test/java/com/example/LeaderboardTest.java`: Unit tests defining the expected behavior.
- `pom.xml`: Maven configuration and dependencies.

## Academic Context
Developed for the **AI & ML course** in the **Master's Degree in Computer Engineering**, in collaboration with **NTT Data**.
