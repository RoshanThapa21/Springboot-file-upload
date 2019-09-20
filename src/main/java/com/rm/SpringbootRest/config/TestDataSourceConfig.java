package com.rm.SpringbootRest.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestDataSourceConfig implements DatasourceConfig {

	@Override
	public void setup() {
		
		System.out.println("Setting up datasource for test environment. ");

	}

}
