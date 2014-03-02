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
	private String element; // wall, floor, lava, water, bridge
	private boolean walkable; // true = can walk
	private boolean interact; // true = can interact
	private boolean nextMap; // true = can go to next map
	private Node next;
	
	/** Creates a walkable floor node that cannot be interacted with */
	public Node() {
		this("floor", true, false,0,0);
	}
	/** Creates a node with the given element and next node. */
	public Node(String e, boolean w, boolean i, int x, int y) {
		setPosition(x,y);
		updatePosition();
		mtuhackgame.g.world.addActor(this);
		
		element = e;
		walkable = w;
		interact = i;
		//nextMap = n;
		switch(e){
		case "floor":
			texture = Textures.walk;
			break;
		case "wall":
		case "walld":
			texture = Textures.wall;
			break;
		case "lava":
			texture = Textures.lava;
			break;
		case "water":
			texture = Textures.water;
			break;
		case "bridge":
			texture = Textures.bridge;
			break;
		}
		setWidth(32);
		setHeight(32);
		
	}
	
	public void updatePosition() {
		//THe map is "inverted" per se, so flip the y
		setPosition(getX() * 32, ( getY()) * 32);
	}
	
	/**
	 * Default draw method, just draws the texture
	 */
	@Override
	public void draw (Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.g, color.g, color.b, color.a * parentAlpha);
		batch.draw(texture, getX() + mtuhackgame.g.scroll, getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	public boolean iswater(){
		return element.equals("water");
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
	public boolean getNextMap() {
		return nextMap;
	}
	public Node getNext() {
		return next;
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
	public void setNextMap(boolean n) {
		nextMap = n;
	}
	public void setNext(Node node) {
		next = node;
	}
}