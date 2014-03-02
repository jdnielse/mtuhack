package com.mtuhack.monsters;

import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Slimes extends monster{

	public Slimes(mtuhackgame p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	int level=3;
	int AC=13;
	int hp=20;
	int xp=30;
	int v_rad=6;
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
		int hit=attackroll;
		double damageroll=Math.random()*8;
		int damage=(int) Math.ceil(damageroll);
	}
}
