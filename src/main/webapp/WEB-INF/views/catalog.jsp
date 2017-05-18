<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<form action="buy" method="POST" id="catalogform">
	<h1>
		<spring:message code="label.appealMakeOrder" />
	</h1>

	<table>
		
		<tr>
			<th></th>
			<th><spring:message code="label.coffeeSort" /></th>
			<th><spring:message code="label.price" /></th>
			<th><spring:message code="label.amount" /></th>
		</tr>
		
		<c:forEach var="goods" items="${catalog}" varStatus="line">
			<c:if test="${(line.count mod 2) ne 0}">
				<tr class="dark">
			</c:if>
			<c:if test="${(line.count mod 2) eq 0}">
				<tr>
			</c:if>

			<td><input type="checkbox" name="chosenIds" value="${goods.id}"
				id="${goods.id}"></td>
			<td><label for="${goods.id}">${goods.name}</label></td>
			<td><fmt:formatNumber value="${goods.price/100}"
					maxFractionDigits="2" minFractionDigits="2" /> byn</td>
			<td><input type="text" size="5" name="amount_for_id_${goods.id}"
				class="amountfield" /></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="4"><input type="submit"
				value="<spring:message code="label.order"/>" /></td>
		</tr>
		
		<tr>
			<td colspan=4>* - <spring:message code="label.each" />
				${nCupFree} <spring:message code="label.cupFree" /></td>
		</tr>
		
	</table>
</form>

<%@ include file="footer.jsp"%>
