package com.mtuhack;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Node of Dungeon Map which keeps track of what type of node it is, 
 * if the player can walk on it, and if the player can interact with it.
 * 
 * @author Aurora Seidenwand
 *
 */
public class Node extends Actor{
	// Instance variables:
	TextureRegion texture;
	private String element; // wall, floor, lava, water
	private boolean walkable; // true = can walk
	private boolean interact; // true = can interact
	
	/** Creates a walkable floor node that cannot be interacted with */
	public Node() {
		this("floor", true, false);
	}
	/** Creates a node with the given element and next node. */
	public Node(String e, boolean w, boolean i) {
		element = e;
		walkable = w;
		interact = i;
		switch(e){
		case "floor":
			texture = Textures.walk;
			break;
		case "wall":
			texture = Textures.wall;
			break;
		case "lava":
			texture = Textures.lava;
			break;
		case "water":
			texture = Textures.water;
			break;	
		}
		setWidth(32);
		setHeight(32);
		
	}
	
	public void updatePosition() {
		//THe map is "inverted" per se, so flip the y
		setPosition(getX() * 32, (32 - getY() - 1) * 32);
	}
	
	/**
	 * Default draw method, just draws the texture
	 */
	@Override
	public void draw (Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.g, color.g, color.b, color.a * parentAlpha);
		batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	// Accessor methods:
	public String getElement() {
		return element; 
	}
	public boolean getCanWalk() {
		return walkable;
	}
	public boolean getCanInteract() {
		return interact;
	}
	
	// Modifier methods:
	public void setElement(String newElem) { 
		element = newElem; 
	}
	public void setWalk(boolean w) {
		walkable = w;
	}
	public void setInteract(boolean i) {
		interact = i;
	}
}