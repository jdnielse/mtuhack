package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class GiantRat extends monster{

	public GiantRat(mtuhackgame p) {
		super(p);
		// add texture
		level=1;
		AC=10;
		hp=10;
		xp=10;
		v_rad=6;
	}
	
	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+1;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll)+1;
	}
}
