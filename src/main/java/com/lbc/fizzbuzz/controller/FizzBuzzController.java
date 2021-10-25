package com.lbc.fizzbuzz.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbc.fizzbuzz.model.FizzBuzzDTO;
import com.lbc.fizzbuzz.model.FizzBuzzDoRequest;
import com.lbc.fizzbuzz.model.FizzBuzzDoResponse;
import com.lbc.fizzbuzz.model.FizzBuzzStatsResponse;
import com.lbc.fizzbuzz.model.StatsDTO;
import com.lbc.fizzbuzz.service.FizzBuzzService;
import com.lbc.fizzbuzz.service.IFizzBuzzService;

/**
 *
 * Bean of type controller exposing the methods REST for the project FizzBuzz.
 * 
 * @author hafares
 *
 */
@RestController
public class FizzBuzzController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzController.class);

	@Autowired
	private IFizzBuzzService serviceFizzBuzz = new FizzBuzzService();

	

	/**
	 * Method POST : enabling to find a list of strings with numbers from 1 to
	 * limit, where: all multiples of int1 are replaced by str1, all multiples of
	 * int2 are replaced by str2, all multiples of int1 and int2 are replaced by
	 * str1str2.
	 * 
	 * @param bodyReqFizzBuzz : body of the request (int1, int2, limit, str1, str2).
	 * @return a list : composed by strings.
	 */
	@PostMapping("/fizzbuzz")
	public FizzBuzzDoResponse doFizzBuzz(@Valid @RequestBody FizzBuzzDoRequest bodyReqFizzBuzz) {

		LOGGER.info("Incoming body request > {} ", bodyReqFizzBuzz);

		final FizzBuzzDoResponse response = new FizzBuzzDoResponse();

		// Call layer service
		List<String> listFizzBuzz = serviceFizzBuzz.postFizzBuzz(bodyReqFizzBuzz.getInt1(), bodyReqFizzBuzz.getInt2(),
				bodyReqFizzBuzz.getLimit(), bodyReqFizzBuzz.getStr1(), bodyReqFizzBuzz.getStr2());

		response.setResults(listFizzBuzz);

		LOGGER.info("Result of request > ", response);
		return (response);
	}

	/**
	 * Method GET : enabling to get stats of the parameters corresponding to the
	 * most used request, as well as the number of hits for this request.
	 * 
	 * @return FizzBuzzStatsResponse : composed by the params most used and the number of hits(count).
	 */
	@GetMapping("/stats")
	public FizzBuzzStatsResponse getStats() {

		FizzBuzzStatsResponse response = new FizzBuzzStatsResponse();

		// Call layer service
		StatsDTO statsDTO = serviceFizzBuzz.getStats();

		FizzBuzzDTO params = new FizzBuzzDTO();
		if (statsDTO != null && statsDTO.getParams() != null) {
			params.setInt1(statsDTO.getParams().getInt1());
			params.setInt2(statsDTO.getParams().getInt2());
			params.setLimit(statsDTO.getParams().getLimit());
			params.setStr1(statsDTO.getParams().getStr1());
			params.setStr2(statsDTO.getParams().getStr2());
			response.setParams(params);
			response.setCount(statsDTO.getCount());
		}
		LOGGER.info("Result of request > ", response);
		return response;
	}

	
	public void setServiceFizzBuzz(IFizzBuzzService serviceFizzBuzz) {
		this.serviceFizzBuzz = serviceFizzBuzz;
	}
}
