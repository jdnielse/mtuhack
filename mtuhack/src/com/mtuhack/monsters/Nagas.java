package com.mtuhack.monsters;

import com.mtuhack.Node;
import com.mtuhack.Textures;
import com.mtuhack.monster;
import com.mtuhack.mtuhackgame;

public class Nagas extends monster{

	public Nagas(mtuhackgame p) {
		super(p);
		textureRegion=Textures.naga;
		level=3;
		AC=19;
		hp=30;
		xp=30;
		v_rad=50;
	}
	public boolean moveLeft(){
		Node left = game.activeMap.getLeft((int)getX()/32, (int)getY()/32);
		if (left.getCanWalk()||left.iswater()){
			game.activeMap.getNode(x, y).setWalk(true);
			setPosition(getX()-32,getY());
			updatePos();
			//make occupied node unwalkable
			game.activeMap.getNode(x, y).setWalk(false);
			return true;
		}
		return false;
	}
	public boolean moveRight(){
		Node right = game.activeMap.getRight((int)getX()/32, (int)getY()/32);
		if (right.getCanWalk()||right.iswater()){
			game.activeMap.getNode(x, y).setWalk(true);
			setPosition(getX()+32,getY());
			updatePos();
			//make occupied node unwalkable
			game.activeMap.getNode(x, y).setWalk(false);
			return true;
		}
		return false;
	}
	public boolean moveUp(){
		Node up = game.activeMap.getUp((int)getX()/32, (int)getY()/32);
		if (up.getCanWalk()||up.iswater()){
			game.activeMap.getNode(x, y).setWalk(true);
			setPosition(getX(),getY()+32);
			updatePos();
			//make occupied node unwalkable
			game.activeMap.getNode(x, y).setWalk(false);
			return true;
		}
		return false;
	}
	public boolean moveDown(){
		Node down = game.activeMap.getDown((int)getX()/32, (int)getY()/32);
		if (down.getCanWalk()||down.iswater()){
			game.activeMap.getNode(x, y).setWalk(true);
			setPosition(getX(),getY()-32);
			updatePos();
			//make occupied node unwalkable
			game.activeMap.getNode(x, y).setWalk(false);
			return true;
		}
		return false;
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
		hit=attackroll+3;
		double damageroll=Math.random()*8;
		damage=(int) Math.ceil(damageroll)+3;
	}
}
