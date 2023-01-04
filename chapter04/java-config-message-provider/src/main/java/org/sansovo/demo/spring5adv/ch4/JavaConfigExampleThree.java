package org.sansovo.demo.spring5adv.ch4;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigExampleThree {
    public static void main(String... args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:spring/app-context-xml-02.xml");

        MessageRenderer renderer =
            ctx.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();
    }
}
