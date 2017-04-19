<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<form action="confirm" method="POST">
	<h1>${localization.attributes.yourOrder}</h1>
	<table>
		<tr>
			<td class="buyer">${localization.attributes.firstName} <input type="text" size="20" name="firstName" /></td>
		</tr>
		<tr>
			<td class="buyer">${localization.attributes.lastName} <input type="text" size="20" name="lastName" /></td>
		</tr>
		<tr>
			<td class="buyer">${localization.attributes.patronymic} <input type="text" size="20" name="patronymic" /></td>
		</tr>
		<tr>
			<td class="buyer">${localization.attributes.address} <input type="text" size="20" name="address" /></td>
		</tr>


		<tr>
			<td class="buyer"><input type="submit" value="${localization.attributes.confirm}" /></td>
		</tr>
	</table>

	<table>
		<tr>
			<th>${localization.attributes.coffeeSort}</th>
			<th>${localization.attributes.price}</th>
			<th>${localization.attributes.amount}</th>
			<th>${localization.attributes.cost}</th>
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
<tr><td colspan="3" class="order_details">${localization.attributes.summ}</td><td class="order_details_nums">${(order.cost-order.discount-order.delivery)/100} byn</td></tr>
<tr><td colspan="3" class="order_details">${localization.attributes.delivery}</td><td class="order_details_nums">${order.delivery/100} byn</td></tr>
<tr><td colspan="3" class="order_details">${localization.attributes.discount}</td><td class="order_details_nums">${order.discount/100} byn</td></tr>
<tr><td colspan="3" class="order_details">${localization.attributes.total}</td><td class="order_details_nums">${order.cost/100} byn</td></tr>

	</table>

</form>

<%@ include file="footer.jsp"%>
