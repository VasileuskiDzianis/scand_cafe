package by.scand.coffeeshop.domain;

import java.util.List;

import by.scand.coffeeshop.dao.BusinessRulesDao;
import by.scand.coffeeshop.dao.DaoException;

public class BusinessRulesImpl implements BusinessRules {

	BusinessRulesDao businessRulesDao;
	private int eachNCupFree; // each N-cup of same coffee-sort is free
	private int deliveryCost;
	private int freeDeliveryCost; // if order's cost greater than this value,
									// then delivery is free

	public BusinessRulesImpl(int eachNCupFree, int deliveryCost, int freeDeliveryCost) {

		this.eachNCupFree = eachNCupFree;
		this.deliveryCost = deliveryCost;
		this.freeDeliveryCost = freeDeliveryCost;
	}

	public BusinessRulesImpl() {
		
	}
	@Override
	public void setBusinessRulesDao(BusinessRulesDao businessRulesDao) {
		this.businessRulesDao = businessRulesDao;
		BusinessRulesImpl bRules;
		try {
			bRules = (BusinessRulesImpl) businessRulesDao.getOne();
			this.eachNCupFree = bRules.getEachNCupFree();
			this.deliveryCost = bRules.getDeliveryCost();
			this.freeDeliveryCost = bRules.getFreeDeliveryBorder();
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public int getEachNCupFree() {
		return eachNCupFree;
	}

	public void setEachNCupFree(int eachNCupFree) {
		this.eachNCupFree = eachNCupFree;
	}

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public int getFreeDeliveryBorder() {
		return freeDeliveryCost;
	}

	public void setFreeDeliveryBorder(int freeDeliveryBorder) {
		this.freeDeliveryCost = freeDeliveryBorder;
	}

	@Override

	// sign minus means that we have discount.
	// sign plus means that we have extra charges (it could be delivery, extra
	// fast delivery, delivery at the night time etc.
	public int calcDiscount(List<OrderItem> items) {
		int discount = 0;
		int cost = 0;
		for (OrderItem orderItem : items) {
			cost += orderItem.getPrice(); // calculate cost of all orderItems

			if (eachNCupFree != 0) { // calculate how many times N-cup is
										// containing in value of amount and
										// multiply it on
										// price of goods
				discount -= (orderItem.getAmount() / eachNCupFree) * orderItem.getGoods().getPrice();
			}

		}

		return discount;
	}

	@Override
	public int calcDelivery(List<OrderItem> items) {
		int cost = 0;
		for (OrderItem orderItem : items) {
			cost += orderItem.getPrice(); // calculate cost of all orderItems
		}
		if (cost <= freeDeliveryCost) {
			return deliveryCost;
		} else
			return 0;
	}

}
