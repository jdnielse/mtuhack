package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class GiantRat extends monster{

	public GiantRat(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=1;
	int AC=10;
	int hp=10;
	int xp=10;
	int v_rad=6;

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+1;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll)+1;
	}
}
