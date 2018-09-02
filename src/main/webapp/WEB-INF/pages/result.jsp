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
    margin-left: 75px;
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
        margin-left:400px;
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

<a href="books"  class="mycss2" >Back to books' view</a>

<br/>


<h2>Book Information</h2>

<table class="tg" >
  <tr>
    <th width="80">ID</th>
    <th width="120">Title</th>
    <th width="120">Description</th>
    <th width="120">Author</th>
    <th width="120">ISBN</th>
    <th width="120">Year published</th>
    <th width="120">Already read</th>
  </tr>
  <tr>
    <td>${book.id}</td>
    <td>${book.title}</td>
    <td>${book.description}</td>
    <td>${book.author}</td>
    <td>${book.isbn}</td>
    <td>${book.printYear}</td>
    <td>${book.readAlready}</td>



  </tr>
</table>



</body>
</html>