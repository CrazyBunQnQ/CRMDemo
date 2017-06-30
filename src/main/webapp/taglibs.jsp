<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.bean.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    User user = (User) session.getAttribute("user");
    if (user == null) {
        //重定向登录界面
        System.out.println("重定向登录界面");
    }
%>
<c:set var="basePath" value="<%=basePath1 %>"></c:set>
<c:set var="contextPath" value="<%=request.getContextPath() %>"></c:set>

