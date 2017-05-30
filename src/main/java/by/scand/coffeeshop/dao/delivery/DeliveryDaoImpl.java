package by.scand.coffeeshop.dao.delivery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;

@Repository
public class DeliveryDaoImpl extends BaseDao implements DeliveryDao {

	@Value("#{businessRules['deliveryCost'] ?: 200}")
	private int deliveryCost;
	
	@Value("#{businessRules['freeDeliveryCost'] ?: 1000}")
	private int freeDeliveryCost;
	
	@Override
	public int getDeliveryCost() {

		return deliveryCost;
	}

	@Override
	public int getFreeDeliveryLevel() {

		return freeDeliveryCost;
	}

}
