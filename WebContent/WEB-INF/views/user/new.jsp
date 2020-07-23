<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>ユーザー 新規登録ページ</h2>
        <form method="post" action="<c:url value='/user/create'/>">
            <c:import url="_form.jsp">
            </c:import>
        </form>
        <p><a href="${pageContext.request.contextPath}/word/index">単語一覧に戻る</a></p>
    </c:param>
</c:import>