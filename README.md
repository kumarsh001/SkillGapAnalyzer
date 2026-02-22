# Skill Gap Analyzer

Web application to analyze skill gaps and generate career roadmaps.

## Prerequisites

- **Java JDK 17** or higher (must be in your system PATH)
- **MySQL Server** (must be installed and running)

## Database Setup

1. Log in to your MySQL server.
2. Create the database:
   ```sql
   CREATE DATABASE skill_gap_db;
   ```
3. Run the schema script located at `sql/schema.sql` to create the necessary tables.
4. (Optional) If your MySQL root password is not `root`, update the `src/main/resources/db.properties` file:
   ```properties
   db.url=jdbc:mysql://localhost:3306/skill_gap_db
   db.username=your_username
   db.password=your_password
   ```

## How to Run

### Windows

Simply double-click or run the `run_app.bat` script in the terminal:

```cmd
.\run_app.bat
```

This script will:
1. Set up a local Maven environment.
2. Check for Java and MySQL.
3. Build and start the application using the Jetty server on port 8081.

### Accessing the Application

**Local Access:**
Open your browser and navigate to: [http://localhost:8081](http://localhost:8081)

**Mobile Access (Local Network):**
To access the app from your mobile device (must be on the same Wi-Fi):
1.  Navigate to: **[http://192.168.1.14:8081](http://192.168.1.14:8081)**
2.  If you cannot connect, ensure your Windows Firewall allows inbound connections on port 8081.

## Project Structure

- `src/main/java`: Java source code (Servlets, Models, Services)
- `src/main/webapp`: JSP pages, CSS, and other web resources
- `src/main/resources`: Configuration files (db.properties)
- `sql`: Database schema scripts
