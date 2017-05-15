package by.scand.coffeeshop.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.scand.coffeeshop.dao.delivery.DeliveryDao;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryDao deliveryDao;

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}

	@Override
	public int calcDelivery(int orderSum) {
		int deliveryFreeLevel = 0;
		int deliveryCost = 0;
		
			deliveryFreeLevel = deliveryDao.getFreeDeliveryLevel();
			deliveryCost = deliveryDao.getDeliveryCost();
		if (orderSum >= deliveryFreeLevel) {
			return 0;
		} else
			return deliveryCost;
	}

}
