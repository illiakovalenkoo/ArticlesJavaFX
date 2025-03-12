# FeodalShop - JavaFX Article Management Application

**FeodalShop** is a JavaFX-based application that allows users to create and manage articles. The application supports **user authentication** and **database storage via MySQL**.

## 1. How to Download and Run the Project

### **Prerequisites**

To run this project, you need to have:

- **Java Development Kit (JDK) 23+** installed. Download from [Adoptium JDK](https://adoptium.net/) or use OpenJDK.
- **JavaFX SDK 23** installed. Download from [Gluon JavaFX](https://gluonhq.com/products/javafx/) or [OpenJFX](https://openjfx.io/).
- **MySQL Database** installed. You can use [MAMP](https://www.mamp.info/en/) for an easy setup on macOS or Windows.

### **Setting Up the MySQL Database with MAMP**

1. **Install MAMP**:

   - Download and install MAMP from the [official website](https://www.mamp.info/en/).

2. **Start MAMP**:

   - Open the MAMP application and click on "Start Servers".

3. **Access phpMyAdmin**:

   - Click on "Open WebStart page" in MAMP.
   - Navigate to the "Tools" section and select "phpMyAdmin".

4. **Create a New Database**:

   - In phpMyAdmin, go to the "Databases" tab.
   - Enter a name for your database (e.g., `feodalshop_db`) and click "Create".

5. **Create the Necessary Tables**:

   - Select the newly created database.
   - Go to the "SQL" tab and execute the following SQL statements to create the required tables:

     ```sql
     CREATE TABLE users (
         id INT AUTO_INCREMENT PRIMARY KEY,
         username VARCHAR(50) NOT NULL UNIQUE,
         password VARCHAR(255) NOT NULL
     );

     CREATE TABLE articles (
         id INT AUTO_INCREMENT PRIMARY KEY,
         title VARCHAR(255) NOT NULL,
         content TEXT NOT NULL,
         author_id INT,
         FOREIGN KEY (author_id) REFERENCES users(id)
     );
     ```

### **Clone the Repository**

1. **Download the repository**:

   ```sh
   git clone https://github.com/illiakovalenkoo/ArticlesJavaFX.git
   cd ArticlesJavaFX
   ```

### **Configure the Application**

1. **Set Database Connection Properties**:

   - Locate the configuration file (e.g., `config.properties`) in the `src/feodalShop` directory.
   - Update the database connection properties to match your MySQL setup:

     ```
     db.url=jdbc:mysql://localhost:3306/feodalshop_db
     db.username=root
     db.password=root
     ```

### **Run the Application**

- **Option 1: Using the `.jar` file**:

  ```sh
  java -jar feodalShop.jar
  ```

  If JavaFX is missing, use:

  ```sh
  java --module-path "path_to_javafx_sdk/lib" --add-modules javafx.controls,javafx.fxml -jar "path_to_project/feodalShop.jar"
  ```

- **Option 2: Using an IDE**:

  - Open the project in your preferred IDE (e.g., IntelliJ IDEA).
  - Ensure that the JavaFX SDK is properly configured in your project settings.
  - Run the `Main` class located in the `src/feodalShop` directory.

## 2. First-Time Execution Issues

- **Java not installed** → Install **JDK 17+**.
- **JavaFX not found** → Install JavaFX SDK and configure it in your environment.
- **MySQL database not configured** → Ensure MySQL is running, and the database along with the necessary tables are created as described above.

## 3. Project Structure

```
ArticlesJavaFX/                     # Root project directory
│── src/                            # Source code of the application
│── images/                         # Screenshots and images for documentation
│── doc/                            # README.md file
```

## 4. Technologies Used

- **Java 23+**
- **JavaFX 23**
- **MySQL** (via MAMP)
- **Maven** (for project management)
- **JUnit** (for testing)

## 5. Application Testing

The application has been tested for:

- **User authentication and registration**
- **Database integration with MySQL**
- **Creating, editing, and deleting articles**
- **Graphical interface responsiveness**

### `images/` Folder

Screenshots and other images related to the application's UI and functionality are stored in the `images/` folder.

## 6. License

This project is licensed under the **MIT License**. You are free to use, modify, and distribute this software with no restrictions. The software is provided "as is", without warranty of any kind.

🚀 **Happy coding!**
