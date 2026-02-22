<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.skillgap.model.User" %>
        <%@ page import="com.skillgap.model.Roadmap" %>
            <% User user=(User) session.getAttribute("user"); if (user==null) { response.sendRedirect("login.jsp");
                return; } String aiResponse=(String) request.getAttribute("aiResponse"); Roadmap roadmap=(Roadmap)
                request.getAttribute("roadmap"); if (roadmap==null) { response.sendRedirect("dashboard.jsp"); return; }
                %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Your Roadmap - Skill Gap Analyzer</title>
                    <link rel="stylesheet" type="text/css" href="css/style.css">
                    <style>
                        .section {
                            margin-bottom: 20px;
                        }

                        .badge {
                            background: #e9ecef;
                            padding: 5px 10px;
                            border-radius: 15px;
                            margin-right: 5px;
                            display: inline-block;
                        }

                        .roadmap-week {
                            background: #f8f9fa;
                            padding: 10px;
                            border-left: 4px solid #28a745;
                            margin-bottom: 10px;
                        }
                    </style>
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
                        <div class="dashboard-header">
                            <h2>Career Roadmap: <span style="color: var(--primary-color);">
                                    <%= roadmap.getTargetRole() %>
                                </span></h2>
                            <p>Here is your personalized path to success.</p>
                        </div>

                        <div id="results-container">
                            <p class="text-center">Loading analysis...</p>
                        </div>

                        <script>
                            try {
                                const aiData = <%= aiResponse %>;
                                const container = document.getElementById('results-container');

                                let html = '<div class="section"><h3>Missing Core Skills</h3>';
                                html += '<div>';
                                if (aiData.missing_core_skills && aiData.missing_core_skills.length > 0) {
                                    aiData.missing_core_skills.forEach(skill => {
                                        html += '<span class="badge" style="background-color: #fffbeb; color: #b45309; border: 1px solid #fcd34d;">' + skill + '</span>';
                                    });
                                } else {
                                    html += '<p style="color: var(--text-secondary);">You have a solid foundation! No core skill gaps.</p>';
                                }
                                html += '</div></div>';

                                html += '<div class="section"><h3>Missing Advanced Skills</h3>';
                                html += '<div>';
                                if (aiData.missing_advanced_skills && aiData.missing_advanced_skills.length > 0) {
                                    aiData.missing_advanced_skills.forEach(skill => {
                                        html += '<span class="badge" style="background-color: #fef2f2; color: #b91c1c; border: 1px solid #fecaca;">' + skill + '</span>';
                                    });
                                } else {
                                    html += '<p style="color: var(--text-secondary);">You are doing great! No advanced skill gaps.</p>';
                                }
                                html += '</div></div>';

                                html += '<div class="section"><h3>Recommended Study Resources</h3><div class="recommendations"><ul>';
                                if (aiData.youtube_links && aiData.youtube_links.length > 0) {
                                    aiData.youtube_links.forEach(link => {
                                        html += '<li><a href="' + link + '" target="_blank">📺 Watch Tutorial</a> <span style="color: var(--text-secondary); font-size: 0.9em;">(' + link + ')</span></li>';
                                    });
                                } else {
                                    html += '<li>No specific video links found.</li>';
                                }
                                html += '</ul></div></div>';

                                html += '<div class="section"><h3>3-Month Action Plan</h3>';
                                if (aiData.roadmap) {
                                    aiData.roadmap.forEach(item => {
                                        html += '<div class="roadmap-week"><strong style="color: var(--primary-color);">Week ' + item.week + ':</strong> ' + item.focus + '</div>';
                                    });
                                }
                                html += '</div>';

                                html += '<div class="section"><h3>Suggested Projects</h3><ul style="padding-left: 20px; color: var(--text-secondary);">';
                                if (aiData.projects) {
                                    aiData.projects.forEach(project => {
                                        html += '<li style="margin-bottom: 5px;">' + project + '</li>';
                                    });
                                }
                                html += '</ul></div>';

                                html += '<div class="section" style="background-color: #f0fdf4; border-color: #bbf7d0;"><h3>💡 Pro Tip</h3><p style="margin: 0; color: #166534;">' + aiData.tips + '</p></div>';

                                container.innerHTML = html;
                            } catch (e) {
                                console.error("Error parsing JSON", e);
                                document.getElementById('results-container').innerHTML = "<div class='error text-center'>Error loading roadmap. Please try again.</div>";
                            }
                        </script>

                        <div class="mt-4 mb-4">
                            <a href="dashboard.jsp" class="button"
                                style="background-color: var(--secondary-color); text-decoration:none; display: inline-block; width: auto;">
                                &larr; Back to Dashboard
                            </a>
                        </div>
                    </div>
                </body>

                </html>