
---

# Currency Converter

Welcome to the **Currency Converter**! This is a simple command-line application that allows users to convert currencies using real-time exchange rates fetched from the **Exchange Rate API**.

## Features

- Convert between the following currencies:
  - **USD** ↔ **Argentine Peso (ARS)**
  - **USD** ↔ **Brazilian Real (BRL)**
  - **USD** ↔ **Colombian Peso (COP)**
- Real-time exchange rates fetched from the [Exchange Rate API](https://www.exchangerate-api.com/).
- Simple and interactive text-based menu.
- Includes error handling for invalid inputs and API errors.

---

## Table of Contents

- [Features](#features)
- [Setup](#setup)
- [How to Run](#how-to-run)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Usage](#usage)
- [Future Improvements](#future-improvements)
- [License](#license)

---

## Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/currency-converter.git
   cd currency-converter
   ```

2. **Obtain an API Key**:
   - Sign up at [Exchange Rate API](https://www.exchangerate-api.com/) to get your free API Key.
   - After signing up, you'll receive an API Key in your email or account dashboard.
   - Replace the placeholder `"YOUR_API_KEY_HERE"` in the `App.java` file with your API Key:
     ```java
     final String API_KEY = "YOUR_API_KEY_HERE"; // Replace with your API Key
     ```

3. **Add the Gson Library**:
   - Download the Gson JAR file from [Maven Central](https://mvnrepository.com/artifact/com.google.code.gson/gson).
   - Place the `gson-*.jar` file in the `lib/` directory of the project.
   - Configure the library in your IDE:
     - **IntelliJ IDEA**: Go to **File > Project Structure > Libraries** and add the Gson JAR.

---

## How to Run

1. **Compile the Project**:
   ```bash
   javac -cp lib/gson-*.jar src/com/app/currencyconverter/*.java
   ```

2. **Run the Application**:
   ```bash
   java -cp lib/gson-*.jar:src com.app.currencyconverter.App
   ```

---

## Project Structure

```
project-root/
├── src/
│   ├── com/
│   │   ├── app/
│   │   │   ├── currencyconverter/
│   │   │   │   ├── api/
│   │   │   │   │   └── ExchangeRateApiClient.java
│   │   │   │   ├── model/
│   │   │   │   │   └── ExchangeRateResponse.java
│   │   │   │   ├── service/
│   │   │   │   │   └── CurrencyConversionService.java
│   │   │   │   ├── App.java
│   │   │   │   └── Menu.java
├── lib/
│   └── gson-*.jar
├── .gitignore
└── README.md
```

---

## Dependencies

The project relies on the following dependency:

- **Gson**: For parsing JSON responses from the Exchange Rate API.
  - Download: [Gson JAR](https://mvnrepository.com/artifact/com.google.code.gson/gson)
  - Version: `2.8.9` or later.

---

## Usage

1. When you run the application, you'll see a menu like this:
   ```
   *************************************************
   1) USD to Argentine Peso
   2) Argentine Peso to USD
   3) USD to Brazilian Real
   4) Brazilian Real to USD
   5) USD to Colombian Peso
   6) Colombian Peso to USD
   7) Exit
   Choose a valid option:
   *************************************************
   ```

2. Enter a menu option (1–7) and provide the amount to convert. For example:
   ```
   Enter the amount to convert:
   100
   ```

3. The program will fetch the latest exchange rates and display the result:
   ```
   100 USD is 128.50 ARS.
   ```

---

## Future Improvements

- Add support for more currencies.
- Implement caching to reduce API calls.
- Create a graphical user interface (GUI) for easier interaction.
- Add unit tests for better code quality assurance.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
