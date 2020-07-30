<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${word != null}">
                <h2>編集ページ</h2>
                <form method="post" action="<c:url value='/word/update'/>">
                    <c:import url="_form.jsp">
                    </c:import>
                </form>
                <p><a href="#" onclick="confirmDestroy();">登録情報を削除する</a></p>
				<form method="POST" action="<c:url value='/word/destroy' />">
				    <input type="hidden" name="_token" value="${_token}" />
				</form>
				<script>
                    function confirmDestroy() {
                        if(confirm("本当に削除してよろしいですか？")) {
                            document.forms[1].submit();
                        }
                    }
                </script>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>