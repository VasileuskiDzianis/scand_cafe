package by.scand.coffeeshop.dao.buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Buyer;

@Repository
public class BuyerDaoImpl extends BaseDao implements BuyerDao {

	@Override
	public int addOne(Buyer buyer) {
		Connection connection;
		connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet generatedKey = null;
		String dbReqAddBuyer = "INSERT INTO buyer(first_name,last_name,patronymic,address) VALUES(?,?,?,?);";
		int id = 0;

		try {
			prepStatement = connection.prepareStatement(dbReqAddBuyer, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, buyer.getFirstName());
			prepStatement.setString(2, buyer.getLastName());
			prepStatement.setString(3, buyer.getPatronymic());
			prepStatement.setString(4, buyer.getAddress());
			prepStatement.execute();
			generatedKey = prepStatement.getGeneratedKeys();
			if (generatedKey.next()) {
				id = generatedKey.getInt(1);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error: adding Buyer!", e);
		} finally

		{
			closeAll(generatedKey, prepStatement, connection);
		}
		return id;
	}

}
