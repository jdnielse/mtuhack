package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Minotaur extends monster{

	public Minotaur(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=4;
	int AC=20;
	int hp=40;
	int xp=40;
	int v_rad=6;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+10;
		double damageroll=Math.random()*12;
		int damage=(int) Math.ceil(damageroll)+10;
	}
}
