package com.loiane.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.loiane.model.Error;

/**
 * Contact DAO class.
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Repository
public class ErrorDAO implements IErrorDAO{
	
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
	public List<Error> getErrors() {
		return hibernateTemplate.find("from Error");
	}

	/**
	 * Delete a contact with the id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteError(int e_id){
		Object record = hibernateTemplate.load(Error.class, e_id);
		hibernateTemplate.delete(record);
	}
	
	/**
	 * Create a new Contact on the database or
	 * Update contact
	 * @param contact
	 * @return contact added or updated in DB
	 */
	@Override
	public Error saveError(Error error){
		hibernateTemplate.saveOrUpdate(error);
		return error;
	}

}
