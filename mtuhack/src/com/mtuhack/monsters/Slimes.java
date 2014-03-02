package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Slimes extends monster{

	public Slimes(mtuhackgame p) {
		super(p);
		textureRegion=Textures.slimes;
	}
	int level=3;
	int AC=13;
	int hp=20;
	int xp=30;
	int v_rad=3;
	int act_count=0;
	int chase_count=0;
	public void act(float delta){
		super.act(delta);
		boolean move=false;
		if(dist2play()>v_rad){
			chase_count=0;
			if(++act_count>4){
				act_count=1;
			}
			switch(act_count){
			case 1:
				moveUp();
				break;
			case 2:
				moveRight();
				break;
			case 3:
				moveDown();
				break;
			case 4:
				moveLeft();
				break;
			}
		}
		else{
			++chase_count;
			if(chase_count>5){
				if(chase_count>10){
					chase_count=0;
				}
			}
			else{
				chase();
			}
		}
	}

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll;
		double damageroll=Math.random()*8;
		int damage=(int) Math.ceil(damageroll);
	}
}
