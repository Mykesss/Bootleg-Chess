package com.mygdx.chess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
public class Launcher extends Game {

	SpriteBatch batch;
	Texture pieceTexture;
	TextureRegion region;
	ShapeRenderer shape;
	@Override
	public void create () {
		shape = new ShapeRenderer();
		batch = new SpriteBatch();
		pieceTexture = new Texture("pieces.png");
		region = new TextureRegion(pieceTexture);

	}

	@Override
	public void render () {
		// Clear Screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);

		// Draw Board
		for(int file = 0; file < 8; file ++){
			for(int rank = 0; rank < 8; rank ++){
				shape.begin(ShapeRenderer.ShapeType.Filled);
				boolean isLightSquare = (file + rank) % 2 != 0;
				if(isLightSquare){
					shape.setColor(Color.WHITE);
				}else{
					shape.setColor(Color.BROWN);
				}
				shape.rect(100*file,100*rank,100,100);
				shape.end();
			}
		}

		//Draw Pieces
		batch.begin();
		batch.draw(region,0,0);
		batch.end();



	}
	
	@Override
	public void dispose () {
		shape.dispose();
	}
}
