package by.scand.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.scand.coffeeshop.domain.BusinessRules;
import by.scand.coffeeshop.domain.BusinessRulesImpl;

public class BusinessRulesDao extends Dao<BusinessRules> {

	@Override
	public BusinessRules getOne(int id) throws DaoException {
		Connection connection;

		connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetBusineesRules = "SELECT * FROM business_rules;";
		BusinessRulesImpl rules = new BusinessRulesImpl();

		try {
			prepStatement = connection.prepareStatement(dbReqGetBusineesRules);
			resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("property").equals("delivery")){
					rules.setDeliveryCost(resultSet.getInt("value"));
				}
				if (resultSet.getString("property").equals("free_cup")){
					rules.setEachNCupFree(resultSet.getInt("value"));
				}
				if (resultSet.getString("property").equals("free_delivery")){
					rules.setFreeDeliveryBorder(resultSet.getInt("value"));
				}
			}

		} catch (SQLException e) {
			throw new DaoException("Error: getting business rules!", e);
		} finally

		{
			try {
				if (resultSet != null)
					resultSet.close();
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
		return rules;
	}

	@Override
	public List<BusinessRules> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOne(BusinessRules object) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAll(List<BusinessRules> object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
