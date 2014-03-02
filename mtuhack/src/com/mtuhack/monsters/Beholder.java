package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Beholder extends monster{

	public Beholder(mtuhackgame p) {
		super(p);
		// put texture here
		level=10;
		AC=25;
		hp=120;
		xp=100;
		v_rad=10;
	}


	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+15;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll)+15;
	}
}
