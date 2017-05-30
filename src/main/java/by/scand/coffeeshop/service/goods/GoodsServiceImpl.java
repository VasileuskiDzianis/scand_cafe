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
	public Goods getOneGoodsById(int id) {

		return goodsDao.getOneById(id);
	}

	@Override
	public List<Goods> getAllGoods() {

		return goodsDao.getAll();
	}
}