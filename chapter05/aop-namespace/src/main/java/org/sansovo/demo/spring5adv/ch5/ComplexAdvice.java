package org.sansovo.demo.spring5adv.ch5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.sansovo.demo.spring5adv.ch2.common.Guitar;

/**
 * Created by iuliana.cosmina on 4/9/17.
 */
public class ComplexAdvice {
	public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
		if(value.getBrand().equalsIgnoreCase("Gibson")) {
			System.out.println("Executing: " +
					joinPoint.getSignature().getDeclaringTypeName() + " "
					+ joinPoint.getSignature().getName());
		}
	}

	public Object simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar value) throws Throwable {
		System.out.println("Before execution: " +
				pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName()
				+ " argument: " + value.getBrand());

		Object retVal = pjp.proceed();

		System.out.println("After execution: " +
				pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName()
				+ " argument: " + value.getBrand());

		return retVal;
	}
}
