<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register - Skill Gap Analyzer</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>

    <body>
        <header>
            <h1>Skill Gap Analyzer</h1>
        </header>
        <div class="auth-wrapper">
            <div class="auth-container">
                <h2>Create Account</h2>
                <% String error=(String) request.getAttribute("error"); if (error !=null) { %>
                    <div class="error">
                        <%= error %>
                    </div>
                    <% } %>
                        <form action="register" method="post">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" id="username" name="username" placeholder="Choose a username"
                                    required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email Address</label>
                                <input type="email" id="email" name="email" placeholder="name@example.com" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" id="password" name="password"
                                    placeholder="Choose a strong password" required>
                            </div>
                            <button type="submit">Register</button>
                        </form>
                        <p class="text-center mt-4" style="font-size: 0.9rem; color: var(--text-secondary);">
                            Already have an account? <a href="login.jsp"
                                style="color: var(--primary-color); font-weight: 600;">Login here</a>
                        </p>
            </div>
        </div>
    </body>

    </html>