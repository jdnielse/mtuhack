package com.mtuhack;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.mtuhack.monsters.Kobolds;
import com.mtuhack.monsters.Slimes;
import com.mtuhack.monsters.Troll;

public class hackinput implements InputProcessor{

	mtuhackgame game;
	public hackinput(mtuhackgame g){
		game = g;
	}

	/**
	 * The one we're using, just detects when a key is pressed
	 */
	@Override
	public boolean keyDown(int keycode) {
		boolean handled=false;
		switch(keycode){
		case Keys.NUM_1:
			//spawn a kobold at a set location
			Kobolds k = new Kobolds(game);
			k.setPosition(10*32, 0);
			game.world.addActor(k);
			handled=true;
			break;
		case Keys.NUM_2:
			//spawn a slime at a set location
			Slimes s = new Slimes(game);
			s.setPosition(10*32, 0);
			game.world.addActor(s);
			handled=true;
			break;
		case Keys.DOWN:
			game.p.moveDown();
			handled=true;
			break;
		case Keys.RIGHT:
			game.p.moveRight();
			handled=true;
			break;
		case Keys.UP:
			game.p.moveUp();
			handled=true;
			break;
		case Keys.LEFT:
			game.p.moveLeft();
			handled=true;
			break;
			default:
				return false;
		}
		game.world.act();	
		return handled;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
