package com.mtuhack;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mtuhack.monsters.DragonAdult;
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
		boolean moved = false;
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
		case Keys.D:
			//spawn a dragon at a set location
			DragonAdult da = new DragonAdult(game);
			da.setPosition(10*32, 0);
			game.world.addActor(da);
			handled=true;
			break;
		case Keys.DOWN:
			moved = game.p.moveDown();
			if(!moved){
				Node down = game.activeMap.getDown(game.p.x, game.p.y);
				//check if its an enemy
				for(Actor c:game.world.getActors()){
					if(c.getX()==down.getX()&&c.getY()==down.getY()){
						if(c instanceof monster){
							game.p.attack((monster) c);
						}
					}
				}
			}
			handled=true;
			break;
		case Keys.RIGHT:
			moved = game.p.moveRight();
			if(!moved){
				Node right = game.activeMap.getRight(game.p.x, game.p.y);
				//check if its an enemy
				for(Actor c:game.world.getActors()){
					if(c.getX()==right.getX()&&c.getY()==right.getY()){
						if(c instanceof monster){
							game.p.attack((monster) c);
						}
					}
				}
			}
			handled=true;
			break;
		case Keys.UP:
			moved = game.p.moveUp();
			if(!moved){
				Node up = game.activeMap.getUp(game.p.x, game.p.y);
				//check if its an enemy
				for(Actor c:game.world.getActors()){
					if(c.getX()==up.getX()&&c.getY()==up.getY()){
						if(c instanceof monster){
							game.p.attack((monster) c);
						}
					}
				}
			}
			handled=true;
			break;
		case Keys.LEFT:
			moved = game.p.moveLeft();
			if(!moved){
				Node left = game.activeMap.getLeft(game.p.x, game.p.y);
				//check if its an enemy
				for(Actor c:game.world.getActors()){
					if(c.getX()==left.getX()&&c.getY()==left.getY()){
						if(c instanceof monster){
							game.p.attack((monster) c);
						}
					}
				}
			}
			handled=true;
			break;
		case Keys.SPACE:
			handled=true;
			break;
		case Keys.NUM_7:
			game.p.assignclass("Fighter");
			handled=true;
			break;
		case Keys.NUM_8:
			game.p.assignclass("Thief");
			handled=true;
			break;
		case Keys.NUM_9:
			game.p.assignclass("Wizard");
			handled=true;
			break;
		case Keys.NUM_0:
			game.p.assignclass("Brute");
			handled=true;
			break;
		case Keys.MINUS:
			game.p.assignclass("Ranger");
			handled=true;
			break;
		default:
			return false;
		}
		game.world.act();
		game.mess3 = "HP "+game.p.hp+"/"+game.p.maxhp;
		game.mess4 = "XP "+game.p.totalxp;
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
