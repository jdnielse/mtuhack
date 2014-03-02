package com.mtuhack;


/**
 * holds common monster ai
 * @author kobold
 *
 */
public class monster extends character{
	public int xp;
	public int hit;
	public int damage;
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
	public void attack(character c){
		if(hit>c.AC){
			game.mess2="";
			c.hp-=damage;
			if(c.hp <= 0){
				//kill it
				c.kill();
				game.mess2 = "Killed and ";
			}
			game.mess2 += "Hit "+(c.getClass().toString().substring(c.getClass().toString().lastIndexOf('.')+1, c.getClass().toString().length())+" with a "+hit+" to hit and did "+damage+" damage!");

		}else{
			game.mess2 = "Missed "+(c.getClass().toString().substring(c.getClass().toString().lastIndexOf('.')+1, c.getClass().toString().length())+" with a "+hit);
		}
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
					if(dist2play()==1){
						attack(game.p);
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
					if(dist2play()==1){
						attack(game.p);
					}
				}

			}
		}
	}
}
