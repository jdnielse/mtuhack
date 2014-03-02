package com.mtuhack;

import java.util.Random;

/**
 * Creates a two-dimensional map of nodes and keeps track of node relations
 * Keeps player from going out of bounds. 
 * 
 * @author Aurora Seidenwand
 * 
 */
public class Map extends Node {

	private Node[][] theMap;
	private int width;
	private int height;
	private Node wall = new Node("wall", false, false); 
	private Node[][] entrance; 

	/** default constructor */
	public Map() {	
		theMap = new Node[10][10];	
		width = 10;
		height = 10;
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				theMap[i][j] = new Node();
			}
		}
	}//end default constructor

	/** number of nodes by number of nodes */
	public Map(int w, int h) {
		theMap = new Node[w][h];
		width = w;
		height = h;
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				theMap[i][j] = nodeGenerator();
			}
		}
	}//end constructor

	public Node[][] getMap() {
		return theMap;
	}

	public void setMap(Node[][] newMap) {
		this.theMap = newMap;
	}

	// get neighbors methods
	public Node getUp(int w, int h) {
		if ( !(h<height) ) {
			return wall;
		}
		return theMap[w][h+1];
	}
	public Node getDown(int w, int h) {
		if ( !(h>0) ) {
			return wall;
		}
		return theMap[w][h-1];
	}
	public Node getLeft(int w, int h) {
		if ( !(w>0) ) {
			return wall;
		}
		return theMap[w-1][h];
	}
	public Node getRight(int w, int h) {
		if ( !(w<width) ) {
			return wall;
		}
		return theMap[w+1][h];
	}

	//node generator
	public Node nodeGenerator() {
		Node random; 
		Random generator = new Random();
		String type;
		
		//three node types
		int t = generator.nextInt(3);
		if (t == 0) { type = "floor"; }
		else if (t == 1) { type = "wall"; }
		else if (t == 2) { type = "lava"; }
		else { type = "water"; }
		//two options for walkable
		boolean w = generator.nextBoolean(); 
		//two options for interaction
		boolean i = generator.nextBoolean();
		random = new Node(type, w, i);
		
		return random;
	}

	private void setEntrance() {
		entrance = new Map[20][20];
		for (int w=0; w<20; w++) {
			for (int h=0; h<20; h++) {
				if (w<15) {
					
				}
			}
		}
		
	}//end set entrance

}
