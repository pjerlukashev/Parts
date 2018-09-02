<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Book Info</title>
</head>
<body>

<br/>

<a href="books"  class="mycss2" >   Back to main menu </a>

<br/>


<h2>Book Information</h2>

<table border="1" >
  <tr>
    <th width="80">ID</th>
    <th width="120">Title</th>
    <th width="120">Description</th>
    <th width="120">Author</th>
    <th width="120">ISBN</th>
    <th width="120">Year Published</th>
    <th width="120">Has been already read</th>
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