<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Book Info</title>
    <style type="text/css">
    .tg {
    border-collapse: collapse;
    border-spacing: 0;
    border-color: #20a088;
  position: absolute;
      top:150px;
      left: 550px;
    }

    .tg td {
    font-family: "Times New Roman", sans-serif;
    font-size: 15px;
    padding: 10px 5px;
    border-style: solid;
    border-width: 1px;
    overflow: hidden;
    word-break: normal;
    border-color: #b2d1a6;
    color: #155654;
    background-color: #e9ffcf;

    }

    .tg th {
    font-family: "Times New Roman", sans-serif;
    font-size: 15px;
    font-weight: normal;
    padding: 10px 5px;
    border-style: solid;
    border-width: 1px;
    overflow: hidden;
    word-break: normal;
    border-color: #19cc95;
    color: #35484e;
    background-color: #bcddaf;

    }

    h1{
        color: #035447;
        margin-left:270px;
    }

    h2{
        color: #085a4b;
        margin-left:550px;
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

<br/>

<a href="<c:url value="/parts"> <c:param name="page" value="${page}"/></c:url>"  class="mycss2" >Back to part list</a>

<br/>


<h2>Part Information</h2>

<table class="tg" >
  <tr>
    <th width="120">Name</th>
    <th width="60">Quantity</th>
    <th width="60">Required</th>

  </tr>
  <tr>
    <td>${part.partName}</td>
    <td>${part.quantity}</td>
    <td><c:if test="${part.isRequired==0}"><c:out value="no"/></c:if><c:if test="${part.isRequired==1}"><c:out value="yes"/></c:if></td>


  </tr>
</table>



</body>
</html>