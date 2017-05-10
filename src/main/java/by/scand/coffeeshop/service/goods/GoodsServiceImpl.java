package by.scand.coffeeshop.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.scand.coffeeshop.dao.goods.GoodsDao;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.exception.ServiceException;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDao goodsDao;
	
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public Goods getOneGoods(int id, String lang) throws ServiceException {
		Goods goods = null;
		try {
			goods = goodsDao.getOne(id, lang);
		} catch (DaoException e) {
			throw new ServiceException("Getting one goods error", e);
		}
		return goods;
	}

	@Override
	public List<Goods> getAllGoods(String lang) throws ServiceException {
		List<Goods> goods = null;
		try {
			goods = goodsDao.getAll(lang);
		} catch (DaoException e) {
			throw new ServiceException("Getting all goods error", e);
		}
		return goods;
	}

}
