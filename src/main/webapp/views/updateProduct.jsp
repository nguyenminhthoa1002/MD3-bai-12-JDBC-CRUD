<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/11/2022
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productServlet" method="post">
    <table>
        <tr>
            <td>Product ID</td>
            <td><input type="text" name="productId" value="${productUpdate.productId}"></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName" value="${productUpdate.productName}"></td>
        </tr>
        <tr>
            <td>Import Price</td>
            <td><input type="number" name="importPrice" value="${productUpdate.importPrice}"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="descriptions" value="${productUpdate.descriptions}"></td>
        </tr>
        <tr>
            <td>Product Status</td>
            <td>
                <c:choose>
                    <c:when test="${productUpdate.productStatus}">
                        <input type="radio" name="productStatus" id="saling" value="true" checked/>
                        <label for="saling">Saling</label>
                        <input type="radio" name="productStatus" id="notSale" value="false"/>
                        <label for="notSale">Not Sale</label>
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="productStatus" id="saling" value="true"/>
                        <label for="saling">Saling</label>
                        <input type="radio" name="productStatus" id="notSale" value="false" checked/>
                        <label for="notSale">Not Sale</label>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>Date Input Product</td>
            <td><input type="date" name="dateInputProduct" value="${productUpdate.dateInputProduct}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update" name="action">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
