package by.scand.coffeeshop.dao.localization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.service.localization.LocalizationService;

@Repository
public class LocalizationDaoImpl extends BaseDao implements LocalizationDao {

	@Override
	public void getLocalization(LocalizationService localizationServiceImpl) throws DaoException {
		Connection connection;

		connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetLocalization = "SELECT attribute," + localizationServiceImpl.getLanguage() + " FROM localization;";
		Map<String, String> parameters = new HashMap<String, String>();

		try {
			prepStatement = connection.prepareStatement(dbReqGetLocalization);
			resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				parameters.put(resultSet.getString("attribute"), resultSet.getString(localizationServiceImpl.getLanguage()));
			}

			localizationServiceImpl.setAttributes(parameters);

		} catch (SQLException e) {
			throw new DaoException("Error: getting business rules!", e);
		} finally

		{
			closeAll(resultSet, prepStatement, connection);
		}
	}

}
