package com.loiane.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * Contact POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@JsonAutoDetect
@Entity
@Table(name="ERROR")
public class Error {
	
	private int e_id;
	private String e_desc;

	
	@Id
	@GeneratedValue
	@Column(name="ERROR_ID")
	public int getId() {
		return e_id;
	}
	
	public void setId(int e_id) {
		this.e_id = e_id;
	}
	
	@Column(name="ERROR_DESC", nullable=false)
	public String getDesc() {
		return e_desc;
	}
	
	public void setDesc(String e_desc) {
		this.e_desc = e_desc;
	}	
}