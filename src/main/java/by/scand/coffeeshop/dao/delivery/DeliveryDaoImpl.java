package by.scand.coffeeshop.dao.delivery;

import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;

@Repository
public class DeliveryDaoImpl extends BaseDao implements DeliveryDao {

	@Override
	public int getDeliveryCost() {

		return getOneIntProperty("business_rules", "delivery");
	}

	@Override
	public int getFreeDeliveryLevel() {

		return getOneIntProperty("business_rules", "free_delivery");
	}

}
