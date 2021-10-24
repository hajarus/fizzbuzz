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
	
	private List<String> listOfStrings;

	
	public List<String> getListOfStrings() {
		return listOfStrings;
	}

	public void setListOfStrings(List<String> listOfStrings) {
		this.listOfStrings = listOfStrings;
	}
	
	
}
