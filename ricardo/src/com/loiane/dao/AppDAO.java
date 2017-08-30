package com.loiane.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.loiane.model.App;

/**
 * Contact DAO class.
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Repository
public class AppDAO implements IAppDAO{
	
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
	public List<App> getApps() {
		return hibernateTemplate.find("from App");
	}

	/**
	 * Delete a contact with the id passed as parameter
	 * @param id
	 */
	@Override
	public void deleteApp(int a_id){
		Object record = hibernateTemplate.load(App.class, a_id);
		hibernateTemplate.delete(record);
	}
	
	/**
	 * Create a new Contact on the database or
	 * Update contact
	 * @param contact
	 * @return contact added or updated in DB
	 */
	@Override
	public App saveApp(App app){
		hibernateTemplate.saveOrUpdate(app);
		return app;
	}

}
