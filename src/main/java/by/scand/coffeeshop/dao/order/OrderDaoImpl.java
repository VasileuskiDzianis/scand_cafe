package by.scand.coffeeshop.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.dao.buyer.BuyerDao;
import by.scand.coffeeshop.dao.orderitem.OrderItemDao;
import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.DaoException;

@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private BuyerDao buyerDao;

	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	public void setBuyerDao(BuyerDao buyerDao) {
		this.buyerDao = buyerDao;
	}

	@Override
	public int addOne(Order order) throws DaoException {
		int buyerId;
		buyerId = buyerDao.addOne(order.getBuyer());

		Connection connection;
		connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet generatedKey = null;
		String dbReqAddOrder = "INSERT INTO orders(date,buyer_id,discount,delivery,cost) VALUES(?,?,?,?,?);";
		int orderId = 0;

		try {
			prepStatement = connection.prepareStatement(dbReqAddOrder, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, new Timestamp(order.getDate().getTime()).toString());
			prepStatement.setInt(2, buyerId);
			prepStatement.setInt(3, order.getDiscount());
			prepStatement.setInt(4, order.getDelivery());
			prepStatement.setInt(5, order.getCost());
			prepStatement.execute();
			generatedKey = prepStatement.getGeneratedKeys();
			if (generatedKey.next()) {
				orderId = generatedKey.getInt(1);
			}

		} catch (SQLException e) {
			throw new DaoException("Error: adding Order!", e);
		} finally {
			closeAll(generatedKey, prepStatement, connection);
		}
		// for every OrderItem we set order id
		for (OrderItem orderItem : order.getItems()) {
			orderItem.setOrderId(orderId);
		}

		orderItemDao.addAll(order.getItems());

		return orderId;
	}

}
