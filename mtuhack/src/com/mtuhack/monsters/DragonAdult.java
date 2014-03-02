package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class DragonAdult extends monster{

	public DragonAdult(mtuhackgame p) {
		super(p);
		textureRegion=Textures.dragonadult;
		level=10;
		AC=30;
		hp=100;
		xp=100;
		v_rad=8;
	}
	
	public void act(float delta){
		if(dead)return;
		chase();
	}
	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+12;
		double damageroll=Math.random()*8;
		int damage=(int) Math.ceil(damageroll)+12;
	}
}
