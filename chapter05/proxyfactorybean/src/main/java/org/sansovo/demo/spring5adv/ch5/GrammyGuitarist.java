package org.sansovo.demo.spring5adv.ch5;

import org.sansovo.demo.spring5adv.ch2.common.Guitar;

/**
 * Created by iuliana.cosmina on 4/9/17.
 */
public class GrammyGuitarist {
	public void sing() {
		System.out.println("sing: Gravity is working against me\n" +
				"And gravity wants to bring me down");
	}

	public void sing(Guitar guitar) {
		System.out.println("play: " + guitar.play());
	}

	public void talk(){
		System.out.println("talk");
	}

}
