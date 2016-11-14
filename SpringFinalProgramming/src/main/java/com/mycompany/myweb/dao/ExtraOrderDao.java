package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.ExtraOrder;
//이명진
@Component
public class ExtraOrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//1개 메뉴에 사이드 삽입
	public int insertXidOid(ExtraOrder extraorder){
		String sql = "insert into extra_order(xid, orid) values(?,?)";
		int row = jdbcTemplate.update(
				sql,
				extraorder.getXid(),
				extraorder.getOrid()
		);
		return row;		
	}
	
	
	
	//1개 메뉴에 대한 사이드 검색
	public ExtraOrder selectByXidOid(ExtraOrder extraorder){
		String sql = "select xid, oid from extra_order where (xid=? and orid=?)";
		List<ExtraOrder> list =  jdbcTemplate.query(sql, 
				new Object[]{extraorder.getXid(),extraorder.getOrid()}, 
				new RowMapper<ExtraOrder>(){
			
			@Override
			public ExtraOrder mapRow(ResultSet rs, int row) throws SQLException {
				ExtraOrder extraorder = new ExtraOrder();
				extraorder.setXid(rs.getInt("xid"));
				extraorder.setOrid(rs.getInt("orid"));
				
				return extraorder;
			}
		});
		return (list.size() != 0) ? list.get(0) : null;
	}
	
	//1개 메뉴에 대한 사이드 메뉴 삭제
	public int deleteXidOid(ExtraOrder extraorder){
		String sql = "delete from event where (xid=? and orid=?)";
		int row = jdbcTemplate.update(sql, extraorder.getXid(),extraorder.getOrid());
		return row;
	}
}
