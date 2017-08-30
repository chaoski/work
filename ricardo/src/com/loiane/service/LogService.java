package com.loiane.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiane.dao.LogDAO;
import com.loiane.model.Log;
import com.loiane.util.Util;

/**
 * Contact Service
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Service
public class LogService {
	
	private LogDAO logDAO;
	private Util util;

	/**
	 * Get all contacts
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<Log> getLogList(){

		return logDAO.getLogs();
	}
	
	/**
	 * Create new Contact/Contacts
	 * @param data - json data from request
	 * @return created contacts
	 */
	@Transactional
	public List<Log> create(Object data){
		
        List<Log> newLogs = new ArrayList<Log>();
		
		List<Log> list = util.getLogsFromRequest(data);
		
		for (Log log : list){
			newLogs.add(logDAO.saveLog(log));
		}
		
		return newLogs;
	}
	
	
	/**
	 * Update contact/contacts
	 * @param data - json data from request
	 * @return updated contacts
	 */
	@Transactional
	public List<Log> update(Object data){
		
		List<Log> returnLogs = new ArrayList<Log>();
		
		List<Log> updatedLogs = util.getLogsFromRequest(data);
		
		for (Log log : updatedLogs){
			returnLogs.add(logDAO.saveLog(log));
		}
		
		return returnLogs;
	}
	
	/**
	 * Delete contact/contacts
	 * @param data - json data from request
	 */
	@Transactional
	public void delete(Object data){
		
		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){
			
			List<Integer> deleteLogs = util.getListIdFromJSON3(data);
			
			for (Integer id : deleteLogs){
				logDAO.deleteLog(id);
			}
			
		} else { //it is only one object - cast to object/bean
			
			Integer id = Integer.parseInt(data.toString());
			
			logDAO.deleteLog(id);
		}
	}
	

	/**
	 * Spring use - DI
	 * @param contactDAO
	 */
	@Autowired
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	/**
	 * Spring use - DI
	 * @param util
	 */
	@Autowired
	public void setUtil(Util util) {
		this.util = util;
	}
	
}
