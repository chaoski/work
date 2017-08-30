package com.loiane.dao;

import java.util.List;

import com.loiane.model.Error;

public interface IErrorDAO {

	List<Error> getErrors();
	
	void deleteError(int e_id);
	
	Error saveError(Error error);
	
}