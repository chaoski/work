package com.loiane.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.loiane.model.Contact;
import com.loiane.model.App;
import com.loiane.model.Error;
import com.loiane.model.Log;

/**
 * Util class. Contains some common methods that can be used
 * for any class
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Component
public class Util {
	
	/**
	 * Get list of Contacts from request.
	 * @param data - json data from request 
	 * @return list of Contacts
	 */
	public List<Contact> getContactsFromRequest(Object data){

		List<Contact> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListContactsFromJSON(data);

		} else { //it is only one object - cast to object/bean

			Contact contact = getContactFromJSON(data);

			list = new ArrayList<Contact>();
			list.add(contact);
		}

		return list;
	}
		
	/**
	 * Transform json data format into Contact object
	 * @param data - json data from request
	 * @return 
	 */
	private Contact getContactFromJSON(Object data){
		JSONObject jsonObject = JSONObject.fromObject(data);
		Contact newContact = (Contact) JSONObject.toBean(jsonObject, Contact.class);
		return newContact;
	}
	
	/**
	 * Transform json data format into list of Contact objects
	 * @param data - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Contact> getListContactsFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Contact> newContacts = (List<Contact>) JSONArray.toCollection(jsonArray,Contact.class);
		return newContacts;
	}
	
	/**
	 * Tranform array of numbers in json data format into
	 * list of Integer
	 * @param data - json data from request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getListIdFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idContacts = (List<Integer>) JSONArray.toCollection(jsonArray,Integer.class);
		return idContacts;
	}
	
	//////APP////
	public List<App> getAppsFromRequest(Object data){

		List<App> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListAppsFromJSON(data);

		} else { //it is only one object - cast to object/bean

			App app = getAppFromJSON(data);

			list = new ArrayList<App>();
			list.add(app);
		}

		return list;
	}
	
	private App getAppFromJSON(Object data){
		JSONObject jsonObject = JSONObject.fromObject(data);
		App newApp = (App) JSONObject.toBean(jsonObject, App.class);
		return newApp;
	}
	
	@SuppressWarnings("unchecked")
	private List<App> getListAppsFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<App> newApps = (List<App>) JSONArray.toCollection(jsonArray,App.class);
		return newApps;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getListIdFromJSON1(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idApps = (List<Integer>) JSONArray.toCollection(jsonArray,Integer.class);
		return idApps;
	}
	
	//////ERROR////
	public List<Error> getErrorsFromRequest(Object data){

		List<Error> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListErrorsFromJSON(data);

		} else { //it is only one object - cast to object/bean

			Error error = getErrorFromJSON(data);

			list = new ArrayList<Error>();
			list.add(error);
		}

		return list;
	}
	
	private Error getErrorFromJSON(Object data){
		JSONObject jsonObject = JSONObject.fromObject(data);
		Error newError = (Error) JSONObject.toBean(jsonObject, Error.class);
		return newError;
	}
	
	@SuppressWarnings("unchecked")
	private List<Error> getListErrorsFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Error> newErrors = (List<Error>) JSONArray.toCollection(jsonArray,Error.class);
		return newErrors;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getListIdFromJSON2(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idErrors = (List<Integer>) JSONArray.toCollection(jsonArray,Integer.class);
		return idErrors;
	}
	
	//////LOG////
	public List<Log> getLogsFromRequest(Object data){

		List<Log> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListLogsFromJSON(data);

		} else { //it is only one object - cast to object/bean

			Log log = getLogFromJSON(data);

			list = new ArrayList<Log>();
			list.add(log);
		}

		return list;
	}
		
	private Log getLogFromJSON(Object data){
		JSONObject jsonObject = JSONObject.fromObject(data);
		Log newLog = (Log) JSONObject.toBean(jsonObject, Log.class);
		return newLog;
	}
	
	@SuppressWarnings("unchecked")
	private List<Log> getListLogsFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Log> newLogs = (List<Log>) JSONArray.toCollection(jsonArray,Log.class);
		return newLogs;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getListIdFromJSON3(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idLogs = (List<Integer>) JSONArray.toCollection(jsonArray,Integer.class);
		return idLogs;
	}
}
