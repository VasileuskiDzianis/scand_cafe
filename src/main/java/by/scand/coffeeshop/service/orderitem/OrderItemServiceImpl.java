package by.scand.coffeeshop.service.orderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.orderitem.OrderItemDao;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.exception.ServiceException;
	
	
	
@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	
	
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	@Override
	public int getPrice(OrderItem orderItem) throws ServiceException {
		int price = orderItem.getGoods().getPrice() * orderItem.getAmount();
		orderItem.setCost(price);
		return price;
	}

	@Override
	public void addAllItems(List<OrderItem> orderItems) throws ServiceException {
		
		try {
			orderItemDao.addAll(orderItems);
		} catch (DaoException e) {
			throw new ServiceException("Adding order's items error", e);
		}
		
	}

}
