package by.scand.coffeeshop.domain;

import java.util.ArrayList;
import java.util.List;

import by.scand.coffeeshop.dao.Dao;
import by.scand.coffeeshop.dao.DaoException;
import by.scand.coffeeshop.dao.GoodsDao;

public class Catalog {

	private List<Goods> goods;
	private GoodsDao goodsDao;

	public Catalog() {
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public List<Goods> getCatalog(String lang) throws DomainException {
		goods = new ArrayList<Goods>();
		List<Goods> allGoods = null;
		try {
			allGoods = goodsDao.getAll(lang);
		} catch (DaoException e) {
			throw new DomainException("Getting catalog error");
		}
		for (Goods product : allGoods) {
			if (product.getDisabled() == 'N') { //throw out goods where (disabled != 'N')
				goods.add(product);
			}
		}

		return goods;
	}
	
	public Goods getOneItemOfGoods(int id, String lang) throws DomainException{
		Goods goods = null;
		try {
			goods = goodsDao.getOne(id, lang);
		} catch (DaoException e) {
			throw new DomainException("Getting goods error");
		}
		return goods;
	}

}
