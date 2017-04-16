package by.scand.coffeeshop.domain;

import java.util.ArrayList;
import java.util.List;

import by.scand.coffeeshop.dao.Dao;
import by.scand.coffeeshop.dao.DaoException;
import by.scand.coffeeshop.dao.GoodsDao;

public class Catalog {

	private List<Goods> goods;
	private Dao<Goods> dao;

	public Catalog() {
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.dao = goodsDao;
	}

	public List<Goods> getCatalog() {
		goods = new ArrayList<Goods>();
		List<Goods> allGoods = null;
		try {
			allGoods = dao.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Goods product : allGoods) {
			if (product.getDisabled() == 'N') { //throw out goods where (disabled != 'N')
				goods.add(product);
			}
		}

		return goods;
	}
	
	public Goods getOneItemOfGoods(int id){
		Goods goods = null;
		try {
			goods = dao.getOne(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

}
