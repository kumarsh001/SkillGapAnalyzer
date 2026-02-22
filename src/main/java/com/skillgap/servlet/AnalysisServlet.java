package com.skillgap.servlet;

import com.skillgap.dao.RoadmapDAO;
import com.skillgap.model.Roadmap;
import com.skillgap.model.User;
import com.skillgap.service.AIService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/analyze")
public class AnalysisServlet extends HttpServlet {
    private AIService aiService;
    private RoadmapDAO roadmapDAO;

    public void init() {
        aiService = new AIService();
        roadmapDAO = new RoadmapDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;
        
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String currentSkills = request.getParameter("skills");
        String targetRole = request.getParameter("role");
        String experienceLevel = request.getParameter("experience");

        String aiResponseJson = aiService.generateRoadmap(currentSkills, targetRole, experienceLevel);

        Roadmap roadmap = new Roadmap(user.getId(), targetRole, currentSkills, experienceLevel, aiResponseJson);
        roadmapDAO.saveRoadmap(roadmap);

        // Pass the result to the JSP
        request.setAttribute("aiResponse", aiResponseJson);
        request.setAttribute("roadmap", roadmap);
        request.getRequestDispatcher("roadmap.jsp").forward(request, response);
    }
}
