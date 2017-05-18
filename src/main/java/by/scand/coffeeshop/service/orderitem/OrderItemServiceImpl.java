package by.scand.coffeeshop.service.orderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.orderitem.OrderItemDao;
import by.scand.coffeeshop.domain.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;

	@Override
	public int getOrderItemCost(OrderItem orderItem) {
		int cost = orderItem.getGoods().getPrice() * orderItem.getAmount();
		orderItem.setCost(cost);
		
		return cost;
	}

	@Override
	public void addAllItems(List<OrderItem> orderItems) {
		
		orderItemDao.addAll(orderItems);
	}
}