package com.loiane.dao;

import java.util.List;

import com.loiane.model.Log;

public interface ILogDAO {

	List<Log> getLogs();
	
	void deleteLog(int l_id);
	
	Log saveLog(Log log);
	
}