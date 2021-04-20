package com.mygdx.chess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Launcher extends Game {

	SpriteBatch batch;
	Texture pieceSprite;
	TextureRegion region;
	ShapeRenderer shape;
	Board board;
	ArrayList<TextureRegion> pieceTextures;
	ArrayList<Pieces> pieceLocations;
	Pieces p;
	@Override
	public void create () {
		board = new Board();
		shape = new ShapeRenderer();
		batch = new SpriteBatch();
		pieceTextures = new ArrayList<>();
		pieceLocations = new ArrayList<>();
		pieceSprite = new Texture("pieces.png");
		for (int j = 0; j < 2;j++){
			for (int k = 0; k < 6;k++){
				region = new TextureRegion(pieceSprite,k*100,j*100,100,100);
				pieceTextures.add(region);

			}
		}
		pieceLocations.add(new King(3,0,0,0));
		pieceLocations.add(new Queen(4,0,0,1));
		pieceLocations.add(new Bishop(2,0,0,2));
		pieceLocations.add(new Bishop(5,0,0,2));
		pieceLocations.add(new Knight(1,0,0,3));
		pieceLocations.add(new Knight(6,0,0,3));
		pieceLocations.add(new Rook(0,0,0,4));
		pieceLocations.add(new Rook(7,0,0,4));
		pieceLocations.add(new Pawn(0,1,0,5));
		pieceLocations.add(new Pawn(1,1,0,5));
		pieceLocations.add(new Pawn(2,1,0,5));
		pieceLocations.add(new Pawn(3,1,0,5));
		pieceLocations.add(new Pawn(4,1,0,5));
		pieceLocations.add(new Pawn(5,1,0,5));
		pieceLocations.add(new Pawn(6,1,0,5));
		pieceLocations.add(new Pawn(7,1,0,5));

		pieceLocations.add(new King(3,7,6,1));
		pieceLocations.add(new Queen(4,7,6,2));
		pieceLocations.add(new Bishop(2,7,6,3));
		pieceLocations.add(new Bishop(5,7,6,3));
		pieceLocations.add(new Knight(1,7,6,4));
		pieceLocations.add(new Knight(6,7,6,4));
		pieceLocations.add(new Rook(0,7,6,5));
		pieceLocations.add(new Rook(7,7,6,5));
		pieceLocations.add(new Pawn(0,6,6,5));
		pieceLocations.add(new Pawn(1,6,6,5));
		pieceLocations.add(new Pawn(2,6,6,5));
		pieceLocations.add(new Pawn(3,6,6,5));
		pieceLocations.add(new Pawn(4,6,6,5));
		pieceLocations.add(new Pawn(5,6,6,5));
		pieceLocations.add(new Pawn(6,6,6,5));
		pieceLocations.add(new Pawn(7,6,6,5));



	}

	@Override
	public void render () {
		// Clear Screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);

		// Draw Board
		for (int file = 0; file < 8; file++) {
			for (int rank = 0; rank < 8; rank++) {
				shape.begin(ShapeRenderer.ShapeType.Filled);
				boolean isLightSquare = (file + rank) % 2 != 0;
				if (isLightSquare) {
					shape.setColor(Color.WHITE);
				} else {
					shape.setColor(Color.BROWN);
				}
				shape.rect(100 * file, 100 * rank, 100, 100);
				shape.end();
			}
		}
		//Draw Pieces
		batch.begin();
		for(Pieces p:pieceLocations) {
			batch.draw(pieceTextures.get(p.isWhite + p.pieceName), p.x * 100, p.y * 100);
		}
		batch.end();
	}



	
	@Override
	public void dispose () {
		shape.dispose();
	}
}
