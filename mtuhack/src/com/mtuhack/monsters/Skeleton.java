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
	int act_count=0;

	public void act(float delta){
		if(dead)return;
		super.act(delta);
		calcattack();
		if(dist2play()>v_rad){
			if(++act_count>4){
				act_count=-3;		
			}
			if(act_count>0){
				moveRight();
			}
			else{
				moveLeft();
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