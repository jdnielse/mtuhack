package com.mtuhack;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mtuhack.monsters.DragonAdult;
import com.mtuhack.monsters.GiantRat;
import com.mtuhack.monsters.Goblin;
import com.mtuhack.monsters.Kobolds;
import com.mtuhack.monsters.Nagas;
import com.mtuhack.monsters.Skeleton;
import com.mtuhack.monsters.Slimes;
import com.mtuhack.monsters.Troll;


public class mtuhackgame implements ApplicationListener, Screen  {
	public static mtuhackgame g;
	SpriteBatch spriteBatch = new SpriteBatch();
	BitmapFont font;
	private Textures textures;
	public ArrayList<character> actors;
	public player p;
	public hackworld world;
	public settings set;
	public Map activeMap;
	public String mess ="";
	public String mess2="";
	public String mess3="";
	public String mess4="";
	public String mess5="";
	public String mess6="";
	public String mess7="";
	public String mess8="";
	int scroll = 0;
	public hackinput in;

	@Override
	public void render(float delta) {
		render();
		
	}

	@Override
	public void create() {
		// load all the textures
		textures = new Textures(this);
		//create the game stage
		world = new hackworld();
		g = this;
		//setup the font
		font = new BitmapFont();
		//create the map
		//activeMap = new Map(40,40,this);
		Map m = new Map();
		//m.setMap();
		m.getMap();
		activeMap = m;
		//create the player
		p = new player(this);
		//add the player to the stage
		world.addActor(p);
		p.setPosition(8*32,19*32);
		set = new settings();
		//set up the input stuff
		in = new hackinput(this);
    	Gdx.input.setInputProcessor(in);
    	Kobolds k = new Kobolds(this);
		k.setPosition(23*32, 2*32);
		this.world.addActor(k);
		k=new Kobolds(this);
		k.setPosition(25*32, 1*32);
		this.world.addActor(k);
		k=new Kobolds(this);
		k.setPosition(28*32, 4*32);
		this.world.addActor(k);
		Skeleton s = new Skeleton(this);
		s.setPosition(14*32, 13*32);
		this.world.addActor(s);
		s = new Skeleton(this);
		s.setPosition(18*32, 15*32);
		this.world.addActor(s);
		s = new Skeleton(this);
		s.setPosition(21*32, 18*32);
		this.world.addActor(s);
		Goblin g = new Goblin(this);
		g.setPosition(5*32, 4*32);
		this.world.addActor(g);
		g = new Goblin(this);
		g.setPosition(0*32, 9*32);
		this.world.addActor(g);
		g = new Goblin(this);
		g.setPosition(3*32, 10*32);
		this.world.addActor(g);
		Nagas n = new Nagas(this);
		n.setPosition(16*32, 2*32);
		this.world.addActor(n);
		n = new Nagas(this);
		n.setPosition(37*32, 15*32);
		this.world.addActor(n);
		Slimes sl = new Slimes(this);
		sl.setPosition(43*32, 4*32);
		this.world.addActor(sl);
		sl = new Slimes(this);
		sl.setPosition(48*32, 7*32);
		this.world.addActor(sl);
		Troll t = new Troll(this);
		t.setPosition(68*32, 7*32);
		this.world.addActor(t);
		DragonAdult da = new DragonAdult(this);
		da.setPosition(79*32, 19*32);
		this.world.addActor(da);
		GiantRat r = new GiantRat(this);
		r.setPosition(16*32, 19*32);
		this.world.addActor(r);
		r = new GiantRat(this);
		r.setPosition(38*32, 14*32);
		this.world.addActor(r);
		r= new GiantRat(this);
		r.setPosition(49*32, 7*32);
		this.world.addActor(r);
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
        spriteBatch.begin();
       // world.act(Gdx.graphics.getDeltaTime());
        world.draw();
        spriteBatch.end();
        spriteBatch.begin();
        font.setColor(Color.WHITE);
        font.setScale((float)1.5);
        font.draw(spriteBatch, mess, 0, 40);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess2, 0, 20);
        //font.setColor(1.0f, 0.25f, 0.25f, 1.0f);
        font.draw(spriteBatch, mess3, Gdx.graphics.getWidth()-90, 40);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess4, Gdx.graphics.getWidth()-90, 20);
        //font.setColor(1.0f, 0.25f, 0.25f, 1.0f);
        font.draw(spriteBatch, mess5, Gdx.graphics.getWidth()-90, 630);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess6, Gdx.graphics.getWidth()-90, 610);
        //font.setColor(1.0f, 0.25f, 0.25f, 1.0f);
        font.draw(spriteBatch, mess7, Gdx.graphics.getWidth()-90, 590);
        //font.setColor(0.5f, 0.5f, 1.0f, 1.0f);
        font.draw(spriteBatch, mess8, Gdx.graphics.getWidth()-90, 570);
        spriteBatch.end();
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
