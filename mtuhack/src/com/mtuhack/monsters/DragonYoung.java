package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class DragonYoung extends monster{

	public DragonYoung(mtuhackgame p) {
		super(p);
		textureRegion=Textures.dragonyoung;
		level=6;
		AC=20;
		hp=60;
		xp=60;
		v_rad=6;
	}
	

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+7;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll)+7;
	}
}
