package org.sansovo.demo.spring5adv.ch4.mixed;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageProvider;
import org.sansovo.demo.spring5adv.ch4.annotated.ConfigurableMessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 3/15/17.
 */
@Configuration
public class AppConfigSix {

	@Bean
	public MessageProvider provider() {
		return new ConfigurableMessageProvider("Love on the weekend");
	}
}
