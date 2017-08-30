package com.loiane.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiane.dao.AppDAO;
import com.loiane.model.App;
import com.loiane.util.Util;

/**
 * Contact Service
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Service
public class AppService {
	
	private AppDAO appDAO;
	private Util util;

	/**
	 * Get all contacts
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<App> getAppList(){

		return appDAO.getApps();
	}
	
	/**
	 * Create new Contact/Contacts
	 * @param data - json data from request
	 * @return created contacts
	 */
	@Transactional
	public List<App> create(Object data){
		
        List<App> newApps = new ArrayList<App>();
		
		List<App> list = util.getAppsFromRequest(data);
		
		for (App app : list){
			newApps.add(appDAO.saveApp(app));
		}
		
		return newApps;
	}
	
	
	/**
	 * Update contact/contacts
	 * @param data - json data from request
	 * @return updated contacts
	 */
	@Transactional
	public List<App> update(Object data){
		
		List<App> returnApps = new ArrayList<App>();
		
		List<App> updatedApps = util.getAppsFromRequest(data);
		
		for (App app : updatedApps){
			returnApps.add(appDAO.saveApp(app));
		}
		
		return returnApps;
	}
	
	/**
	 * Delete contact/contacts
	 * @param data - json data from request
	 */
	@Transactional
	public void delete(Object data){
		
		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){
			
			List<Integer> deleteApps = util.getListIdFromJSON1(data);
			
			for (Integer id : deleteApps){
				appDAO.deleteApp(id);
			}
			
		} else { //it is only one object - cast to object/bean
			
			Integer id = Integer.parseInt(data.toString());
			
			appDAO.deleteApp(id);
		}
	}
	

	/**
	 * Spring use - DI
	 * @param contactDAO
	 */
	@Autowired
	public void setAppDAO(AppDAO appDAO) {
		this.appDAO = appDAO;
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
