package com.skillgap.model;

import java.sql.Timestamp;

public class Roadmap {
    private int id;
    private int userId;
    private String targetRole;
    private String currentSkills;
    private String experienceLevel;
    private String aiResponseJson;
    private Timestamp createdAt;

    public Roadmap() {}

    public Roadmap(int userId, String targetRole, String currentSkills, String experienceLevel, String aiResponseJson) {
        this.userId = userId;
        this.targetRole = targetRole;
        this.currentSkills = currentSkills;
        this.experienceLevel = experienceLevel;
        this.aiResponseJson = aiResponseJson;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getTargetRole() { return targetRole; }
    public void setTargetRole(String targetRole) { this.targetRole = targetRole; }
    
    public String getCurrentSkills() { return currentSkills; }
    public void setCurrentSkills(String currentSkills) { this.currentSkills = currentSkills; }

    public String getExperienceLevel() { return experienceLevel; }
    public void setExperienceLevel(String experienceLevel) { this.experienceLevel = experienceLevel; }

    public String getAiResponseJson() { return aiResponseJson; }
    public void setAiResponseJson(String aiResponseJson) { this.aiResponseJson = aiResponseJson; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
