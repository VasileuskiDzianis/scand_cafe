<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<form action="confirm" method="POST" id="buyer">
	<h1><spring:message code="label.yourOrder"/></h1>
	<table>
		<tr>
			<td class="buyer"><spring:message code="label.firstName"/> <input type="text" size="20" name="firstName" /></td>
		</tr>
		<tr>
			<td class="buyer"><spring:message code="label.lastName"/> <input type="text" size="20" name="lastName" /></td>
		</tr>
		<tr>
			<td class="buyer"><spring:message code="label.patronymic"/> <input type="text" size="20" name="patronymic" /></td>
		</tr>
		<tr>
			<td class="buyer"><spring:message code="label.address"/> <input type="text" size="20" name="address" /></td>
		</tr>


		<tr>
			<td class="buyer"><input type="submit" value="<spring:message code="label.confirm"/>" /></td>
		</tr>
	</table>

	<table>
		<tr>
			<th><spring:message code="label.coffeeSort"/></th>
			<th><spring:message code="label.price"/></th>
			<th><spring:message code="label.amount"/></th>
			<th><spring:message code="label.cost"/></th>
		</tr>
		<c:forEach var="orderItem" items="${order.items}" varStatus="line">
			<c:if test="${(line.count mod 2) ne 0}">
			<tr class="dark">
			</c:if>
			<c:if test="${(line.count mod 2) eq 0}">
			<tr>
			</c:if>
				<td>${orderItem.goods.name}</td>
				<td>${orderItem.goods.price/100} byn</td>
				<td>${orderItem.amount}</td>
				<td>${orderItem.cost/100} byn</td>
			</tr>
		</c:forEach>
<tr><td colspan="3" class="order_details"><spring:message code="label.summ"/></td><td class="order_details_nums">${(order.cost-order.discount-order.delivery)/100} byn</td></tr>
<tr><td colspan="3" class="order_details"><spring:message code="label.delivery"/></td><td class="order_details_nums">${order.delivery/100} byn</td></tr>
<tr><td colspan="3" class="order_details"><spring:message code="label.discount"/></td><td class="order_details_nums">${order.discount/100} byn</td></tr>
<tr><td colspan="3" class="order_details"><spring:message code="label.total"/></td><td class="order_details_nums">${order.cost/100} byn</td></tr>

	</table>

</form>

<%@ include file="footer.jsp"%>
