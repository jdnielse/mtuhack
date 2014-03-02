package com.mtuhack;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class character extends Actor{
	
	//set this in the individual character classes
	protected TextureRegion textureRegion = null;
	
	mtuhackgame game;
	int hp;
	int AC;
	int v_rad;
	int level;
	
	//keep track of what direction this is facing
	String dir = "up";
	//keep track of what node it is on
	Node current;
	//keep track of location in map
	int x;
	int y;
	
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
		//update location
		x = (int) (getX()/32);
		y = (int) (getY()/32);
		
		
	}
	
	//see if we can move to the given square
	public boolean moveLeft(){
		Node left = game.activeMap.getLeft((int)getX()/32, (int)getY()/32);
		if (left.getCanWalk()){
			setPosition(getX()-32,getY());
			return true;
		}
		return false;
	}
	public boolean moveRight(){
		Node right = game.activeMap.getRight((int)getX()/32, (int)getY()/32);
		if (right.getCanWalk()){
			setPosition(getX()+32,getY());
			return true;
		}
		return false;
	}
	public boolean moveUp(){
		Node up = game.activeMap.getUp((int)getX()/32, (int)getY()/32);
		if (up.getCanWalk()){
			setPosition(getX(),getY()+32);
			return true;
		}
		return false;
	}
	public boolean moveDown(){
		Node down = game.activeMap.getDown((int)getX()/32, (int)getY()/32);
		if (down.getCanWalk()){
			setPosition(getX(),getY()-32);
			return true;
		}
		return false;
	}
	
	/**
	 * Default draw method, just draws the texture
	 */
	@Override
	public void draw (Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.g, color.g, color.b, color.a * parentAlpha);
		batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

}
