package by.scand.coffeeshop.service.shop;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.goods.GoodsService;
import by.scand.coffeeshop.service.order.OrderService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;

	@Override
	public Order buyGoods(Map<Integer, Integer> purchases, String language) throws ServiceException {
		// Key - goods Id; Value - amount which we get from UI
		Order order = new Order();
		for (Map.Entry<Integer, Integer> entry : purchases.entrySet()) {
			try {
				orderService.addItem(goodsService.getOneGoods(entry.getKey(), language), entry.getValue(), order);
			} catch (ServiceException e) {
				throw new ServiceException("Error buying goods", e);
			}
		}
		orderService.sum(order);
		return order;
	}

	@Override
	public List<Goods> getCatalog(String language) throws ServiceException {
		return goodsService.getAllGoods(language);
	}

	@Override
	public boolean confirmOrder(Buyer buyer, Order order) throws ServiceException {
		Date date = new Date();
		order.setBuyer(buyer);
		order.setDate(date);
		boolean confirmation = false;
		orderService.saveOrder(order);
		confirmation = true;
		return confirmation;
	}

}