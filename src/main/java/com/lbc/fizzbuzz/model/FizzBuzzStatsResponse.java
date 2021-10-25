package com.lbc.fizzbuzz.model;


/**
 * Bean defining object : FizzBuzzStatsResponse.
 * 
 * @author hafares
 */
public class FizzBuzzStatsResponse {
	
	public FizzBuzzStatsResponse(){
		
	}

	private FizzBuzzDTO params;
	private Integer count;
	
	
	public FizzBuzzDTO getParams() {
		return params;
	}
	public void setParams(FizzBuzzDTO params) {
		this.params = params;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
