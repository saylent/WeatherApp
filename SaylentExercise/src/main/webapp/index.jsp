<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saylet Coding Exercise</title>
<style>
table {
    border-collapse: collapse;
}

table, td, th {
    padding: 6px 13px;
    border: 1px solid #dfe2e5;
}
body {
	font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
    font-size: 16px;
    line-height: 1.5;
    word-wrap: break-word;
}
tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>

<c:choose>
  <c:when test="${somethingWentWrong}">
   Oops!! Something went wrong....
  </c:when>
  <c:otherwise>
    <table>
		<thead>
			<tr>
				<th>Poster</th>
				<th>Title</th>
				<th>Comments</th>
			</tr>
		</thead>
		 <c:forEach items="${displayObjects}" var="displayObject">
		    <tr>
		        <td>${displayObject.personName}</td>
		        <td>${displayObject.title}</td>
		        <td>${displayObject.commentCount}</td>
		    </tr>
		 </c:forEach>
	</table>
  </c:otherwise>
</c:choose>
</body>
</html>