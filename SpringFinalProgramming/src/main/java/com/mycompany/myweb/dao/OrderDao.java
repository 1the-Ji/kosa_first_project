package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Order;

@Component
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Order order) {
		String sql = "insert into order_table(oid,ordercount,ototalprice,otime,user_id) "
				+ "values(seq_order_oid.nextval,?,?,sysdate,?)";

		int row = jdbcTemplate.update(sql, order.getOrdercount(), order.getOtotalprice(),
				order.getUser_id());
		return row;
	}


	public int delete(int oid) {
		String sql = "delete from order_table where oid=?";

		int row = jdbcTemplate.update(sql, oid);

		return row;
	}

	public Order selectByOid(int oid) {
		String sql = "select oid,ordercount,ototalprice,otime,user_id " + "from order_table where oid=?";

		List<Order> list = jdbcTemplate.query(sql, new Object[] { oid }, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int row) throws SQLException {
				Order order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setOrdercount(rs.getInt("ordercount"));
				order.setOtotalprice(rs.getInt("ototalprice"));
				order.setOtime(rs.getDate("otime"));
				order.setUser_id(rs.getInt("user_id"));

				return order;
			}

		});
		return (list.size() != 0) ? list.get(0) : null;
	}

	public List<Order> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "";
		sql += "select rn, oid, ordercount, ototalprice, otime, user_id ";
		sql += "from ( ";
		sql += "select rownum as rn, oid, ordercount, ototalprice, otime, user_id ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn >= ? ";

		List<Order> list = jdbcTemplate.query(sql,
				new Object[] { (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) }, new RowMapper<Order>() {

					@Override
					public Order mapRow(ResultSet rs, int row) throws SQLException {
						Order order = new Order();
						order.setOid(rs.getInt("oid"));
						order.setOrdercount(rs.getInt("ordercount"));
						order.setOtotalprice(rs.getInt("ototalprice"));
						order.setOtime(rs.getDate("otime"));
						order.setUser_id(rs.getInt("user_id"));

						return order;
					}

				});

		return list;
	}

	public int count() {
		String sql = "select count(*) from order_table";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
}
