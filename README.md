# Rest-Api-Client-Java

*COMPANY *: CODTECH IT SOLUTIONS

*NAME *: VISHALINI B

*INTERN ID *: CTIS8696

*DOMAIN *: Java Programming

*DURATION *: 4 WEEEKS

*MENTOR *: NEELA SANTOSH

# 🎮 Pokemon REST API Client — Java

A simple Java console application that fetches and displays Pokemon data
by consuming the free public REST API from [PokeAPI](https://pokeapi.co).
This project demonstrates how to handle HTTP requests, parse JSON responses,
and manage errors effectively using core Java libraries.

---

## 📌 Overview

This project is built as part of a **REST API Client** task using the Java
programming language. The application connects to the PokeAPI, sends an
HTTP GET request, reads the JSON response, extracts the required data, and
displays it in a clean and structured format on the console. The program
also includes a menu-driven interface so users can search for multiple
Pokemon in a single run without restarting the application.

REST API consumption is a fundamental skill in modern software development.
This project demonstrates that concept in a beginner-friendly way using
only built-in Java libraries — no external dependencies required.

---

## 👨‍💻 Role

**Role: Java Developer**

Responsibilities undertaken in this project:

- Designed and implemented an HTTP client using `HttpURLConnection`
- Consumed a live public REST API (PokeAPI) to fetch real-time Pokemon data
- Parsed JSON responses manually without any third-party libraries
- Built a menu-driven console interface for interactive user experience
- Applied structured exception handling using multiple `try-catch` blocks
- Handled all edge cases including invalid input, empty input, and network errors
- Wrote clean, modular, and well-commented Java code

---

## 🛠️ Platform & Tools Used

| Tool            | Details                     |
|-----------------|-----------------------------|
| IDE             | Eclipse IDE                 |
| Language        | Java                        |
| JDK Version     | JDK 11+                     |
| API Used        | PokeAPI (pokeapi.co)        |
| Package         | java.net, java.io, java.util|
| Libraries       | No external libraries used  |
| Protocol        | HTTP GET Request            |
| Data Format     | JSON                        |

---

## ⚙️ Features

- ✅ Fetches live Pokemon data from PokeAPI
- ✅ Search Pokemon by **name** (e.g. pikachu) or **ID** (e.g. 25)
- ✅ Displays ID, Name, Height, Weight, and Base Experience
- ✅ Menu-driven interface — search multiple Pokemon in one run
- ✅ Handles HTTP response codes (200, 404, others)
- ✅ Handles no internet / unknown host errors
- ✅ Handles invalid menu input (letters instead of numbers)
- ✅ Handles empty search input
- ✅ No external libraries — uses only built-in Java

---

## 📂 Project Structure

```
RestApiClientProject/
│
├── src/
│   └── tasks/
│       └── RestApiClient.java
└── README.md
```

---

## 🚀 How to Run

Follow these steps to run the project in **Eclipse IDE**:

1. Open **Eclipse IDE**
2. Go to **File → New → Java Project**
3. Name the project `RestApiClientProject`
4. Right-click **src** → **New → Package** → name it `tasks`
5. Right-click **tasks** package → **New → Class** → name it `RestApiClient`
6. Paste the source code into the class
7. Press **Ctrl + S** to save
8. Go to **Project → Clean → Clean All Projects**
9. Right-click the file → **Run As → Java Application**
10. The console will display the menu

---

## 📋 Menu Options

```
================================
   Pokemon REST API Client
================================

1. Search Pokemon   — Search by name or ID
2. Exit             — Exit the program
```

---

## 🔍 How It Works

### 🌐 getResponse()
Builds the API URL using the Pokemon name or ID entered by the user.
Opens an `HttpURLConnection`, sets the request method to GET, checks
the HTTP response code, reads the response line by line using a
`BufferedReader`, and returns the full JSON string. All network
errors are caught and handled with meaningful messages.

### 🔎 extract()
Takes the raw JSON string and a key name as input. Searches for the
key inside the JSON string, extracts its value whether it is a string
or a number, and returns it. Returns `N/A` safely if the key is not found.

### 🖥️ display()
Takes the parsed JSON data string and prints all the Pokemon details
to the console in a clean, formatted layout. Wrapped in try-catch
to handle any unexpected display errors gracefully.

### 🎛️ main()
Entry point of the program. Runs a `do-while` loop showing the menu
continuously until the user selects Exit. Handles invalid menu input
using `NumberFormatException` and empty Pokemon name input with a
validation check.

---

## 🛡️ Error Handling

| Error                  | Cause                          | Message Displayed                        |
|------------------------|--------------------------------|------------------------------------------|
| `MalformedURLException`| Invalid URL format             | Invalid URL format                       |
| `UnknownHostException` | No internet connection         | No internet connection. Check network    |
| HTTP 404               | Pokemon name/ID not found      | Pokemon not found. Check name or ID      |
| Other HTTP codes       | Server-side issues             | Server returned code X                   |
| `NumberFormatException`| Letters typed in menu          | Invalid input. Please enter a number     |
| Empty input            | User pressed Enter with no text| Input cannot be empty. Try again         |
| JSON parse error       | Unexpected JSON structure      | Returns N/A safely                       |

---

## 🌐 API Reference

| Detail       | Info                                        |
|--------------|---------------------------------------------|
| API Name     | PokeAPI                                     |
| Base URL     | `https://pokeapi.co/api/v2/pokemon/`        |
| Method       | GET                                         |
| Auth         | No API key required                         |
| Response     | JSON                                        |
| Example URL  | `https://pokeapi.co/api/v2/pokemon/pikachu` |

---

## 📚 Concepts Used

| Concept              | Class / Method Used                  |
|----------------------|--------------------------------------|
| HTTP Connection      | `HttpURLConnection`, `URL`           |
| Reading Response     | `BufferedReader`, `InputStreamReader`|
| JSON Parsing         | Manual string parsing                |
| User Input           | `Scanner`                            |
| Menu Loop            | `do-while` loop                      |
| Error Handling       | `try-catch`, multiple exception types|
| Input Validation     | `isEmpty()`, `NumberFormatException` |

---

## Output

<img width="1920" height="1020" alt="Image" src="https://github.com/user-attachments/assets/a3cce631-02c0-4637-89b1-dbbe9d674fb7" />

---

## 👩‍🎓 Author

**Vishalini**
B.Tech — Third Year
Java Programming | REST API Client Project
