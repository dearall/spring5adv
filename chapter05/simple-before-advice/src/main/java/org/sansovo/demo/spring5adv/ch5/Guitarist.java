package org.sansovo.demo.spring5adv.ch5;

import org.sansovo.demo.spring5adv.ch2.common.Singer;

/**
 * Created by iuliana.cosmina on 3/26/17.
 */
public class Guitarist implements Singer {

	private String lyric="You're gonna live forever in me";

	@Override
	public void sing(){
		System.out.println(lyric);
	}

}
