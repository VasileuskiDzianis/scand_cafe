package by.scand.coffeeshop.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.scand.coffeeshop.dao.delivery.DeliveryDao;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	private static final int FREE_DELIVERY_COST = 0;

	@Autowired
	private DeliveryDao deliveryDao;

	@Override
	public int calculateDeliveryCost(int orderSum) {
		int deliveryFreeLevel = deliveryDao.getFreeDeliveryLevel();

		if (orderSum >= deliveryFreeLevel) {
			
			return FREE_DELIVERY_COST;
		} else {
			
			return deliveryDao.getDeliveryCost();
		}
	}
}