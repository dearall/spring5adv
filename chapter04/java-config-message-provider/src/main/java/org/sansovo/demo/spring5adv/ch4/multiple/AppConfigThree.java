package org.sansovo.demo.spring5adv.ch4.multiple;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageProvider;
import org.sansovo.demo.spring5adv.ch2.decoupled.MessageRenderer;
import org.sansovo.demo.spring5adv.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by iuliana.cosmina on 3/15/17.
 */
@Configuration
@Import(AppConfigFour.class)
public class AppConfigThree {
	@Autowired
	MessageProvider provider;


	@Bean(name = "messageRenderer")
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider);
		return renderer;
	}
}
