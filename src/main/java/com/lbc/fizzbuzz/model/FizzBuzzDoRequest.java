package com.lbc.fizzbuzz.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



/**
 * 
 * Bean defining object : FizzBuzzDoRequest.
 * 
 * @author hafares
 *
 */
public class FizzBuzzDoRequest {

	/**
	 * Constructor
	 */
	public FizzBuzzDoRequest(){		
	}
	
	@Min(value = 1, message = "int1 cannot be less than 1.")
	private Integer int1;
	
	@Min(value = 1, message = "int2 cannot be less than 1.")
	private Integer int2;
	
	@Min(value = 2, message = "limit cannot be less than 2.")
	private Integer limit;
	
	@NotEmpty(message = "str1 cannot be empty")
	private String str1;
	
	@NotEmpty(message = "str2 cannot be empty")
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
