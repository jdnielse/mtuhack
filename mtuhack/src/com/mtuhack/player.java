package com.mtuhack;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * contains methods and info about the player
 * @author kobold
 *
 */
public class player extends character{
	Map<String,Integer>stats;
	int maxhp = 0;
	int totalxp=0;
	String classes;
	String weapon;
	String armor;
	boolean assigned=false;
	/**
	 * constructor just takes the parent
	 * assigns the texture of the player to the player texture
	 * @param p
	 */
	public player(mtuhackgame p) {
		super(p);
		textureRegion = Textures.player;
		weapon = "Greatsword";
		assignclass();
		armor="Fullplate";
	}
	public void assignclass() {
		game.mess = "Choose a class:\n7 Fighter   8 Thief   9 Wizard   0 Brute   - Ranger";
	}
	public void assignclass(String classname){
		if (!assigned) {
			Textures.player = new TextureRegion(new Texture(Gdx.files.internal("assets/"+classname+".png")));
			textureRegion = Textures.player;
			stats=StatRoller.StatGen(classname);
			classes=classname;
			assigned=true;
			game.mess = "";
			levelup();
			hp = maxhp;
			setAC(armor);
		}
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
				totalxp=totalxp+m.xp;
				game.mess = "Killed and ";
			}
			game.mess += "Hit "+(m.getClass().toString().substring(m.getClass().toString().lastIndexOf('.'), m.getClass().toString().length())+" with a "+hit+" to hit and did "+damage+" damage!");

		}
		else{
			game.mess = "Missed "+(m.getClass().toString().substring(m.getClass().toString().lastIndexOf('.'), m.getClass().toString().length())+" with a "+hit);
		}
	}

	public void setAC(String armor){
		int armorval=0;
		switch(armor){
		case "Breastplate":
			armorval=6;
			break;
		case "Chainmail":
			armorval=4;
			break;
		case "Leather":
			armorval=3;
			break;
		case "Fullplate":
			armorval=9;
			break;
		case "Cloth":
			armorval=1;
			break;
		}
		AC=10+armorval+stats.get("DEX");
	}
	public void act(float delta){
	}
}
