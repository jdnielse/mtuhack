package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Nagas extends monster{

	public Nagas(mtuhackgame p) {
		super(p);
		// add texture
		level=3;
		AC=19;
		hp=30;
		xp=30;
		v_rad=6;
	}
	

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+3;
		double damageroll=Math.random()*8;
		int damage=(int) Math.ceil(damageroll)+3;
	}
}
