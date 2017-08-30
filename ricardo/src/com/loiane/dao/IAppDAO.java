package com.loiane.dao;

import java.util.List;

import com.loiane.model.App;

public interface IAppDAO {

	List<App> getApps();
	
	void deleteApp(int a_id);
	
	App saveApp(App app);
	
}