package com.mtuhack;

import java.awt.Point;
import java.util.Random;

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
	private Node wall = new Node("walld", false, false,-1,-1); 
	public Node[][] entrance;
	public Node[][] archway;
	private mtuhackgame g;

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

	public Node[][] getEntranceMap() {
		if(entrance==null){
			setEntrance();
		}
		this.theMap = entrance;
		return entrance;
	}

	// get neighbors methods
	public Node getUp(int w, int h) {
		if ( h+1>=height ) {
			return wall;
		}
		return theMap[w][h+1];
	}
	public Node getDown(int w, int h) {
		if ( h-1<0 ) {
			return wall;
		}
		return theMap[w][h-1];
	}
	public Node getLeft(int w, int h) {
		if ( w-1<0 ) {
			return wall;
		}
		return theMap[w-1][h];
	}
	public Node getRight(int w, int h) {
		if ( w+1>=width ) {
			return wall;
		}
		return theMap[w+1][h];
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
		random = new Node(type, w, i,x,y);

		return random;
	}

	private void setEntrance() {
		height = 20;
		width = 20;
		entrance = new Node[20][20];
		for (int w=0; w<20; w++) {
			for (int h=0; h<20; h++) {
				//set node to default walkable non interactable floor
				entrance[w][h] = new Node("floor",true,false,w,h);

				//change nodes to create map
				if (w==0) {
					if (h<4) {	entrance[w][h] = new Node("wall",false,false,w,h);	}
					if (h>=5 && h<15) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==1) {
					if (h<3) {	entrance[w][h] = new Node("wall",false,false,w,h);	}
					if (h>=7 && h<15) { entrance[w][h] = new Node("water",false,false,w,h);	}
				}
				if (w==2) {
					if (h==0) {	entrance[w][h] = new Node("wall",false,false,w,h);	}
					if (h>=10 && h<15) { entrance[w][h] = new Node("water",false,false,w,h);	}
				}
				if (w==3) {
					if (h==0) {	entrance[w][h] = new Node("wall",false,false,w,h);	} 
					if (h>=13 && h<15) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==4) {
					if (h==0) {	entrance[w][h] = new Node("wall",false,false,w,h);	}   
					if (h==14) { entrance[w][h] = new Node("water",false,false,w,h); } 
				}
				if (w==5) {
					if (h==0) {	entrance[w][h] = new Node("wall",false,false,w,h);	}
					if (h==14) { entrance[w][h] = new Node("water",true,false,w,h); }
				}
				if (w==6) {
					if (h==14) { entrance[w][h] = new Node("water",true,false,w,h); }
				}
				if (w==7) {
					if (h==14 || h==15) { entrance[w][h] = new Node("water",true,false,w,h); }
					if (h>15) {	entrance[w][h] = new Node("water",false,false,w,h);	}
				}
				if (w==8) {
					if (h>=7 && h<10) {	entrance[w][h] = new Node("wall",false,false,w,h);	}
					if (h>=17) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==9) {
					if (h>=6 && h<10) {	entrance[w][h] = new Node("wall",false,false,w,h);	} 
					if (h>=17) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==10) {
					if (h>=6 && h<11) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>=17) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==11) {
					if (h>=7 && h<11) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>=17) { entrance[w][h] = new Node("water",false,false,w,h); } 
				}
				if (w==12) {
					if (h==9) { entrance[w][h] = new Node("wall",false,false,w,h); } 
					if (h>=17) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==13) { 
					if (h>14) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==14) {
					if (h>14) { entrance[w][h] = new Node("water",false,false,w,h); } 
				}
				if (w==15) {
					if (h>14) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==16) {
					if (h==0) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>14) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==17) {
					if (h<2) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>8 && h<11) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>16) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==18) {
					if (h<2) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>=8 && h<13) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>17) { entrance[w][h] = new Node("water",false,false,w,h); }
				}
				if (w==19) {
					if (h<2) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>=7 && h<15) { entrance[w][h] = new Node("wall",false,false,w,h); }
					if (h>17) { entrance[w][h] = new Node("water",false,false,w,h); }
				}

			}
		}

	}//end set entrance

	private void setArchway() {
		archway = new Node[20][20];
		

	}//end set archway
}
