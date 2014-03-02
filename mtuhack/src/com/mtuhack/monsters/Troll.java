package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Troll extends monster{

	public Troll(mtuhackgame p) {
		super(p);
		textureRegion=Textures.troll;
		level=6;
		AC=22;
		hp=50;
		xp=60;
		v_rad=7;
	}
	
int act_count=0;
	public void act(float delta){
		if(dead)return;
		super.act(delta);
		calcattack();
		if(dist2play()>v_rad){
			if(++act_count>1){
				act_count=0;		
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
		hit=attackroll+8;
		double damageroll=Math.random()*10;
		damage=(int) Math.ceil(damageroll)+8;
	}
}
