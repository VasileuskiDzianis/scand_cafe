package by.scand.coffeeshop.dao.delivery;

import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;

@Repository
public class DeliveryDaoImpl extends BaseDao implements DeliveryDao {

	@Override
	public int getDeliveryCost() {
		int deliveryCost = 0; // coins

		deliveryCost = getOneIntProperty("business_rules", "delivery");

		return deliveryCost;
	}

	@Override
	public int getFreeDeliveryLevel() {
		int deliveryFreeLevel = 0; // coins

		deliveryFreeLevel = getOneIntProperty("business_rules", "free_delivery");

		return deliveryFreeLevel;
	}

}
