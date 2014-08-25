package com.fairdeal.compass.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Query;

import com.fairdeal.compass.util.ObjectRepository;

/**
 * This is used to Cache the Query Used for Not wasting memory all the time. 
 * 
 * @author puneetbehl
 *
 */
public class QueryCache {

	private Map<String,Query> queryMap = new HashMap<>();
	private static QueryCache object;
	
	public static QueryCache getInstance(){
		if (object!=null){
			object =  ObjectRepository.getApplicationContext().getBean(QueryCache.class);
		}
		return object;
	}
	
	public Query getQuery(String queryName){
		Query query = queryMap.get(queryName);
		return query;
	}
	
	public void addQuery(String queryName, Query query){
		queryMap.put(queryName, query);
	}
	
}
