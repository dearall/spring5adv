package org.sansovo.demo.spring5adv.ch3;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();
		MessageRenderer messageRenderer = ctx.getBean("renderer",
				MessageRenderer.class);
		messageRenderer.render();
		ctx.close();
	}
}
