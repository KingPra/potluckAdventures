package com.tts.potluckAdventures.cloud.config;

import javax.activation.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig extends AbstractCloudConfig {

	@Bean
	public DataSource dataSource() {
		return (DataSource) connectionFactory().dataSource();
	}
}
