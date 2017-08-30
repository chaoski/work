package com.loiane.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loiane.model.Error;
import com.loiane.service.ErrorService;

/**
 * Controller - Spring
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Controller
public class ErrorController  {

	private ErrorService errorService;
	
	@RequestMapping(value="/error/view.action")
	public @ResponseBody Map<String,? extends Object> view() throws Exception {

		try{

			List<Error> errors = errorService.getErrorList();

			return getMap(errors);

		} catch (Exception e) {

			return getModelMapError("Error retrieving Errors from database.");
		}
	}
	
	@RequestMapping(value="/error/create.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestParam Object data) throws Exception {

		try{

			List<Error> errors = errorService.create(data);

			return getMap(errors);

		} catch (Exception e) {

			return getModelMapError("Error trying to create error.");
		}
	}
	
	@RequestMapping(value="/error/update.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestParam Object data) throws Exception {
		try{

			List<Error> errors = errorService.update(data);

			return getMap(errors);

		} catch (Exception e) {

			return getModelMapError("Error trying to update error.");
		}
	}
	
	@RequestMapping(value="/error/delete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestParam Object data) throws Exception {
		
		try{

			errorService.delete(data);

			Map<String,Object> modelMap = new HashMap<String,Object>(3);
			modelMap.put("success", true);

			return modelMap;

		} catch (Exception e) {

			return getModelMapError("Error trying to delete error.");
		}
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param errors
	 * @return
	 */
	private Map<String,Object> getMap(List<Error> errors){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", errors.size());
		modelMap.put("data", errors);
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
	public void setErrorService(ErrorService errorService) {
		this.errorService = errorService;
	}

}
