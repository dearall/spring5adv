package org.sansovo.demo.spring5adv.ch4.mixed;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageProvider;
import org.sansovo.demo.spring5adv.ch2.decoupled.MessageRenderer;
import org.sansovo.demo.spring5adv.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by iuliana.cosmina on 3/15/17.
 */
@Configuration
@ImportResource(value="classpath:spring/app-context-xml-01.xml")
public class AppConfigFive {
	@Autowired
	MessageProvider provider;


	@Bean(name = "messageRenderer")
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider);
		return renderer;
	}

}
