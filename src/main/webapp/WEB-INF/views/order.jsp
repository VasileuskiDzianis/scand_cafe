<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<form action="confirm" method="POST">
	<h1>${localization.attributes.yourOrder}</h1>
	<table>
		<tr>
			<td>${localization.attributes.firstName}</td>
			<td><input type="text" size="20" name="firstName" /></td>
		</tr>
		<tr>
			<td>${localization.attributes.lastName}</td>
			<td><input type="text" size="20" name="lastName" /></td>
		</tr>
		<tr>
			<td>${localization.attributes.patronymic}</td>
			<td><input type="text" size="20" name="patronymic" /></td>
		</tr>
		<tr>
			<td>${localization.attributes.address}</td>
			<td><input type="text" size="20" name="address" /></td>
		</tr>


		<tr>
			<td></td>
			<td><input type="submit" value="${localization.attributes.confirm}" /></td>
		</tr>
	</table>

	<table>
		<tr>
			<td>${localization.attributes.coffeeSort}</td>
			<td>${localization.attributes.price}</td>
			<td>${localization.attributes.amount}</td>
			<td>${localization.attributes.cost}</td>
		</tr>
		<c:forEach var="orderItem" items="${order.items}">
			<tr>
				<td>${orderItem.goods.name}</td>
				<td>${orderItem.goods.price/100} byn</td>
				<td>${orderItem.amount}</td>
				<td>${orderItem.cost/100} byn</td>
			</tr>
		</c:forEach>
<tr><td colspan="3">${localization.attributes.summ}</td><td>${(order.cost-order.discount-order.delivery)/100} byn</td></tr>
<tr><td colspan="3">${localization.attributes.delivery}</td><td>${order.delivery/100} byn</td></tr>
<tr><td colspan="3">${localization.attributes.discount}</td><td>${order.discount/100} byn</td></tr>
<tr><td colspan="3">${localization.attributes.total}</td><td>${order.cost/100} byn</td></tr>

	</table>

</form>

<%@ include file="footer.jsp"%>
