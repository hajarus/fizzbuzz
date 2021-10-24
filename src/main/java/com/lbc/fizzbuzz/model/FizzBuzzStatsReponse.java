package com.lbc.fizzbuzz.model;


/**
 * Bean defining object : FizzBuzzStatsReponse.
 * 
 * @author hafares
 */
public class FizzBuzzStatsReponse {
	
	public FizzBuzzStatsReponse(){
		
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
