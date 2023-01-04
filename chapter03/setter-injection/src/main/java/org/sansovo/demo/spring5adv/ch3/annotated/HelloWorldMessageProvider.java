package org.sansovo.demo.spring5adv.ch3.annotated;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World!";
	}
}
