package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;
import com.mtuhack.weapons;

public class Skeleton extends monster{

	public Skeleton(mtuhackgame p) {
		super(p);
		textureRegion=Textures.skeleton;
		level=1;
		AC=12;
		hp=6;
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