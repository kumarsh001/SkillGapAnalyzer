<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.skillgap.model.User" %>
        <% User user=(User) session.getAttribute("user"); if (user==null) { response.sendRedirect("login.jsp"); return;
            } %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Dashboard - Skill Gap Analyzer</title>
                <link rel="stylesheet" type="text/css" href="css/style.css">
            </head>

            <body>
                <header>
                    <div class="container">
                        <h1>Skill Gap Analyzer</h1>
                        <nav>
                            <a href="dashboard.jsp">Dashboard</a>
                            <a href="login?logout=true">Logout</a>
                        </nav>
                    </div>
                </header>

                <div class="container">
                    <div class="dashboard-header text-center">
                        <h2>Welcome, <%= user.getUsername() %>!</h2>
                        <p>Let's map out your career journey. Tell us about your goals.</p>
                    </div>

                    <div style="max-width: 600px; margin: 0 auto;">
                        <form action="analyze" method="post" class="roadmap-card">
                            <div class="form-group">
                                <label for="role">Target Job Role</label>
                                <input type="text" id="role" name="role"
                                    placeholder="e.g. Full Stack Developer, Data Scientist" required>
                            </div>

                            <div class="form-group">
                                <label for="experience">Experience Level</label>
                                <select id="experience" name="experience">
                                    <option value="Fresher">Fresher (0-1 Years)</option>
                                    <option value="1-2 Years">Junior (1-2 Years)</option>
                                    <option value="3-5 Years">Mid-Level (3-5 Years)</option>
                                    <option value="5+ Years">Senior (5+ Years)</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="skills">Current Skills</label>
                                <textarea id="skills" name="skills" rows="4" placeholder="e.g. Java, HTML, CSS, MySQL"
                                    required></textarea>
                                <small style="color: var(--text-secondary); display: block; margin-top: 5px;">Separate
                                    skills with commas</small>
                            </div>

                            <button type="submit" class="mt-4">Generate Roadmap</button>
                        </form>
                    </div>
                </div>
            </body>

            </html>