package by.scand.coffeeshop.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import by.scand.coffeeshop.exception.DaoException;

public abstract class BaseDao {

	@Resource(name = "dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected Connection getConnection() throws DaoException {

		Properties property = new Properties();
		Connection connection = null;

		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");
			property.load(inputStream);
			inputStream.close();

		} catch (IOException e) {
			throw new DaoException("Error: property file wasn't found!", e);
		}
		// for using Tomcat DBCP set connectionType=dbcp in db.properties
		if (property.getProperty("connectionType").equals("dbcp")) {
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				throw new DaoException("Error: getting connection from DBCP was faulted", e);
			}
		} else {
			try {
				Class.forName(property.getProperty("driverClassName"));
			} catch (ClassNotFoundException e) {
				throw new DaoException("Error: JDBC driver wasn't found!", e);
			}

			try {
				connection = DriverManager.getConnection(property.getProperty("url"), property);
			} catch (SQLException e) {
				throw new DaoException("Error: getting connection was faulted", e);
			}

		}

		return connection;
	}

	protected void closeAll(ResultSet resultSet, Statement statement, Connection connection) throws DaoException {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			throw new DaoException("Error: result set closing", e);
		}
		try {
			if (statement != null)
				statement.close();
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

	protected int getOneIntProperty(String tableName, String propertyName) throws DaoException {
		Connection connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		int property = 0;
		String dbReqGetProperty = "SELECT value FROM " + tableName + " WHERE property=?;";
		try {
			prepStatement = connection.prepareStatement(dbReqGetProperty);
			prepStatement.setString(1, propertyName);
			resultSet = prepStatement.executeQuery();
			if (resultSet.next()) {
				property = resultSet.getInt("value");
			}

		} catch (SQLException e) {
			throw new DaoException("Error: getting int property from database", e);
		} finally {
			closeAll(resultSet, prepStatement, connection);
		}
		return property;

	}

}
