<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    
    <!-- 로그인 -->
    <form action="${contextPath}/login" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">Login</button>
    </form>
    
      <!-- ID 찾기와 PW 찾기 버튼 추가 -->
    <div style="margin-top: 10px;">
        <button onclick="location.href='${contextPath}/findId'">ID 찾기</button>
        <button onclick="location.href='${contextPath}/resetPassword'">PW 찾기</button>
    </div>

    <!-- 에러 메시지 표시 -->
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</body>
</html>
