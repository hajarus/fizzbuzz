package com.lbc.fizzbuzz.model;

import org.springframework.data.annotation.Id;

/**
 * Bean defining object : FizzBuzzDTO.
 * 
 * @author hafares
 *
 */
public class FizzBuzzDTO {
	
	/**
	 * Constructor
	 */
	public FizzBuzzDTO() {
		
	}
	
	@Id
	private String id;
	
	private Integer int1;
	private Integer int2;
	private Integer limit;
	private String str1;
	private String str2;
	
	
	public Integer getInt1() {
		return int1;
	}
	
	public void setInt1(Integer int1) {
		this.int1 = int1;
	}
	
	public Integer getInt2() {
		return int2;
	}
	
	public void setInt2(Integer int2) {
		this.int2 = int2;
	}
	
	public Integer getLimit() {
		return limit;
	}
	
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public String getStr1() {
		return str1;
	}
	
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	
	public String getStr2() {
		return str2;
	}
	
	public void setStr2(String str2) {
		this.str2 = str2;
	}
	
}
