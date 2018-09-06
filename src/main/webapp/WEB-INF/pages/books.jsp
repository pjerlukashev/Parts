<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<html>
<head>
    <title>Library</title>

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
       #searchforms{
           position:absolute;
           top: 100px;
           left:1000px;
       }
       #pagination{
           margin-left:75px;

       }
       #backreference{
           margin-left: 75px;

       }
        .ii{
            font-size: 20px;
            color: #155654;
        }

        h1{
            color: #035447;
            margin-left:270px;
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


    </style>
    <style type="text/css">
        .mycss{
            background-color: #e9ffcf;
            color: #35484e;
        }
    </style>
    <style type="text/css">
        .mycss2{
            color: #35484e;
        }
    </style>
</head>
<h1>Information about the books</h1>

<c:if test="${empty listBooks}">
    <p class="ii">The library is empty! <br/> Enter book information in the form to add book.</p>
</c:if>

<c:if test="${!empty listBooks}">

    <table class="tg">

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
                <td><c:if test="${book.readAlready==0}"><c:out value="no"/></c:if><c:if test="${book.readAlready==1}"><c:out value="yes"/></c:if></td>
                <td><a href="<c:url value='/edit/${book.id}'>  <c:param name="page" value="${page}"/></c:url>">edit</a></td>
                <td><a href="<c:url value='/remove/${book.id}'> <c:param name="page" value="${page}"/></c:url>">delete</a></td>
                <td><a href="<c:url value='/mark/${book.id}'> <c:param name="page" value="${page}"/></c:url>">mark</a></td>

            </tr>

        </c:forEach>

    </table>

</c:if>
<div id="pagination">

    <div class="mycss2">
<p >Pages: </p>
        </div>

<c:url value="/books" var="prev">
    <c:param name="page" value="${page-1}"/>
</c:url>
<c:if test="${page > 1}">
    <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
</c:if>

<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
    <c:choose>
        <c:when test="${page == i.index}">
            <span>${i.index}</span>
        </c:when>
        <c:otherwise>
            <c:url value="/books" var="url">
                <c:param name="page" value="${i.index}"/>
            </c:url>
            <a href='<c:out value="${url}" />'>${i.index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:url value="/books" var="next">
    <c:param name="page" value="${page + 1}"/>
</c:url>
<c:if test="${page + 1 <= maxPages}">
    <a href='<c:out value="${next}" />' class="pn next">Next</a>
</c:if>
</div>

<div id="searchforms">
<h2>Enter book information</h2>
<c:url var="addAction" value="/addBook" >
    <c:param name="page" value="${page}"/>
</c:url>

<form:form action="${addAction}" modelAttribute="command">

    <table>
        <c:if test="${!empty command.title}" >
            <tr>
                <td>
                    <form:label path="id" cssClass="mycss2">
<spring:message text="ID"/>
                    </form:label>
                </td>
                 <td>
        <form:input path="id" readonly="true" size="8" disabled="true"  cssClass="mycss"/>
                 <form:hidden path="id"/>
                 </td>
             </tr>
                 </c:if>
        <tr>
            <td>
               <form:label path="title" cssClass="mycss2">

                   <spring:message text="Title"/>
                </form:label>
            </td>
            <td>

                <form:input path="title" cssClass="mycss" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description" cssClass="mycss2">

                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>

                <form:input path="description" cssClass="mycss" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="author" cssClass="mycss2">

                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>

                <form:input path="author" cssClass="mycss" />
            </td>

        </tr>
        <tr>
            <td>
                <form:label path="isbn" cssClass="mycss2">

                    <spring:message text="Isbn"/>
                </form:label>
            </td>
            <td>

                <form:input path="isbn"  cssClass="mycss"/>
            </td>

        </tr>

        <tr>
            <td>
                <form:label path="printYear" cssClass="mycss2">

                    <spring:message text="Year published"/>
                </form:label>
            </td>
            <td>

                <form:input path="printYear"  cssClass="mycss"/>
            </td>

        </tr>
        <tr>
            <td>
                <form:label path="readAlready" cssClass="mycss2">

                    <spring:message text="Already read"/>
                </form:label>
            </td>
            <td>

                <form:input path="readAlready"  cssClass="mycss"/>
            </td>

        </tr>

        <tr>
<td colspan="2">
<c:if test="${!empty command.title}">

    <input type="submit"  value="<spring:message text="Edit Book" />" class="mycss" />

</c:if>

    <c:if test="${empty command.title}">

        <input type="submit"  value="<spring:message text="Add Book"/> " class="mycss" />

    </c:if>

</td>

        </tr>

    </table>


</form:form>


<h2 >Search a book by title:</h2>

<c:url value="/search" var="searchAction" >
    <c:param name="page" value="${page}"/>
    </c:url>
<form:form action="${searchAction}"  method="POST" >
    <label >
        <input type="text" name="title"/>
    </label>
    <input type="submit" value="search" /> </form:form>

    </div>
<br/>
<div id = backreference>
<a href="/"  class="mycss2"  >Back to main page </a>
</div>
</body>
</html>