package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Orc extends monster{

	public Orc(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=3;
	int AC=19;
	int hp=35;
	int xp=30;
	int v_rad=7;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+10;
		double damageroll=Math.random()*12;
		int damage=(int) Math.ceil(damageroll)+10;
	}
}
