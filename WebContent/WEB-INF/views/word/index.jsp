<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"/>
            </div>
        </c:if>
        <h2>Hello Eitan!</h2>
        <c:if test="${sessionScope.login_user != null}">
            <a href="<c:url value='/word/new'/>">新しい単語を登録する</a>
        </c:if>
    </c:param>
</c:import>
