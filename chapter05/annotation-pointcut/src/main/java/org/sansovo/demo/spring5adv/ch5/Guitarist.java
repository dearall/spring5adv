package org.sansovo.demo.spring5adv.ch5;

import org.sansovo.demo.spring5adv.ch2.common.Guitar;
import org.sansovo.demo.spring5adv.ch2.common.Singer;

/**
 * Created by iuliana.cosmina on 4/2/17.
 */
public class Guitarist implements Singer {

	@Override public void sing() {
		System.out.println("Dream of ways to throw it all away");
	}

	@AdviceRequired
	public void sing(Guitar guitar) {
		System.out.println("play: " + guitar.play());
	}

	public void rest(){
		System.out.println("zzz");
	}

}
