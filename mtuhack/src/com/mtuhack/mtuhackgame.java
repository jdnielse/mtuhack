package com.mtuhack;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
	public String mess ="";
	public String mess2="";
	public String mess3="";
	public String mess4="";
	public String mess5="";
	public String mess6="";
	public String mess7="";
	public String mess8="";
	int scroll = 0;
	public hackinput in;

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
		//m.setMap();
		m.getMap();
		activeMap = m;
		//create the player
		p = new player(this);
		//add the player to the stage
		world.addActor(p);
		p.setPosition(8*32,19*32);
//		p.setWidth(32);
//		p.setHeight(32);
		set = new settings();
		//set up the input stuff
		in = new hackinput(this);
    	Gdx.input.setInputProcessor(in);
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
        spriteBatch.begin();
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, mess, 0, 30);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess2, 0, 15);
        //font.setColor(1.0f, 0.25f, 0.25f, 1.0f);
        font.draw(spriteBatch, mess3, Gdx.graphics.getWidth()-60, 40);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess4, Gdx.graphics.getWidth()-60, 20);
        //font.setColor(1.0f, 0.25f, 0.25f, 1.0f);
        font.draw(spriteBatch, mess5, Gdx.graphics.getWidth()-60, 630);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess6, Gdx.graphics.getWidth()-60, 610);
        //font.setColor(1.0f, 0.25f, 0.25f, 1.0f);
        font.draw(spriteBatch, mess7, Gdx.graphics.getWidth()-60, 590);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess8, Gdx.graphics.getWidth()-60, 570);
        spriteBatch.end();
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
