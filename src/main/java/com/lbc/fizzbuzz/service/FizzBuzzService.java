package com.lbc.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import com.lbc.fizzbuzz.db.FizzBuzzRepository;
import com.lbc.fizzbuzz.model.FizzBuzzDTO;
import com.lbc.fizzbuzz.model.StatsDTO;

/**
 * 
 * Service layer implementing functional methods for the project FizzBuzz.
 * 
 * @author hafares
 *
 */
@Service("serviceFizzBuzz")
public class FizzBuzzService implements IFizzBuzzService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzService.class);
	
	@Autowired
	private FizzBuzzRepository repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 
	 */
	@Override
	public List<String> postFizzBuzz(final Integer int1, final Integer int2, final Integer limit,final String str1,final String str2){
		
		List<String> finalList = new ArrayList<>();
		FizzBuzzDTO fizzBuzzDTO = new FizzBuzzDTO();
		
		fizzBuzzDTO.setInt1(int1);
		fizzBuzzDTO.setInt2(int2);
		fizzBuzzDTO.setLimit(limit);
		fizzBuzzDTO.setStr1(str1);
		fizzBuzzDTO.setStr2(str2);
		
		LOGGER.info("Saving in database object > ", fizzBuzzDTO);
		repository.save(fizzBuzzDTO);
		

		try {
			for (int i = 1; i <= limit; i++) {
				if (i % int2 == 0 && i % int1 == 0) {
					finalList.add(str1 + str2);
				} else if (i % int1 == 0) {
					finalList.add(str1);
				} else if (i % int2 == 0) {
					finalList.add(str2);
				} else {
					finalList.add(String.valueOf(i));
				}
			}
		
		} catch (Exception ex) {
		LOGGER.debug("Handling of [" + ex.getClass().getName() + "] resulted in Exception", ex);
		}
		return (finalList);
	}

	/**
	 * 
	 */
	@Override
	public StatsDTO getStats() {
		
		//Prepare Aggregation
		GroupOperation countParams = Aggregation.group("int1", "int2", "limit", "str1", "str2").count().as("count");
		SortOperation sortByCount = Aggregation.sort(Direction.DESC, "count");
		LimitOperation limit = Aggregation.limit(1);
		Aggregation aggregation = Aggregation.newAggregation(countParams, sortByCount, limit);

		AggregationResults<StatsDTO> resultAggregation = mongoTemplate
		  .aggregate(aggregation, "fizzBuzzDTO", StatsDTO.class);
		List<StatsDTO> listStatsDTO = resultAggregation.getMappedResults();
		
		if (CollectionUtils.isEmpty(listStatsDTO)) {
			return null;
		}
		return listStatsDTO.get(0);		
	}
	
	
}
