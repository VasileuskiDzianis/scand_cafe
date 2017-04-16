package by.scand.coffeeshop.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.scand.coffeeshop.domain.Goods;

public class GoodsDaoMock extends GoodsDao{
	private Goods goods1 = new Goods(1,"Coffe sort 1", 150, 'Y');
	private Goods goods2 = new Goods(2, "Coffe sort 2", 200, 'N');
	private Goods goods3 = new Goods(3, "Coffe sort 3", 100, 'Y');
	private Goods goods4 = new Goods(4, "Coffe sort 4", 100, 'N');
	private List<Goods> goods = new ArrayList<Goods>(Arrays.asList(goods1, goods2, goods3, goods4));
	@Override
	
	public Goods getOne(int id) {
		Goods oneItem = null;
		for (Goods product : goods) {
			if (product.getId() == id){
				oneItem = product;
				break;
			} 
		}
		return oneItem;
	}

	@Override
	public List<Goods> getAll() {
		
		
		return goods;
	}

}
