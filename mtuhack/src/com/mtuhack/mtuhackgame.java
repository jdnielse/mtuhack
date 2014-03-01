package com.mtuhack;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class mtuhackgame implements ApplicationListener, Screen  {
	SpriteBatch spriteBatch = new SpriteBatch();
	BitmapFont font;
	private Textures textures;
	public ArrayList<character> actors;
	public player p;
	public hackworld world;
	

	@Override
	public void render(float delta) {
		render();
		
	}

	@Override
	public void create() {
		// load all the textures
		textures = new Textures(this);
		
		//setup the font
		 font = new BitmapFont();
		 
		//create the player
		p = new player(this);
		//create the game stage
		world = new hackworld();
		//add the player to the stage
		world.addActor(p);
		
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
        world.act(Gdx.graphics.getDeltaTime());
        world.draw();
        spriteBatch.begin();
        font.setColor(1.0f, 0.0f, 1.0f, 1.0f);
        font.draw(spriteBatch, ""+Gdx.graphics.getDeltaTime(), (int)(1200*Math.random()), (int)(600*Math.random()));
        spriteBatch.end();
        System.out.println(Gdx.graphics.getDeltaTime());
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
