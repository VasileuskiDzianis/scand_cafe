package by.scand.coffeeshop.service.delivery;

import by.scand.coffeeshop.exception.ServiceException;

public interface DeliveryService {
	public int calcDelivery(int orderSum) throws ServiceException;
	

}
