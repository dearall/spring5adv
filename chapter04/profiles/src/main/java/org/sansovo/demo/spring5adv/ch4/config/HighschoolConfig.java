package org.sansovo.demo.spring5adv.ch4.config;


import org.sansovo.demo.spring5adv.ch4.FoodProviderService;
import org.sansovo.demo.spring5adv.ch4.highschool.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by iuliana.cosmina on 3/18/17.
 */
@Configuration
@Profile("highschool")
public class HighschoolConfig {

	@Bean
	public FoodProviderService foodProviderService(){
		return new FoodProviderServiceImpl();
	}
}
