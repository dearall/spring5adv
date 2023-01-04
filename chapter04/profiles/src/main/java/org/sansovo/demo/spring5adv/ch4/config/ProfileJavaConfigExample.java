package org.sansovo.demo.spring5adv.ch4.config;

import org.sansovo.demo.spring5adv.ch4.Food;
import org.sansovo.demo.spring5adv.ch4.FoodProviderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

/**
 * Created by iuliana.cosmina on 3/18/17.
 */
public class ProfileJavaConfigExample {

	public static void main(String... args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(
				KindergartenConfig.class,
				HighschoolConfig.class);

		FoodProviderService foodProviderService =
				ctx.getBean("foodProviderService", FoodProviderService.class);

		List<Food> lunchSet = foodProviderService.provideLunchSet();
		for (Food food : lunchSet) {
			System.out.println("Food: " + food.getName());
		}
		ctx.close();
	}
}
