package by.scand.coffeeshop.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.exception.ServiceException;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryDao deliveryDao;

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}

	@Override
	public int calcDelivery(int orderSum) throws ServiceException {
		int deliveryFreeLevel = 0;
		int deliveryCost = 0;
		
		try {
			deliveryFreeLevel = deliveryDao.getFreeDeliveryLevel();
			deliveryCost = deliveryDao.getDeliveryCost();
		} catch (DaoException e) {
			throw new ServiceException("Calculation delivery error", e);
		}
		if (orderSum >= deliveryFreeLevel) {
			return 0;
		} else
			return deliveryCost;
	}

}
