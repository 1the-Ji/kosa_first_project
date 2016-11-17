package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Order;
//명진
@Component
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//삽입(완료)
	public int insert(Order order) {
		String sql = "insert into order_total(oid,ototalprice,otime,user_id,sid,howpay) values(seq_order_oid.nextval,?,sysdate,?,?,?);";
		int row = jdbcTemplate.update(
				sql, 
				order.getOtotalprice(),
				order.getUser_id(),
				order.getSid(),
				order.getHowpay()
				);
		return row;
	}

	
	
	//1개 주문 검색(완료)
	public Order selectByOid(int oid) {
		String sql = "select oid,ototalprice,otime,user_id,sid,howpay from order_total where oid=?";
		List<Order> list = jdbcTemplate.query(sql, 
				new Object[] {oid},
				new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int row) throws SQLException {
				Order order = new Order();
				order.setOid(rs.getInt("oid"));
				order.setOtotalprice(rs.getInt("ototalprice"));
				order.setOtime(rs.getDate("otime"));
				order.setUser_id(rs.getString("user_id"));
				order.setSid(rs.getString("sid"));
				order.setHowpay(rs.getString("howpay"));

				return order;
			}

		});
		return (list.size() != 0) ? list.get(0) : null;
	}
	
	//기간 주문 검색
	public List<Order> selectByTerm(int pageNo, int rowsPerPage, Date term1, Date term2) {
		String sql ="";
		sql += "select rn, oid, ototalprice, otime, user_id, sid, howpay ";
		sql += "from( ";
		sql += "select rownum as rn, oid, ototalprice, otime, user_id, sid, howpay ";
		sql += "from(select oid, ototalprice, otime, user_id, sid, howpay from order_total where otime between ? AND ? order by oid desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";

		List<Order> list = jdbcTemplate.query(sql,
				new Object[] { term1, term2, (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) }, new RowMapper<Order>() {

					@Override
					public Order mapRow(ResultSet rs, int row) throws SQLException {
						Order order = new Order();
						order.setOid(rs.getInt("oid"));
						order.setOtotalprice(rs.getInt("ototalprice"));
						order.setOtime(rs.getDate("otime"));
						order.setUser_id(rs.getString("user_id"));
						order.setSid(rs.getString("sid"));
						order.setHowpay(rs.getString("howpay"));

						return order;
					}

				});

		return list;
	}
	
	//모든 주문 검색(완료)
	public List<Order> selectByPage(int pageNo, int rowsPerPage) {
		String sql ="";
		sql += "select rn, oid, ototalprice, otime, user_id, sid, howpay ";
		sql += "from( ";
		sql += "select rownum as rn, oid, ototalprice, otime, user_id, sid, howpay ";
		sql += "from(select oid, ototalprice, otime, user_id, sid, howpay from order_total order by oid desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";

		List<Order> list = jdbcTemplate.query(sql,
				new Object[] { (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) }, new RowMapper<Order>() {

					@Override
					public Order mapRow(ResultSet rs, int row) throws SQLException {
						Order order = new Order();
						order.setOid(rs.getInt("oid"));
						order.setOtotalprice(rs.getInt("ototalprice"));
						order.setOtime(rs.getDate("otime"));
						order.setUser_id(rs.getString("user_id"));
						order.setSid(rs.getString("sid"));
						order.setHowpay(rs.getString("howpay"));

						return order;
					}

				});

		return list;
	}
	
	//삭제(완료)
		public int delete(int oid) {
			String sql = "delete from order_total where oid=?";
			int row = jdbcTemplate.update(sql, oid);
			return row;
		}
	
	//카운트(완료)
	public int count() {
		String sql = "select count(*) from order_total";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
}
