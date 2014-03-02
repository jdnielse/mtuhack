package com.mtuhack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	public static TextureRegion wall,water,walk,lava,player,kobold,orc,skeleton,dragonadult,dragonyoung,slimes,troll,goblin,giant;
	
	public Textures(mtuhackgame parent) {
		//Time to load the textures
		wall = new TextureRegion(new Texture(Gdx.files.internal("assets/wall.png")));
		water = new TextureRegion(new Texture(Gdx.files.internal("assets/water.png")));
		walk = new TextureRegion(new Texture(Gdx.files.internal("assets/walk.png")));
		lava = new TextureRegion(new Texture(Gdx.files.internal("assets/lava.png")));
		player = new TextureRegion(new Texture(Gdx.files.internal("assets/player.png")));
		kobold = new TextureRegion(new Texture(Gdx.files.internal("assets/Kobold.png")));
		orc = new TextureRegion(new Texture(Gdx.files.internal("assets/Orc.png")));
		skeleton = new TextureRegion(new Texture(Gdx.files.internal("assets/Skeleton.png")));
		dragonadult = new TextureRegion(new Texture(Gdx.files.internal("assets/DragonAdult.png")));
		dragonyoung = new TextureRegion(new Texture(Gdx.files.internal("assets/DragonYoung.png")));
		slimes = new TextureRegion(new Texture(Gdx.files.internal("assets/Slimes.png")));
		troll = new TextureRegion(new Texture(Gdx.files.internal("assets/Troll.png")));
		goblin = new TextureRegion(new Texture(Gdx.files.internal("assets/Goblin.png")));
		giant = new TextureRegion(new Texture(Gdx.files.internal("assets/Giant.png")));

		//used to restrict what pixels are seen of the image
	   // solid.setRegion(0, 0, 6, 6);
	    //gridTopLeft.setRegion(0, 0, 6, 6);
	}

}
