package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Giant extends monster{

	public Giant(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=8;
	int AC=25;
	int hp=115;
	int xp=80;
	int v_rad=6;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+20;
		double damageroll=Math.random()*10+Math.random()*10;
		int damage=(int) Math.ceil(damageroll)+20;
	}
}
