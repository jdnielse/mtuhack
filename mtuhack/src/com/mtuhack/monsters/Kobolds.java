package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Kobolds extends monster{

	public Kobolds(mtuhackgame p) {
		super(p);
		textureRegion = Textures.kobold;
		level=2;
		AC=15;
		hp=12;
		xp=20;
		v_rad=6;
	}


	public void act(float delta){
		if(dead)return;
		super.act(delta);
		calcattack();
		chase();
	}
	public void calcattack(){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		hit=attackroll+3;
		double damageroll=Math.random()*6;
		damage=(int) Math.ceil(damageroll)+3;
	}
}