package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import scenes.MainMenu;

public class GameMain extends Game {
	private SpriteBatch batch;
	Sprite player;
	Texture img;
	int velX = -1;

	@Override
	public void create () {

		batch = new SpriteBatch();
		setScreen(new MainMenu(this));

	}

	@Override
	public void render () {
		super.render();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
