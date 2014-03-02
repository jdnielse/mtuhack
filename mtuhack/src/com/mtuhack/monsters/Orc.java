package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Orc extends monster{

	public Orc(mtuhackgame p) {
		super(p);
		textureRegion=Textures.orc;
		level=3;
		AC=19;
		hp=35;
		xp=30;
		v_rad=7;
	}
	

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+10;
		double damageroll=Math.random()*12;
		int damage=(int) Math.ceil(damageroll)+10;
	}
}
