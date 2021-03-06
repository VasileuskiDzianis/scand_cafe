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

public abstract class BaseDao {

	@Resource(name = "dataSource")
	private DataSource dataSource;

	protected Connection getConnection() {
		Properties property = new Properties();
		Connection connection = null;

		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");
			property.load(inputStream);
			inputStream.close();

		} catch (IOException e) {
			throw new RuntimeException("Error: property file wasn't found!", e);
		}

		// for using Tomcat DBCP set connectionType=dbcp in db.properties
		if (property.getProperty("connectionType").equals("dbcp")) {
			try {
				connection = dataSource.getConnection();
				return connection;
			} catch (SQLException e) {
				throw new RuntimeException("Error: getting connection from DBCP was faulted", e);
			}
		}
		
		try {
			Class.forName(property.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Error: JDBC driver wasn't found!", e);
		}

		try {
			connection = DriverManager.getConnection(property.getProperty("url"), property);
		} catch (SQLException e) {
			throw new RuntimeException("Error: getting connection was faulted", e);
		}

		return connection;
	}

	protected void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
		
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error: result set closing", e);
		}
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error: prepared statement closing", e);
		}
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error: connection closing", e);
		}
	}

	protected int getOneIntProperty(String tableName, String propertyName) {
		Connection connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetProperty = "SELECT value FROM " + tableName + " WHERE property=?;";
		
		try {
			prepStatement = connection.prepareStatement(dbReqGetProperty);
			prepStatement.setString(1, propertyName);
			resultSet = prepStatement.executeQuery();
			if (resultSet.next()) {
				
				return resultSet.getInt("value");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error: getting int property from database", e);
		} finally {
			closeAll(resultSet, prepStatement, connection);
		}
		
		return 0;
	}
}
