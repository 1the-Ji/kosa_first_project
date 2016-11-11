package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.EventMenu;
import com.mycompany.myweb.dto.Order;

@Component
public class EventMenuDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(EventMenu eventmenu){
		String sql = "insert into event_menu_table(emid,dc_price,eid,mid) values(seq_eventmenu_emid.nextval,?,?,?)";
		int row = jdbcTemplate.update(sql,eventmenu.getDc_price(),eventmenu.getEid(),eventmenu.getMid());
		return row;
	}
	
	public int update(EventMenu eventmenu){
		String sql ="update event_menu_table set dc_price=?";
		int row = jdbcTemplate.update(sql,eventmenu.getDc_price());
		return row;
	}
	
	public int delete(int emid){
		String sql = "delete from event_menu_table where emid=?";
		int row = jdbcTemplate.update(sql, emid);
		return row;
	}
	
	public EventMenu selectByEmid(int emid){
		String sql = "select emid,dc_price,eid,mid from event_menu_table where emid=?";
		List<EventMenu> list = jdbcTemplate.query(sql, new Object[]{emid}, new RowMapper<EventMenu>(){

			@Override
			public EventMenu mapRow(ResultSet rs, int row) throws SQLException {
				EventMenu eventmenu = new EventMenu();
				eventmenu.setEmid(rs.getInt("emid"));
				eventmenu.setDc_price(rs.getInt("dc_price"));
				eventmenu.setEid(rs.getInt("eid"));
				eventmenu.setMid(rs.getInt("mid"));
				return eventmenu;
			}
		});
		
		return (list.size() != 0) ? list.get(0) : null;
	}
	
	public List<EventMenu> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "";
		sql += "select rn, oid, ordercount, ototalprice, otime, user_id ";
		sql += "from ( ";
		sql += "select rownum as rn, oid, ordercount, ototalprice, otime, user_id ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn >= ? ";

		List<EventMenu> list = jdbcTemplate.query(sql,
				new Object[] { (pageNo * rowsPerPage), ((pageNo - 1) * rowsPerPage + 1) }, new RowMapper<EventMenu>() {

					@Override
					public EventMenu mapRow(ResultSet rs, int row) throws SQLException {
						EventMenu eventmenu = new EventMenu();
						eventmenu.setEmid(rs.getInt("emid"));
						eventmenu.setDc_price(rs.getInt("dc_price"));
						eventmenu.setEid(rs.getInt("eid"));
						eventmenu.setMid(rs.getInt("mid"));

						return eventmenu;
					}
				});
		return list;
	}

	public int count() {
		String sql = "select count(*) from event_menu_table";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}
	

}
