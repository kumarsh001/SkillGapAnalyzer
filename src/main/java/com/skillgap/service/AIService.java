package com.skillgap.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AIService {

    // Helper method to call AI (e.g., OpenAI or similar)
    // For now, this is a mock implementation or a generic structure
    public String generateRoadmap(String currentSkills, String targetRole, String experienceLevel) {
        String lowerSkills = currentSkills.toLowerCase();
        String lowerRole = targetRole.toLowerCase();
        
        java.util.List<String> missingCoreSkills = new java.util.ArrayList<>();
        java.util.List<String> missingAdvancedSkills = new java.util.ArrayList<>();
        java.util.List<String> projects = new java.util.ArrayList<>();
        java.util.List<String> youtubeLinks = new java.util.ArrayList<>();
        String tips = "Focus on building a strong portfolio.";

        // Basic Rule Engine
        if (lowerRole.contains("java") && !lowerRole.contains("javascript")) {
            // Core Skills
            if (!lowerSkills.contains("core java")) missingCoreSkills.add("Core Java (Streams, Collections)");
            if (!lowerSkills.contains("spring boot")) missingCoreSkills.add("Spring Boot");
            if (!lowerSkills.contains("hibernate") && !lowerSkills.contains("jpa")) missingCoreSkills.add("Hibernate/JPA");
            if (!lowerSkills.contains("sql")) missingCoreSkills.add("SQL Basics");

            // Advanced Skills
            if (!lowerSkills.contains("microservices")) missingAdvancedSkills.add("Microservices Architecture");
            if (!lowerSkills.contains("docker")) missingAdvancedSkills.add("Docker & Kubernetes");
            if (!lowerSkills.contains("kafka")) missingAdvancedSkills.add("Apache Kafka");
            if (!lowerSkills.contains("cloud")) missingAdvancedSkills.add("AWS/Cloud Deployment");
            
            projects.add("E-commerce REST API with Spring Boot");
            projects.add("Microservices-based Task Manager");

            youtubeLinks.add("https://www.youtube.com/user/Java/videos");
            youtubeLinks.add("https://www.youtube.com/c/Amigoscode");
        } else if (lowerRole.contains("front") || lowerRole.contains("react") || lowerRole.contains("web") || lowerRole.contains("angular") || lowerRole.contains("vue")) {
            // Core Skills
            if (!lowerSkills.contains("html")) missingCoreSkills.add("HTML5 & Accessibility");
            if (!lowerSkills.contains("css")) missingCoreSkills.add("CSS3, Flexbox & Tailwind");
            if (!lowerSkills.contains("javascript")) missingCoreSkills.add("Modern JavaScript (ES6+)");
            if (!lowerSkills.contains("react") && !lowerSkills.contains("angular") && !lowerSkills.contains("vue")) missingCoreSkills.add("Frontend Framework (React/Angular/Vue)");

            // Advanced Skills
            if (!lowerSkills.contains("typescript")) missingAdvancedSkills.add("TypeScript");
            if (!lowerSkills.contains("state management")) missingAdvancedSkills.add("State Management (Redux/NgRx/Vuex)");
            if (!lowerSkills.contains("next") && !lowerSkills.contains("ssr")) missingAdvancedSkills.add("SSR/SSG Frameworks (Next.js)");
            if (!lowerSkills.contains("testing")) missingAdvancedSkills.add("Frontend Testing (Jest/Cypress)");
            
            projects.add("Interactive Dashboard with Analytics");
            projects.add("E-commerce Storefront with Cart Strategy");

            youtubeLinks.add("https://www.youtube.com/c/TraversyMedia");
            youtubeLinks.add("https://www.youtube.com/c/WebDevSimplified");
        } else if (lowerRole.contains("data") || lowerRole.contains("machine learning") || lowerRole.contains("ai ")) {
            // Core Skills
            if (!lowerSkills.contains("python")) missingCoreSkills.add("Python Programming");
            if (!lowerSkills.contains("sql")) missingCoreSkills.add("Advanced SQL & Database Design");
            if (!lowerSkills.contains("pandas")) missingCoreSkills.add("Data Manipulation (Pandas/NumPy)");

            // Advanced Skills
            if (!lowerSkills.contains("machine learning")) missingAdvancedSkills.add("Machine Learning Algorithms");
            if (!lowerSkills.contains("deep learning")) missingAdvancedSkills.add("Deep Learning (TensorFlow/PyTorch)");
            if (!lowerSkills.contains("big data") && !lowerSkills.contains("spark")) missingAdvancedSkills.add("Big Data Technologies (Spark)");
            
            projects.add("Predictive Model with API Integration");
            projects.add("Automated Data Pipeline & Dashboard");

            youtubeLinks.add("https://www.youtube.com/c/KrishNaik");
            youtubeLinks.add("https://www.youtube.com/c/joshstarmer");
        } else if (lowerRole.contains("node") || lowerRole.contains("express") || lowerRole.contains("backend") || lowerRole.contains("api")) {
            // Core Skills
            if (!lowerSkills.contains("javascript") && !lowerSkills.contains("typescript")) missingCoreSkills.add("JavaScript/TypeScript Basics");
            if (!lowerSkills.contains("node") && !lowerSkills.contains("express")) missingCoreSkills.add("Node.js & Express framework");
            if (!lowerSkills.contains("database") && !lowerSkills.contains("nosql")) missingCoreSkills.add("Database Management (MongoDB)");
            if (!lowerSkills.contains("api")) missingCoreSkills.add("RESTful API Design");

            // Advanced Skills
            if (!lowerSkills.contains("auth")) missingAdvancedSkills.add("Authentication & Authorization (JWT)");
            if (!lowerSkills.contains("caching")) missingAdvancedSkills.add("Caching Strategies (Redis)");
            if (!lowerSkills.contains("microservices")) missingAdvancedSkills.add("Microservices Architecture");
            if (!lowerSkills.contains("docker")) missingAdvancedSkills.add("Containerization (Docker)");
            
            projects.add("Scalable REST API with JWT Auth");
            projects.add("Real-time App using WebSockets");

            youtubeLinks.add("https://www.youtube.com/c/HusseinNasser");
            youtubeLinks.add("https://www.youtube.com/c/ProgrammingWithMosh");
        } else if (lowerRole.contains("devops") || lowerRole.contains("sre") || lowerRole.contains("cloud")) {
            // Core Skills
            if (!lowerSkills.contains("linux")) missingCoreSkills.add("Linux Fundamentals & Shell Scripting");
            if (!lowerSkills.contains("git")) missingCoreSkills.add("Version Control & GitOps");
            if (!lowerSkills.contains("ci/cd")) missingCoreSkills.add("CI/CD Pipelines (Jenkins/GitHub Actions)");
            if (!lowerSkills.contains("cloud")) missingCoreSkills.add("Cloud Provider Basics (AWS/Azure/GCP)");

            // Advanced Skills
            if (!lowerSkills.contains("docker")) missingAdvancedSkills.add("Containerization (Docker)");
            if (!lowerSkills.contains("kubernetes")) missingAdvancedSkills.add("Container Orchestration (Kubernetes)");
            if (!lowerSkills.contains("terraform") && !lowerSkills.contains("iac")) missingAdvancedSkills.add("Infrastructure as Code (Terraform)");
            if (!lowerSkills.contains("monitoring")) missingAdvancedSkills.add("Monitoring & Logging (Prometheus/Grafana)");
            
            projects.add("Automated CI/CD Pipeline for a Microservice");
            projects.add("Infrastructure Provisioning using Terraform");

            youtubeLinks.add("https://www.youtube.com/c/TechWorldwithNana");
            youtubeLinks.add("https://www.youtube.com/c/NetworkChuck");
        } else if (lowerRole.contains("mobile") || lowerRole.contains("android") || lowerRole.contains("ios") || lowerRole.contains("flutter") || lowerRole.contains("react native")) {
            // Core Skills
            if (!lowerSkills.contains("ui")) missingCoreSkills.add("Mobile UI/UX Design Principles");
            if (!lowerRole.contains("ios") && !lowerSkills.contains("java") && !lowerSkills.contains("kotlin") && !lowerSkills.contains("dart")) missingCoreSkills.add("Mobile Programming");
            if (lowerRole.contains("ios") && !lowerSkills.contains("swift")) missingCoreSkills.add("iOS Programming (Swift)");
            if (!lowerSkills.contains("api")) missingCoreSkills.add("REST API Integration");

            // Advanced Skills
            if (!lowerSkills.contains("state management")) missingAdvancedSkills.add("Advanced State Management");
            if (!lowerSkills.contains("local storage")) missingAdvancedSkills.add("Local Database (SQLite/Room/CoreData)");
            if (!lowerSkills.contains("architecture")) missingAdvancedSkills.add("Mobile Architecture (MVVM/Clean)");
            if (!lowerSkills.contains("publishing")) missingAdvancedSkills.add("App Store/Play Store Publishing");
            
            projects.add("Cross-Platform Utility Application");
            projects.add("Social Media Clone with Real-time Updates");

            youtubeLinks.add("https://www.youtube.com/c/ResoCoder");
            youtubeLinks.add("https://www.youtube.com/c/PhilippLackner");
        } else if (lowerRole.contains("security") || lowerRole.contains("cyber") || lowerRole.contains("penetration")) {
            // Core Skills
            if (!lowerSkills.contains("networking")) missingCoreSkills.add("Computer Networking (TCP/IP, HTTP)");
            if (!lowerSkills.contains("linux")) missingCoreSkills.add("Linux/Unix Administration");
            if (!lowerSkills.contains("owasp")) missingCoreSkills.add("OWASP Top 10 Vulnerabilities");
            if (!lowerSkills.contains("scripting")) missingCoreSkills.add("Security Scripting (Python/Bash)");

            // Advanced Skills
            if (!lowerSkills.contains("ethical hacking")) missingAdvancedSkills.add("Ethical Hacking & Penetration Testing");
            if (!lowerSkills.contains("cryptography")) missingAdvancedSkills.add("Applied Cryptography");
            if (!lowerSkills.contains("incident response")) missingAdvancedSkills.add("Incident Response & Forensics");
            if (!lowerSkills.contains("cloud security")) missingAdvancedSkills.add("Cloud Security Posture Management");
            
            projects.add("Vulnerability Assessment Report on Test Network");
            projects.add("Automated Security Scanning Script");

            youtubeLinks.add("https://www.youtube.com/c/NetworkChuck");
            youtubeLinks.add("https://www.youtube.com/c/DavidBombal");
        } else if (lowerRole.contains("python") || lowerRole.contains("django") || lowerRole.contains("flask")) {
            // Core Skills
            if (!lowerSkills.contains("python")) missingCoreSkills.add("Python Advanced Concepts");
            if (!lowerSkills.contains("framework")) missingCoreSkills.add("Web Framework (Django or Flask)");
            if (!lowerSkills.contains("database")) missingCoreSkills.add("Database Integration (SQLAlchemy/Django ORM)");
            if (!lowerSkills.contains("api")) missingCoreSkills.add("REST API Development");

            // Advanced Skills
            if (!lowerSkills.contains("celery")) missingAdvancedSkills.add("Asynchronous Task Queues (Celery/Redis)");
            if (!lowerSkills.contains("testing")) missingAdvancedSkills.add("Unit Testing (PyTest)");
            if (!lowerSkills.contains("docker")) missingAdvancedSkills.add("Application Containerization (Docker)");
            if (!lowerSkills.contains("security")) missingAdvancedSkills.add("Web Application Security");
            
            projects.add("High-Traffic API with Celery Background Tasks");
            projects.add("Django E-Commerce with Payment Gateway Integration");

            youtubeLinks.add("https://www.youtube.com/c/Coreyms");
            youtubeLinks.add("https://www.youtube.com/c/ArjanCodes");
        } else if (lowerRole.contains("c#") || lowerRole.contains(".net") || lowerRole.contains("dotnet")) {
            // Core Skills
            if (!lowerSkills.contains("c#")) missingCoreSkills.add("Advanced C# & LINQ");
            if (!lowerSkills.contains("asp")) missingCoreSkills.add("ASP.NET Core Basics");
            if (!lowerSkills.contains("entity framework") && !lowerSkills.contains("ef ")) missingCoreSkills.add("Entity Framework Core");
            if (!lowerSkills.contains("sql")) missingCoreSkills.add("SQL Server Fundamentals");

            // Advanced Skills
            if (!lowerSkills.contains("microservices")) missingAdvancedSkills.add("Microservices with .NET");
            if (!lowerSkills.contains("azure")) missingAdvancedSkills.add("Azure Cloud Services Integration");
            if (!lowerSkills.contains("testing")) missingAdvancedSkills.add("xUnit & Moq for Testing");
            if (!lowerSkills.contains("ci/cd")) missingAdvancedSkills.add("Azure DevOps & CI/CD");
            
            projects.add("Enterprise Web API with ASP.NET Core");
            projects.add("Full Stack Application with Blazor or Angular");

            youtubeLinks.add("https://www.youtube.com/c/IAmTimCorey");
            youtubeLinks.add("https://www.youtube.com/c/NickChapsas");
        } else if (lowerRole.contains("qa") || lowerRole.contains("test") || lowerRole.contains("automation")) {
            // Core Skills
            if (!lowerSkills.contains("manual")) missingCoreSkills.add("Manual Testing Fundamentals & Test Cases");
            if (!lowerSkills.contains("agile")) missingCoreSkills.add("Agile Methodologies (Scrum/Kanban)");
            if (!lowerSkills.contains("programming")) missingCoreSkills.add("Programming Basics (Java/Python/JS)");
            if (!lowerSkills.contains("api testing")) missingCoreSkills.add("API Testing (Postman/SoapUI)");

            // Advanced Skills
            if (!lowerSkills.contains("selenium") && !lowerSkills.contains("cypress")) missingAdvancedSkills.add("UI Automation (Selenium/Cypress)");
            if (!lowerSkills.contains("ci/cd")) missingAdvancedSkills.add("Continuous Testing in CI/CD");
            if (!lowerSkills.contains("performance")) missingAdvancedSkills.add("Performance Testing (JMeter)");
            if (!lowerSkills.contains("bdd")) missingAdvancedSkills.add("BDD Frameworks (Cucumber)");
            
            projects.add("End-to-End Automation Framework from Scratch");
            projects.add("Comprehensive API Test Suite Implementation");

            youtubeLinks.add("https://www.youtube.com/c/NaveenAutomationLabs");
            youtubeLinks.add("https://www.youtube.com/c/ExecuteAutomation");
        }
        
        // Comprehensive Fallback for any other IT Role requested by the user
        if (missingCoreSkills.isEmpty() && missingAdvancedSkills.isEmpty()) {
            String formattedRole = targetRole.length() > 0 ? targetRole.substring(0, 1).toUpperCase() + targetRole.substring(1) : "IT Role";

            missingCoreSkills.add(formattedRole + " Fundamentals & Theory");
            missingCoreSkills.add("Core Tools & Ecosystem for " + formattedRole);
            missingCoreSkills.add("Industry Best Practices & Standards");
            missingCoreSkills.add("Basic Troubleshooting & Problem Solving");

            missingAdvancedSkills.add("Advanced " + formattedRole + " Architectures");
            missingAdvancedSkills.add("Performance Optimization & Scalability");
            missingAdvancedSkills.add("Security & System Design in " + formattedRole);
            missingAdvancedSkills.add("Integration & Automation Techniques");
            
            projects.add("Build a comprehensive " + formattedRole + " Prototype");
            projects.add("Real-world " + formattedRole + " Implementation matching industry standards");

            String searchParam = targetRole.replace(" ", "+");
            youtubeLinks.add("https://www.youtube.com/results?search_query=" + searchParam + "+full+course");
            youtubeLinks.add("https://www.youtube.com/results?search_query=" + searchParam + "+interview+questions");
            youtubeLinks.add("https://www.youtube.com/results?search_query=" + searchParam + "+projects+for+beginners");
        }

        // Generate Roadmap JSON dynamically
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        
        // Core Skills
        json.append("  \"missing_core_skills\": [");
        for (int i = 0; i < missingCoreSkills.size(); i++) {
            json.append("\"").append(missingCoreSkills.get(i)).append("\"");
            if (i < missingCoreSkills.size() - 1) json.append(", ");
        }
        json.append("],\n");

        // Advanced Skills
        json.append("  \"missing_advanced_skills\": [");
        for (int i = 0; i < missingAdvancedSkills.size(); i++) {
            json.append("\"").append(missingAdvancedSkills.get(i)).append("\"");
            if (i < missingAdvancedSkills.size() - 1) json.append(", ");
        }
        json.append("],\n");
        
        // Roadmap construction (combining both for the timeline)
        java.util.List<String> allMissing = new java.util.ArrayList<>(missingCoreSkills);
        allMissing.addAll(missingAdvancedSkills);

        json.append("  \"roadmap\": [\n");
        int week = 1;
        for (String skill : allMissing) {
            json.append("    {\"week\": \"").append(week).append("-").append(week + 1).append("\", \"focus\": \"Mastering ").append(skill).append("\"}");
            if (allMissing.indexOf(skill) < allMissing.size() - 1) json.append(",\n");
            week += 2;
        }
        json.append("\n  ],\n");

        json.append("  \"projects\": [");
        for (int i = 0; i < projects.size(); i++) {
            json.append("\"").append(projects.get(i)).append("\"");
            if (i < projects.size() - 1) json.append(", ");
        }
        json.append("],\n");

        json.append("  \"youtube_links\": [");
        for (int i = 0; i < youtubeLinks.size(); i++) {
            json.append("\"").append(youtubeLinks.get(i)).append("\"");
            if (i < youtubeLinks.size() - 1) json.append(", ");
        }
        json.append("],\n");
        
        json.append("  \"tips\": \"Based on your experience level (" + experienceLevel + "), ensure you understand the 'Why' behind these technologies.\"\n");
        json.append("}");

        return json.toString();
    }
}
