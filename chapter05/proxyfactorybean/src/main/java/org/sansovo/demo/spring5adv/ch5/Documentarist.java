package org.sansovo.demo.spring5adv.ch5;

public class Documentarist {

	protected GrammyGuitarist guitarist;

	public void execute() {
		guitarist.sing();
		guitarist.talk();
	}

	public void setGuitarist(GrammyGuitarist guitarist) {
		this.guitarist = guitarist;
	}
}
