package by.scand.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.scand.coffeeshop.domain.Goods;

public class GoodsDao extends Dao{

	
	public Goods getOne(int id, String lang) throws DaoException {
		Connection connection;

		connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetGoods = "SELECT * FROM goods WHERE id=?;";
		Goods goods = new Goods();

		try {
			prepStatement = connection.prepareStatement(dbReqGetGoods);
			prepStatement.setInt(1, id);
			resultSet = prepStatement.executeQuery();
			if (resultSet.next()) {
				goods.setId(resultSet.getInt("id"));
				goods.setName(resultSet.getString("name"+"_"+lang));
				goods.setPrice(resultSet.getInt("price"));
				goods.setDisabled(resultSet.getString("disabled").charAt(0));
			}

		} catch (SQLException e) {
			throw new DaoException("Error: getting one Goods!", e);
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

		return goods;
	}

	
	public List<Goods> getAll(String lang) throws DaoException {
		Connection connection;

		connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetAllGoods = "SELECT * FROM goods;";
		List<Goods> goodsList = new ArrayList<Goods>();

		try {
			prepStatement = connection.prepareStatement(dbReqGetAllGoods);
			resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				goodsList.add(new Goods(
						resultSet.getInt("id"), 
						resultSet.getString("name"+"_"+lang), 
						resultSet.getInt("price"),
						resultSet.getString("disabled").charAt(0)));
			}

		} catch (SQLException e) {
			throw new DaoException("Error: getting all Goods!", e);
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

		return goodsList;
	}

}
