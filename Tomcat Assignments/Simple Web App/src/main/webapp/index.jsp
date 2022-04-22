<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>RandomWebsite.Something</title>
    </head>
    <body>
        <h1>Welcome To RandomWebsite.Something</h1>
        <p>please login here:</p>
        <form action="MyServlet">
		  <label for="username">User Name:</label>
		  <input type="text" id="username" name="username"><br><br>
		  <label for="password">Password:</label>
		  <input type="text" id="password" name="password"><br><br>
		  <input type="submit" value="Submit">
		</form>
    </body>
</html>