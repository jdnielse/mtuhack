package com.mtuhack;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Creates a two-dimensional map of nodes and keeps track of node relations
 * Keeps player from going out of bounds. 
 * 
 * @author Aurora Seidenwand
 * 
 */
public class Map{

	public Node[][] theMap;
	private int width;
	private int height;
	private Node wall = new Node("walld", false, false, false,-1,-1); 
	public Node[][] entrance;
	public Node[][] archway;
	public Node[][] riverofdoom;
	private mtuhackgame g;

	/** default constructor */
	public Map() {	
		theMap = new Node[20][20];	
		width = 20;
		height = 20;
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				theMap[i][j] = new Node();
			}
		}
	}//end default constructor

	/** number of nodes by number of nodes */
	public Map(int w, int h, mtuhackgame game) {
		g = game;
		theMap = new Node[w][h];
		width = w;
		height = h;
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				theMap[i][j] = nodeGenerator(i,j);
			}
		}
	}//end constructor

	public Node[][] getMap() {
		return theMap;
	}

	public void setMap(Node[][] newMap) {
		this.theMap = newMap;
	}

	public void setMap() {
		theMap = new Node[20][20];
		int w=0;
		int h=19;
		String type;
		Scanner scanner;
		try {
			scanner = new Scanner(new File("bigmap"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		scanner.useDelimiter(" ");
		int last = 19;
		while (scanner.hasNext()) {
			type = scanner.next();
			type = type.replace("\n", "");
			type = type.trim();

			if (type.equals("000")) { //unwalkable floor
				theMap[w][h] = new Node("floor",false,false,false,w,h);
				w++;
			}else
				if (type.equals("010")) { //walkable floor
					theMap[w][h] = new Node("floor",true,false,false,w,h);
					w++;
				}else
					if (type.equals("300")) { //unwalkable water
						theMap[w][h] = new Node("water",false,false,false,w,h);
						w++;
					}else
						if (type.equals("310")) { //walkable water
							theMap[w][h] = new Node("water",true,false,false,w,h);
							w++;
						}else
							if (type.equals("100")) { //unwalkable wall
								theMap[w][h] = new Node("wall",false,false,false,w,h);
								w++;
							}else
								if (type.equals("110")) { //walkable wall
									theMap[w][h] = new Node("wall",true,false,false,w,h);
									w++;
								}else
									if (type.equals("200")) { //unwalkable lava
										theMap[w][h] = new Node("lava",false,false,false,w,h);
										w++;
									}else
										if (type.equals("210")) { //walkable lava
											theMap[w][h] = new Node("lava",true,false,false,w,h);
											w++;
										}else{
											System.out.println("unhandled case: ["+type+"]");
										}
			if (w>19) {
				w=0;
				h--;
			}

		}
		scanner.close();
	}
	
	public Node[][] getEntranceMap() {
		if(entrance==null){
			setEntrance();
		}
		this.theMap = entrance;
		return entrance;
	}

	public Node[][] getArchwayMap() {
		if(archway==null){
			setArchway();
		}
		this.theMap = archway;
		return archway;
	}

	public Node[][] getRiverOfDoomMap() {
		if(riverofdoom==null){
			setRiverOfDoom();
		}
		this.theMap = riverofdoom;
		return riverofdoom;
	}

	// get neighbors methods
	public Node getUp(int w, int h) {
		if ( h+1>=height ) {
			if (theMap[w][h].getNextMap()) { 
				return theMap[w][h].getNext();
			}
			else {
				return wall;
			}
		}
		return theMap[w][h+1];
	}
	public Node getDown(int w, int h) {
		if ( h-1<0 ) {
			if (theMap[w][h].getNextMap()) { 
				return theMap[w][h].getNext();
			}
			else {
				return wall;
			}
		}
		return theMap[w][h-1];
	}
	public Node getLeft(int w, int h) {
		if ( w-1<0 ) {
			if (theMap[w][h].getNextMap()) { 
				return theMap[w][h].getNext();
			}
			else {
				return wall;
			}
		}
		return theMap[w-1][h];
	}
	public Node getRight(int w, int h) {
		if ( w+1>=width ) {
			if (theMap[w][h].getNextMap()) { 
				return theMap[w][h].getNext();
			}
			else {
				return wall;
			}
		}
		return theMap[w+1][h];
	}
	public Node getNode(int w, int h){
		return theMap[w][h];
	}
	/**
	 * Gets the tile at the given point on the screen
	 * @param p
	 * @return
	 */
	//X is position in pixels from the left of the screen
	//y is the position in pixels from the bottom of the MINABLE GRID
	public Node getNodeAtScreenPoint(Point p) {
		int xGrid = p.x / width;
		int yGrid = p.y / height;
		yGrid = height - yGrid;
		return theMap[xGrid][yGrid];
	}

	//node generator
	public Node nodeGenerator(int x, int y) {
		Node random; 
		Random generator = new Random();
		String type;
		boolean n = false;
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
		random = new Node(type, w, i, n,x,y);

		return random;
	}

	private void setEntrance() {
		entrance = new Node[20][20];
		int w=0;
		int h=19;
		String type;
		Scanner scanner;
		try {
			scanner = new Scanner(new File("entrance"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		scanner.useDelimiter(" ");
		int last = 19;
		while (scanner.hasNext()) {
			type = scanner.next();
			type = type.replace("\n", "");
			type = type.trim();

			if (type.equals("000")) { //unwalkable floor
				entrance[w][h] = new Node("floor",false,false,false,w,h);
				w++;
			}else
				if (type.equals("010")) { //walkable floor
					entrance[w][h] = new Node("floor",true,false,false,w,h);
					w++;
				}else
					if (type.equals("300")) { //unwalkable water
						entrance[w][h] = new Node("water",false,false,false,w,h);
						w++;
					}else
						if (type.equals("310")) { //walkable water
							entrance[w][h] = new Node("water",true,false,false,w,h);
							w++;
						}else
							if (type.equals("100")) { //unwalkable wall
								entrance[w][h] = new Node("wall",false,false,false,w,h);
								w++;
							}else
								if (type.equals("110")) { //walkable wall
									entrance[w][h] = new Node("wall",true,false,false,w,h);
									w++;
								}else
									if (type.equals("200")) { //unwalkable lava
										entrance[w][h] = new Node("lava",false,false,false,w,h);
										w++;
									}else
										if (type.equals("210")) { //walkable lava
											entrance[w][h] = new Node("lava",true,false,false,w,h);
											w++;
										}else{
											System.out.println("unhandled case: ["+type+"]");
										}
			if (w>19) {
				w=0;
				h--;
			}

		}
		scanner.close();


	}//end set entrance

	private void setArchway() {
		archway = new Node[20][20];
		int w=0;
		int h=19;
		String type;
		Scanner scanner;
		try {
			scanner = new Scanner(new File("archway"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		scanner.useDelimiter(" ");
		int last = 19;
		while (scanner.hasNext()) {
			type = scanner.next();
			type = type.replace("\n", "");
			type = type.trim();

			if (type.equals("000")) { //unwalkable floor
				archway[w][h] = new Node("floor",false,false,false,w,h);
				w++;
			}else
				if (type.equals("010")) { //walkable floor
					archway[w][h] = new Node("floor",true,false,false,w,h);
					w++;
				}else
					if (type.equals("0101")) {//walkable floor to next map
						entrance[w][h] = new Node("floor",true,false,true,w,h);
					}else
						if (type.equals("300")) { //unwalkable water
							archway[w][h] = new Node("water",false,false,false,w,h);
							w++;
						}else
							if (type.equals("310")) { //walkable water
								archway[w][h] = new Node("water",true,false,false,w,h);
								w++;
							}else
								if (type.equals("100")) { //unwalkable wall
									archway[w][h] = new Node("wall",false,false,false,w,h);
									w++;
								}else
									if (type.equals("110")) { //walkable wall
										archway[w][h] = new Node("wall",true,false,false,w,h);
										w++;
									}else
										if (type.equals("200")) { //unwalkable lava
											archway[w][h] = new Node("lava",false,false,false,w,h);
											w++;
										}else
											if (type.equals("210")) { //walkable lava
												archway[w][h] = new Node("lava",true,false,false,w,h);
												w++;
											}else{
												System.out.println("unhandled case: ["+type+"]");
											}
			if (w>19) {
				w=0;
				h--;
			}

		}
		scanner.close();

	}//end set archway

	private void setRiverOfDoom() {
		riverofdoom = new Node[20][20];
		int w=0;
		int h=19;
		String type;
		Scanner scanner;
		try {
			scanner = new Scanner(new File("riverofdoom"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		scanner.useDelimiter(" ");
		int last = 19;
		while (scanner.hasNext()) {
			type = scanner.next();
			type = type.replace("\n", "");
			type = type.trim();

			if (type.equals("000")) { //unwalkable floor
				riverofdoom[w][h] = new Node("floor",false,false,false,w,h);
				w++;
			}else
				if (type.equals("010")) { //walkable floor
					riverofdoom[w][h] = new Node("floor",true,false,false,w,h);
					w++;
				}else
					if (type.equals("0101")) {//walkable floor to next map
						entrance[w][h] = new Node("floor",true,false,true,w,h);
					}else
						if (type.equals("300")) { //unwalkable water
							riverofdoom[w][h] = new Node("water",false,false,false,w,h);
							w++;
						}else
							if (type.equals("310")) { //walkable water
								riverofdoom[w][h] = new Node("water",true,false,false,w,h);
								w++;
							}else
								if (type.equals("310")) { //walkable water to next map
									riverofdoom[w][h] = new Node("water",true,false,true,w,h);
									w++;
								}else
									if (type.equals("100")) { //unwalkable wall
										riverofdoom[w][h] = new Node("wall",false,false,false,w,h);
										w++;
									}else
										if (type.equals("110")) { //walkable wall
											riverofdoom[w][h] = new Node("wall",true,false,false,w,h);
											w++;
										}else
											if (type.equals("200")) { //unwalkable lava
												riverofdoom[w][h] = new Node("lava",false,false,false,w,h);
												w++;
											}else
												if (type.equals("210")) { //walkable lava
													riverofdoom[w][h] = new Node("lava",true,false,false,w,h);
													w++;
												}else{
													System.out.println("unhandled case: ["+type+"]");
												}
			if (w>19) {
				w=0;
				h--;
			}

		}
		scanner.close();

	}//end set riverOfDoom

	

}
