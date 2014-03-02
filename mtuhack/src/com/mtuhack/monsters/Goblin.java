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
int act_count=0;
	public void act(float delta){
		if(dead)return;
		super.act(delta);
		calcattack();
		if(dist2play()>v_rad){
			if(++act_count>2){
				act_count=-1;		
			}
			if(act_count>0){
				moveUp();
			}
			else{
				moveDown();
			}
		}
		else{
			chase();
		}
	}
	public void calcattack(){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		hit=attackroll;
		double damageroll=Math.random()*6;
		damage=(int) Math.ceil(damageroll);
	}
}
