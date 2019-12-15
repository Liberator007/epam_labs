<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 15.12.2019
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cars</title>
</head>
<body>
<div>
  <div>
    <table border="1">
      <caption>Car info</caption>
      <tr>
        <th>Model</th>
        <th>Id</th>
        <th>Year Issue</th>
        <th>Price</th>
        <th>Seats</th>
        <th>Rent</th>
        <th>Fuel</th>
      </tr>
      <c:forEach var="car" items="${listCar}">
        <tr>
          <td><c:out value="${car.setModel()}" /></td>
          <td><c:out value="${car.setId()}" /></td>
          <td><c:out value="${car.setYearIssue()}" /></td>
          <td><c:out value="${car.setPrice()}" /></td>
          <td><c:out value="${car.setSeats()}" /></td>
          <td><c:out value="${car.setRent()}" /></td>
          <td><c:out value="${car.getFuel().toString()}" /></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>
