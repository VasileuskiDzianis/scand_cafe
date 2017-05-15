package by.scand.coffeeshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.scand.coffeeshop.dao.goods.GoodsDao;
import by.scand.coffeeshop.domain.Goods;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDao goodsDao;

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public Goods getOneGoods(int id, String lang) {
		Goods goods = null;
		goods = goodsDao.getOne(id, lang);
		return goods;
	}

	@Override
	public List<Goods> getAllGoods(String lang) {
		List<Goods> goods = null;
		goods = goodsDao.getAll(lang);
		return goods;
	}

}
