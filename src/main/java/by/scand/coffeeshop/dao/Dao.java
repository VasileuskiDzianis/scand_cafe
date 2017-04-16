package by.scand.coffeeshop.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public abstract class Dao/*<T>*/ {
	
	protected Connection getConnection() throws DaoException{
		
        Properties property = new Properties();
        Connection connection = null;
 
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");
            property.load(inputStream);
                         
        } catch (IOException e) {
        	throw new DaoException("Error: property file wasn't found!", e);
        }
        
        try {
			Class.forName(property.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new DaoException("Error: JDBC driver wasn't found!", e);
		}
        
        try {
			connection = DriverManager.getConnection(property.getProperty("url"),property);
		} catch (SQLException e) {
			throw new DaoException("Error: getting connection was faulted", e);
		}
        
     return connection;   
	}
	
	//abstract public T getOne(int id) throws DaoException;
	//abstract public List<T> getAll() throws DaoException;
	//abstract public int addOne(T object) throws DaoException;
	//abstract public void addAll(List<T> object) throws DaoException;

}
