<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 06.12.2019
  Time: 14:53
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
        <table border="1">
            <caption>Vehicle info</caption>
            <tr>
                <th>Model</th>
                <th>IdCar</th>
                <th>YearIssue</th>
                <th>Price</th>
                <th>Seats</th>
                <th>Rent</th>
            </tr>
            <c:forEach var="vehicle" items="${vehicleList}">
                <tr>
                    <td><c:out value="${vehicle.getModel()}" /></td>
                    <td><c:out value="${vehicle.getId()}" /></td>
                    <td><c:out value="${vehicle.getYearIssue()}" /></td>
                    <td><c:out value="${vehicle.getPrice()}" /></td>
                    <td><c:out value="${vehicle.getSeats()}" /></td>
                    <td><c:out value="${vehicle.getRent()}" /></td>

                    <td>
                        <button onclick="location.href='/vehicles/edit?id=${vehicle.idCar}'">Edit</button> // Was id!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        <form method="post" action='<c:url value="/vehicles/delete" />' style="display:inline;">
                            <input type="hidden" name="id" value="${vehicle.idCar}">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>


<div>
    <button onclick="location.href='/vehicles/add'">Add vehicle</button>
</div>

<div>
    <button onclick="location.href='/'">Log out</button>
</div>
</body>
</html>
