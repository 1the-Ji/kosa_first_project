package com.mycompany.myweb.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.EventDao;
import com.mycompany.myweb.dto.Event;


@Component
public class EventService {
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	
	private static final Logger logger = LoggerFactory.getLogger(EventDao.class);
	
	
	@Autowired
	private EventDao eventDao;
	
<<<<<<< HEAD
	public List<Event> getList(String sid){
=======
	public List<Event> getList(int eid){//김정호 파라미터 int eid추가(임시 수정)
>>>>>>> 318dde86730b03e187a399c751aa1c61458d51c9
		logger.info("getList 처리");
		List<Event> list = eventDao.selectList(sid);
		return list;
	}

	public int write(Event event){
		int row = eventDao.insert(event);
		return WRITE_SUCCESS;
	}
	 
	public int modify(Event event){
		int row = eventDao.update(event);	
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int eid){
		int row = eventDao.delete(eid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	} 
	
	public Event info(int eid){
		return eventDao.selectByEid(eid);		
	}
	
}
