package com.lbc.fizzbuzz.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.easymock.EasyMock.createMock;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


import com.lbc.fizzbuzz.model.FizzBuzzDTO;
import com.lbc.fizzbuzz.model.FizzBuzzDoRequest;
import com.lbc.fizzbuzz.model.FizzBuzzDoResponse;
import com.lbc.fizzbuzz.model.FizzBuzzStatsReponse;
import com.lbc.fizzbuzz.model.StatsDTO;

import com.lbc.fizzbuzz.service.IFizzBuzzService;
/**
 * 
 * @author hajarus
 *
 */
@RunWith(EasyMockRunner.class)
public class FizzbuzzControllerTests {

	@TestSubject
	private final FizzBuzzController fizzBuzzController = new FizzBuzzController();

	@Mock
	private IFizzBuzzService serviceFizzBuzzMock = createMock(IFizzBuzzService.class);

	@BeforeEach
	public final void setUp() {
		fizzBuzzController.setServiceFizzBuzz(serviceFizzBuzzMock);
	}

	/**
	 * Case test nominal : doFizzBuzz
	 */
	@Test
	public void doFizzBuzzTestOK() {
		
		List<String> listExpected = new ArrayList<String>();
		listExpected.add("test");
		
		EasyMock.expect(serviceFizzBuzzMock.postFizzBuzz(2, 3, 50, "str1", "str2")).andReturn(listExpected);
		EasyMock.replay(serviceFizzBuzzMock);
		
		@Valid
		FizzBuzzDoRequest bodyReqFizzBuzz = new FizzBuzzDoRequest();
		bodyReqFizzBuzz.setInt1(2);
		bodyReqFizzBuzz.setInt2(3);
		bodyReqFizzBuzz.setLimit(50);
		bodyReqFizzBuzz.setStr1("str1");
		bodyReqFizzBuzz.setStr2("str2");
		FizzBuzzDoResponse result = fizzBuzzController.doFizzBuzz(bodyReqFizzBuzz);
		
		assertNotNull(result);
		assertEquals(result.getListOfStrings().get(0), "test");
		EasyMock.verify(serviceFizzBuzzMock);
		
	}
	
	/**
	 * Case test nominal : getStats
	 */
	@Test
	public void getStatsFizzBuzzTestOK() {
		
		StatsDTO statsDTOExpected = new StatsDTO();
		statsDTOExpected.setCount(4);
		FizzBuzzDTO params = new  FizzBuzzDTO();
		params.setInt1(2);
		params.setInt2(3);
		params.setLimit(50);
		params.setStr1("str1");
		params.setStr2("str2");
		statsDTOExpected.setParams(params);
		
		EasyMock.expect(serviceFizzBuzzMock.getStats()).andReturn(statsDTOExpected);
		EasyMock.expectLastCall();
		EasyMock.replay(serviceFizzBuzzMock);
		
		FizzBuzzStatsReponse result = fizzBuzzController.getStats();
		
		assertNotNull(result);
		assertEquals(result.getCount(), Integer.valueOf(4));
		
		EasyMock.verify(serviceFizzBuzzMock);
		
	}
	

}
