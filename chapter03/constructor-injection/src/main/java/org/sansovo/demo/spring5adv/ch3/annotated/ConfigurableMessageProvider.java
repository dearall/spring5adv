package org.sansovo.demo.spring5adv.ch3.annotated;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {

	private String message;

	@Autowired
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
