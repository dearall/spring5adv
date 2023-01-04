package org.sansovo.demo.spring5adv.ch16.integration.config;

import org.sansovo.demo.spring5adv.ch16.services.DBInitializer;
import org.sansovo.demo.spring5adv.ch16.services.SingerService;
import org.sansovo.demo.spring5adv.ch16.services.SingerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by iuliana.cosmina on 6/25/17.
 */

@Configuration
@ComponentScan(basePackages={"org.sansovo.demo.spring5adv.ch16"},
		excludeFilters =  {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
				value = DBInitializer.class)
		})
@Profile("test")
public class IntegrationTestConfig {

	private static Logger logger = LoggerFactory.getLogger(IntegrationTestConfig.class);

	@Bean
	public DataSource dataSource() {
		try {
			EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
			return dbBuilder.setType(EmbeddedDatabaseType.H2).build();
		} catch (Exception e) {
			logger.error("Embedded DataSource bean cannot be created!", e);
			return null;
		}
	}

	@Bean
	public SingerService singerService(){
		return new SingerServiceImpl();
	}
}
