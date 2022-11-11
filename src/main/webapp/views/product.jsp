<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/11/2022
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Import Price</th>
        <th>Descriptions</th>
        <th>Product Status</th>
        <th>Date Input Product</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="pro">
        <tr>
            <td>${pro.productId}</td>
            <td>${pro.productName}</td>
            <td>${pro.importPrice}</td>
            <td>${pro.descriptions}</td>
            <td>${pro.productStatus?"Saling":"Not sale"}</td>
            <td><fmt:formatDate value="${pro.dateInputProduct}" pattern="dd-MM-yyyy"></fmt:formatDate> </td>
            <td>
                <a href="<%=request.getContextPath()%>/productServlet?productId=${pro.productId}&&action=Update">Update</a>
                <a href="<%=request.getContextPath()%>/productServlet?productId=${pro.productId}&&action=Delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="views/newProduct.jsp">Create new product</a>
<form action="<%=request.getContextPath()%>/productServlet" method="post">
    <input type="text" name="searchName">
    <input type="submit" value="Search" name="action">
</form>
</body>
</html>
