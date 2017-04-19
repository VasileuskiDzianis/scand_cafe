<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<form action="buy" method="POST">
	<h1>${localization.attributes.appealMakeOrder}</h1>
	<table>
		<tr>
<th></th>
<th>${localization.attributes.coffeeSort}</th>
<th>${localization.attributes.price}</th>
<th>${localization.attributes.amount}</th>

		</tr>
		<c:forEach var="goods" items="${catalog}" varStatus="line">
			<c:if test="${(line.count mod 2) ne 0}">
			<tr class="dark">
			</c:if>
			<c:if test="${(line.count mod 2) eq 0}">
			<tr>
			</c:if>
			
			   <td><input type="checkbox" name="sort" value="${goods.id}"
					id="${goods.id}"></td>
				<td><label for="${goods.id}">${goods.name}</label></td>
				<td>${goods.price/100} byn</td>
				<td><input type="text" size="5" name="amount_for_id_${goods.id}" /></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="4"><input type="submit" value="${localization.attributes.order}" /></td>
		</tr>
		<tr><td colspan=4>* - ${localization.attributes.each} ${nCupFree} ${localization.attributes.cupFree}</td></tr>
	</table>
</form>

<%@ include file="footer.jsp"%>
