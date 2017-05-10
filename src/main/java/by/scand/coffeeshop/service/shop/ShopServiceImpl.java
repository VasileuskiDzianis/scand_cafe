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

	private List<Goods> catalog;
	private Order order;
	@Autowired
	private GoodsService goodsService;
	private String lang;
	@Autowired
	private OrderService orderService;

	public ShopServiceImpl() {
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String getLang() {
		return lang;
	}

	@Override
	public void setLang(String lang) {
		this.lang = lang;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public Order buyGoods(Map<Integer, Integer> purchases) throws ServiceException {
		// Key - goods Id; Value - amount which we get from UI
		order = new Order();
		for (Map.Entry<Integer, Integer> entry : purchases.entrySet()) {
			try {
				orderService.addItem(goodsService.getOneGoods(entry.getKey(), lang), entry.getValue(), order);
			} catch (ServiceException e) {
				throw new ServiceException("Error buying goods", e);
			}
		}
		orderService.sum(order);
		return order;
	}

	@Override
	public List<Goods> getCatalog() throws ServiceException {
		catalog = goodsService.getAllGoods(lang);
		return catalog;
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