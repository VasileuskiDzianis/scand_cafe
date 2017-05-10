package by.scand.coffeeshop.dao.goods;

import java.util.List;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.exception.DaoException;

public interface GoodsDao {

	Goods getOne(int id, String lang) throws DaoException;

	List<Goods> getAll(String lang) throws DaoException;

}