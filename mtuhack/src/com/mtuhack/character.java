package com.mtuhack;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class character extends Actor{

	//set this in the individual character classes
	protected TextureRegion textureRegion = null;

	protected mtuhackgame game;
	public int hp;
	public int AC;
	public int v_rad;
	public int level;

	//keep track of what direction this is facing
	String dir = "up";
	//keep track of what node it is on
	Node current;
	//keep track of location in map
	public int x;
	public int y;
	public boolean dead = false;

	public character(mtuhackgame p){
		game = p;
		setWidth(32);
		setHeight(32);
	}

	/**
	 * default character acting
	 */
	@Override
	public void act(float delta){
		updatePos();
	}
	
	public void updatePos(){

		//update location
		x = (int) (getX()/32);
		y = (int) (getY()/32);
	}

	//see if we can move to the given square
	public boolean moveLeft(){
		Node left = game.activeMap.getLeft((int)getX()/32, (int)getY()/32);
		if (left.getCanWalk()){
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
		if (right.getCanWalk()){
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
		if (up.getCanWalk()){
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
		if (down.getCanWalk()){
			game.activeMap.getNode(x, y).setWalk(true);
			setPosition(getX(),getY()-32);
			updatePos();
			//make occupied node unwalkable
			game.activeMap.getNode(x, y).setWalk(false);
			return true;
		}
		return false;
	}
	
	public void kill(){

		updatePos();
		//make occupied node unwalkable
		game.activeMap.getNode(x, y).setWalk(true);

		setPosition(-100, -100);
		dead = true;
	}

	/**
	 * Default draw method, just draws the texture
	 */
	@Override
	public void draw (Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.g, color.g, color.b, color.a * parentAlpha);
		batch.draw(textureRegion, getX()+ mtuhackgame.g.scroll, getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

}
