package org.sansovo.demo.spring5adv.ch4;

import org.sansovo.demo.spring5adv.ch2.decoupled.MessageRenderer;
import org.sansovo.demo.spring5adv.ch4.mixed.AppConfigFive;
import org.sansovo.demo.spring5adv.ch4.multiple.AppConfigThree;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleTwo {
    public static void main(String... args) {
        ApplicationContext ctx = new 
            //AnnotationConfigApplicationContext(AppConfigTwo.class);
            //AnnotationConfigApplicationContext(AppConfigThree.class);
            AnnotationConfigApplicationContext(AppConfigFive.class);

        MessageRenderer renderer =
            ctx.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();
    }
}
