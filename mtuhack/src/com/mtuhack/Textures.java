package com.mtuhack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	public static TextureRegion gridTopLeft;
	public static TextureRegion solid;
	
	public Textures(mtuhackgame parent) {
		//Time to load the textures
	    //gridTopLeft 	= new TextureRegion(new Texture(Gdx.files.internal("assets/topLeft.png")));
	    //solid			= new TextureRegion(new Texture(Gdx.files.internal("assets/solid.png")));

		//used to restrict what pixels are seen of the image
	   // solid.setRegion(0, 0, 6, 6);
	    //gridTopLeft.setRegion(0, 0, 6, 6);
	}

}
