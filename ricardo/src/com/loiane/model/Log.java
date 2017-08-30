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
@Table(name="LOG")
public class Log {
	
	private int l_id;
	private String l_name;
	private int fk_a_id;
	private int fk_e_id;
	
	@Id
	@GeneratedValue
	@Column(name="LOG_ID")
	public int getId() {
		return l_id;
	}
	
	public void setId(int l_id) {
		this.l_id = l_id;
	}
	
	@Column(name="USER_NAME", nullable=false)
	public String getName() {
		return l_name;
	}
	
	public void setName(String l_name) {
		this.l_name = l_name;
	}
	
	@Column(name="fk_app_id", nullable=false)
	public int getAID() {
		return fk_a_id;
	}
	
	public void setAID(int fk_a_id) {
		this.fk_a_id = fk_a_id;
	}
	
	@Column(name="fk_error_id", nullable=false)
	public int getEID() {
		return fk_e_id;
	}
	
	public void setEID(int fk_e_id) {
		this.fk_e_id = fk_e_id;
	}
	
}


