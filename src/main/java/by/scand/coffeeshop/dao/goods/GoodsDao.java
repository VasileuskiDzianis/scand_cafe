package by.scand.coffeeshop.dao.goods;

import java.util.List;

import by.scand.coffeeshop.domain.Goods;

public interface GoodsDao {

	Goods getOneById(int id, String lang);

	List<Goods> getAll(String lang);

}