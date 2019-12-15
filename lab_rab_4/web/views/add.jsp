<%--
  Created by IntelliJ IDEA.
  User: Aleksey
  Date: 08.12.2019
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Rental</title>
</head>

<body>
<div>
    <h1>Car Rental</h1>
</div>

<div>
    <div>
        <div>
            <h2>Add car</h2>
        </div>

        <form method="post">
            <label>Model:
                <input type="text" name="model"><br />
            </label>
            <label>IdCar:
                <input type="text" name="idCar"><br />
            </label>
            <label>YearIssue:
                <input type="number" min="1980" max="2019" step="1" name="yearIssue"><br />
            </label>
            <label>Price:
                <input type="number" name="price" step="0.1"><br />
            </label>
            <label>Seats:
                <input type="number" name="seats"><br />
            </label>
            <label>Rent:
                <input type="number" name="rent"><br />
            </label>
            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/vehicles'">Back to main</button>
</div>
</body>
</html>
