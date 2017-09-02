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
@Table(name="APP")
public class App {
	
	private int a_id;
	private String a_name;
	private String a_desc;
	private String a_stat;
	
	@Id
	@GeneratedValue
	@Column(name="APP_ID")
	public int getId() {
		return a_id;
	}
	
	public void setId(int a_id) {
		this.a_id = a_id;
	}
	
	@Column(name="APP_NAME", nullable=false)
	public String getName() {
		return a_name;
	}
	
	public void setName(String a_name) {
		this.a_name = a_name;
	}
	
	@Column(name="APP_DESC", nullable=false)
	public String getDesc() {
		return a_desc;
	}
	
	public void setDesc(String a_desc) {
		this.a_desc = a_desc;
	}
	
	@Column(name="APP_STAT", nullable=false)
	public String getStat() {
		return a_stat;
	}
	
	public void setStat(String a_stat) {
		this.a_stat = a_stat;
	}
	
}