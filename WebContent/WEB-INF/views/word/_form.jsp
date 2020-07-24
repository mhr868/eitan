<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
                        ・<c:out value="${error}" /><br />
        </c:forEach>
    </div>
</c:if>
<label for="word">単語</label><br />
<input type="text" name="word" value="${word.word}" />
<br />
<br />
<label for="mean">意味</label><br />
<input type="text" name="mean" value="${word.mean}" />
<br />
<br />
<label for="situation">シチュエーション</label><br />
<input type="text" name="situation" value="${word.situation}" />
<br />
<br />
<label for="note">note</label><br/>
<textarea name="note" rows="10" cols="50">${word.note}</textarea>
<br/>
<br/>
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>