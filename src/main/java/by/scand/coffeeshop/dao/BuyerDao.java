package by.scand.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import by.scand.coffeeshop.domain.Buyer;

public class BuyerDao extends Dao<Buyer> {

	@Override
	public Buyer getOne(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Buyer> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOne(Buyer buyer) throws DaoException {
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
			prepStatement.setString(4, buyer.getShippingAddress());
			prepStatement.execute();
			generatedKey = prepStatement.getGeneratedKeys();
			if (generatedKey.next()) {
				id = generatedKey.getInt(1);
			}

		} catch (SQLException e) {
			throw new DaoException("Error: adding Buyer!", e);
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
		return id;
	}

	@Override
	public void addAll(List<Buyer> object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
