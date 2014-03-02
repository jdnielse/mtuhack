package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Troll extends monster{

	public Troll(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=6;
	int AC=24;
	int hp=50;
	int xp=60;
	int v_rad=6;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+12;
		double damageroll=Math.random()*10;
		int damage=(int) Math.ceil(damageroll)+12;
	}
}
