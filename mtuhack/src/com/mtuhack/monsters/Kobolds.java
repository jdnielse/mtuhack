package com.mtuhack.monsters;

import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Kobolds extends monster{

	public Kobolds(mtuhackgame p) {
		super(p);
		textureRegion = Textures.kobold;
		//setWidth(16);
		//setHeight(16);
	}
	int level=2;
	int AC=15;
	int hp=12;
	int xp=20;
	int v_rad=6;

	public void act(float delta){
		super.act(delta);
		boolean move=false;
		while(!move){
			if(Math.random()>.5){
				if(getX()<game.p.getX()){
					move=moveRight();
				}
				else if(getX()>game.p.getX()){
					move=moveLeft();
				}
			}
			else{
				if(getY()<game.p.getY()){
					move=moveUp();
				}
				else if(getY()>game.p.getY()){
					move=moveDown();
				}
			}

		}
	}

	public void attack(int playerAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit=attackroll+2;
		double damageroll=Math.random()*6;
		int damage=(int) Math.ceil(damageroll)+2;
	}
}
