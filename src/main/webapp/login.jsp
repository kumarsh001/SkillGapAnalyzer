<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - Skill Gap Analyzer</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>

    <body>
        <header>
            <h1>Skill Gap Analyzer</h1>
        </header>
        <div class="auth-wrapper">
            <div class="auth-container">
                <h2>Login</h2>
                <% String error=(String) request.getAttribute("error"); if (error !=null) { %>
                    <div class="error">
                        <%= error %>
                    </div>
                    <% } %>
                        <% if (request.getParameter("registered") !=null) { %>
                            <div class="success">Registration successful! Please login.</div>
                            <% } %>
                                <form action="login" method="post">
                                    <div class="form-group">
                                        <label for="username">Username</label>
                                        <input type="text" id="username" name="username"
                                            placeholder="Enter your username" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" id="password" name="password"
                                            placeholder="Enter your password" required>
                                    </div>
                                    <button type="submit">Sign In</button>
                                </form>
                                <p class="text-center mt-4" style="font-size: 0.9rem; color: var(--text-secondary);">
                                    Don't have an account? <a href="register.jsp"
                                        style="color: var(--primary-color); font-weight: 600;">Register here</a>
                                </p>
            </div>
        </div>
    </body>

    </html>