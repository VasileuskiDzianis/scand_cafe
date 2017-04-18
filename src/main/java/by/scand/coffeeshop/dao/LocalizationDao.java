package by.scand.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import by.scand.coffeeshop.view.language.Localization;

public class LocalizationDao extends Dao {

	public void getLocalization(Localization localization) throws DaoException {
		Connection connection;

		connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetLocalization = "SELECT attribute,"+localization.getLanguage()+" FROM localization;";
		Map<String,String> parameters = new HashMap<String,String>();
		
		try {
			prepStatement = connection.prepareStatement(dbReqGetLocalization);
			resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				parameters.put(resultSet.getString("attribute"), resultSet.getString(localization.getLanguage()));
			}
			
			localization.setAttributes(parameters);

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
	}

}
