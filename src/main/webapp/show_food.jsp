<%--
  Created by IntelliJ IDEA.
  User: ayushparihar
  Date: 20/03/23
  Time: 3:54 pm
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<c:forEach var="items" items="${foodItems}">
${items.getId()}
${items.getItem()}
${items.getPrice()}
</c:forEach>

</body>
</html>
