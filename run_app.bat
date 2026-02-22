@echo off
echo Starting script...
echo Current Directory: %CD%
echo Setting up local Maven environment...
if not exist "%~dp0apache-maven-3.9.6\bin\mvn.cmd" (
    echo [ERROR] Maven executable not found at "%~dp0apache-maven-3.9.6\bin\mvn.cmd"
    echo Please make sure you extracted the files correctly.
    pause
    exit /b 1
)
set "MAVEN_HOME=%~dp0apache-maven-3.9.6"
set "PATH=%MAVEN_HOME%\bin;%PATH%"

echo Checking for Java...
java -version
if %errorlevel% neq 0 (
    echo [ERROR] Java is not installed or not in your PATH.
    echo Please install Java JDK and try again.
    pause
    exit /b 1
)

echo Checking for MySQL...
mysql --version >nul 2>&1
if %errorlevel% neq 0 (
    echo [WARNING] MySQL is not detected in your PATH.
    echo Please ensure MySQL Server is installed and running.
    echo If installed, add it to your PATH or update src/main/resources/db.properties.
)

echo Starting Skill Gap Analyzer on port 8081...
mvn clean jetty:run
pause
