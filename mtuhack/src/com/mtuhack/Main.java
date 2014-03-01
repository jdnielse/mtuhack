package com.mtuhack;

import com.badlogic.gdx.ApplicationListener;

public class Main extends com.badlogic.gdx.Game implements ApplicationListener{
	mtuhackgame game;
	
	@Override
	public void create() {
		game = new mtuhackgame();
		game.create();
	}

}
