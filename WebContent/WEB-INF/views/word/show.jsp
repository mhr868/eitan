<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${word != null}">
                <h2>詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>単語</th>
                            <td><c:out value="${word.word}"/></td>
                        </tr>
                        <tr>
                            <th>意味</th>
                            <td><c:out value="${word.mean}"/></td>
                        </tr>
                        <tr>
                            <th>シチュエーション</th>
                            <td><c:out value="${word.situation}"/></td>
                        </tr>
                        <tr>
                            <th>投稿者</th>
                            <td><c:out value="${word.posting_user.name}"/></td>
                        </tr>
                        <tr>
                            <th>note</th>
                            <td>
                                <pre><c:out value="${word.note}"/></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td><fmt:formatDate value="${word.created_at}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td><fmt:formatDate value="${word.updated_at}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${sessionScope.login_user.primary_id == word.posting_user.primary_id}">
                    <p><a href="<c:url value='/word/edit?id=${word.primary_id}'/>">内容を編集する</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>