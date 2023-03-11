<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:forEach items="${memberDtos}" var="dto">
		<h2>${dto.memberId }</h2>
	</c:forEach>
    <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>