<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<html>
<head>
    <title>Warehouse</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #20a088;

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

        #amount{color: red; display:inline-block; }
        #table{
            position: absolute;
            top:100px;
            left:75px;

        }
        #infoandreferences{
            position:absolute;
            top: 100px;
            left:500px;

        }
        .ii{
            font-size: 20px;
            color: #155654;
        }

        h1{
            color: #035447;
            margin-left:350px;
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

<body>
<h1>Information about the required parts</h1>

<c:if test="${empty listParts}">
    <p class="ii">There are no required parts in stock! <br/> Enter part information in the form to add computer part.</p>
</c:if>


<div id="table">
<c:if test="${!empty listParts}">

    <table class="tg">

        <tr>
            <th>Part name</th>
            <th>Quantity</th>
            <th>Is required</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${listParts}" var = "part">
            <tr>
                <td>${part.partName}</td>
                <td>${part.quantity}</td>
                <td><c:if test="${part.isRequired==0}"><c:out value="no"/></c:if><c:if test="${part.isRequired==1}"><c:out value="yes"/></c:if></td>
                <td><a href="<c:url value='/edit/${part.id}'>  <c:param name="page" value="${page}"/><c:param name="viewParam" value="requiredparts"/></c:url>">edit</a></td>
                <td><a href="<c:url value='/remove/${part.id}'> <c:param name="page" value="${page}"/><c:param name="viewParam" value="requiredparts"/></c:url>">delete</a></td>

            </tr>

        </c:forEach>

    </table>



    <div class="mycss2">
        <p >Pages: </p>
    </div>

    <c:url value="/requiredparts" var="prev">
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
                <c:url value="/requiredparts" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:url value="/requiredparts" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next">Next</a>
    </c:if>
</div>
</c:if>
<br/>
<br/>




<div id="searchforms">
    <h2>Enter part information</h2>
    <c:url var="addAction" value="/addPart" >
        <c:param name="page" value="${page}"/><c:param name="viewParam" value="requiredparts"/>
    </c:url>

    <form:form action="${addAction}" modelAttribute="command">

        <table>
            <c:if test="${!empty command.partName}" >
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
                    <form:label path="partName" cssClass="mycss2">

                        <spring:message text="Part name"/>
                    </form:label>
                </td>
                <td>

                    <form:input path="partName" cssClass="mycss" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="quantity" cssClass="mycss2">

                        <spring:message text="Quantity"/>
                    </form:label>
                </td>
                <td>

                    <form:input path="quantity" cssClass="mycss" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="isRequired" cssClass="mycss2">

                        <spring:message text="Is part required"/>
                    </form:label>
                </td>
                <td>

                    <form:input path="isRequired"  cssClass="mycss"/>
                </td>

            </tr>
            <tr>

            </tr>

            <tr>
                <td colspan="2">
                    <c:if test="${!empty command.partName}">

                        <input type="submit"  value="<spring:message text="Edit Part" />" class="mycss" />

                    </c:if>

                    <c:if test="${empty command.partName}">

                        <input type="submit"  value="<spring:message text="Add Part"/> " class="mycss" />

                    </c:if>

                </td>

            </tr>

        </table>


    </form:form>

    <h2 >Search a part by name:</h2>

    <c:url value="/search" var="searchAction" >
        <c:param name="page" value="${page}"/>
    </c:url>
    <form:form action="${searchAction}"  method="POST" >
        <label >
            <input type="text" name="partName"/>
        </label>
        <input type="submit" value="search" /> </form:form>

</div>
<br/>
<div id = infoandreferences>

    <br/>

    <c:if test="${computerCount!=0}">
        <h2 class="mycss2">You can assemble <div id="amount"><c:out  value=" ${computerCount}"  /></div> computers</h2>

        </c:if>

        <br/>

       <h2> <a href="<c:url value='/parts'> </c:url>" class="mycss2">Show all parts</a>
        <br/>
        <br/>
           <a href="<c:url value='/'/>"  class="mycss2"  >Back to main page </a></h2>
</div>



</body>

</html>

