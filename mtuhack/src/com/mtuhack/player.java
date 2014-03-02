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
	String weapon;
	/**
	 * constructor just takes the parent
	 * assigns the texture of the player to the player texture
	 * @param p
	 */
	public player(mtuhackgame p) {
		super(p);
		textureRegion = Textures.player;

	}
	public void assignclass(String classname){
		stats=StatRoller.StatGen(classname);
		classes=classname;
	}
	public void levelup(){
		maxhp=maxhp+StatRoller.hitpoint(stats.get("CON"),classes);	
	}
	public void attack(int enemyAC){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		switch(weapon){
		case "Longsword":
			int damage=weapons.longsword()+stats.get("STR");
			int hit=attackroll+stats.get("STR");
			break;
		case "Greatsword":
			damage=weapons.greatsword()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Mace":
			damage=weapons.mace()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Longbow":
			damage=weapons.longbow()+stats.get("STR");
			hit=attackroll+stats.get("DEX");
			break;
		}

	}
}
