package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Goblin extends monster{

	public Goblin(mtuhackgame p) {
		super(p);
		textureRegion=Textures.goblin;
		level=1;
		AC=10;
		hp=5;
		xp=10;
		v_rad=6;
	}
	

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll);
	}
}
