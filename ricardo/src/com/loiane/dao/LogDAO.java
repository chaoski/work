package com.loiane.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.loiane.model.Log;

/**
 * Contact DAO class.
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Repository
public class LogDAO implements ILogDAO{
	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * Get List of contacts from database
	 * @return list of all contacts
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Log> getLogs() {
		return hibernateTemplate.find("from Log");
	}

	/**
	 * Delete a contact with the id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteLog(int l_id){
		Object record = hibernateTemplate.load(Log.class, l_id);
		hibernateTemplate.delete(record);
	}
	
	/**
	 * Create a new Contact on the database or
	 * Update contact
	 * @param contact
	 * @return contact added or updated in DB
	 */
	@Override
	public Log saveLog(Log log){
		hibernateTemplate.saveOrUpdate(log);
		return log;
	}

}
