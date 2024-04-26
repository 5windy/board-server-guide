<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		boolean isValid = true;
		
		if(id == null || id.equals(""))
			isValid = false;
		else if(password == null || password.equals(""))
			isValid = false;
		
		if(isValid) {
			// 연동된 데이터 베이스로부터 
			// 유저의 정보를 조회 하고,
			// 정보가 일치하면 
			// 로그인 처리 후, 페이지 이동
			
			response.sendRedirect("/mypage");
		} else {
			response.sendRedirect("/login");
		}
	%>
</body>
</html>