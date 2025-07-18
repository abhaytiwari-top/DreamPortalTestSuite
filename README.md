## Please view README.md Code for better display


# 🧪 Dream Portal Automation - QA Intern Assignment

This project is an automated UI testing suite for the [Dream Portal Website](https://arjitnigam.github.io/myDreams/), built using **Selenium (Java)** and **TestNG** with the **Page Object Model (POM)** design pattern.

---

## 📌 Objective

Automate functional tests for the following pages:

- `index.html`: Home page
- `dreams-diary.html`: Dream table
- `dreams-total.html`: Dream summary

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- WebDriverManager
- HTML Report
- Maven (Project build)
- POM (Page Object Model)

---

## 🧪 Test Coverage

### ✅ index.html — Dream Portal Home
- Loader visible for ~3 seconds
- Main content and “My Dreams” button visible
- Clicking “My Dreams” opens both dream pages in new tabs/windows

### ✅ dreams-diary.html — Dream Log
- Exactly 10 dream entries
- Dream types only “Good” or “Bad”
- All 3 columns are filled
- “Flying over mountains” and “Lost in maze” are recurring dreams

### ✅ dreams-total.html — Summary Page
- Good Dreams: 6
- Bad Dreams: 4
- Total Dreams: 10
- Recurring Dreams: 2

---

## 📷 Screenshots

Screenshots will be auto-captured for failed tests and saved in `screenshots/` folder.

---

## 📊 Reporting

After test execution, open the HTML report in a browser:
HTML reports are generated in `/target/surefire-reports/index.html`.  

---

## Project Highlights

- Uses **Page Object Model (POM)** for maintainable test code
- Automatically manages WebDriver binaries using **WebDriverManager**
- Captures **screenshots on test failures**
- Generates **HTML reports** for easy test result analysis


## Contact

For questions or help, contact -Abhay Tiwari- at <tiwarisabhay1@gmail.com>.

---

Thank you for using DreamPortalTest Automation!
#   D r e a m P o r t a l T e s t 
 
 
