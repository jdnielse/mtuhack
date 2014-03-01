package com.mtuhack;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

public class Main extends Game implements ApplicationListener{
	mtuhackgame game;
	
	@Override
	public void create() {
		game = new mtuhackgame();
		game.create();
		this.setScreen(game);
	}

}
