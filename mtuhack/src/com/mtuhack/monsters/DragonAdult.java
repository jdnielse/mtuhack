package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class DragonAdult extends monster{

	public DragonAdult(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=10;
	int AC=30;
	int hp=100;
	int xp=100;
	int v_rad=8;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+12;
		double damageroll=Math.random()*8;
		int damage=(int) Math.ceil(damageroll)+12;
	}
}
