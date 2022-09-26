/*
infrateam and application team
 */
package com.amazonaws.saas.eks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

@Configuration
public class DynamodbConfiguration {

	ClientConfiguration getClientConfiguration() {
		ClientConfiguration cfg = new ClientConfiguration();
		cfg.setProtocol(Protocol.HTTPS);
		cfg.setProxyPort(8099);
		return cfg;
	}

	@Bean(name = "dynamoDBMapper")
	public DynamoDBMapper dynamoDBMapperLocal() {
		DynamoDBMapperConfig dbMapperConfig = new DynamoDBMapperConfig.Builder().build();
		AmazonDynamoDBClient dynamoClient = getAmazonDynamoDBLocalClient();
		return new DynamoDBMapper(dynamoClient, dbMapperConfig);
	}

	private AmazonDynamoDBClient getAmazonDynamoDBLocalClient() {
		return (AmazonDynamoDBClient) AmazonDynamoDBClientBuilder.standard()
				// .withCredentials(WebIdentityTokenCredentialsProvider.builder().roleSessionName("ddb-query").build())
				.withCredentials(new DefaultAWSCredentialsProviderChain()).build();
	}

}