package com.mtuhack;


/**
 * holds common monster ai
 * @author kobold
 *
 */
public class monster extends character{
	public int xp;

	/**
	 * give the monster a texture
	 * @param p
	 */
	public monster(mtuhackgame p) {
		super(p);
	}
	public int dist2play(){
		return Math.abs(x-game.p.x)+Math.abs(y-game.p.y);
	}
	public void chase(){
		if(dist2play()<v_rad){
			boolean move=false;
			if(Math.random()>.5){
				if(getX()<game.p.getX()){
					move=moveRight();
				}
				else if(getX()>game.p.getX()){
					move=moveLeft();
				}
				if(!move){
					if(getY()<game.p.getY()){
						move=moveUp();
					}
					else if(getY()>game.p.getY()){
						move=moveDown();
					}
				}
			}
			else{
				if(getY()<game.p.getY()){
					move=moveUp();
				}
				else if(getY()>game.p.getY()){
					move=moveDown();
				}
				if(!move){
					if(getX()<game.p.getX()){
						move=moveRight();
					}
					else if(getX()>game.p.getX()){
						move=moveLeft();
					}
				}
			}

		}
	}
}
