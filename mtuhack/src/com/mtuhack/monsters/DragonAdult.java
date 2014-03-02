package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class DragonAdult extends monster{

	public DragonAdult(mtuhackgame p) {
		super(p);
		textureRegion=Textures.dragonadult;
		level=10;
		AC=20;
		hp=50;
		xp=100;
		v_rad=11;
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
		hit=attackroll+5;
		double damageroll=Math.random()*8;
		damage=(int) Math.ceil(damageroll)+8;
	}
	
	public void kill(){
		super.kill();
		game.mess10 = "You win!";
	}
}
