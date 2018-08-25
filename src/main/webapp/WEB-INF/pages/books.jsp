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
<c:url var="addAction" value="/addBook" />

<form:form action="${addAction}" modelAttribute="command">

    <table>

         <c:if test="${!empty command.title}" >

             <tr>
                <td>

              <form:label path="id">
<spring:message text="ID"/>
                    </form:label>
                </td>
                 <td>
        <form:input path="id" readonly="true" size="8" disabled="true" />
                 <form:hidden path="id"/>
                 </td>
             </tr>
                 </c:if>

        <tr>
            <td>
               <form:label path="title">

                   <spring:message text="title"/>
                </form:label>
            </td>
            <td>

                <form:input path="title" />
            </td>


        </tr>
        <tr>
            <td>
                <form:label path="description">

                    <spring:message text="description"/>
                </form:label>
            </td>
            <td>

                <form:input path="description" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="author">

                    <spring:message text="author"/>
                </form:label>
            </td>
            <td>

                <form:input path="author" />
            </td>

        </tr>
        <tr>
            <td>
                <form:label path="isbn">

                    <spring:message text="isbn"/>
                </form:label>
            </td>
            <td>

                <form:input path="isbn" />
            </td>

        </tr>

        <tr>
            <td>
                <form:label path="printYear">

                    <spring:message text="printYear"/>
                </form:label>
            </td>
            <td>

                <form:input path="printYear" />
            </td>

        </tr>
        <tr>
            <td>
                <form:label path="readAlready">

                    <spring:message text="readAlready"/>
                </form:label>
            </td>
            <td>

                <form:input path="readAlready" />
            </td>

        </tr>

        <tr>
<td colspan="2">
<c:if test="${!empty book.title}">

    <input type="submit"  value="<spring:message text="Edit Book"/>" />

</c:if>

    <c:if test="${empty book.title}">

        <input type="submit"  value="<spring:message text="Add Book"/>" />

    </c:if>

</td>

        </tr>

    </table>


</form:form>



</body>
</html>