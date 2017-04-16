package by.scand.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;

public class OrderItemDao extends Dao {

	public void addAll(List<OrderItem> orderItems) throws DaoException {
		Connection connection;
		connection = getConnection();
		PreparedStatement prepStatement = null;
		String dbAddOrderItem = "INSERT INTO order_item(order_id,goods_id,amount) VALUES(?,?,?);";

		try {
			prepStatement = connection.prepareStatement(dbAddOrderItem);
			connection.setAutoCommit(false);
			for (OrderItem orderItem : orderItems) {
				prepStatement.setInt(1, orderItem.getOrderId());
				prepStatement.setInt(2, orderItem.getGoods().getId());
				prepStatement.setInt(3, orderItem.getAmount());
				prepStatement.addBatch();
			}

			prepStatement.executeBatch();
			connection.commit();

		} catch (SQLException e) {
			throw new DaoException("Error: adding order items!", e);
		} finally

		{

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

	}

}
