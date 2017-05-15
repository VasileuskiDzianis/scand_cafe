package by.scand.coffeeshop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.order.OrderDao;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.service.delivery.DeliveryService;
import by.scand.coffeeshop.service.discount.DiscountService;
import by.scand.coffeeshop.service.orderitem.OrderItemService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	DeliveryService deliveryService;
	@Autowired
	DiscountService discountService;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItemService orderItemService;

	@Override
	public int sum(Order order) {
		int cost = 0;
		for (OrderItem orderItem : order.getItems()) {
			cost += orderItemService.getPrice(orderItem);
		}
		int discount = discountService.calcDiscount(order.getItems());
		order.setDiscount(discount);
		int delivery = deliveryService.calcDelivery(cost);
		order.setDelivery(delivery);

		cost = cost + discount + delivery;
		order.setCost(cost);
		return cost;
	}

	@Override
	public void addItem(Goods goods, int amount, Order order) {
		order.getItems().add(new OrderItem(goods, amount));
	}

	@Override
	public int saveOrder(Order order) {
		int id = 0;
		id = orderDao.addOne(order);
		return id;
	}

}
