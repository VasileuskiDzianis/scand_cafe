package by.scand.coffeeshop.service.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.scand.coffeeshop.dao.discount.DiscountDao;
import by.scand.coffeeshop.domain.OrderItem;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	DiscountDao discountDao;

	@Override
	public int calcDiscount(List<OrderItem> items) {
		int discount = 0;
		if (getNumberOfFreeCup() != 0) {
			for (OrderItem orderItem : items) {
				// calculate how many times N-cup is
				// containing in value of amount and
				// multiply it on price of goods
				discount -= (orderItem.getAmount() / getNumberOfFreeCup()) * orderItem.getGoods().getPrice();
			}
		}
		return discount;
	}

	@Override
	public int getNumberOfFreeCup() {
		int numberOfFreeCup = 0;
		numberOfFreeCup = discountDao.getNumberOfFreeCup();
		return numberOfFreeCup;
	}

}
