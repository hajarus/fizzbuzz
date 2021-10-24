package com.lbc.fizzbuzz.service;

import java.util.List;

import com.lbc.fizzbuzz.model.StatsDTO;

/**
 * Interface describing the service FizzBuzz.
 * 
 * @author hafares
 *
 */
public interface IFizzBuzzService {

	/**
	 * 
	 * Method enabling to find the multiples of int1 and int2. Then replace this
	 * multiples by str1(for int1) and str2(for int2). For multiples of int1 and int2 they will be
	 * replaced by str1str2.
	 * 
	 * @param int1 : first number to find his multiple
	 * @param int2 : second number to find his multiple
	 * @param limit : defining the limit of the research
	 * @param str1 : string to write when the multiple of int1 is find
	 * @param str2 : string to write when the multiple of int2 is find
	 * @return list of strings
	 */
	List<String> postFizzBuzz(Integer int1, Integer int2, Integer limit, String str1, String str2);


	/**
	 * Method enabling to get stats of the parameters corresponding to the
	 * most used request, as well as the number of hits for this request.
	 * 
	 * @return an object : composed by the parameters most used and the number of hits(count).
	 */
	StatsDTO getStats();

}
