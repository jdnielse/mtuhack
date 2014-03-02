package com.mtuhack;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class character extends Actor{
	
	//set this in the individual character classes
	TextureRegion textureRegion = null;
	
	mtuhackgame parent;
	int hp;
	int AC;
	int v_rad;
	int level;
	
	//keep track of what direction this is facing
	String dir = "up";
	//keep track of what node it is on
	Node current;
	//keep track of location in map
	int w;
	int h;
	
	public character(mtuhackgame p){
		parent = p;
		
	}
	
	/**
	 * default character acting
	 */
	@Override
	public void act(float delta){

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
