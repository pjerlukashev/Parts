<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<html>
<head>
    <title>Developer</title>
</head>
<body>
<h2>Information about the books</h2>

<c:if test="${!empty listBooks}">

   <table>

       <tr>
         <th>Id</th>
         <th>Title</th>
         <th>Description</th>
         <th>Author</th>
         <th>Isbn</th>
         <th>PrintYear</th>
         <th>Read already</th>
         <th>Edit</th>
         <th>Delete</th>
         <th>Mark as already read</th>
       </tr>
<c:forEach items="${listBooks}" var = "book">
       <tr>
<td>${book.id}</td>
<td>${book.title}</td>
<td>${book.description}</td>
<td>${book.author}</td>
<td>${book.isbn}</td>
<td>${book.printYear}</td>
<td>${book.readAlready}</td>
           <td><a href="<c:url value='/edit/${book.id}'/>">edit</a></td>
<td><a href="<c:url value='/remove/${book.id}'/>">delete</a></td>
           <td><a href="mark">mark as already read</a></td>
       </tr>

</c:forEach>

   </table>

</c:if>


<h2>Enter book information</h2>
<form:form method="post" action="addBook">
    <table>
      <!--  <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" /></td>
        </tr> -->
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td><form:label path="author">Author</form:label></td>
            <td><form:input path="author" /></td>
        </tr>

        <tr>
            <td><form:label path="isbn">ISBN</form:label></td>
            <td><form:input path="isbn" /></td>
        </tr>
        <tr>
            <td><form:label path="printYear">Published</form:label></td>
            <td><form:input path="printYear" /></td>
        </tr>
        <tr>
            <td><form:label path="readAlready">Read already</form:label></td>
            <td><form:input path="readAlready" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>