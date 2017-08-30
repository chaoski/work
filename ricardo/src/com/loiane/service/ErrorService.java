package com.loiane.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiane.dao.ErrorDAO;
import com.loiane.model.Error;
import com.loiane.util.Util;

/**
 * Contact Service
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Service
public class ErrorService {
	
	private ErrorDAO errorDAO;
	private Util util;

	/**
	 * Get all contacts
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<Error> getErrorList(){

		return errorDAO.getErrors();
	}
	
	/**
	 * Create new Contact/Contacts
	 * @param data - json data from request
	 * @return created contacts
	 */
	@Transactional
	public List<Error> create(Object data){
		
        List<Error> newErrors = new ArrayList<Error>();
		
		List<Error> list = util.getErrorsFromRequest(data);
		
		for (Error error : list){
			newErrors.add(errorDAO.saveError(error));
		}
		
		return newErrors;
	}
	
	
	/**
	 * Update contact/contacts
	 * @param data - json data from request
	 * @return updated contacts
	 */
	@Transactional
	public List<Error> update(Object data){
		
		List<Error> returnErrors = new ArrayList<Error>();
		
		List<Error> updatedErrors = util.getErrorsFromRequest(data);
		
		for (Error error : updatedErrors){
			returnErrors.add(errorDAO.saveError(error));
		}
		
		return returnErrors;
	}
	
	/**
	 * Delete contact/contacts
	 * @param data - json data from request
	 */
	@Transactional
	public void delete(Object data){
		
		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){
			
			List<Integer> deleteErrors = util.getListIdFromJSON2(data);
			
			for (Integer id : deleteErrors){
				errorDAO.deleteError(id);
			}
			
		} else { //it is only one object - cast to object/bean
			
			Integer id = Integer.parseInt(data.toString());
			
			errorDAO.deleteError(id);
		}
	}
	

	/**
	 * Spring use - DI
	 * @param contactDAO
	 */
	@Autowired
	public void setErrorDAO(ErrorDAO errorDAO) {
		this.errorDAO = errorDAO;
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
