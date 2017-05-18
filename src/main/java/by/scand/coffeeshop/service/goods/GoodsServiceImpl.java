package by.scand.coffeeshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.goods.GoodsDao;
import by.scand.coffeeshop.domain.Goods;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public Goods getOneGoodsById(int id, String lang) {

		return goodsDao.getOneById(id, lang);
	}

	@Override
	public List<Goods> getAllGoods(String lang) {

		return goodsDao.getAll(lang);
	}
}