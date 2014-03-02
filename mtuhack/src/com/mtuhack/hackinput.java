package com.mtuhack;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.mtuhack.monsters.Kobolds;

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
		switch(keycode){
		case Keys.NUM_1:
			//spawn a kobold at a set location
			Kobolds k = new Kobolds(game);
			k.setPosition(10*32, 0);
			game.world.addActor(k);
			return true;
		case Keys.DOWN:
			Node down=game.activeMap.getDown((int)game.p.getX()/32, (int)game.p.getY()/32);
			if (down.getCanWalk()){
				game.p.setPosition(game.p.getX(),game.p.getY()-32);
			}
			return true;
		case Keys.RIGHT:
			Node right=game.activeMap.getRight((int)game.p.getX()/32, (int)game.p.getY()/32);
			if (right.getCanWalk()){
				game.p.setPosition(game.p.getX()+32,game.p.getY());
			}
			return true;
		case Keys.UP:
			Node up=game.activeMap.getUp((int)game.p.getX()/32, (int)game.p.getY()/32);
			if (up.getCanWalk()){
				game.p.setPosition(game.p.getX(),game.p.getY()+32);
			}
			return true;
		case Keys.LEFT:
			Node left=game.activeMap.getLeft((int)game.p.getX()/32, (int)game.p.getY()/32);
			if (left.getCanWalk()){
				game.p.setPosition(game.p.getX()-32,game.p.getY());
			}
			return true;
		default:
			return false;
		}
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
