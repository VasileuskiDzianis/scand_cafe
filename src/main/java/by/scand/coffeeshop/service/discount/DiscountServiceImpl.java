package by.scand.coffeeshop.service.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.discount.DiscountDao;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.exception.ServiceException;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	DiscountDao discountDao;

	public void setDiscountDao(DiscountDao discountDao) {
		this.discountDao = discountDao;
	}

	@Override
	public int calcDiscount(List<OrderItem> items) throws ServiceException {
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
	public int getNumberOfFreeCup() throws ServiceException {
		int numberOfFreeCup = 0;
		try {
			numberOfFreeCup = discountDao.getNumberOfFreeCup();
		} catch (DaoException e) {
			throw new ServiceException("Getting number of free cup error", e);
		}
		return numberOfFreeCup;
	}

}
