package com.mtuhack;

/**
 * contains methods and info about the player
 * @author kobold
 *
 */
public class player extends character{

	/**
	 * constructor just takes the parent
	 * assigns the texture of the player to the player texture
	 * @param p
	 */
	public player(mtuhackgame p) {
		super(p);
		textureRegion = Textures.solid;
		
	}

	
}
