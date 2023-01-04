package org.sansovo.demo.spring5adv.ch2.annotated;

import org.sansovo.demo.spring5adv.ch2.decoupled.HelloWorldMessageProvider;
import org.sansovo.demo.spring5adv.ch2.decoupled.MessageProvider;
import org.sansovo.demo.spring5adv.ch2.decoupled.MessageRenderer;
import org.sansovo.demo.spring5adv.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 1/28/17.
 */
@Configuration
public class HelloWorldConfiguration {

	@Bean
	public MessageProvider provider() {
		return new HelloWorldMessageProvider();
	}

	@Bean
	public MessageRenderer renderer(){
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider());
		return renderer;
	}
}
