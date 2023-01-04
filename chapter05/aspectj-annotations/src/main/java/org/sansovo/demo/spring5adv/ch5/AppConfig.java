package org.sansovo.demo.spring5adv.ch5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by iuliana.cosmina on 4/9/17.
 */
@Configuration
@ComponentScan(basePackages = {"org.sansovo.demo.spring5adv.ch5"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
