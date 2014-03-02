package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Troll extends monster{

	public Troll(mtuhackgame p) {
		super(p);
		textureRegion=Textures.troll;
		level=6;
		AC=24;
		hp=50;
		xp=60;
		v_rad=6;
	}
	

	public void act(float delta){
		super.act(delta);
		boolean move=false;
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
			}
		}

	}
	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+12;
		double damageroll=Math.random()*10;
		int damage=(int) Math.ceil(damageroll)+12;
	}
}
