package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.ExtraOrder;

@Component
public class ExtraOrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//사이드 메뉴 삽입
	public int insert(ExtraOrder extraorder){
		String sql = "insert into extra_order(xid, oid) values(?, ?)";
		int row = jdbcTemplate.update(
				sql,
				extraorder.getXid(),
				extraorder.getOid()
		);
		return row;		
	}
	
	//사이드 메뉴 검색
	public ExtraOrder select(ExtraOrder extraorder){
		String sql = "select xid, oid from extra_order where (xid=? and oid=?)";
		List<ExtraOrder> list =  jdbcTemplate.query(sql, 
				new Object[]{extraorder.getXid(),extraorder.getOid()}, 
				new RowMapper<ExtraOrder>(){
			
			@Override
			public ExtraOrder mapRow(ResultSet rs, int row) throws SQLException {
				ExtraOrder extraorder = new ExtraOrder();
				extraorder.setXid(rs.getInt("xid"));
				extraorder.setOid(rs.getInt("oid"));
				
				return extraorder;
			}
		});
		return (list.size() != 0) ? list.get(0) : null;
	}
	
	//사이드 메뉴 삭제
	public int delete(ExtraOrder extraorder){
		String sql = "delete from event where (xid=? and oid=?)";
		int row = jdbcTemplate.update(sql, extraorder.getXid(),extraorder.getOid());
		return row;
	}
}