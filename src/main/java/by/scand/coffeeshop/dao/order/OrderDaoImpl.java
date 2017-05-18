package by.scand.coffeeshop.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Order;

@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {
		
	@Override
	public int addOne(Order order) {
		Connection connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet generatedKey = null;
		String dbReqAddOrder = "INSERT INTO orders(date,buyer_id,discount,delivery,cost) VALUES(?,?,?,?,?);";
		
		try {
			prepStatement = connection.prepareStatement(dbReqAddOrder, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, new Timestamp(order.getDate().getTime()).toString());
			prepStatement.setInt(2, order.getBuyer().getId());
			prepStatement.setInt(3, order.getDiscount());
			prepStatement.setInt(4, order.getDelivery());
			prepStatement.setInt(5, order.getCost());
			prepStatement.execute();
			
			generatedKey = prepStatement.getGeneratedKeys();
			
			if (generatedKey.next()) {
				return generatedKey.getInt(1);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error: adding Order!", e);
		} finally {
			closeAll(generatedKey, prepStatement, connection);
		}
		
		return 0;
	}
}