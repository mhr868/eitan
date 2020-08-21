<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"/>
            </div>
        </c:if>
        <br/>
        <img src="f0020118_3121126.jpg">
        <br/>
        <br/>
        <p>新着の英単語</p>
        <table>
            <tbody>
                <tr>
                    <th class="word">単語</th>
                    <th class="mean">意味</th>
                    <th class="situation">シチュエーション</th>
                    <th class="action">操作</th>
                </tr>
                <c:forEach var="word" items="${words}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="word"><c:out value="${word.word}"/></td>
                        <td class="mean"><c:out value="${word.mean}"/></td>
                        <td class="situation"><c:out value="${word.situation}"/></td>
                        <td class="action"><a href="<c:url value='/word/show?id=${word.primary_id}'/>">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:param>
</c:import>