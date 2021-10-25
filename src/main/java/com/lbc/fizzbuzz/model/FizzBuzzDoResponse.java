package com.lbc.fizzbuzz.model;

import java.util.List;
/**
 * 
 * Bean defining object : FizzBuzzDoResponse.
 * 
 * @author hafares
 *
 */
public class FizzBuzzDoResponse {

	/**
	 * Constructor
	 */
	public FizzBuzzDoResponse(){
	};
	
	private List<String> results;

	
	public List<String> getResults() {
		return results;
	}

	public void setResults(List<String> results) {
		this.results = results;
	}
	
	
}
