package com.rm.SpringbootRest.config;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringProfilesWithMavenPropertiesIntegrationTest {

	
	@Autowired
    DatasourceConfig datasourceConfig;
 
    public void setupDatasource() {
        datasourceConfig.setup();
    }
	
}
