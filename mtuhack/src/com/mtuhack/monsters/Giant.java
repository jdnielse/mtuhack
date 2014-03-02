package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Giant extends monster{

	public Giant(mtuhackgame p) {
		super(p);
		textureRegion=Textures.giant;
		level=8;
		AC=25;
		hp=115;
		xp=80;
		v_rad=6;
	}
	

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+20;
		double damageroll=Math.random()*10+Math.random()*10;
		int damage=(int) Math.ceil(damageroll)+20;
	}
}
