<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>Hello Eitan!</h2>
        <p>Eitanは英単語を投稿できるWebサービスです。</p>
        <p>気になった英単語を登録していくことで、パーソナルな単語帳を作ることが出来ます。</p>
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
                        <td class="action"><a>詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:param>
</c:import>