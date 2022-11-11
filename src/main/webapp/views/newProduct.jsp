<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/11/2022
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productServlet" method="post">
    <table>
        <tr>
            <td>Product ID</td>
            <td><input type="text" name="productId"></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName"></td>
        </tr>
        <tr>
            <td>Import Price</td>
            <td><input type="number" name="importPrice"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="descriptions"></td>
        </tr>
        <tr>
            <td>Product Status</td>
            <td>
                <input type="radio" name="productStatus" id="saling" value="true" checked/>
                <label for="saling">Saling</label>
                <input type="radio" name="productStatus" id="notSale" value="false"/>
                <label for="notSale">Not Sale</label>
            </td>
        </tr>
        <tr>
            <td>Date Input Product</td>
            <td><input type="date" name="dateInputProduct"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Create" name="action">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
