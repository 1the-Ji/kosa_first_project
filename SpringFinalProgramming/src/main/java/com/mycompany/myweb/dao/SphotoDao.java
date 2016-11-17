package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Sphoto;

/*작성자: 이윤주*/

@Component
public class SphotoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Sphoto sphoto) {
		String sql = "insert into Sphoto(spic_id, spic_savedfile, spic_mimetype, sid) "
				+ "values(SEQ_SPHOTO_SPID.nextval,?,?,?) ";

		int row = jdbcTemplate.update(sql, sphoto.getSpic_savedfile(), sphoto.getSpic_mimetype(), sphoto.getSid());

		return row;
	}

	public int update(Sphoto sphoto){
      String sql = "update sphoto set spic_savedfile=?, spic_mimetype=?, where spic_id=? ";
   
   int row = jdbcTemplate.update(
         sql,
         sphoto.getSpic_savedfile(),
         sphoto.getSpic_mimetype(),
         sphoto.getSpic_id()
         );
   
   return row;
}

	public int delete(int spic_id) {
		String sql = "delete from sphoto where spic_id=? ";
		int row = jdbcTemplate.update(sql, spic_id);
		return row;

	}

	public Sphoto selectBySpic_id(int spic_id) {
		String sql = "select spic_id, spic_savedfile from sphoto where spic_id=? ";

		List<Sphoto> list = jdbcTemplate.query(sql, new Object[] { spic_id }, new RowMapper<Sphoto>() {

			@Override
			public Sphoto mapRow(ResultSet rs, int row) throws SQLException {
				Sphoto sphoto = new Sphoto();
				sphoto.setSpic_id(rs.getInt("spic_id"));
				sphoto.setSpic_savedfile(rs.getString("savedfile"));
				sphoto.setSpic_mimetype(rs.getString("smimetype"));
				sphoto.setSid(rs.getString("sid"));

				return sphoto;
			}

		});
		return (list.size() != 0) ? list.get(0) : null;
	}
	
	
	/*public List<Sphoto> selectByPage(int pageNo, int rowsPerPage){//rowsPerPage : 한 페이지의 갯수 pageNo : 페이지 번호(ex. 1page, 2page, 3page)
	      String sql="";
	      sql += "select rn, spic_id, spic_savedfile ";//이미지는 화면에 보여 지기만 하면 되므로 서버에 저장 되있는 이미지인 savedfile만 적는다.
	      sql += "from ( ";
	      sql += "select rownum as rn, spic_id, spic_savedfile ";
	      sql += "from (select spic_id, spic_savedfile from sphoto order by spic_id desc) ";
	      sql += "where rownum<=? ";
	      sql += ") ";
	      sql += "where rn>=? ";
	      List<Sphoto> list = jdbcTemplate.query(
	            sql, 
	            new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1)},
	            //((pageNo-1)*rowsPerPage+1) => 한페이당 시작 번호 (1,11,21,31.....)
	            //(pageNo*rowsPerPage) => 한페이지당 나오는 게시판 개수
	            new RowMapper<Sphoto>(){
	               @Override
	               public Sphoto mapRow(ResultSet rs, int row) throws SQLException {
	            	   Sphoto sphoto = new Sphoto();
	            	   sphoto.setSpic_id(rs.getInt("spic_id"));
	            	   sphoto.setSpic_savedfile(rs.getString("spic_savedfile"));
	                  return sphoto;
	               }
	            }
	      );
	      return list;
	   }
	
	
	public int count(){
		String sql = "select count(*) from sphoto";//count(*) => 무조건 하나의 값이 넘어 온다. (0도 값)
		int count = jdbcTemplate.queryForObject(sql, Integer.class);//queryForObject = select 문으로 무조건 값이 넘어 오는 경우 사용
		
		return count;
	}*/
	
	public List<Sphoto> selectAll(String sid){
		String sql = "select spic_id, spic_savedfile, spic_mimetype, sid from sphoto where sid=?";
		
		List<Sphoto> list = jdbcTemplate.query(sql, new Object[]{sid}, new RowMapper<Sphoto>() {
				@Override
				public Sphoto mapRow(ResultSet rs, int rowNum) throws SQLException {
					Sphoto sphoto = new Sphoto();
					sphoto.setSpic_id(rs.getInt("spic_id"));
					sphoto.setSpic_savedfile(rs.getString("spic_savedfile"));
					sphoto.setSpic_mimetype(rs.getString("spic_mimetype"));
					return sphoto;
				}
		});
		
		return list;
	}
}