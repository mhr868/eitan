<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"/>
            </div>
        </c:if>
        <p>全ての英単語</p>
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
                        <td class="action"><a>詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div id="pagination">
                      (全 ${words_count} 件)<br />
           <c:forEach var="i" begin="1" end="${(words_count - 1) / 15 + 1}" step="1">
               <c:choose>
                   <c:when test="${i == page}">
                       <c:out value="${i}"/>&nbsp;
                   </c:when>
                   <c:otherwise>
                       <a href="<c:url value='/word/index?page=${i}'/>"><c:out value="${i}"/>&nbsp;</a>
                   </c:otherwise>
               </c:choose>
           </c:forEach>
        </div>
        <c:if test="${sessionScope.login_user != null}">
            <a href="<c:url value='/word/new'/>">新しい単語を登録する</a>
        </c:if>
    </c:param>
</c:import>
