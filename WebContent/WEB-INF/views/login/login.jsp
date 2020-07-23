<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${hasError}">
            <div id="flush_error">
                            入力内容に誤りがあります。
            </div>
        </c:if>
        <h2>ログイン</h2>
        <form method="post" action="<c:url value='/login'/>">
            <label for="user_id">ユーザーID</label><br />
            <input type="text" name="user_id" value="${user_id}">
            <br />
            <br />
            <label for="password">パスワード</label><br />
            <input type="password" name="password">
            <br />
            <br />
            <input type="hidden" name="_token" value="${_token}">
            <button type="submit">ログイン</button>
        </form>
        <br />
        <a href="<c:url value='/user/new'/>">新規ユーザー登録</a>
    </c:param>
</c:import>