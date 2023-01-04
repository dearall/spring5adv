package org.sansovo.demo.spring5adv.ch5;

import org.sansovo.demo.spring5adv.ch2.common.Guitar;

/**
 * Created by iuliana.cosmina on 4/9/17.
 */
public class NewDocumentarist extends Documentarist {

	@Override
	public void execute() {
		guitarist.sing();
		Guitar guitar = new Guitar();
		guitar.setBrand("Gibson");
		guitarist.sing(guitar);
		//guitarist.sing(new Guitar());
		guitarist.talk();
	}

}
