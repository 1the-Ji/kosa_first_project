package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.ExtraOrder;
//이명진
@Component
public class ExtraOrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//1개 메뉴에 대한 사이드 상세 검색
		public Extra selectByXid(int xid){
			String sql = "select xid, xname, xprice from extra where xid=?";
			List<Extra> list =  jdbcTemplate.query(sql, 
					new Object[]{xid}, 
					new RowMapper<Extra>(){
		  		
				@Override
				public Extra mapRow(ResultSet rs, int row) throws SQLException {
					Extra extra = new Extra();
					extra.setXid(rs.getInt("xid"));
					extra.setXname(rs.getString("xname"));
					extra.setXprice(rs.getInt("xprice"));
					
					return extra;
				}
			});
			return (list.size() != 0) ? list.get(0) : null;
		}
	
		//1개 주문 품목에 대한 사이드 검색
		public int selectXidByOrid(int orid){
			String sql = "select xid from extra_order where orid=?";
			List<Integer> list =  jdbcTemplate.query(sql, 
					new Object[]{orid}, 
					new RowMapper<Integer>(){
		  		
				@Override
				public Integer mapRow(ResultSet rs, int row) throws SQLException {
					ExtraOrder extraorder = new ExtraOrder();
					extraorder.setXid(rs.getInt("xid"));
					extraorder.setOrid(rs.getInt("orid"));
					
					return extraorder.getXid();
				}
			});
			return (list.size() != 0) ? list.get(0) : null;
		}
		
	//1개 메뉴에 사이드 삽입
	public int insertXidOrid(ExtraOrder extraorder){
		String sql = "insert into extra_order(xid, orid) values(?,?)";
		int row = jdbcTemplate.update(
				sql,
				extraorder.getXid(),
				extraorder.getOrid()
		);
		return row;		
	}
	
	
	
	//1개 메뉴에 대한 사이드 검색
	public ExtraOrder selectByXidOrid(ExtraOrder extraorder){
		String sql = "select xid, orid from extra_order where (xid=? and orid=?)";
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
	public int deleteXidOrid(ExtraOrder extraorder){
		String sql = "delete from event where (xid=? and orid=?)";
		int row = jdbcTemplate.update(sql, extraorder.getXid(),extraorder.getOrid());
		return row;
	}
}
