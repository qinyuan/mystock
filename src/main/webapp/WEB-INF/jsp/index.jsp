<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="inc-header.jsp" %>
<table class="normal">
    <thead>
    <tr>
        <th>名称</th>
        <th>代码</th>
        <th>价格</th>
        <th>涨跌</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="price" items="${prices}">
        <tr>
            <td>${price.stock.name}</td>
            <td>${price.stock.code}</td>
            <td>${price.price}</td>
            <td><span style="color:${price.rate > 0 ? 'red':"green"}">${price.rate}%</span></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="inc-footer.jsp" %>
