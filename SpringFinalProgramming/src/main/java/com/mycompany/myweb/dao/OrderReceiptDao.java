package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.OrderReceipt;
//이명진
@Component
public class OrderReceiptDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//주문 영수중 삽입
	public int insert(OrderReceipt orderreceipt){
		String sql = "insert into order_receipt(mid, oid) values(?, ?)";
		int row = jdbcTemplate.update(
				sql,
				orderreceipt.getMid(),
				orderreceipt.getOid()
		);
		return row;		
	}
	
	//주문 영수증 검색
	public OrderReceipt selectByMidOid(OrderReceipt orderreceipt){
		String sql = "select mid,oid from orderreceipt where (mid = ? and oid = ?)";
		List<OrderReceipt> list = jdbcTemplate.query(sql, new Object[]{orderreceipt.getMid(),orderreceipt.getOid()}, new RowMapper<OrderReceipt>(){
			@Override
			public OrderReceipt mapRow(ResultSet rs, int row) throws SQLException {
				OrderReceipt orderreceipt = new OrderReceipt();
				orderreceipt.setMid(rs.getInt("mid"));
				orderreceipt.setOid(rs.getInt("oid"));
				
				return orderreceipt;
			}
			
		});
		return (list.size() != 0)?list.get(0):null;
	}
	
	//주문 영수증 목록
	public List<OrderReceipt> selectByPage(int pageNo, int rowsPerPage){
		String sql ="";
		sql += "select rn, mid, oid ";
		sql += "from( ";
		sql += "select rownum as rn, mid, oid ";
		sql += "from(select mid, oid from orderreceipt order by oid desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<OrderReceipt> list = jdbcTemplate.query(sql, 
				new Object[]{pageNo*rowsPerPage,(pageNo-1)*rowsPerPage+1}, 
				new RowMapper<OrderReceipt>(){

					@Override
					public OrderReceipt mapRow(ResultSet rs, int row) throws SQLException {
						OrderReceipt orderreceipt = new OrderReceipt();
						orderreceipt.setMid(rs.getInt("mid"));
						orderreceipt.setOid(rs.getInt("oid"));
						
						return orderreceipt;
					}
			
		});
		return list;
	}
	//주문 영수증 수정
	public int update(OrderReceipt orderreceipt){
		String sql = "update orderreceipt set mid=?,oid=? where (mid = ? and oid = ?)";
		
		int row = jdbcTemplate.update(
				sql, 
				orderreceipt.getMid(),
				orderreceipt.getOid()
				);
		return row;
	}
	
	//주문 영수증 삭제
	public int delete(OrderReceipt orderreceipt){
		String sql = "delete from orderreceipt where (mid = ? and oid = ?)";
		int row = jdbcTemplate.update(sql, orderreceipt.getMid(), orderreceipt.getOid());
		return row;
		
	}
	//주문 영수증 카운트
	public int count(){
		String sql = "select count(*) from orderreceipt";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}
