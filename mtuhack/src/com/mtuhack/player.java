package com.mtuhack;

import java.util.Map;

/**
 * contains methods and info about the player
 * @author kobold
 *
 */
public class player extends character{
	Map<String,Integer>stats;
	int maxhp;
	String classes;
	/**
	 * constructor just takes the parent
	 * assigns the texture of the player to the player texture
	 * @param p
	 */
	public player(mtuhackgame p) {
		super(p);
		textureRegion = Textures.solid;

	}
	public void assignclass(String classname){
		stats=StatRoller.StatGen(classname);
		classes=classname;
	}
	public void levelup(){
		maxhp=maxhp+StatRoller.hitpoint(stats.get("CON"),classes);	
	}
	public void attack(int enemyAC){

	}
}
