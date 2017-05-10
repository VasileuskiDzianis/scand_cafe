package by.scand.coffeeshop.dao.delivery;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.exception.DaoException;

@Repository
public class DeliveryDaoImpl extends BaseDao implements DeliveryDao {

	@Override
	public int getDeliveryCost() throws DaoException {
		int deliveryCost = 0; // coins
		try {
			deliveryCost = getOneIntProperty("business_rules", "delivery");
		} catch (DaoException e) {
			throw new DaoException("Error: getting value of delivery cost from database", e);
		}
		return deliveryCost;
	}

	@Override
	public int getFreeDeliveryLevel() throws DaoException{
		int deliveryFreeLevel = 0; // coins
		try {
			deliveryFreeLevel = getOneIntProperty("business_rules", "free_delivery");
		} catch (DaoException e) {
			throw new DaoException("Error: getting value of free delivery level from database", e);
		}
		return deliveryFreeLevel;
	}

}
