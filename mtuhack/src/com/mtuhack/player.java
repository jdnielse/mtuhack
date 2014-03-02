package com.mtuhack;

import java.util.Map;

/**
 * contains methods and info about the player
 * @author kobold
 *
 */
public class player extends character{
	Map<String,Integer>stats;
	int maxhp = 10;
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
		weapon = "Dagger";
		assignclass("Fighter");
		hp = maxhp;

	}
	public void assignclass(String classname){
		stats=StatRoller.StatGen(classname);
		classes=classname;
	}
	public void levelup(){
		maxhp=maxhp+StatRoller.hitpoint(stats.get("CON"),classes);	
	}

	public void attack(monster m){
		double attackroll1=(Math.random()*20);
		int attackroll=(int) Math.ceil(attackroll1);
		int hit, damage;
		switch(weapon){
		case "Longsword":
			damage=weapons.longsword()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Greatsword":
			damage=weapons.greatsword()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Mace":
			damage=weapons.mace()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Staff":
			damage=weapons.staff()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Club":
			damage=weapons.club()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Greatax":
			damage=weapons.greatax()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Dagger":
			damage=weapons.dagger()+stats.get("STR");
			hit=attackroll+stats.get("STR");
			break;
		case "Shortbow":
			damage=weapons.shortbow()+stats.get("STR");
			hit=attackroll+stats.get("DEX");
			break;
		case "Crossbow":
			damage=weapons.crossbow();
			hit=attackroll+stats.get("DEX");
			break;
		default:
			damage = 0;
			hit = 0;
			break;
		}
		if(hit>m.AC){
			game.mess="";
			m.hp-=damage;
			if(m.hp <= 0){
				//kill it
				m.kill();
				game.mess = "Killed and ";
			}
			game.mess += "hit "+(m.getClass().toString().substring(m.getClass().toString().lastIndexOf('.'), m.getClass().toString().length()-1)+" with a "+hit+" to hit and did "+damage+" damage!");

		}else{
			game.mess = "Missed "+(m.getClass().toString().substring(m.getClass().toString().lastIndexOf('.'), m.getClass().toString().length()-1)+" with a "+hit);
		}

	}
}
