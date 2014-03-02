package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Slimes extends monster{

	public Slimes(mtuhackgame p) {
		super(p);
		textureRegion=Textures.slimes;
		level=3;
		AC=13;
		hp=20;
		xp=30;

	}
	int v_rad=3;
	int act_count=0;
	int chase_count=0;
	public void act(float delta){
		if(dead){return;}
		super.act(delta);
		boolean move=false;
		calcattack();
		if(dist2play()>v_rad){
			chase_count=0;
			game.mess2="";
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
				game.mess2="";
				if(chase_count>10){
					chase_count=0;
				}
			}
			else{
				if(Math.random()>.5){
					if(getX()<game.p.getX()){
						move=moveRight();
					}
					else if(getX()>game.p.getX()){
						move=moveLeft();
					}
					if(!move){
						if(getY()<game.p.getY()){
							move=moveUp();
						}
						else if(getY()>game.p.getY()){
							move=moveDown();
						}
						if(dist2play()==1){
							attack(game.p);
						}
					}
				}
				else{
					if(getY()<game.p.getY()){
						move=moveUp();
					}
					else if(getY()>game.p.getY()){
						move=moveDown();
					}
					if(!move){
						if(getX()<game.p.getX()){
							move=moveRight();
						}
						else if(getX()>game.p.getX()){
							move=moveLeft();
						}
						if(dist2play()==1){
							attack(game.p);
						}
					}

				}
			}
		}
	}

	public void calcattack(){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		hit=attackroll;
		double damageroll=Math.random()*8;
		damage=(int) Math.ceil(damageroll);
	}
}
