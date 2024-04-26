<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String gender = request.getParameter("gender");
	String country = request.getParameter("country");
	String telecom = request.getParameter("telecom");
	String phone = request.getParameter("phone");
	String agree = request.getParameter("agree");
	
	// Backend 에서 전달받은 데이터에 대한 유효성 검증 
	boolean isValid = true;
	
	if(id == null || id.equals(""))
		isValid = false;
	else if(password == null || password.equals(""))
		isValid = false;
	else if(name == null || name.equals(""))
		isValid = false;
	else if(birth == null || birth.equals(""))
		isValid = false;
	else if(gender == null || gender.equals(""))
		isValid = false;
	else if(country == null || country.equals(""))
		isValid = false;
	else if(telecom == null || telecom.equals(""))
		isValid = false;
	else if(phone == null || phone.equals(""))
		isValid = false;
	else if(agree == null)
		isValid = false;
	
	// Processing Page 에서는 사용자에게 보여주는 화면을 작성하지 않음 
	// 요청에 대한 응답 처리를 작성 
	// 1) 페이지 이동 처리 (흐름을 제어)
	if(isValid)
		response.sendRedirect("/mypage");
	else 
		response.sendRedirect("/join");

%>
</body>
</html>