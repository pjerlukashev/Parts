<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <style type="text/css">
        h1{
            color: #035447;
            margin-left:500px;
        }

        h2{
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
        h3{
            color: #085a4b;
            margin-left:600px;
        }
    </style>
</head>
<body>

<h1>Welcome to warehouse!</h1>
<br/>

  <h3><a href="<c:url value='/parts'/>">View part list</a></h3>
</body>
</html>
