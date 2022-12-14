package org.sansovo.demo.spring5adv.ch5;

import org.sansovo.demo.spring5adv.ch2.common.Guitar;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * Created by iuliana.cosmina on 4/2/17.
 */
public class NamePointcutUsingAdvisor {
	public static void main(String... args) {
		GrammyGuitarist johnMayer = new GrammyGuitarist();

		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
		advisor.setMappedNames("sing");
		advisor.setMappedNames("rest");

		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(johnMayer);
		pf.addAdvisor(advisor);

		GrammyGuitarist proxy = (GrammyGuitarist) pf.getProxy();
		proxy.sing();
		proxy.sing(new Guitar());
		proxy.rest();
		proxy.talk();
	}
}
