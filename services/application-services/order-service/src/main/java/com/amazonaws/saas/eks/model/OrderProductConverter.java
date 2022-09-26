/*
infrateam and application team
 */
package com.amazonaws.saas.eks.model;

import java.io.IOException;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderProductConverter implements DynamoDBTypeConverter<String, List<OrderProduct>> {

	@Override
	public String convert(List<OrderProduct> objects) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String objectsString = objectMapper.writeValueAsString(objects);
			return objectsString;
		} catch (JsonProcessingException e) {
		}
		return null;
	}

	@Override
	public List<OrderProduct> unconvert(String objectssString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<OrderProduct> objects = objectMapper.readValue(objectssString,
					new TypeReference<List<OrderProduct>>() {
					});
			return objects;
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
	}
}
