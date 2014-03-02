package com.mtuhack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	public static TextureRegion wall,water,walk,lava,player,kobold;
	
	public Textures(mtuhackgame parent) {
		//Time to load the textures
		wall = new TextureRegion(new Texture(Gdx.files.internal("assets/wall.png")));
		water = new TextureRegion(new Texture(Gdx.files.internal("assets/water.png")));
		walk = new TextureRegion(new Texture(Gdx.files.internal("assets/walk.png")));
		lava = new TextureRegion(new Texture(Gdx.files.internal("assets/lava.png")));
		player = new TextureRegion(new Texture(Gdx.files.internal("assets/Fighter.png")));
		kobold = new TextureRegion(new Texture(Gdx.files.internal("assets/Kobold.png")));

		//used to restrict what pixels are seen of the image
	   // solid.setRegion(0, 0, 6, 6);
	    //gridTopLeft.setRegion(0, 0, 6, 6);
	}

}
