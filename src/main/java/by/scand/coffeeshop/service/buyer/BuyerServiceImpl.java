package by.scand.coffeeshop.service.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.buyer.BuyerDao;
import by.scand.coffeeshop.domain.Buyer;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	private BuyerDao buyerDao;

	@Override
	public int addOne(Buyer buyer) {

		return buyerDao.addOne(buyer);
	}

}
