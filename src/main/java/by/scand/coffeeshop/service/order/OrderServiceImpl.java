package by.scand.coffeeshop.service.order;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.order.OrderDao;
import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.service.buyer.BuyerService;
import by.scand.coffeeshop.service.delivery.DeliveryService;
import by.scand.coffeeshop.service.discount.DiscountService;
import by.scand.coffeeshop.service.goods.GoodsService;
import by.scand.coffeeshop.service.orderitem.OrderItemService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private DiscountService discountService;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private BuyerService buyerService;

	@Override
	public void addItem(Goods goods, int amount, Order order) {

		order.getItems().add(new OrderItem(goods, amount));
	}

	@Override
	public void confirmOrder(Buyer buyer, Order order) {
		int orderId = 0;
			
	//	buyerService.addOne(buyer);
		order.setBuyer(buyer);
		order.setDate(new Date());
		orderId = orderDao.addOne(order);

		// for every OrderItem we set order id
		/*for (OrderItem orderItem : order.getItems()) {
			orderItem.setOrder(order);
		}
		orderItemService.addAllItems(order.getItems());*/
	}

	@Override
	public Order buyGoods(Map<Integer, Integer> purchases, String language) {
		Order order = new Order();	// Key - goods Id; Value - amount which we get from UI

		for (Map.Entry<Integer, Integer> entry : purchases.entrySet()) {
			addItem(goodsService.getOneGoodsById(entry.getKey()), entry.getValue(), order);
		}

		calculateOrderCost(order);

		return order;
	}
	
	@Override
	public int calculateOrderCost(Order order) {
		int orderCost = 0;

		for (OrderItem orderItem : order.getItems()) {
			orderCost += orderItemService.getOrderItemCost(orderItem);
		}

		order.setDiscount(discountService.calculateDiscount(order.getItems()));
		order.setDelivery(deliveryService.calculateDeliveryCost(orderCost));

		orderCost = orderCost + order.getDiscount() + order.getDelivery();

		order.setCost(orderCost);

		return orderCost;
	}
}