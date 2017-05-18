package by.scand.coffeeshop.dao.goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Goods;

@Repository
public class GoodsDaoImpl extends BaseDao implements GoodsDao {

	@Override
	public Goods getOneById(int id, String lang) {

		Connection connection = getConnection();
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		String dbReqGetGoods = "SELECT * FROM goods WHERE id=?;";

		try {
			prepStatement = connection.prepareStatement(dbReqGetGoods);
			prepStatement.setInt(1, id);
			resultSet = prepStatement.executeQuery();

			if (resultSet.next()) {
				return new Goods(resultSet.getInt("id"), resultSet.getString("name" + "_" + lang),
								 resultSet.getInt("price"), resultSet.getString("disabled").charAt(0));
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error: getting one Goods!", e);
		} finally {
			closeAll(resultSet, prepStatement, connection);
		}

		return null;
	}

	@Override
	public List<Goods> getAll(String lang) {
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
			throw new RuntimeException("Error: getting all Goods!", e);
		} finally {
			closeAll(resultSet, prepStatement, connection);
		}

		return goodsList;
	}

}
