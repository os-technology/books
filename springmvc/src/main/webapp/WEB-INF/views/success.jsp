<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果页</title>
</head>
<body>
	<h2>默认spring配置文件的配置方式</h2>
	[公共部分]输出request结果为：${requestScope.res}
	<br>
	<br> 输出session结果为：${sessionScope.res}
	<br>
	<br>
	<br> 输出request user结果为：${requestScope.user}
	<br>
	<br> 输出session user结果为：${sessionScope.user}
	<br>
	<br> 输出request school结果为：${sessionScope.school}
	<br>
	<br> 输出session school结果为：${sessionScope.school}
	<br>
	<br>
	<br>
	<br>
	<font color=red>国际化部分的测试信息：</font>
	<br>
	<fmt:message key="i18n.username"></fmt:message>
	<br>
	<br>
	<fmt:message key="i18n.password"></fmt:message>
	<br>
	<br>
</body>
</html>