package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Beholder extends monster{

	public Beholder(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=10;
	int AC=25;
	int hp=125;
	int xp=100;
	int v_rad=10;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+15;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll)+15;
	}
}
