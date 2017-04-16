package by.scand.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.domain.OrderItem;

public class OrderDao extends Dao<Order> {

	private Dao<OrderItem> orderItemDao;
	private Dao<Buyer> buyerDao;

	public void setOrderItemDao(Dao<OrderItem> orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	public void setBuyerDao(Dao<Buyer> buyerDao) {
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
		} finally

		{
			try {
				if (generatedKey != null)
					generatedKey.close();
			} catch (SQLException e) {
				throw new DaoException("Error: result set closing", e);
			}
			try {
				if (prepStatement != null)
					prepStatement.close();
			} catch (SQLException e) {
				throw new DaoException("Error: prepared statement closing", e);
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				throw new DaoException("Error: connection closing", e);
			}

		}
		// for every OrderItem we set order id
		for (OrderItem orderItem : order.getItems()) {
			orderItem.setOrderId(orderId);
		}

		orderItemDao.addAll(order.getItems());

		return orderId;
	}

	@Override
	public void addAll(List<Order> object) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
