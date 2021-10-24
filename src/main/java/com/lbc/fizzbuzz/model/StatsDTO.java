package com.lbc.fizzbuzz.model;

import org.springframework.data.annotation.Id;

/**
 * 
 * Bean defining object : StatsDTO.
 * 
 * @author hafares
 *
 */
public class StatsDTO {	
	
	public StatsDTO() {
	}
	
	private Integer count;
	@Id
	private FizzBuzzDTO params;
		
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public FizzBuzzDTO getParams() {
		return params;
	}
	public void setParams(FizzBuzzDTO params) {
		this.params = params;
	}
}
