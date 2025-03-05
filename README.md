# 📖 Project Overview
**FeodalShop** is a **JavaFX-based** application that allows users to create and manage articles.  
The application supports **user authentication** and **database storage via MySQL (MAMP)**.  

---

## 🚀 Features
✔ **User registration and authentication**  
✔ **Create, edit, and delete articles**  
✔ **MySQL database integration (via MAMP)**  
✔ **JavaFX modern UI**  

---

## 🛠 How It Works
1. **Register or log in** to the system.
2. **Create an article** by entering the title and content.
3. **Save the article** to the MySQL database.
4. **View and manage** articles via the UI.

**Example:**
- User **logs in** and adds an article titled **"My First Post"**.
- The article is saved in the database.
- The user can **edit or delete** the article.

---

## 📦 System Requirements

### **1️⃣ Java Development Kit (JDK)**
- Download **JDK 17+**: [Adoptium JDK](https://adoptium.net/)  
- Verify installation:
  
  ```sh
  java -version
  ```

### **2️⃣ JavaFX SDK**
- Download **JavaFX 17 SDK**: [Gluon JavaFX](https://gluonhq.com/products/javafx/)  
- Extract and set up JavaFX libraries.

### **3️⃣ MySQL (via MAMP)**
- Install **MAMP**: [Download MAMP](https://www.mamp.info/en/)  
- Create the database using:
  
  ```sql
  CREATE DATABASE feodalshop_db;
  ```

---

## ⚙️ Configuration

1. Open **`DB.java`** and modify the database connection settings:
   
   ```java
   String url = "jdbc:mysql://localhost:8889/feodalshop_db";
   String user = "root";
   String password = "root";
   ```

2. Save the file.

---

## 💻 How to Run the Application

### **Option 1: Running from IntelliJ IDEA**
1. Open the project in **IntelliJ IDEA**.
2. Ensure **JavaFX SDK and MySQL Connector JARs** are loaded in dependencies.
3. Run the **`HelloApplication`** class.

### **Option 2: Running as a JAR**
1. **Build the project** using Maven:
   
   ```sh
   mvn clean package
   ```

2. **Run the JAR file**:
   
   ```sh
   java --module-path "C:\path\to\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar target/feodalShop.jar
   ```

### **Option 3: Running as an EXE (Windows)**
1. Use **Launch4j** to generate an .exe file.
2. Run **feodalShop.exe**.

---

## 🛠 Built With
- **Java 17+**
- **JavaFX 17**
- **MySQL (via MAMP)**
- **Maven**

---

## 📜 License
This project is licensed under the **MIT License** – feel free to use and modify it.  

🚀 **Happy coding!**
