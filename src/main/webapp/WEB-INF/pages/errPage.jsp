<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pjer
  Date: 27.08.2018
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book with this name not found</title>
    <style type="text/css">

        h1{
            color: #035447;
            margin-left:430px;
        }

        h2{
            color: #085a4b;
        }
        h3{
            margin-left: 600px;
            color: #085a4b;
        }
        a{
            color: #328072;
        }
        a:hover{
            color: #b3bf2f;
        }
        a:active{

            color: #07bf7c
        }
        a:visited{
            color: #418598;
        }

    </style>
</head>
<body>

<h1 >Book with this name not found</h1>
<br/>
<h3>
    <a href="<c:url value="/books"> <c:param name="page" value="${page}"/></c:url>"   >Book list</a>
</h3>





</body>
</html>
