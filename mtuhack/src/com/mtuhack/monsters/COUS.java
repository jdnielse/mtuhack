package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class COUS extends monster{

	public COUS(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=2;
	int AC=15;
	int hp=15;
	int xp=20;
	int v_rad=5;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+2;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll)+2;
	}
}
