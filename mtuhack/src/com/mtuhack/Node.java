package com.mtuhack;

/**
 * Node of Dungeon Map which keeps track of what type of node it is, 
 * if the player can walk on it, and if the player can interact with it.
 * 
 * @author Aurora Seidenwand
 *
 */
public class Node {
	// Instance variables:
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