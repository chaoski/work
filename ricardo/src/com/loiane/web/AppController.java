package com.loiane.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loiane.model.App;
import com.loiane.service.AppService;

/**
 * Controller - Spring
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Controller
public class AppController  {

	private AppService appService;
	
	@RequestMapping(value="/app/view.action")
	public @ResponseBody Map<String,? extends Object> view() throws Exception {

		try{

			List<App> app = appService.getAppList();

			return getMap(app);

		} catch (Exception e) {

			return getModelMapError("Error retrieving App from database.");
		}
	}
	
	@RequestMapping(value="/app/create.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestParam Object data) throws Exception {

		try{

			List<App> app = appService.create(data);

			return getMap(app);

		} catch (Exception e) {

			return getModelMapError("Error trying to create app.");
		}
	}
	
	@RequestMapping(value="/app/update.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestParam Object data) throws Exception {
		try{

			List<App> app = appService.update(data);

			return getMap(app);

		} catch (Exception e) {

			return getModelMapError("Error trying to update app.");
		}
	}
	
	@RequestMapping(value="/app/delete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestParam Object data) throws Exception {
		
		try{

			appService.delete(data);

			Map<String,Object> modelMap = new HashMap<String,Object>(3);
			modelMap.put("success", true);

			return modelMap;

		} catch (Exception e) {

			return getModelMapError("Error trying to delete app.");
		}
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param contacts
	 * @return
	 */
	private Map<String,Object> getMap(List<App> app){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", app.size());
		modelMap.put("data", app);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	private Map<String,Object> getModelMapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	} 


	@Autowired
	public void setAppService(AppService appService) {
		this.appService = appService;
	}

}
