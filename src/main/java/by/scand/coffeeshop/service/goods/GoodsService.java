package by.scand.coffeeshop.service.goods;

import java.util.List;

import by.scand.coffeeshop.domain.Goods;

public interface GoodsService {

	Goods getOneGoodsById(int id);

	List<Goods> getAllGoods();
}