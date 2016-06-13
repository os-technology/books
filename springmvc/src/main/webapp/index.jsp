<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<a href="user" target="_blank">user信息展示</a>
	<br>
	<a href="mapping/testSpringRequestMapping" target="_blank">test
		RequestMapping</a>
	<br>
	<a href="mapping/testMethod" target="_blank">test Method[失败]</a>
	<br>
	<form action="mapping/testMethod" method="post" target="_blank">
		<input name="input" type="text"> <input type="submit"
			value="method post">
	</form>
	<a href="mapping/testParamsAndHeaders?username=张小新&age=11"
		target="_blank">test ParamsAndHeaders</a>
	<br>
	<a href="mapping/hello/path" target="_blank">test AntPath</a>
	<br>
	<a href="mapping/testPathVariable/12" target="_blank">test
		PathVariable</a>
	<br>
	<a href="mapping/testRest/1" target="_blank">test Rest GET</a>
	<br>
	<form action="mapping/testRest" method="post"  target="_blank">
		<input type="submit" value = "test Rest POST"/>
	</form>
	<br>
	<form action="mapping/testRest/1" method="post" target="_blank">
	<input type="hidden" value="DELETE" name="_method">
		<input type="submit" value = "test Rest DELETE"/>
	</form>
	<br>
	<form action="mapping/testRest/1" method="post" target="_blank">
	<input type="hidden" value="PUT" name="_method">
		<input type="submit" value = "test Rest PUT"/>
	</form>
	<br>
	<a href="mapping/testRequestParams?username=shui&age=29" target="_blank">test RequestParams</a>
	<br>
	<a href="mapping/testRequestHeader" target="_blank">test RequestHeader</a>
	<br>
	<a href="mapping/testCookieValue" target="_blank">test CookieValue</a>
	<br>
	<form action="mapping/testPojo" target="_blank" method="post">
		username:<input type="text" name="username"/><br>
		password:<input type="password" name="password"/><br>
		age:<input type="text" name="age"/><br>
		email:<input type="text" name="email"/><br>
		city:<input type="text" name="address.city"/><br>
		province:<input type="text" name="address.province"/><br>
		<input type="submit" value="submit"/>
	</form>
	<br>
	<a href="mapping/testServletAPI" target="_blank">test ServletAPI</a>
	<br>
	<a href="mapping/testServletAPI_2" target="_blank">test ServletAPI_2</a>
	<br>
	<a href="mapping/testModelAndView" target="_blank">test ModelAndView</a>
	<br>
	<a href="mapping/" target="_blank">null</a>
	<br>
	<a href="mapping/" target="_blank">null</a>
	<br>

</body>
</html>