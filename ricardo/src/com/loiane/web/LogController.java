package com.loiane.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loiane.model.Log;
import com.loiane.service.LogService;

/**
 * Controller - Spring
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Controller
public class LogController  {

	private LogService logService;
	
	@RequestMapping(value="/log/view.action")
	public @ResponseBody Map<String,? extends Object> view() throws Exception {

		try{

			List<Log> logs = logService.getLogList();

			return getMap(logs);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Logs from database.");
		}
	}
	
	@RequestMapping(value="/log/create.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestParam Object data) throws Exception {

		try{

			List<Log> logs = logService.create(data);

			return getMap(logs);

		} catch (Exception e) {

			return getModelMapError("Error trying to create log.");
		}
	}
	
	@RequestMapping(value="/log/update.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestParam Object data) throws Exception {
		try{

			List<Log> logs = logService.update(data);

			return getMap(logs);

		} catch (Exception e) {

			return getModelMapError("Error trying to update log.");
		}
	}
	
	@RequestMapping(value="/log/delete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestParam Object data) throws Exception {
		
		try{

			logService.delete(data);

			Map<String,Object> modelMap = new HashMap<String,Object>(3);
			modelMap.put("success", true);

			return modelMap;

		} catch (Exception e) {

			return getModelMapError("Error trying to delete log.");
		}
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param logs
	 * @return
	 */
	private Map<String,Object> getMap(List<Log> logs){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", logs.size());
		modelMap.put("data", logs);
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
	public void setLogService(LogService logService) {
		this.logService = logService;
	}

}
