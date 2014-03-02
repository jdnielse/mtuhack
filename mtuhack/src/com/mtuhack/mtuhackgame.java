package com.mtuhack;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class mtuhackgame implements ApplicationListener, Screen  {
	public static mtuhackgame g;
	SpriteBatch spriteBatch = new SpriteBatch();
	BitmapFont font;
	private Textures textures;
	public ArrayList<character> actors;
	public player p;
	public hackworld world;
	public settings set;
	public Map activeMap;

	@Override
	public void render(float delta) {
		render();
		
	}

	@Override
	public void create() {
		// load all the textures
		textures = new Textures(this);
		//create the game stage
		world = new hackworld();
		g = this;
		//setup the font
		font = new BitmapFont();
		//create the map
		//activeMap = new Map(40,40,this);
		Map m = new Map();
		m.getEntranceMap();
		activeMap = m;
		//create the player
		p = new player(this);
		//add the player to the stage
		world.addActor(p);
		p.setPosition(0,19*32);
		p.setWidth(32);
		p.setHeight(32);
		set = new settings();
		//set up the input stuff
    	Gdx.input.setInputProcessor(new hackinput(this));
	}

	@Override
	public void resize(int width, int height) {
		//built in method for stages that handles resize
		world.setViewport(width, height, false);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		//clear the background
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
       // world.act(Gdx.graphics.getDeltaTime());
        world.draw();
        spriteBatch.end();
//        spriteBatch.begin();
//        font.setColor(1.0f, 0.0f, 1.0f, 1.0f);
//        font.draw(spriteBatch, ""+Gdx.graphics.getDeltaTime(), 0, 15);
//        spriteBatch.end();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
