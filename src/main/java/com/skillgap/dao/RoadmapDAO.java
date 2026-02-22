package com.skillgap.dao;

import com.skillgap.model.Roadmap;
import com.skillgap.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoadmapDAO {

    public boolean saveRoadmap(Roadmap roadmap) {
        String sql = "INSERT INTO roadmaps (user_id, target_role, current_skills, experience_level, ai_response_json) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, roadmap.getUserId());
            stmt.setString(2, roadmap.getTargetRole());
            stmt.setString(3, roadmap.getCurrentSkills());
            stmt.setString(4, roadmap.getExperienceLevel());
            stmt.setString(5, roadmap.getAiResponseJson());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
