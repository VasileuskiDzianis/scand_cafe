package by.scand.coffeeshop.dao.orderitem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.DaoException;

@Repository
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	@Override
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
		} finally {
			closeAll(null, prepStatement, connection);
		}
	}
}
