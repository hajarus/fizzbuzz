package com.lbc.fizzbuzz.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;import org.springframework.data.mongodb.core.aggregation.AggregationResults;


import com.lbc.fizzbuzz.db.FizzBuzzRepository;
import com.lbc.fizzbuzz.model.FizzBuzzDTO;
import com.lbc.fizzbuzz.model.StatsDTO;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 
 * Test class for : FizzBuzzService
 * 
 * @author hafares
 *
 */
@ExtendWith(MockitoExtension.class)
@DataMongoTest
public class FizzBuzzServiceTests {
	
	
	private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

	@Mock
	private FizzBuzzRepository repositoryMock  = mock(FizzBuzzRepository.class);
	
	@Mock
	private MongoTemplate mongoTemplateMock = mock(MongoTemplate.class);
	
	
	@BeforeEach
	public void setUp() {
		fizzBuzzService.setMongoTemplate(mongoTemplateMock);
		fizzBuzzService.setRepository(repositoryMock);
	}
	
	/**
	 * Case Test nominal : postFizzBuzz
	 */
	@Test
	public void postFizzBuzzTest() {
		
		Integer int1 = 2;
		Integer int2 = 6;
		Integer limit = 20;
		String str1 = "str1";
		String str2 = "str2";
		
		ArgumentCaptor<FizzBuzzDTO> fizzBuzzDTOCapture = ArgumentCaptor.forClass(FizzBuzzDTO.class);
		
		when(repositoryMock.save(fizzBuzzDTOCapture.capture())).thenReturn(fizzBuzzDTOCapture.capture());
		
		
		List<String> result = fizzBuzzService.postFizzBuzz(int1, int2, limit, str1, str2);
		
		FizzBuzzDTO capturedFizzBuzzDTO = fizzBuzzDTOCapture.getValue();
		
		assertNotNull(result);
		assertEquals(result.get(2), "3");
		assertEquals(result.get(3), "str1");
		assertEquals(capturedFizzBuzzDTO.getInt1(), Integer.valueOf(2));
		
		verify(repositoryMock).save(fizzBuzzDTOCapture.capture());
		
	}
	
	/**
	 * Case Test nominal : getStats
	 */
	@Test
	public void getStats() {
	
		
		ArgumentCaptor<Aggregation> capureAggregation  =  ArgumentCaptor.forClass(Aggregation.class);
		
		List<StatsDTO> listStatsDTOExpected = new ArrayList<StatsDTO>();
		StatsDTO element  = new StatsDTO();
		element.setCount(14);
		listStatsDTOExpected.add(element);
		
		AggregationResults<StatsDTO> expectedAggregationResult = new AggregationResults<StatsDTO>(listStatsDTOExpected, new Document());
				
	 
		when(mongoTemplateMock.aggregate(capureAggregation.capture(), eq("fizzBuzzDTO"),
				eq(StatsDTO.class))).thenReturn(expectedAggregationResult);
		
		StatsDTO result = fizzBuzzService.getStats();
		
		assertNotNull(result);
		assertEquals(result.getCount(),  Integer.valueOf(14));
	
		
		verify(mongoTemplateMock).aggregate(capureAggregation.capture(), eq("fizzBuzzDTO"),
				eq(StatsDTO.class));
		
	}
		
	
}
