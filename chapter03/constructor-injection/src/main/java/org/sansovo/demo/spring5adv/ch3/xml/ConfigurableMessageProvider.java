package org.sansovo.demo.spring5adv.ch3.xml;


import org.sansovo.demo.spring5adv.ch2.decoupled.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {
	private String message = "Default message";

	public ConfigurableMessageProvider() {

	}

	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
