package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class GiantRat extends monster{

	public GiantRat(mtuhackgame p) {
		super(p);
		textureRegion=Textures.rat;
		level=1;
		AC=10;
		hp=10;
		xp=10;
		v_rad=3;
	}
	public void act(float delta){
		if(dead)return;
		super.act(delta);
		calcattack();
		if(dist2play()>v_rad){
			switch((int) Math.ceil(Math.random()*4)){
			case 1:
				moveUp();
				break;
			case 2:
				moveDown();
				break;
			case 3:
				moveRight();
				break;
			case 4:
				moveLeft();
				break;
			}
		}
		else{
			chase();
		}
	}
	public void calcattack(){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		hit=attackroll+1;
		double damageroll=Math.random()*6;
		damage=(int) Math.ceil(damageroll)+1;
	}
}
