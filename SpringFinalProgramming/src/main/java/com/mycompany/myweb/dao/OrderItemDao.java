package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.OrderItem;
//이명진
@Component
public class OrderItemDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//주문 품목 삽입(1개)
	public int insertOrid(OrderItem orderitem){
		String sql = "insert into order_item(orid, oid, mid) values(?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				orderitem.getOrid(),
				orderitem.getMid(),
				orderitem.getOid()
		);
		return row;		
	}
	
	//주문 품목 검색(1개)
	public OrderItem selectByOrid(int orid){
		String sql = "select orid,mid,oid from order_item where orid=?";
		List<OrderItem> list = jdbcTemplate.query(sql, new Object[]{orid}, new RowMapper<OrderItem>(){
			@Override
			public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
				OrderItem orderitem = new OrderItem();
				orderitem.setOrid(rs.getInt("orid"));
				orderitem.setOid(rs.getInt("oid"));
				orderitem.setMid(rs.getInt("mid"));
				
				return orderitem;
			}
			
		});
		return (list.size() != 0)?list.get(0):null;
	}
	
	//주문 품목 목록(다수)
	public List<OrderItem> selectByOridAll(int pageNo, int rowsPerPage){
		String sql ="";
		sql += "select rn, orid, oid, mid ";
		sql += "from( ";
		sql += "select rownum as rn, orid, oid, mid ";
		sql += "from(select orid, oid, mid from order_item order by oid desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<OrderItem> list = jdbcTemplate.query(sql, 
				new Object[]{pageNo*rowsPerPage,(pageNo-1)*rowsPerPage+1}, 
				new RowMapper<OrderItem>(){

					@Override
					public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
						OrderItem orderitem = new OrderItem();
						orderitem.setOrid(rs.getInt("orid"));
						orderitem.setMid(rs.getInt("mid"));
						orderitem.setOid(rs.getInt("oid"));
						
						return orderitem;
					}
			
		});
		return list;
	}
	
	//주문 품목 수정(1개)(주문 1건에 대한)(필요없음 서비스단에서 dao 섞어서 쓰면 됨)
	/*public int updateOrid(OrderItem orderitem){
		String sql = "update order_item set oid=?, mid=? where orid=?";
		
		int row = jdbcTemplate.update(sql, 
				orderitem.getOrid(),
				orderitem.getOrid()
				
				);
		return row;
	}*/
	
	//주문 품목 삭제
	public int deleteOrid(OrderItem orderitem){
		String sql = "delete from order_item where orid=?";
		int row = jdbcTemplate.update(sql, orderitem.getOrid());
		return row;
		
	}
	//주문 품목 카운트
	public int countOrid(){
		String sql = "select count(*) from order_item";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}
