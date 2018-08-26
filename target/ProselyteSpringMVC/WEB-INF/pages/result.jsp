<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Developer Info</title>
</head>
<body>

<h2>Book Information</h2>
<table>
  <tr>
    <td>Id</td>
    <td>${id}</td>
  </tr>
  <tr>
  <tr>
    <td>Title</td>
    <td>${title}</td>
  </tr>
  <tr>
    <td>Description</td>
    <td>${description}</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>${author}</td>
  </tr>

  <tr>
    <td>isbn</td>
    <td>${isbn}</td>
  </tr>

  <tr>
    <td>Published</td>
    <td>${printYear}</td>
  </tr>

  <tr>
    <td>Read already</td>
    <td>${readAlready}</td>
  </tr>

    <a href="http://localhost:8080/book.jsp">back to book view</a>
</table>
</body>
</html>