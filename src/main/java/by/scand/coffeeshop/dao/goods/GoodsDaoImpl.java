package by.scand.coffeeshop.dao.goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.exception.DaoException;

@Repository
public class GoodsDaoImpl extends BaseDao implements GoodsDao {

	
		
	@Override
	public Goods getOne(int id, String lang) throws DaoException {
		Connection connection = null;

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
				goods.setName(resultSet.getString("name" + "_" + lang));
				goods.setPrice(resultSet.getInt("price"));
				goods.setDisabled(resultSet.getString("disabled").charAt(0));
			}

		} catch (SQLException e) {
			throw new DaoException("Error: getting one Goods!", e);
		} finally {
			closeAll(resultSet, prepStatement, connection);
		}

		return goods;
	}

	@Override
	public List<Goods> getAll(String lang) throws DaoException {
		Connection connection;

		connection = getConnection();
		
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetAllGoods = "SELECT * FROM goods WHERE disabled=\'N\';";
		List<Goods> goodsList = new ArrayList<Goods>();

		try {
			prepStatement = connection.prepareStatement(dbReqGetAllGoods);
			resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				goodsList.add(new Goods(resultSet.getInt("id"), resultSet.getString("name" + "_" + lang),
						resultSet.getInt("price"), resultSet.getString("disabled").charAt(0)));
			}

		} catch (SQLException e) {
			throw new DaoException("Error: getting all Goods!", e);
		} finally {
			closeAll(resultSet, prepStatement, connection);
		}

		return goodsList;
	}

}
