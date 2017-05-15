package by.scand.coffeeshop.service.goods;

import java.util.List;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.exception.ServiceException;

public interface GoodsService {
	Goods getOneGoods(int id, String lang);
	List<Goods> getAllGoods(String lang);
}
