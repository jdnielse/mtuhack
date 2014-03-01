package com.mtuhack;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;


public class mtuhackgame implements ApplicationListener, Screen  {
	private Textures textures;
	public ArrayList<character> actors;
	public player p;
	public hackworld world;
	
	//just declare all textures here?
	//no, make a textures class!

	@Override
	public void render(float delta) {
		//clear the background
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        world.act(delta);
        world.draw();
		
	}

	@Override
	public void create() {
		// load all the textures
		textures = new Textures(this);
		
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
		world.setViewport(width, height, true);
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
		// TODO Auto-generated method stub
		
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
