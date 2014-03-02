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
	public boolean assigned=false;
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
		armor="Platemail";
		level = 0;
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
		}
	}
	public void levelup(){
		//pick a stat to add 1 to
		level++;
		if(level!=1){
			double rand = Math.random();
			switch(classes){
			case "Fighter":
				if(rand>(4/9.0)){
					stats.put("STR", stats.get("STR")+1);
					game.mess2 = "You leveled up and got a point in STR!";
				}else if(rand < (3/9.0)){
					stats.put("CON", stats.get("CON")+1);
					game.mess2 = "You leveled up and got a point in CON!";
				}else{
					stats.put("DEX", stats.get("DEX")+1);
					game.mess2 = "You leveled up and got a point in DEX!";
				}
				break;
			case "Thief":
			case "Ranger":
				if(rand>(4/9.0)){
					stats.put("DEX", stats.get("DEX")+1);
					game.mess2 = "You leveled up and got a point in DEX!";
				}else if(rand < (3/9.0)){
					stats.put("CON", stats.get("CON")+1);
					game.mess2 = "You leveled up and got a point in CON!";
				}else{
					stats.put("STR", stats.get("STR")+1);
					game.mess2 = "You leveled up and got a point in STR!";
				}
				break;
			case "Wizard":
				if(rand>(4/9.0)){
					stats.put("INT", stats.get("INT")+1);
					game.mess2 = "You leveled up and got a point in INT!";
				}else if(rand < (3/9.0)){
					stats.put("DEX", stats.get("DEX")+1);
					game.mess2 = "You leveled up and got a point in DEX!";
				}else{
					stats.put("CON", stats.get("CON")+1);
					game.mess2 = "You leveled up and got a point in CON!";
				}
				break;
			case "Brute":
				if(rand>(4/9.0)){
					stats.put("CON", stats.get("CON")+1);
					game.mess2 = "You leveled up and got a point in CON!";
				}else if(rand < (3/9.0)){
					stats.put("STR", stats.get("STR")+1);
					game.mess2 = "You leveled up and got a point in STR!";
				}else{
					stats.put("DEX", stats.get("DEX")+1);
					game.mess2 = "You leveled up and got a point in DEX!";
				}
				break;
			}
		}

		maxhp=maxhp+StatRoller.hitpoint(stats.get("CON"),classes);	

		hp = maxhp;
		setAC(armor);
	}

	@Override
	public void kill(){

		updatePos();
		//make occupied node unwalkable 
		game.activeMap.getNode(x, y).setWalk(true);

		setPosition(-100, -100);
		dead = true;

		game.scroll = 0;
		game.in.hitMid = false;


		game.mess2 = "You died! Play again, it's easy";
		Textures.player = new TextureRegion(new Texture(Gdx.files.internal("assets/player.png")));
		game.p = new player(game);
		game.p.setPosition(8*32,19*32);
		game.world.addActor(game.p);

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
				if(totalxp >= level*50){
					levelup();
				}
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
